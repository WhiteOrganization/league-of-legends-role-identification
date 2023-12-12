package org.white_sdev.white_gaming.lol;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@lombok.extern.slf4j.Slf4j
public class ChampionRoleTest {
	//region String Compositions

	
	@Test
	@Disabled
	public void sacrificePrimaryRoleForAnotherChampionToNotBeUseless() {
		Set<String> champions = Set.of("Yuumi", "Soraka", "Lucian", "Gnar", "Zilean");
		Map<String, String> championRoles = RoleIdentifier.identifyStringRoles(champions);
		assertThat(championRoles)
				.as("It works with an easy composition")
				.containsEntry("Zilean", "Top")
				.containsEntry("Soraka", "Middle")
				.containsEntry("Lucian", "Bottom")
				.containsEntry("Yuumi", "Utility")
				.containsEntry("Gnar", "Jungle");
	}
	
	@Test
	public void sennaIsNotSupComposition() {
		Set<String> champions = Set.of("Annie", "Ziggs", "Senna", "Nunu", "Heimerdinger");
		Map<String, String> championRoles = RoleIdentifier.identifyStringRoles(champions);
		assertThat(championRoles)
				.as("It works with an easy composition")
				.containsEntry("Heimerdinger", "Top")
				.containsEntry("Annie", "Middle")
				.containsEntry("Ziggs", "Bottom")
				.containsEntry("Senna", "Utility")
				.containsEntry("Nunu", "Jungle");
	}
	
	@Test
	public void easyComposition() {
		Set<String> champions = Set.of("Aatrox", "Alistar", "Ashe", "Azir", "Belveth");
		Map<String, String> championRoles = RoleIdentifier.identifyStringRoles(champions);
		assertThat(championRoles)
				.as("It works with an easy composition")
				.containsEntry("Aatrox", "Top")
				.containsEntry("Azir", "Middle")
				.containsEntry("Ashe", "Bottom")
				.containsEntry("Alistar", "Utility")
				.containsEntry("Belveth", "Jungle");
	}
	
	@Test
	public void incompleteComposition() {
		Set<String> champions = Set.of("Garen", "Syndra", "Zeri", "Veigar");
		Map<String, String> championRoles = RoleIdentifier.identifyStringRoles(champions);
		assertThat(championRoles)
				.as("It accepts incomplete compositions and answers correctly")
				.containsEntry("Garen", "Top")
				.containsEntry("Syndra", "Middle")
				.containsValue("Bottom")
				.containsKeys("Zeri","Veigar");
	}
	
	@Test
	public void hardComposition() {
		Set<String> champions = Set.of("Annie", "Rumble", "Vayne", "Senna", "Veigar");
		Map<String, String> championRoles = RoleIdentifier.identifyStringRoles(champions);
		assertThat(championRoles)
				.as("It works with a complex composition")
				.containsValue("Middle")
				.doesNotContainEntry("Vayne", "Middle")
				.doesNotContainEntry("Senna", "Top")
				.containsValue("Utility")
				.containsEntry("Rumble", "Jungle");
	}
	
	@Test
	public void repeatedSingleRoleChampionsComposition() {
		Set<String> champions = Set.of("Sona", "Janna", "Taric", "Blitzcrank", "Leona");
		Map<String, String> championRoles = RoleIdentifier.identifyStringRoles(champions);
		assertThat(championRoles)
				.as("It works even with a single role sup Composition")
				.containsEntry("Taric", "Utility")
				.containsValue("Top")
				.containsValue("Middle")
				.containsValue("Bottom")
				.containsValue("Jungle");
	}
	
	@Test
	public void cochilepoTest1(){
		Set<String> champions = Set.of("Velkoz", "Rumble", "JarvanIV", "Kaisa", "Cassiopeia");
		Map<String, String> championRoles = RoleIdentifier.identifyStringRoles(champions);
		assertThat(championRoles)
				.as("It works with an easy composition")
				.containsEntry("Cassiopeia", "Top")
				.containsEntry("Velkoz", "Utility")
				.containsEntry("JarvanIV", "Jungle")
				.containsEntry("Kaisa", "Bottom")
				.containsEntry("Rumble", "Middle");
	}
	
