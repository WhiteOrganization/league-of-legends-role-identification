package org.white_sdev.white_gaming.lol;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

/**
 * TODO: Complete class documentation
 */
@lombok.extern.slf4j.Slf4j
@NoArgsConstructor
@SuppressWarnings("unused")
public class RoleIdentifier <Champion, Role>{
	List<Role> roles;
	Map<Champion, Role> primaryForChampions;
	Multimap<Champion, Role> rolesForChampions;
	//region Methods
	//region Constructors
	public RoleIdentifier(List<Role> roles, Map<Champion, Role> primaryForChampions, Multimap<Champion, Role> rolesForChampions){
		this(roles, rolesForChampions);
		String logID="::RoleIdentifier([primaryForChampions, rolesForChampion]): ";
		log.trace("{}Start ", logID);
		this.primaryForChampions = primaryForChampions;
	}
	
	public RoleIdentifier(List<Role> roles, Multimap<Champion, Role> rolesForChampions){
		String logID="::RoleIdentifier([rolesForChampion]): ";
		log.trace("{}Start ", logID);
		this.rolesForChampions = rolesForChampions;
		this.roles = roles;
	}
	
	@SuppressWarnings("all")
	private static Multimap<String, String> getGenericSecondaryRoles(){
		Multimap<String, String> secondary = ArrayListMultimap.create();
		secondary.put("Annie","Utility");
		secondary.put("Annie","Middle");
		secondary.put("Annie","Bottom");
		secondary.put("Annie","Top");
		secondary.put("Olaf","Jungle");
		secondary.put("Olaf","Middle");
		secondary.put("Olaf","Top");
		secondary.put("Galio","Middle");
		secondary.put("Galio","Top");
		secondary.put("Galio","Utility");
		secondary.put("TwistedFate","Middle");
		secondary.put("TwistedFate","Utility");
		secondary.put("XinZhao","Top");
		secondary.put("XinZhao","Middle");
		secondary.put("XinZhao","Jungle");
		secondary.put("Urgot","Top");
		secondary.put("Leblanc","Utility");
		secondary.put("Leblanc","Middle");
		secondary.put("Leblanc","Bottom");
		secondary.put("Leblanc","Top");
		secondary.put("Vladimir","Middle");
		secondary.put("Vladimir","Top");
		secondary.put("Fiddlesticks","Top");
		secondary.put("Fiddlesticks","Jungle");
		secondary.put("Fiddlesticks","Utility");
		secondary.put("Kayle","Middle");
		secondary.put("Kayle","Top");
		secondary.put("MasterYi","Jungle");
		secondary.put("MasterYi","Middle");
		secondary.put("MasterYi","Top");
		secondary.put("Alistar","Top");
		secondary.put("Alistar","Utility");
		secondary.put("Ryze","Middle");
		secondary.put("Ryze","Bottom");
		secondary.put("Ryze","Top");
		secondary.put("Sion","Utility");
		secondary.put("Sion","Top");
		secondary.put("Sion","Middle");
		secondary.put("Sion","Jungle");
		secondary.put("Sion","Bottom");
		secondary.put("Sivir","Bottom");
		secondary.put("Sivir","Middle");
		secondary.put("Soraka","Top");
		secondary.put("Soraka","Utility");
		secondary.put("Teemo","Utility");
		secondary.put("Teemo","Jungle");
		secondary.put("Teemo","Top");
		secondary.put("Teemo","Middle");
		secondary.put("Tristana","Middle");
		secondary.put("Tristana","Bottom");
		secondary.put("Tristana","Top");
		secondary.put("Warwick","Jungle");
		secondary.put("Warwick","Top");
		secondary.put("Nunu","Utility");
		secondary.put("Nunu","Middle");
		secondary.put("Nunu","Jungle");
		secondary.put("MissFortune","Utility");
		secondary.put("MissFortune","Bottom");
		secondary.put("Ashe","Bottom");
		secondary.put("Ashe","Utility");
		secondary.put("Ashe","Top");
		secondary.put("Tryndamere","Middle");
		secondary.put("Tryndamere","Top");
		secondary.put("Jax","Top");
		secondary.put("Jax","Jungle");
		secondary.put("Jax","Middle");
		secondary.put("Morgana","Top");
		secondary.put("Morgana","Utility");
		secondary.put("Morgana","Middle");
		secondary.put("Morgana","Jungle");
		secondary.put("Zilean","Utility");
		secondary.put("Zilean","Middle");
		secondary.put("Singed","Top");
		secondary.put("Singed","Jungle");
		secondary.put("Singed","Middle");
		secondary.put("Evelynn","Jungle");
		secondary.put("Evelynn","Utility");
		secondary.put("Twitch","Jungle");
		secondary.put("Twitch","Bottom");
		secondary.put("Twitch","Middle");
		secondary.put("Twitch","Utility");
		secondary.put("Twitch","Top");
		secondary.put("Karthus","Middle");
		secondary.put("Karthus","Top");
		secondary.put("Karthus","Jungle");
		secondary.put("Karthus","Utility");
		secondary.put("Karthus","Bottom");
		secondary.put("Chogath","Utility");
		secondary.put("Chogath","Top");
		secondary.put("Chogath","Jungle");
		secondary.put("Chogath","Middle");
		secondary.put("Chogath","Bottom");
		secondary.put("Amumu","Jungle");
		secondary.put("Amumu","Utility");
		secondary.put("Rammus","Middle");
		secondary.put("Rammus","Top");
		secondary.put("Rammus","Jungle");
		secondary.put("Rammus","Utility");
		secondary.put("Anivia","Top");
		secondary.put("Anivia","Utility");
		secondary.put("Anivia","Bottom");
		secondary.put("Anivia","Middle");
		secondary.put("Shaco","Utility");
		secondary.put("Shaco","Middle");
		secondary.put("Shaco","Top");
		secondary.put("Shaco","Jungle");
		secondary.put("DrMundo","Middle");
		secondary.put("DrMundo","Top");
		secondary.put("DrMundo","Jungle");
		secondary.put("Sona","Utility");
		secondary.put("Kassadin","Middle");
		secondary.put("Kassadin","Top");
		secondary.put("Irelia","Middle");
		secondary.put("Irelia","Top");
		secondary.put("Irelia","Bottom");
		secondary.put("Janna","Utility");
		secondary.put("Gangplank","Middle");
		secondary.put("Gangplank","Top");
		secondary.put("Corki","Middle");
		secondary.put("Karma","Top");
		secondary.put("Karma","Utility");
		secondary.put("Karma","Middle");
		secondary.put("Taric","Utility");
		secondary.put("Veigar","Top");
		secondary.put("Veigar","Utility");
		secondary.put("Veigar","Bottom");
		secondary.put("Veigar","Middle");
		secondary.put("Trundle","Top");
		secondary.put("Trundle","Utility");
		secondary.put("Trundle","Jungle");
		secondary.put("Swain","Bottom");
		secondary.put("Swain","Top");
		secondary.put("Swain","Utility");
		secondary.put("Swain","Middle");
		secondary.put("Caitlyn","Middle");
		secondary.put("Caitlyn","Bottom");
		secondary.put("Caitlyn","Utility");
		secondary.put("Blitzcrank","Utility");
		secondary.put("Malphite","Utility");
		secondary.put("Malphite","Jungle");
		secondary.put("Malphite","Top");
		secondary.put("Malphite","Middle");
		secondary.put("Katarina","Bottom");
		secondary.put("Katarina","Top");
		secondary.put("Katarina","Middle");
		secondary.put("Nocturne","Jungle");
		secondary.put("Maokai","Utility");
		secondary.put("Maokai","Jungle");
		secondary.put("Maokai","Top");
		secondary.put("Renekton","Top");
		secondary.put("Renekton","Middle");
		secondary.put("JarvanIV","Utility");
		secondary.put("JarvanIV","Jungle");
		secondary.put("JarvanIV","Middle");
		secondary.put("JarvanIV","Top");
		secondary.put("Elise","Jungle");
		secondary.put("Elise","Utility");
		secondary.put("Orianna","Utility");
		secondary.put("Orianna","Middle");
		secondary.put("MonkeyKing","Jungle");
		secondary.put("MonkeyKing","Utility");
		secondary.put("MonkeyKing","Middle");
		secondary.put("MonkeyKing","Top");
		secondary.put("Brand","Bottom");
		secondary.put("Brand","Utility");
		secondary.put("Brand","Middle");
		secondary.put("LeeSin","Utility");
		secondary.put("LeeSin","Jungle");
		secondary.put("LeeSin","Middle");
		secondary.put("LeeSin","Top");
		secondary.put("Vayne","Middle");
		secondary.put("Vayne","Top");
		secondary.put("Vayne","Bottom");
		secondary.put("Rumble","Middle");
		secondary.put("Rumble","Top");
		secondary.put("Rumble","Utility");
		secondary.put("Rumble","Jungle");
		secondary.put("Cassiopeia","Bottom");
		secondary.put("Cassiopeia","Top");
		secondary.put("Cassiopeia","Middle");
		secondary.put("Skarner","Jungle");
		secondary.put("Heimerdinger","Bottom");
		secondary.put("Heimerdinger","Top");
		secondary.put("Heimerdinger","Utility");
		secondary.put("Heimerdinger","Middle");
		secondary.put("Nasus","Middle");
		secondary.put("Nasus","Top");
		secondary.put("Nasus","Jungle");
		secondary.put("Nidalee","Jungle");
		secondary.put("Nidalee","Utility");
		secondary.put("Udyr","Middle");
		secondary.put("Udyr","Top");
		secondary.put("Udyr","Jungle");
		secondary.put("Poppy","Top");
		secondary.put("Poppy","Utility");
		secondary.put("Poppy","Jungle");
		secondary.put("Gragas","Top");
		secondary.put("Gragas","Utility");
		secondary.put("Gragas","Middle");
		secondary.put("Gragas","Jungle");
		secondary.put("Pantheon","Jungle");
		secondary.put("Pantheon","Middle");
		secondary.put("Pantheon","Top");
		secondary.put("Pantheon","Utility");
		secondary.put("Pantheon","Bottom");
		secondary.put("Ezreal","Bottom");
		secondary.put("Ezreal","Middle");
		secondary.put("Ezreal","Utility");
		secondary.put("Mordekaiser","Top");
		secondary.put("Mordekaiser","Jungle");
		secondary.put("Mordekaiser","Middle");
		secondary.put("Yorick","Jungle");
		secondary.put("Yorick","Top");
		secondary.put("Yorick","Middle");
		secondary.put("Akali","Middle");
		secondary.put("Akali","Top");
		secondary.put("Kennen","Utility");
		secondary.put("Kennen","Top");
		secondary.put("Kennen","Middle");
		secondary.put("Garen","Middle");
		secondary.put("Garen","Top");
		secondary.put("Leona","Utility");
		secondary.put("Malzahar","Bottom");
		secondary.put("Malzahar","Top");
		secondary.put("Malzahar","Utility");
		secondary.put("Malzahar","Middle");
		secondary.put("Talon","Jungle");
		secondary.put("Talon","Top");
		secondary.put("Talon","Middle");
		secondary.put("Riven","Top");
		secondary.put("Riven","Middle");
		secondary.put("KogMaw","Middle");
		secondary.put("KogMaw","Bottom");
		secondary.put("KogMaw","Utility");
		secondary.put("Shen","Middle");
		secondary.put("Shen","Top");
		secondary.put("Shen","Utility");
		secondary.put("Lux","Utility");
		secondary.put("Lux","Middle");
		secondary.put("Lux","Bottom");
		secondary.put("Xerath","Utility");
		secondary.put("Xerath","Middle");
		secondary.put("Xerath","Bottom");
		secondary.put("Shyvana","Jungle");
		secondary.put("Shyvana","Middle");
		secondary.put("Shyvana","Top");
		secondary.put("Ahri","Middle");
		secondary.put("Ahri","Top");
		secondary.put("Ahri","Utility");
		secondary.put("Ahri","Bottom");
		secondary.put("Graves","Middle");
		secondary.put("Graves","Top");
		secondary.put("Graves","Jungle");
		secondary.put("Fizz","Top");
		secondary.put("Fizz","Middle");
		secondary.put("Volibear","Jungle");
		secondary.put("Volibear","Top");
		secondary.put("Rengar","Top");
		secondary.put("Rengar","Jungle");
		secondary.put("Varus","Bottom");
		secondary.put("Varus","Middle");
		secondary.put("Varus","Utility");
		secondary.put("Varus","Top");
		secondary.put("Nautilus","Utility");
		secondary.put("Nautilus","Top");
		secondary.put("Viktor","Middle");
		secondary.put("Viktor","Top");
		secondary.put("Viktor","Bottom");
		secondary.put("Sejuani","Utility");
		secondary.put("Sejuani","Top");
		secondary.put("Sejuani","Jungle");
		secondary.put("Fiora","Middle");
		secondary.put("Fiora","Top");
		secondary.put("Ziggs","Middle");
		secondary.put("Ziggs","Bottom");
		secondary.put("Ziggs","Utility");
		secondary.put("Lulu","Middle");
		secondary.put("Lulu","Utility");
		secondary.put("Draven","Bottom");
		secondary.put("Draven","Middle");
		secondary.put("Draven","Top");
		secondary.put("Hecarim","Jungle");
		secondary.put("Khazix","Jungle");
		secondary.put("Khazix","Top");
		secondary.put("Darius","Jungle");
		secondary.put("Darius","Middle");
		secondary.put("Darius","Top");
		secondary.put("Jayce","Middle");
		secondary.put("Jayce","Top");
		secondary.put("Lissandra","Middle");
		secondary.put("Lissandra","Top");
		secondary.put("Lissandra","Utility");
		secondary.put("Diana","Jungle");
		secondary.put("Diana","Middle");
		secondary.put("Quinn","Middle");
		secondary.put("Quinn","Top");
		secondary.put("Syndra","Utility");
		secondary.put("Syndra","Bottom");
		secondary.put("Syndra","Middle");
		secondary.put("Syndra","Top");
		secondary.put("AurelionSol","Middle");
		secondary.put("AurelionSol","Bottom");
		secondary.put("AurelionSol","Top");
		secondary.put("AurelionSol","Utility");
		secondary.put("Kayn","Top");
		secondary.put("Kayn","Jungle");
		secondary.put("Zoe","Middle");
		secondary.put("Zoe","Utility");
		secondary.put("Zyra","Middle");
		secondary.put("Zyra","Utility");
		secondary.put("Kaisa","Bottom");
		secondary.put("Kaisa","Middle");
		secondary.put("Kaisa","Utility");
		secondary.put("Kaisa","Top");
		secondary.put("Seraphine","Bottom");
		secondary.put("Seraphine","Middle");
		secondary.put("Seraphine","Utility");
		secondary.put("Gnar","Top");
		secondary.put("Zac","Top");
		secondary.put("Zac","Jungle");
		secondary.put("Zac","Utility");
		secondary.put("Zac","Middle");
		secondary.put("Yasuo","Bottom");
		secondary.put("Yasuo","Top");
		secondary.put("Yasuo","Middle");
		secondary.put("Velkoz","Middle");
		secondary.put("Velkoz","Utility");
		secondary.put("Taliyah","Jungle");
		secondary.put("Taliyah","Utility");
		secondary.put("Taliyah","Middle");
		secondary.put("Camille","Top");
		secondary.put("Camille","Middle");
		secondary.put("Akshan","Middle");
		secondary.put("Akshan","Bottom");
		secondary.put("Akshan","Top");
		secondary.put("Akshan","Utility");
		secondary.put("Belveth","Middle");
		secondary.put("Belveth","Top");
		secondary.put("Belveth","Jungle");
		secondary.put("Belveth","Utility");
		secondary.put("Braum","Utility");
		secondary.put("Jhin","Bottom");
		secondary.put("Jhin","Middle");
		secondary.put("Jhin","Utility");
		secondary.put("Kindred","Jungle");
		secondary.put("Zeri","Bottom");
		secondary.put("Zeri","Top");
		secondary.put("Zeri","Middle");
		secondary.put("Jinx","Middle");
		secondary.put("Jinx","Bottom");
		secondary.put("TahmKench","Middle");
		secondary.put("TahmKench","Top");
		secondary.put("TahmKench","Utility");
		secondary.put("TahmKench","Bottom");
		secondary.put("Viego","Top");
		secondary.put("Viego","Jungle");
		secondary.put("Viego","Middle");
		secondary.put("Senna","Bottom");
		secondary.put("Senna","Utility");
		secondary.put("Lucian","Middle");
		secondary.put("Lucian","Top");
		secondary.put("Lucian","Bottom");
		secondary.put("Zed","Jungle");
		secondary.put("Zed","Top");
		secondary.put("Zed","Middle");
		secondary.put("Kled","Middle");
		secondary.put("Kled","Top");
		secondary.put("Ekko","Jungle");
		secondary.put("Ekko","Middle");
		secondary.put("Ekko","Top");
		secondary.put("Qiyana","Middle");
		secondary.put("Qiyana","Top");
		secondary.put("Qiyana","Jungle");
		secondary.put("Vi","Jungle");
		secondary.put("Vi","Middle");
		secondary.put("Aatrox","Utility");
		secondary.put("Aatrox","Top");
		secondary.put("Aatrox","Middle");
		secondary.put("Nami","Utility");
		secondary.put("Azir","Middle");
		secondary.put("Azir","Top");
		secondary.put("Yuumi","Utility");
		secondary.put("Samira","Bottom");
		secondary.put("Samira","Middle");
		secondary.put("Thresh","Top");
		secondary.put("Thresh","Utility");
		secondary.put("Illaoi","Middle");
		secondary.put("Illaoi","Top");
		secondary.put("RekSai","Jungle");
		secondary.put("Ivern","Utility");
		secondary.put("Ivern","Jungle");
		secondary.put("Kalista","Bottom");
		secondary.put("Kalista","Middle");
		secondary.put("Kalista","Utility");
		secondary.put("Kalista","Top");
		secondary.put("Bard","Utility");
		secondary.put("Rakan","Utility");
		secondary.put("Xayah","Middle");
		secondary.put("Xayah","Bottom");
		secondary.put("Ornn","Top");
		secondary.put("Ornn","Middle");
		secondary.put("Sylas","Utility");
		secondary.put("Sylas","Middle");
		secondary.put("Sylas","Top");
		secondary.put("Sylas","Jungle");
		secondary.put("Neeko","Top");
		secondary.put("Neeko","Utility");
		secondary.put("Neeko","Middle");
		secondary.put("Aphelios","Bottom");
		secondary.put("Rell","Utility");
		secondary.put("Pyke","Utility");
		secondary.put("Pyke","Middle");
		secondary.put("Vex","Middle");
		secondary.put("Vex","Bottom");
		secondary.put("Vex","Top");
		secondary.put("Vex","Utility");
		secondary.put("Yone","Middle");
		secondary.put("Yone","Bottom");
		secondary.put("Yone","Top");
		secondary.put("Sett","Utility");
		secondary.put("Sett","Top");
		secondary.put("Sett","Middle");
		secondary.put("Lillia","Top");
		secondary.put("Lillia","Jungle");
		secondary.put("Gwen","Jungle");
		secondary.put("Gwen","Middle");
		secondary.put("Gwen","Top");
		secondary.put("Renata","Utility");
		secondary.put("Nilah","Bottom");
		secondary.put("KSante","Middle");
		secondary.put("KSante","Top");
		secondary.put("Milio","Utility");
		return secondary;
	}
	public static RoleIdentifier<String, String> genericRoleIdentifier(){
		@SuppressWarnings("all")
		Map<String, String> primary = new HashMap<>(){{
			put("Annie","Middle");
			put("Olaf","Top");
			put("Galio","Middle");
			put("TwistedFate","Middle");
			put("XinZhao","Jungle");
			put("Urgot","Top");
			put("Leblanc","Middle");
			put("Vladimir","Middle");
			put("Fiddlesticks","Jungle");
			put("Kayle","Top");
			put("MasterYi","Jungle");
			put("Alistar","Utility");
			put("Ryze","Middle");
			put("Sion","Top");
			put("Sivir","Bottom");
			put("Soraka","Utility");
			put("Teemo","Top");
			put("Tristana","Bottom");
			put("Warwick","Jungle");
			put("Nunu","Jungle");
			put("MissFortune","Bottom");
			put("Ashe","Bottom");
			put("Tryndamere","Top");
			put("Jax","Top");
			put("Morgana","Utility");
			put("Zilean","Utility");
			put("Singed","Top");
			put("Evelynn","Jungle");
			put("Twitch","Bottom");
			put("Karthus","Jungle");
			put("Chogath","Top");
			put("Amumu","Jungle");
			put("Rammus","Jungle");
			put("Anivia","Middle");
			put("Shaco","Jungle");
			put("DrMundo","Top");
			put("Sona","Utility");
			put("Kassadin","Middle");
			put("Irelia","Middle");
			put("Janna","Utility");
			put("Gangplank","Top");
			put("Corki","Middle");
			put("Karma","Utility");
			put("Taric","Utility");
			put("Veigar","Middle");
			put("Trundle","Jungle");
			put("Swain","Utility");
			put("Caitlyn","Bottom");
			put("Blitzcrank","Utility");
			put("Malphite","Top");
			put("Katarina","Middle");
			put("Nocturne","Jungle");
			put("Maokai","Jungle");
			put("Renekton","Top");
			put("JarvanIV","Jungle");
			put("Elise","Jungle");
			put("Orianna","Middle");
			put("MonkeyKing","Jungle");
			put("Brand","Utility");
			put("LeeSin","Jungle");
			put("Vayne","Bottom");
			put("Rumble","Top");
			put("Cassiopeia","Middle");
			put("Skarner","Jungle");
			put("Heimerdinger","Utility");
			put("Nasus","Top");
			put("Nidalee","Jungle");
			put("Udyr","Jungle");
			put("Poppy","Top");
			put("Gragas","Jungle");
			put("Pantheon","Middle");
			put("Ezreal","Bottom");
			put("Mordekaiser","Top");
			put("Yorick","Top");
			put("Akali","Middle");
			put("Kennen","Top");
			put("Garen","Top");
			put("Leona","Utility");
			put("Malzahar","Middle");
			put("Talon","Middle");
			put("Riven","Top");
			put("KogMaw","Bottom");
			put("Shen","Top");
			put("Lux","Utility");
			put("Xerath","Utility");
			put("Shyvana","Jungle");
			put("Ahri","Middle");
			put("Graves","Jungle");
			put("Fizz","Middle");
			put("Volibear","Top");
			put("Rengar","Jungle");
			put("Varus","Bottom");
			put("Nautilus","Utility");
			put("Viktor","Middle");
			put("Sejuani","Jungle");
			put("Fiora","Top");
			put("Ziggs","Middle");
			put("Lulu","Utility");
			put("Draven","Bottom");
			put("Hecarim","Jungle");
			put("Khazix","Jungle");
			put("Darius","Top");
			put("Jayce","Top");
			put("Lissandra","Middle");
			put("Diana","Jungle");
			put("Quinn","Top");
			put("Syndra","Middle");
			put("AurelionSol","Middle");
			put("Kayn","Jungle");
			put("Zoe","Middle");
			put("Zyra","Utility");
			put("Kaisa","Bottom");
			put("Seraphine","Utility");
			put("Gnar","Top");
			put("Zac","Jungle");
			put("Yasuo","Middle");
			put("Velkoz","Utility");
			put("Taliyah","Middle");
			put("Camille","Top");
			put("Akshan","Middle");
			put("Belveth","Jungle");
			put("Braum","Utility");
			put("Jhin","Bottom");
			put("Kindred","Jungle");
			put("Zeri","Bottom");
			put("Jinx","Bottom");
			put("TahmKench","Top");
			put("Viego","Jungle");
			put("Senna","Utility");
			put("Lucian","Bottom");
			put("Zed","Middle");
			put("Kled","Top");
			put("Ekko","Jungle");
			put("Qiyana","Middle");
			put("Vi","Jungle");
			put("Aatrox","Top");
			put("Nami","Utility");
			put("Azir","Middle");
			put("Yuumi","Utility");
			put("Samira","Bottom");
			put("Thresh","Utility");
			put("Illaoi","Top");
			put("RekSai","Jungle");
			put("Ivern","Jungle");
			put("Kalista","Bottom");
			put("Bard","Utility");
			put("Rakan","Utility");
			put("Xayah","Bottom");
			put("Ornn","Top");
			put("Sylas","Middle");
			put("Neeko","Middle");
			put("Aphelios","Bottom");
			put("Rell","Utility");
			put("Pyke","Utility");
			put("Vex","Middle");
			put("Yone","Middle");
			put("Sett","Top");
			put("Lillia","Jungle");
			put("Gwen","Top");
			put("Renata","Utility");
			put("Nilah","Bottom");
			put("KSante","Top");
			put("Milio","Utility");
		}};
		return new RoleIdentifier<>(List.of("Top", "Jungle","Middle",  "Bottom", "Utility"), primary, getGenericSecondaryRoles());
	}
	
