package org.white_sdev.white_gaming.lol;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@lombok.extern.slf4j.Slf4j
public class RoleIdentifierTest {
	@Test
	public void easyComposition() {
		List<String> champions = List.of("Aatrox", "Alistar", "Ashe", "Azir", "Belveth");
		Map<String, String> championRoles = RoleIdentifier.genericRoleIdentifier().identifyRoles(champions);
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
		List<String> champions = List.of("Garen", "Syndra", "Zeri", "Veigar");
		Map<String, String> championRoles = RoleIdentifier.genericRoleIdentifier().identifyRoles(champions);
		assertThat(championRoles)
				.as("It accepts incomplete compositions and answers correctly")
				.containsEntry("Top", "Garen")
				.containsEntry("Middle", "Syndra")
				.containsEntry("Bottom", "Zeri")
				.containsEntry("Utility", "Veigar")
				.doesNotContainKey("Jungle");
	}
	
	@Test
	public void hardComposition() {
		List<String> champions = List.of("Annie", "Mordekaiser", "Vayne", "Senna", "Veigar");
		Map<String, String> championRoles = RoleIdentifier.genericRoleIdentifier().identifyRoles(champions);
		assertThat(championRoles)
				.as("It works with a complex composition")
				.containsKey("Middle")
				.doesNotContainEntry("Middle", "Vayne")
				.doesNotContainEntry("Top", "Senna")
				.containsKey("Utility")
				.containsEntry("Jungle", "Mordekaiser");
	}
	
	@Test
	public void repeatedSingleRoleChampionsComposition() {
		List<String> champions = List.of("Sona", "Janna", "Taric", "Blitzcrank", "Leona");
		Map<String, String> championRoles = RoleIdentifier.genericRoleIdentifier().identifyRoles(champions);
		assertThat(championRoles)
				.as("It works even with a single role sup Composition")
				.containsKey("Top")
				.containsKey("Middle")
				.containsKey("Bottom")
				.containsKey("Utility")
				.containsKey("Jungle");
	}
	
	@Test
	public void cochilepoTest(){
		List<String> champions = List.of("Velkoz", "Rumble", "JarvanIV", "Kaisa", "Cassiopeia");
		Map<String, String> championRoles = RoleIdentifier.genericRoleIdentifier().identifyRoles(champions);
		assertThat(championRoles)
				.as("It works with an easy composition"); //TODO finish test
		
	}
	
	@Test
	public void doubleAdc(){
		List<String> champions = List.of("Velkoz", "Jinx", "JarvanIV", "Vayne", "Cassiopeia");
		Map<String, String> championRoles = RoleIdentifier.genericRoleIdentifier().identifyRoles(champions);
		assertThat(championRoles)
				.as("It works with an easy composition"); //TODO finish test
		
	}
	
	
	@Test
	public void dobleAdcComplexComposition() {
		Lane top = new Lane("top");
		Lane jg = new Lane("jg");
		Lane mid = new Lane("mid");
		Lane adc = new Lane("adc");
		Lane sup = new Lane("sup");
		List<Lane> lanes = List.of(top, jg, mid, adc, sup);
		
		Champion velkoz = new Champion("Velkoz", sup, 28d,Map.of(sup, 28d, mid, 39d));
		
		
		Champion jinx = new Champion("Jinx", sup, 28d,Map.of(sup, 28d, mid, 39d));
		
		Champion jarvan = new Champion("JarvanIV", sup, 28d,Map.of(sup, 28d, mid, 39d));
		//TODO finish test
	}
	
	
	
	@Test
	public void realMatchComplexComposition() {
		Lane top = new Lane("top");
		Lane jg = new Lane("jg");
		Lane mid = new Lane("mid");
		Lane adc = new Lane("adc");
		Lane sup = new Lane("sup");
		List<Lane> lanes = List.of(top, jg, mid, adc, sup);
		
		Champion yorik = new Champion("Yorik", top, 1d,Map.of(top, 1d,
													 mid, 50d));
		Champion udir = new Champion("Udir", jg, 8d,Map.of(jg, 8d));
		Champion syndra = new Champion("Syndra", mid, 5d,Map.of(mid, 5d,
													   adc,100d));
		Champion ez = new Champion("Ezreal", adc, 15d,Map.of(adc, 15d,
													   top,100d));
		//TODO finish test
	}
	
	
	public static class Lane {
		public String name;
		
		public Lane(String name) {
			this.name = name;
		}
	}
	
	@SuppressWarnings("unused")
	public static class Champion {
		public String name;
		public Lane primaryRole;
		public Double primaryRoleStrength;
		public Map<Lane, Double> roleStrength;
		
		public Champion(String name, Lane primaryRole, Double primaryRoleStrength, Map<Lane, Double> roleStrength) {
			this.name = name;
			this.primaryRole = primaryRole;
			this.primaryRoleStrength = primaryRoleStrength;
			this.roleStrength = roleStrength;
		}
	}
	
}