	@Test
	public void cochilepoTest2(){
		Set<String> champions = Set.of("Volibear", "Lulu", "Soraka", "Quinn", "Lucian");
		Map<String, String> championRoles = RoleIdentifier.identifyStringRoles(champions);
		assertThat(championRoles)
				.as("It works with an easy composition")
				.containsEntry("Quinn", "Top")
				.containsEntry("Lulu", "Middle")
				.containsEntry("Volibear", "Jungle")
				.containsEntry("Lucian", "Bottom")
				.containsEntry("Soraka", "Utility");
	}
	
	@Test
	public void doubleAdc(){
		Set<String> champions = Set.of("Velkoz", "Jinx", "JarvanIV", "Vayne", "Cassiopeia");
		Map<String, String> championRoles = RoleIdentifier.identifyStringRoles(champions);
		assertThat(championRoles)
				.as("It works with an easy composition")
				.containsEntry("Velkoz", "Utility")
				.containsEntry("Cassiopeia", "Middle")
				.containsEntry("JarvanIV", "Jungle")
				.containsEntry("Jinx", "Bottom")
				.containsEntry("Vayne", "Top");
	}
	
	@Test
	public void noJungleComposition(){
		Set<String> champions = Set.of("Zed", "Velkoz", "Lux", "Vayne", "Kaisa");
		Map<String, String> championRoles = RoleIdentifier.identifyStringRoles(champions);
		assertThat(championRoles)
				.as("It works with an easy composition")
				.containsEntry("Vayne", "Top")
				.containsEntry("Zed", "Jungle")
				.containsEntry("Kaisa", "Bottom")
				.containsEntry("Velkoz", "Utility")
				.containsEntry("Lux", "Middle");
	}
	
	@Test
	public void hackeritsTest1(){
		Set<String> champions = Set.of("Tristana", "Karthus", "Ashe", "Vayne", "Senna");
		Map<String, String> championRoles = RoleIdentifier.identifyStringRoles(champions);
		assertThat(championRoles)
				.as("It works with an easy composition")
				.containsEntry("Vayne", "Top")
				.containsEntry("Karthus", "Jungle")
				.containsEntry("Ashe", "Bottom")
				.containsEntry("Senna", "Utility")
				.containsEntry("Tristana", "Middle");
	}
	
	@Test
	public void lamentumTest1(){
		Set<String> champions = Set.of("Malphite", "Volibear", "Graves", "Lux", "Vayne");
		Map<String, String> championRoles = RoleIdentifier.identifyStringRoles(champions);
		assertThat(championRoles)
				.as("It works with an easy composition")
				.containsEntry("Graves", "Top")
				.containsEntry("Volibear", "Jungle")
				.containsEntry("Vayne", "Bottom")
				.containsEntry("Lux", "Utility")
				.containsEntry("Malphite", "Middle");
	}
	
	@Test
	public void tryndaMidComposition(){
		Set<String> champions = Set.of("Tryndamere", "Rammus", "Vayne", "Kalista", "Maokai");
		Map<String, String> championRoles = RoleIdentifier.identifyStringRoles(champions);
		assertThat(championRoles)
				.as("It works with an easy composition")
				.containsEntry("Vayne", "Top")
				.containsEntry("Rammus", "Jungle")
				.containsEntry("Kalista", "Bottom")
				.containsEntry("Maokai", "Utility")
				.containsEntry("Tryndamere", "Middle");
	}
	
