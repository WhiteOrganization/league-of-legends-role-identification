package org.white_sdev.white_gaming.lol;

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
	public void easyComposition() {
		Set<String> champions = Set.of("Aatrox", "Alistar", "Ashe", "Azir", "Belveth");
		Map<String, String> championRoles = RoleIdentifier.identifyStringRoles(champions);
		assertThat(championRoles)
				.as("It works with an easy composition")
				.containsEntry("Top", "Aatrox")
				.containsEntry("Middle", "Azir")
				.containsEntry("Bottom", "Ashe")
				.containsEntry("Utility", "Alistar")
				.containsEntry("Jungle", "Belveth");
	}
	
	@Test
	public void incompleteComposition() {
		Set<String> champions = Set.of("Garen", "Syndra", "Zeri", "Veigar");
		Map<String, String> championRoles = RoleIdentifier.identifyStringRoles(champions);
		assertThat(championRoles)
				.as("It accepts incomplete compositions and answers correctly")
				.containsEntry("Top", "Garen")
				.containsEntry("Middle", "Syndra")
				.containsKey("Bottom")
				.containsValues("Zeri","Veigar");
	}
	
	@Test
	public void hardComposition() {
		Set<String> champions = Set.of("Annie", "Rumble", "Vayne", "Senna", "Veigar");
		Map<String, String> championRoles = RoleIdentifier.identifyStringRoles(champions);
		assertThat(championRoles)
				.as("It works with a complex composition")
				.containsKey("Middle")
				.doesNotContainEntry("Middle", "Vayne")
				.doesNotContainEntry("Top", "Senna")
				.containsKey("Utility")
				.containsEntry("Jungle", "Rumble");
	}
	
	@Test
	public void repeatedSingleRoleChampionsComposition() {
		Set<String> champions = Set.of("Sona", "Janna", "Taric", "Blitzcrank", "Leona");
		Map<String, String> championRoles = RoleIdentifier.identifyStringRoles(champions);
		assertThat(championRoles)
				.as("It works even with a single role sup Composition")
				.containsKey("Top")
				.containsKey("Middle")
				.containsKey("Bottom")
				.containsKey("Utility")
				.containsKey("Jungle");
	}
	
	@Test
	public void cochilepoTest1(){
		Set<String> champions = Set.of("Velkoz", "Rumble", "JarvanIV", "Kaisa", "Cassiopeia");
		Map<String, String> championRoles = RoleIdentifier.identifyStringRoles(champions);
		assertThat(championRoles)
				.as("It works with an easy composition")
				.containsEntry("Top","Cassiopeia")
				.containsEntry("Utility","Velkoz")
				.containsEntry("Jungle","JarvanIV")
				.containsEntry("Bottom","Kaisa")
				.containsEntry("Middle","Rumble");
	}
	
	@Test
	public void doubleAdc(){
		Set<String> champions = Set.of("Velkoz", "Jinx", "JarvanIV", "Vayne", "Cassiopeia");
		Map<String, String> championRoles = RoleIdentifier.identifyStringRoles(champions);
		assertThat(championRoles)
				.as("It works with an easy composition")
				.containsEntry("Utility","Velkoz")
				.containsEntry("Middle","Cassiopeia")
				.containsEntry("Jungle","JarvanIV")
				.containsEntry("Bottom","Jinx")
				.containsEntry("Top","Vayne");
	}
	
	@Test
	public void noJungleComposition(){
		Set<String> champions = Set.of("Zed", "Velkoz", "Lux", "Vayne", "Kaisa");
		Map<String, String> championRoles = RoleIdentifier.identifyStringRoles(champions);
		assertThat(championRoles)
				.as("It works with an easy composition")
				.containsEntry("Top","Vayne")
				.containsEntry("Jungle","Zed")
				.containsEntry("Bottom","Kaisa")
				.containsEntry("Utility","Velkoz")
				.containsEntry("Middle","Lux");
	}
	
	@Test
	public void hackeritsTest1(){
		Set<String> champions = Set.of("Tristana", "Karthus", "Ashe", "Vayne", "Senna");
		Map<String, String> championRoles = RoleIdentifier.identifyStringRoles(champions);
		assertThat(championRoles)
				.as("It works with an easy composition")
				.containsEntry("Top","Vayne")
				.containsEntry("Jungle","Karthus")
				.containsEntry("Bottom","Ashe")
				.containsEntry("Utility","Senna")
				.containsEntry("Middle","Tristana");
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
		
		Map<Lane, Champ> championRoles = new RoleIdentifier<>(lanes, championsRoles).identifyRoles(champions);
		assertThat(championRoles)
				.as("A real match is guessed correctly.")
				.containsEntry(top, gangplank)
				.containsEntry(jg, nunu)
				.containsEntry(mid, sylas)
				.containsEntry(adc, sivir)
				.containsEntry(sup, tahm);
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