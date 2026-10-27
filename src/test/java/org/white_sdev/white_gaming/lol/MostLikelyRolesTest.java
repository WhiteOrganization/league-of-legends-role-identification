package org.white_sdev.white_gaming.lol;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Covers {@link RoleIdentifier#identifyMostLikelyRoles(Set)}, which reads the weights as how often each champion is
 * played in each role.
 * <p>
 * The weights are the matches recorded per champion and role, as White_LoLPicker builds them from its encounters.
 */
@lombok.extern.slf4j.Slf4j
public class MostLikelyRolesTest {

	static final Set<String> ROLES = new LinkedHashSet<>(Arrays.asList("Top", "Middle", "Jungle", "Bottom", "Utility"));

	/**
	 * Adds one champion's matches per role, in the order Top, Middle, Jungle, Bottom, Utility; a zero adds nothing.
	 */
	private static void played(Set<ChampionRole<String, String>> weights, String champion, double... matches) {
		List<String> roles = Arrays.asList("Top", "Middle", "Jungle", "Bottom", "Utility");
		for (int role = 0; role < matches.length; role++)
			if (matches[role] > 0) weights.add(new ChampionRole<>(champion, roles.get(role), matches[role]));
	}

	private static Map<String, String> identify(Set<ChampionRole<String, String>> weights, String... champions) {
		return new RoleIdentifier<>(ROLES, weights).identifyMostLikelyRoles(new LinkedHashSet<>(Arrays.asList(champions)));
	}

	@Test
	public void leavesTheGamesPlayedOutOfPositionInTheNoise() {
		// Reported from White_LoLPicker on 2026-10-04, patches 16.18 and 16.19: the per-role algorithm read this team
		// as Shaco in the top lane and Leona in the jungle, with nobody as a support.
		Set<ChampionRole<String, String>> weights = new HashSet<>();
		played(weights, "Shaco", 14457, 1670, 484180, 6, 116659);
		played(weights, "MissFortune", 2788, 16424, 2, 1750541, 66738);
		played(weights, "Leona", 1439, 6, 4, 5, 856352);
		played(weights, "Xerath", 1618, 337471, 0, 58404, 357713);

		Map<String, String> guessed = identify(weights, "Shaco", "MissFortune", "Leona", "Xerath");

		assertThat(guessed)
				.containsEntry("Shaco", "Jungle")
				.containsEntry("MissFortune", "Bottom")
				.containsEntry("Leona", "Utility")
				.as("Xerath is played as a support slightly more than in the middle lane, but Leona is nothing else")
				.containsEntry("Xerath", "Middle");
	}

	@Test
	public void doesNotLetAPopularChampionsMinorRoleOutweighAnotherChampionsMainOne() {
		// Miss Fortune's 66,000 support games outnumber all of Taric's, yet they are 4% of hers and 95% of his.
		Set<ChampionRole<String, String>> weights = new HashSet<>();
		played(weights, "MissFortune", 0, 0, 0, 1750541, 66738);
		played(weights, "Taric", 1500, 0, 0, 0, 30000);
		played(weights, "Jinx", 0, 0, 0, 1500000, 5000);

		Map<String, String> guessed = identify(weights, "MissFortune", "Taric", "Jinx");

		assertThat(guessed)
				.as("Two carries: the one with the stronger second role is the one moved")
				.containsEntry("Jinx", "Bottom")
				.containsEntry("MissFortune", "Utility")
				.as("Taric gives up his role only because somebody had to, and takes his next one")
				.containsEntry("Taric", "Top");
	}

	@Test
	public void givesAChampionWithNoGamesWhateverRoleTheOthersLeave() {
		Set<ChampionRole<String, String>> weights = new HashSet<>();
		played(weights, "Garen", 90000, 0, 0, 0, 0);
		played(weights, "Syndra", 0, 80000, 0, 0, 0);
		played(weights, "Zeri", 0, 0, 0, 70000, 0);
		played(weights, "Leona", 0, 0, 0, 0, 60000);

		Map<String, String> guessed = identify(weights, "Garen", "Syndra", "Zeri", "Leona", "BrandNewChampion");

		assertThat(guessed).containsEntry("BrandNewChampion", "Jungle");
	}

	@Test
	public void leavesTheUnlikeliestRoleEmptyWhenTheTeamIsIncomplete() {
		Set<ChampionRole<String, String>> weights = new HashSet<>();
		played(weights, "Garen", 90000, 3000, 0, 0, 0);
		played(weights, "Syndra", 2000, 80000, 0, 0, 0);

		Map<String, String> guessed = identify(weights, "Garen", "Syndra");

		assertThat(guessed).hasSize(2).containsEntry("Garen", "Top").containsEntry("Syndra", "Middle");
	}

	@Test
	public void leavesTheRoleEmptyWhenItsOnlyCandidateBelongsElsewhere() {
		// Reported from White_LoLPicker on 2026-10-26, patches 16.20 and 16.21: the per-role algorithm put Wukong in
		// the top lane, the first role it visits and one nobody else could take, off 8% of his games.
		Set<ChampionRole<String, String>> weights = new HashSet<>();
		played(weights, "Brand", 0, 101694, 0, 38832, 390428);
		played(weights, "Wukong", 44480, 0, 499478, 0, 0);
		played(weights, "Thresh", 0, 0, 0, 0, 672113);

		Map<String, String> guessed = identify(weights, "Brand", "Wukong", "Thresh");

		assertThat(guessed)
				.as("92% of Wukong's games")
				.containsEntry("Wukong", "Jungle")
				.containsEntry("Thresh", "Utility")
				.containsEntry("Brand", "Middle")
				.as("the enemy top laner is one not picked yet")
				.doesNotContainValue("Top");
	}

	@Test
	public void reproducesWukongInTheTopLaneWithThePerRoleAlgorithm() {
		Set<ChampionRole<String, String>> weights = new HashSet<>();
		played(weights, "Brand", 0, 101694, 0, 38832, 390428);
		played(weights, "Wukong", 44480, 0, 499478, 0, 0);
		played(weights, "Thresh", 0, 0, 0, 0, 672113);

		Map<String, String> guessed = new RoleIdentifier<>(ROLES, weights)
				.identifyRoles(new LinkedHashSet<>(Arrays.asList("Brand", "Wukong", "Thresh")));

		assertThat(guessed).as("what White_LoLPicker answered on 2026-10-26").containsEntry("Wukong", "Top");
	}

	@Test
	public void givesEveryChampionADistinctRole() {
		// Five champions all mostly played in the same lane still get five different roles.
		Set<ChampionRole<String, String>> weights = new HashSet<>();
		played(weights, "Sona", 1, 2, 3, 40, 1000);
		played(weights, "Janna", 2, 3, 1, 10, 1000);
		played(weights, "Taric", 5, 1, 2, 1, 1000);
		played(weights, "Blitzcrank", 1, 1, 9, 3, 1000);
		played(weights, "Leona", 1, 7, 1, 2, 1000);

		Map<String, String> guessed = identify(weights, "Sona", "Janna", "Taric", "Blitzcrank", "Leona");

		assertThat(new HashSet<>(guessed.values())).containsExactlyInAnyOrderElementsOf(ROLES);
		assertThat(guessed)
				.containsEntry("Sona", "Bottom")
				.containsEntry("Taric", "Top")
				.containsEntry("Blitzcrank", "Jungle")
				.containsEntry("Leona", "Middle")
				.containsEntry("Janna", "Utility");
	}

	@Test
	public void answersNothingForNoChampions() {
		assertThat(identify(new HashSet<>())).isEmpty();
	}

	@Test
	public void refusesMoreChampionsThanRoles() {
		assertThatThrownBy(() -> identify(new HashSet<>(), "A", "B", "C", "D", "E", "F"))
				.isInstanceOf(IllegalArgumentException.class);
	}
}
