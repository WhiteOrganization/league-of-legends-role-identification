package org.white_sdev.white_gaming.lol;

import com.sun.tools.javac.Main;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@lombok.extern.slf4j.Slf4j
@NoArgsConstructor
public class RoleIdentifierTest {
	@Test
	public void easyComposition(){
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
	public void incompleteComposition(){
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
	public void hardComposition(){
		List<String> champions = List.of("Annie", "Mordekaiser", "Vayne", "Senna", "Veigar");
		Map<String, String> championRoles = RoleIdentifier.genericRoleIdentifier().identifyRoles(champions);
		assertThat(championRoles)
				.as("It works with an easy composition")
				.containsEntry("Top", "Vayne")
				.containsKey("Middle")
				.containsEntry("Bottom", "Senna")
				.containsKey("Utility")
				.containsEntry("Jungle", "Mordekaiser");
	}
	
	@Test
	public void complexComposition(){
	
	}
	
}