	@Test
	public void fabianTest1(){
		Set<String> champions = Set.of("Yone", "Poppy", "Malphite", "Yasuo", "Alistar");
		Map<String, String> championRoles = RoleIdentifier.identifyStringRoles(champions);
		assertThat(championRoles)
				.as("It works with an easy composition")
				.containsEntry("Malphite", "Top")
				.containsEntry("Yone", "Middle")
				.containsEntry("Poppy", "Jungle")
				.containsEntry("Yasuo", "Bottom")
				.containsEntry("Alistar", "Utility");
	}
	
	@Test
	public void oneChampionGuess(){
		Set<String> champions = Set.of("Taric");
		Map<String, String> championRoles = RoleIdentifier.identifyStringRoles(champions);
		assertThat(championRoles)
				.as("It works with an 1 champion composition")
				.containsEntry("Taric", "Utility");
	}
	
	@Test
	@SuppressWarnings("all")
	public void emptyGuess(){
		Set<String> champions = new HashSet<>(0);
		Map<String, String> championRoles = RoleIdentifier.identifyStringRoles(champions);
		assertThat(championRoles)
				.as("It works with an empty composition");
	}
	
	//endregion String Compositions
	
	@Test
	@SuppressWarnings("all")
	public void doubleAdcComplexComposition() {
		Lane top = new Lane("top");
		Lane jg = new Lane("jg");
		Lane mid = new Lane("mid");
		Lane adc = new Lane("adc");
		Lane sup = new Lane("sup");
		List<Lane> lanes = List.of(top, jg, mid, adc, sup);
		
		Champ velkoz = new Champ("Velkoz", Map.of(sup, 28d, mid, 39d));
		
		
		Champ jinx = new Champ("Jinx", Map.of(sup, 28d, mid, 39d));
		
		Champ jarvan = new Champ("JarvanIV", Map.of(sup, 28d, mid, 39d));
		//TODO finish test
	}
	@Test
	public void realMatchComplexComposition() {
		Lane top = new Lane("top");
		Lane jg = new Lane("jg");
		Lane mid = new Lane("mid");
		Lane adc = new Lane("adc");
		Lane sup = new Lane("sup");
		Set<Lane> lanes = Set.of(top, jg, mid, adc, sup);
		
		Champ gangplank =new Champ("Gangplank", Map.of(mid, 48.1609901685393, top, 48.4251836821156));
		Champ nunu = 	new Champ("Nunu", Map.of(jg, 49.8760311247641));
		Champ sylas = 	new Champ("Sylas", Map.of(jg, 49.3899559193954, mid, 49.685665784325, top, 49.6517122119927));
		Champ sivir = 	new Champ("Sivir", Map.of(adc, 51.628984228521));
		Champ tahm = 	new Champ("TahmKench", Map.of(top, 51.1789656116026, sup, 49.5336864880996));
		Set<Champ> champions = Set.of(gangplank, nunu, sylas, sivir, tahm);
		Set<ChampionRole<Champ, Lane>> championsRoles = new HashSet<>();
		champions.forEach(
				champion->championsRoles.addAll(
						champion.roles.entrySet().stream().map(e->new ChampionRole<>(champion, e.getKey(), e.getValue())).collect(Collectors.toSet())));
		
		Map<Champ, Lane> championRoles = new RoleIdentifier<>(lanes, championsRoles).identifyRoles(champions);
		assertThat(championRoles)
				.as("A real match is guessed correctly.")
				.containsEntry(gangplank, top)
				.containsEntry(nunu, jg)
				.containsEntry(sylas, mid)
				.containsEntry(sivir, adc)
				.containsEntry(tahm, sup);
	}
	
	
	public static class Lane {
		public String name;
		
		public Lane(String name) {
			this.name = name;
		}
		
		@Override
		public String toString() {
			return "{name='" + name + '\'' + '}';
		}
	}
	
	@SuppressWarnings("unused")
	public static class Champ {
		public String name;
		public Map<Lane, Double> roles;
		
		public Champ(String name, Map<Lane, Double> roles) {
			this.name = name;
			this.roles = roles;
		}
		
		@Override
		public String toString() {
			return "{" + "name='" + name + '\'' + '}';
		}
	}
	
}