	//endregion Constructors
	
	//region Chained Getters & Setters
	public RoleIdentifier<Champion, Role> primaryForChampions(Map<Champion, Role> primaryForChampions){
		this.primaryForChampions = primaryForChampions;
				return this;
	}
	public RoleIdentifier<Champion, Role> rolesForChampions(Multimap<Champion, Role> rolesForChampions){
		this.rolesForChampions = rolesForChampions;
		return this;
	}
	
	//endregion Chained Getters & Setters
	
	public Map<Role, Champion> identifyRoles(List<Champion> champions){
		String logID="::identifyRoles([champions]): ";
		log.trace("{}Start ", logID);
		List<Champion> unassignedChampions = new ArrayList<>(champions);
		List<Role> unassignedRoles = new ArrayList<>(roles);
		Map<Role, Champion> guesstimate = new HashMap<>();
		
		int iterations = 4;
		for (int i = 0; i++ <iterations;) {
			for (var role : new ArrayList<>(unassignedRoles)) {
				log.debug("{}Role:{}", logID, role);
				HashSet<Champion> championsThatCanBeInThatRole = new HashSet<>(getChampionsWithPrimaryRole(role, unassignedChampions));
				championsThatCanBeInThatRole.addAll( getChampionsWithRole(role, unassignedChampions));
				log.debug("{}championsThatCanBeInThatRole:{}", logID, championsThatCanBeInThatRole);
				if (championsThatCanBeInThatRole.size() == 1) {
					var foundChampion = championsThatCanBeInThatRole.iterator().next();
					log.debug("{}adding foundChampion:{} to role:{}", logID, foundChampion, role);
					unassignedRoles.remove(role);
					unassignedChampions.remove(foundChampion);
					guesstimate.put(role, foundChampion);
				}
			}
		}
		
		
		for(var role : new ArrayList<>(unassignedRoles)){
			var championsWithPrimary = getChampionsWithPrimaryRole(role, unassignedChampions);
			var championsWithSecondary = getChampionsWithRole(role, unassignedChampions);
			HashSet<Champion> championsThatCanBeInThatRole = new HashSet<>(championsWithPrimary);
			championsThatCanBeInThatRole.addAll(championsWithSecondary);
			if(!championsThatCanBeInThatRole.isEmpty()){
				if(championsThatCanBeInThatRole.size()>1){
					if(championsWithPrimary.size()>=1){
						var foundChampion = championsWithPrimary.iterator().next();
						unassignedRoles.remove(role);
						unassignedChampions.remove(foundChampion);
						guesstimate.put(role, foundChampion);
						continue;
					}
				}
				var foundChampion = championsThatCanBeInThatRole.iterator().next();
				unassignedRoles.remove(role);
				unassignedChampions.remove(foundChampion);
				guesstimate.put(role, foundChampion);
			}
		}
		
		for (int i = 0; ++i < unassignedChampions.size();)  guesstimate.put(unassignedRoles.get(i), unassignedChampions.get(i));
		
		return guesstimate;
	}
	
	public Set<Champion> getChampionsWithPrimaryRole(Role role, List<Champion> champions){
		return primaryForChampions.entrySet().stream()
				.filter(e->e.getValue().equals(role) && champions.contains(e.getKey()))
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
	}
	
	public Set<Champion> getChampionsWithRole(Role role, List<Champion> champions){
		return champions.stream().filter(c->rolesForChampions.get(c).stream().anyMatch(r->Objects.equals(role, r))).collect(Collectors.toSet());
	}
	
	
	//endregion Methods
}