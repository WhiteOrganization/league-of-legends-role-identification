package org.white_sdev.white_gaming.lol;

import java.util.*;
import java.util.stream.Collectors;

/**
 * TODO: Complete class documentation
 */
@lombok.extern.slf4j.Slf4j
public class RoleIdentifier<Champion, Role> {
	Set<Role> roles;
	Set<ChampionRole<Champion, Role>> championRoles;
	
	//region Methods
	//region static
	public RoleIdentifier(Set<Role> roles, Set<ChampionRole<Champion, Role>> championRoles){
		this.roles = roles;
		this.championRoles = championRoles;
	}
	
	private static Set<ChampionRole<String, String>> getStringChampionRoles(){
		Set<ChampionRole<String,String>> championRoles = new HashSet<>(244);
		championRoles.add(new ChampionRole<>("Seraphine","Bottom",55.2512653651482));
		championRoles.add(new ChampionRole<>("Nilah","Bottom",53.7663144810441));
		championRoles.add(new ChampionRole<>("Karthus","Bottom",53.5835845570358));
		championRoles.add(new ChampionRole<>("Veigar","Bottom",53.5357083433473));
		championRoles.add(new ChampionRole<>("Ziggs","Bottom",52.8707265732743));
		championRoles.add(new ChampionRole<>("Jinx","Bottom",52.0309024001844));
		championRoles.add(new ChampionRole<>("Jhin","Bottom",51.740311692641));
		championRoles.add(new ChampionRole<>("Sivir","Bottom",51.628984228521));
		championRoles.add(new ChampionRole<>("MissFortune","Bottom",51.596975939179));
		championRoles.add(new ChampionRole<>("KogMaw","Bottom",51.4113542657786));
		championRoles.add(new ChampionRole<>("Ashe","Bottom",51.3809743826685));
		championRoles.add(new ChampionRole<>("Vayne","Bottom",51.1648628420039));
		championRoles.add(new ChampionRole<>("Twitch","Bottom",51.0823980024726));
		championRoles.add(new ChampionRole<>("Yasuo","Bottom",50.7998270644185));
		championRoles.add(new ChampionRole<>("Tristana","Bottom",50.4471642971719));
		championRoles.add(new ChampionRole<>("Varus","Bottom",50.4365915937854));
		championRoles.add(new ChampionRole<>("Xayah","Bottom",50.2999802128795));
		championRoles.add(new ChampionRole<>("Samira","Bottom",50.0876940770557));
		championRoles.add(new ChampionRole<>("Kaisa","Bottom",49.9603296078566));
		championRoles.add(new ChampionRole<>("Caitlyn","Bottom",48.9937868648301));
		championRoles.add(new ChampionRole<>("Draven","Bottom",48.875615613171));
		championRoles.add(new ChampionRole<>("Lucian","Bottom",48.8441747945626));
		championRoles.add(new ChampionRole<>("Ezreal","Bottom",48.6330732597615));
		championRoles.add(new ChampionRole<>("Zeri","Bottom",48.5555734400269));
		championRoles.add(new ChampionRole<>("Aphelios","Bottom",46.8426817006607));
		championRoles.add(new ChampionRole<>("Kalista","Bottom",46.5607959437482));
		championRoles.add(new ChampionRole<>("JarvanIV","Jungle",53.5008592766237));
		championRoles.add(new ChampionRole<>("Nocturne","Jungle",53.2667949874147));
		championRoles.add(new ChampionRole<>("DrMundo","Jungle",52.3757346349238));
		championRoles.add(new ChampionRole<>("Amumu","Jungle",51.9750822344482));
		championRoles.add(new ChampionRole<>("Fiddlesticks","Jungle",51.9674801198965));
		championRoles.add(new ChampionRole<>("Maokai","Jungle",51.7920603873384));
		championRoles.add(new ChampionRole<>("Rammus","Jungle",51.7518545691693));
		championRoles.add(new ChampionRole<>("Udyr","Jungle",51.736914489119));
		championRoles.add(new ChampionRole<>("Vi","Jungle",51.7230306071249));
		championRoles.add(new ChampionRole<>("Zac","Jungle",51.7004586351219));
		championRoles.add(new ChampionRole<>("Warwick","Jungle",51.5827046533216));
		championRoles.add(new ChampionRole<>("Lillia","Jungle",51.521017699115));
		championRoles.add(new ChampionRole<>("Shyvana","Jungle",51.461448931638));
		championRoles.add(new ChampionRole<>("Skarner","Jungle",51.3902420744959));
		championRoles.add(new ChampionRole<>("XinZhao","Jungle",51.2661653012857));
		championRoles.add(new ChampionRole<>("Kayn","Jungle",51.1593974653524));
		championRoles.add(new ChampionRole<>("MasterYi","Jungle",51.1566056407718));
		championRoles.add(new ChampionRole<>("Trundle","Jungle",50.9873682149035));
		championRoles.add(new ChampionRole<>("Evelynn","Jungle",50.8542232157113));
		championRoles.add(new ChampionRole<>("Belveth","Jungle",50.7686886857185));
		championRoles.add(new ChampionRole<>("Ekko","Jungle",50.6821598797223));
		championRoles.add(new ChampionRole<>("Poppy","Jungle",50.6282216494845));
		championRoles.add(new ChampionRole<>("MonkeyKing","Jungle",50.6088969787438));
		championRoles.add(new ChampionRole<>("Volibear","Jungle",50.3988370359326));
		championRoles.add(new ChampionRole<>("Khazix","Jungle",50.3094938507123));
		championRoles.add(new ChampionRole<>("Diana","Jungle",50.2728852566812));
		championRoles.add(new ChampionRole<>("Sejuani","Jungle",50.141822751481));
		championRoles.add(new ChampionRole<>("Elise","Jungle",50.1092367751871));
		championRoles.add(new ChampionRole<>("Shaco","Jungle",50.0923616883716));
		championRoles.add(new ChampionRole<>("Nunu","Jungle",49.8760311247641));
		championRoles.add(new ChampionRole<>("Viego","Jungle",49.8607467501451));
		championRoles.add(new ChampionRole<>("Hecarim","Jungle",49.6827273907212));
		championRoles.add(new ChampionRole<>("RekSai","Jungle",49.513299026598));
		championRoles.add(new ChampionRole<>("Talon","Jungle",49.51205510907));
		championRoles.add(new ChampionRole<>("Sylas","Jungle",49.3899559193954));
		championRoles.add(new ChampionRole<>("Gragas","Jungle",49.3797093381578));
		championRoles.add(new ChampionRole<>("Kindred","Jungle",49.1044235439335));
		championRoles.add(new ChampionRole<>("Karthus","Jungle",49.0730176839703));
		championRoles.add(new ChampionRole<>("Pantheon","Jungle",48.5769107771026));
		championRoles.add(new ChampionRole<>("Ivern","Jungle",48.4714729442537));
		championRoles.add(new ChampionRole<>("Taliyah","Jungle",48.4040687478077));
		championRoles.add(new ChampionRole<>("LeeSin","Jungle",48.3271849681089));
		championRoles.add(new ChampionRole<>("Rengar","Jungle",48.2624125935556));
		championRoles.add(new ChampionRole<>("Olaf","Jungle",47.8792235801581));
		championRoles.add(new ChampionRole<>("Graves","Jungle",47.8319565661578));
		championRoles.add(new ChampionRole<>("Nidalee","Jungle",47.7656273335214));
		championRoles.add(new ChampionRole<>("Rumble","Jungle",46.175891097976));
		championRoles.add(new ChampionRole<>("Zed","Jungle",46.0525112066599));
		championRoles.add(new ChampionRole<>("Qiyana","Jungle",43.1408681408681));
		championRoles.add(new ChampionRole<>("Singed","Middle",56.6373303997066));
		championRoles.add(new ChampionRole<>("Kayle","Middle",53.4506089309878));
		championRoles.add(new ChampionRole<>("Malphite","Middle",53.3955213396645));
		championRoles.add(new ChampionRole<>("Annie","Middle",53.1940159973792));
		championRoles.add(new ChampionRole<>("Heimerdinger","Middle",53.0977643046608));
		championRoles.add(new ChampionRole<>("Anivia","Middle",52.6600852763799));
		championRoles.add(new ChampionRole<>("Swain","Middle",52.6370472986344));
		championRoles.add(new ChampionRole<>("AurelionSol","Middle",52.5402890613539));
		championRoles.add(new ChampionRole<>("Pantheon","Middle",52.4580607552302));
		championRoles.add(new ChampionRole<>("Malzahar","Middle",52.4120242529063));
		championRoles.add(new ChampionRole<>("Kennen","Middle",52.3747048018892));
		championRoles.add(new ChampionRole<>("Tryndamere","Middle",52.236045729657));
		championRoles.add(new ChampionRole<>("Veigar","Middle",52.2093194385069));
		championRoles.add(new ChampionRole<>("Cassiopeia","Middle",52.1338798344956));
		championRoles.add(new ChampionRole<>("Chogath","Middle",51.9731726283048));
		championRoles.add(new ChampionRole<>("Viktor","Middle",51.8981425381273));
		championRoles.add(new ChampionRole<>("Vex","Middle",51.8498159743798));
		championRoles.add(new ChampionRole<>("Lux","Middle",51.6991396318044));
		championRoles.add(new ChampionRole<>("Akshan","Middle",51.6308006592845));
		championRoles.add(new ChampionRole<>("Jayce","Middle",51.4175257731958));
		championRoles.add(new ChampionRole<>("Fizz","Middle",51.4029340549779));
		championRoles.add(new ChampionRole<>("Ziggs","Middle",51.3798564544933));
		championRoles.add(new ChampionRole<>("Vladimir","Middle",51.3668850164622));
		championRoles.add(new ChampionRole<>("Velkoz","Middle",51.3176457310535));
		championRoles.add(new ChampionRole<>("Neeko","Middle",51.1278195488721));
		championRoles.add(new ChampionRole<>("Ahri","Middle",50.9791505306566));
		championRoles.add(new ChampionRole<>("Brand","Middle",50.890371041896));
		championRoles.add(new ChampionRole<>("Diana","Middle",50.6550987602668));
		championRoles.add(new ChampionRole<>("Xerath","Middle",50.6469696435497));
		championRoles.add(new ChampionRole<>("Ekko","Middle",50.544844928751));
		championRoles.add(new ChampionRole<>("Seraphine","Middle",50.4915600074197));
		championRoles.add(new ChampionRole<>("Galio","Middle",50.4565325659897));
		championRoles.add(new ChampionRole<>("Irelia","Middle",50.4037897586284));
		championRoles.add(new ChampionRole<>("Rumble","Middle",50.2878358084431));
		championRoles.add(new ChampionRole<>("Renekton","Middle",50.2476322877747));
		championRoles.add(new ChampionRole<>("Tristana","Middle",50.2373057668552));
		championRoles.add(new ChampionRole<>("Lissandra","Middle",50.003746815207));
		championRoles.add(new ChampionRole<>("Varus","Middle",49.8936924167257));
		championRoles.add(new ChampionRole<>("Taliyah","Middle",49.8576779026217));
		championRoles.add(new ChampionRole<>("Zed","Middle",49.7183621755567));
		championRoles.add(new ChampionRole<>("Sylas","Middle",49.685665784325));
		championRoles.add(new ChampionRole<>("Kassadin","Middle",49.6737733148997));
		championRoles.add(new ChampionRole<>("Gragas","Middle",49.5513660651275));
		championRoles.add(new ChampionRole<>("Talon","Middle",49.4932775340027));
		championRoles.add(new ChampionRole<>("Orianna","Middle",49.3054471671609));
		championRoles.add(new ChampionRole<>("Yone","Middle",49.239907083419));
		championRoles.add(new ChampionRole<>("Syndra","Middle",49.2025702071013));
		championRoles.add(new ChampionRole<>("Yasuo","Middle",49.1076203375599));
		championRoles.add(new ChampionRole<>("TwistedFate","Middle",48.9746610491004));
		championRoles.add(new ChampionRole<>("Zoe","Middle",48.92858066017));
		championRoles.add(new ChampionRole<>("Katarina","Middle",48.8695191036961));
		championRoles.add(new ChampionRole<>("Ryze","Middle",48.3200719768324));
		championRoles.add(new ChampionRole<>("Gangplank","Middle",48.1609901685393));
		championRoles.add(new ChampionRole<>("Akali","Middle",47.9603764838664));
		championRoles.add(new ChampionRole<>("Corki","Middle",47.9264062735635));
		championRoles.add(new ChampionRole<>("Qiyana","Middle",47.671470822966));
		championRoles.add(new ChampionRole<>("Leblanc","Middle",47.6141904889724));
		championRoles.add(new ChampionRole<>("Azir","Middle",46.6108966108966));
		championRoles.add(new ChampionRole<>("KSante","Middle",44.240465416936));
		championRoles.add(new ChampionRole<>("DrMundo","Top",53.7405063291139));
		championRoles.add(new ChampionRole<>("Malphite","Top",53.6551026887919));
		championRoles.add(new ChampionRole<>("Zac","Top",53.6405346100139));
		championRoles.add(new ChampionRole<>("Maokai","Top",52.7325023969319));
		championRoles.add(new ChampionRole<>("Mordekaiser","Top",52.7143427454005));
		championRoles.add(new ChampionRole<>("Kled","Top",52.6212076145151));
		championRoles.add(new ChampionRole<>("Singed","Top",52.6203793774319));
		championRoles.add(new ChampionRole<>("Cassiopeia","Top",52.1201605031992));
		championRoles.add(new ChampionRole<>("Shen","Top",51.9677677308236));
		championRoles.add(new ChampionRole<>("Ornn","Top",51.8922305764411));
		championRoles.add(new ChampionRole<>("Sion","Top",51.8234392419175));
		championRoles.add(new ChampionRole<>("Chogath","Top",51.7907752913497));
		championRoles.add(new ChampionRole<>("Kayle","Top",51.7873711557602));
		championRoles.add(new ChampionRole<>("Illaoi","Top",51.5071237571713));
		championRoles.add(new ChampionRole<>("Nasus","Top",51.4382781349174));
		championRoles.add(new ChampionRole<>("Akshan","Top",51.3845932532546));
		championRoles.add(new ChampionRole<>("Heimerdinger","Top",51.3516086046068));
		championRoles.add(new ChampionRole<>("TahmKench","Top",51.1789656116026));
		championRoles.add(new ChampionRole<>("Sejuani","Top",51.1599133931333));
		championRoles.add(new ChampionRole<>("Teemo","Top",51.1206003809913));
		championRoles.add(new ChampionRole<>("Urgot","Top",51.1184771652322));
		championRoles.add(new ChampionRole<>("Quinn","Top",51.0477499141188));
		championRoles.add(new ChampionRole<>("Neeko","Top",51.043068640646));
		championRoles.add(new ChampionRole<>("Vayne","Top",50.9403216327402));
		championRoles.add(new ChampionRole<>("Olaf","Top",50.88301237753));
		championRoles.add(new ChampionRole<>("Warwick","Top",50.7798864108602));
		championRoles.add(new ChampionRole<>("Fiora","Top",50.5168313208928));
		championRoles.add(new ChampionRole<>("Jax","Top",50.4863025826524));
		championRoles.add(new ChampionRole<>("Yorick","Top",50.4858556963174));
		championRoles.add(new ChampionRole<>("Garen","Top",50.4752782433966));
		championRoles.add(new ChampionRole<>("Rengar","Top",50.4104839120901));
		championRoles.add(new ChampionRole<>("Vladimir","Top",50.3848934631905));
		championRoles.add(new ChampionRole<>("Pantheon","Top",50.3521254583076));
		championRoles.add(new ChampionRole<>("Sett","Top",50.3208672631614));
		championRoles.add(new ChampionRole<>("Camille","Top",50.1353605943274));
		championRoles.add(new ChampionRole<>("Irelia","Top",50.1073450003252));
		championRoles.add(new ChampionRole<>("MonkeyKing","Top",50.0447200524715));
		championRoles.add(new ChampionRole<>("Poppy","Top",49.7678985895375));
		championRoles.add(new ChampionRole<>("Gwen","Top",49.730333548601));
		championRoles.add(new ChampionRole<>("Sylas","Top",49.6517122119927));
		championRoles.add(new ChampionRole<>("Jayce","Top",49.5910012683897));
		championRoles.add(new ChampionRole<>("Riven","Top",49.5461988601023));
		championRoles.add(new ChampionRole<>("Kennen","Top",49.5444839857651));
		championRoles.add(new ChampionRole<>("Ryze","Top",49.5097486757579));
		championRoles.add(new ChampionRole<>("Darius","Top",49.3508762079442));
		championRoles.add(new ChampionRole<>("Rammus","Top",49.1924569159974));
		championRoles.add(new ChampionRole<>("Udyr","Top",48.7609566064278));
		championRoles.add(new ChampionRole<>("Graves","Top",48.7064643358513));
		championRoles.add(new ChampionRole<>("Gnar","Top",48.6893653394116));
		championRoles.add(new ChampionRole<>("Volibear","Top",48.6846879535558));
		championRoles.add(new ChampionRole<>("Tryndamere","Top",48.6507358619624));
		championRoles.add(new ChampionRole<>("Gangplank","Top",48.4251836821156));
		championRoles.add(new ChampionRole<>("Aatrox","Top",48.3106815292128));
		championRoles.add(new ChampionRole<>("Gragas","Top",48.1380115678654));
		championRoles.add(new ChampionRole<>("Trundle","Top",48.0626700440941));
		championRoles.add(new ChampionRole<>("Yone","Top",48.0408940370862));
		championRoles.add(new ChampionRole<>("Renekton","Top",47.4703886673412));
		championRoles.add(new ChampionRole<>("Rumble","Top",47.4667143240103));
		championRoles.add(new ChampionRole<>("Akali","Top",47.2776940467219));
		championRoles.add(new ChampionRole<>("Yasuo","Top",47.1364647651426));
		championRoles.add(new ChampionRole<>("KSante","Top",44.9685235291718));
		championRoles.add(new ChampionRole<>("Taric","Utility",53.6771331531156));
		championRoles.add(new ChampionRole<>("Sona","Utility",52.7749989996398));
		championRoles.add(new ChampionRole<>("Zyra","Utility",52.3078097065364));
		championRoles.add(new ChampionRole<>("Xerath","Utility",52.1602348993288));
		championRoles.add(new ChampionRole<>("Zac","Utility",52.0575478684015));
		championRoles.add(new ChampionRole<>("Blitzcrank","Utility",51.850564836109));
		championRoles.add(new ChampionRole<>("Heimerdinger","Utility",51.84242261825));
		championRoles.add(new ChampionRole<>("Zilean","Utility",51.8061022551812));
		championRoles.add(new ChampionRole<>("Rakan","Utility",51.7721938440569));
		championRoles.add(new ChampionRole<>("Senna","Utility",51.6928889958375));
		championRoles.add(new ChampionRole<>("Milio","Utility",51.6630516699446));
		championRoles.add(new ChampionRole<>("Amumu","Utility",51.5154574132492));
		championRoles.add(new ChampionRole<>("Fiddlesticks","Utility",51.4944587484607));
		championRoles.add(new ChampionRole<>("Maokai","Utility",51.4867026002487));
		championRoles.add(new ChampionRole<>("Brand","Utility",51.4835476784083));
		championRoles.add(new ChampionRole<>("Velkoz","Utility",51.4434570797059));
		championRoles.add(new ChampionRole<>("Renata","Utility",51.3051732320835));
		championRoles.add(new ChampionRole<>("Shaco","Utility",51.2684428404627));
		championRoles.add(new ChampionRole<>("Annie","Utility",51.2185755977676));
		championRoles.add(new ChampionRole<>("Lux","Utility",51.2150491532171));
		championRoles.add(new ChampionRole<>("Soraka","Utility",51.1937679464));
		championRoles.add(new ChampionRole<>("Rell","Utility",50.8845306053241));
		championRoles.add(new ChampionRole<>("Morgana","Utility",50.6529950659421));
		championRoles.add(new ChampionRole<>("Janna","Utility",50.5681975281333));
		championRoles.add(new ChampionRole<>("Thresh","Utility",50.4782050533932));
		championRoles.add(new ChampionRole<>("Neeko","Utility",50.4243191893603));
		championRoles.add(new ChampionRole<>("Swain","Utility",50.3421717481419));
		championRoles.add(new ChampionRole<>("Alistar","Utility",50.3121358415182));
		championRoles.add(new ChampionRole<>("Leona","Utility",50.2679549366296));
		championRoles.add(new ChampionRole<>("Teemo","Utility",50.2502274795268));
		championRoles.add(new ChampionRole<>("Braum","Utility",50.2095199859483));
		championRoles.add(new ChampionRole<>("Nautilus","Utility",50.2079588312008));
		championRoles.add(new ChampionRole<>("Ziggs","Utility",50.007045230379));
		championRoles.add(new ChampionRole<>("Bard","Utility",49.9494531752596));
		championRoles.add(new ChampionRole<>("Nami","Utility",49.9465058370179));
		championRoles.add(new ChampionRole<>("Galio","Utility",49.5653302192811));
		championRoles.add(new ChampionRole<>("TahmKench","Utility",49.5336864880996));
		championRoles.add(new ChampionRole<>("Seraphine","Utility",49.4512549295344));
		championRoles.add(new ChampionRole<>("Pyke","Utility",49.4364349173227));
		championRoles.add(new ChampionRole<>("Yuumi","Utility",49.3452208169189));
		championRoles.add(new ChampionRole<>("Pantheon","Utility",48.840792717618));
		championRoles.add(new ChampionRole<>("Lulu","Utility",48.6486649788825));
		championRoles.add(new ChampionRole<>("Leblanc","Utility",48.6186643463128));
		championRoles.add(new ChampionRole<>("Karma","Utility",48.5314724510957));
		championRoles.add(new ChampionRole<>("Ashe","Utility",48.4520097462897));
		championRoles.add(new ChampionRole<>("Zoe","Utility",48.4044526901669));
		championRoles.add(new ChampionRole<>("Twitch","Utility",47.4777934380019));
		championRoles.add(new ChampionRole<>("MissFortune","Utility",45.5517224624653));
		return championRoles;
	}
	
	public static Map<String, String> identifyStringRoles(Set<String> champions){
		Set<String> roles = new LinkedHashSet<String>(){{
			add("Top");
			add("Middle");
			add("Jungle");
			add("Bottom");
			add("Utility");
		}};
		Set<ChampionRole<String, String>> championRoles = getStringChampionRoles();
		return new RoleIdentifier<>(roles, championRoles).identifyRoles(champions);
	}
	
	//endregion static
	
	//region Main Functionality
	public Map<Champion, Role> identifyRoles(Set<Champion> champions){
		String logID="::identifyRoles([champions]): ";
		log.trace("{}Start ", logID);
		List<Champion> unassignedChampions = new ArrayList<>(champions);
		List<Role> unassignedRoles = new ArrayList<>(roles);
		Map<Champion, Role> guesstimate = new HashMap<>();
		Set<ChampionRole<Champion, Role>> primaryChampionsRole = getPrimaryChampionsRole(champions);
		log.debug("{}primaryChampionsRole:{}", logID, primaryChampionsRole);
		
		int iterations = 7;
		boolean lastIterationAssignedRole = true;
		for (int i = 0; i<iterations; i++) {
			boolean iterationAssignedRole = false;
			log.debug("{}Iteration:{}.  unassignedRoles:{}.  unassignedChampions:{}{}",
					  logID, i, unassignedRoles, unassignedChampions, lastIterationAssignedRole?"":" FLAGGED TO SOLVE CONFLICTS");
			for (Role role : new ArrayList<>(unassignedRoles)) {
				log.debug("{}Role:{}", logID, role);
				
				Set<Champion> championsWithPrimary = getChampionsWithPrimaryRole(role, unassignedChampions, primaryChampionsRole);
				log.debug("{}championsWithPrimary:{}", logID, championsWithPrimary);
				Set<Champion> championsWithSecondary = getChampionsWithRole(role, unassignedChampions);
				log.debug("{}championsWithSecondary:{}", logID, championsWithSecondary);
				HashSet<Champion> championsThatCanBeInThatRole = new HashSet<>(championsWithPrimary);
				championsThatCanBeInThatRole.addAll(championsWithSecondary);
				log.debug("{}championsThatCanBeInThatRole:{}", logID, championsThatCanBeInThatRole);
				
				if (championsThatCanBeInThatRole.size() == 1) {
					log.debug("{}Checking for petty champions", logID);
					if(!lastIterationAssignedRole) {
						Optional<Champion> optionalPettyChampion = only1ChampionHasThisRoleAndTheRestHaveMoreRoles(unassignedRoles, unassignedChampions, role);
						if (optionalPettyChampion.isPresent()) {
							Champion pettyChampion = optionalPettyChampion.get();
							log.debug("{}ASSIGNED - {} has only this role:{} available, and it will be assigned to it as a token of pity.", logID, pettyChampion, role);
							unassignedRoles.remove(role);
							unassignedChampions.remove(pettyChampion);
							guesstimate.put(pettyChampion, role);
							iterationAssignedRole = true;
							lastIterationAssignedRole = true;
							continue;
						}
					}
					Champion foundChampion = championsThatCanBeInThatRole.iterator().next();
					log.debug("{}ASSIGNED - foundChampion:{} to role:{}", logID, foundChampion, role);
					unassignedRoles.remove(role);
					unassignedChampions.remove(foundChampion);
					guesstimate.put(foundChampion, role);
					iterationAssignedRole = true;
				}
				
				if(!lastIterationAssignedRole && !championsThatCanBeInThatRole.isEmpty()){
					if(championsThatCanBeInThatRole.size()>1 && !championsWithPrimary.isEmpty()){
						log.trace("{}Obtaining champion with primary role with the highest win-rate", logID);
						Champion foundChampion = championsWithPrimary.size()>1 ? primaryChampionsRole.stream()
								.filter(pcr->championsWithPrimary.contains(pcr.champion))
								.max(Comparator.comparingDouble(ChampionRole::getWinRate))
								.map(cr->cr.champion).orElseThrow(()->new NoSuchElementException("No champion found"))
								:championsWithPrimary.iterator().next();
						log.debug("{}ASSIGNED - a primary role on champion:{} to role:{} was found.", logID, foundChampion, role);
						unassignedRoles.remove(role);
						unassignedChampions.remove(foundChampion);
						guesstimate.put(foundChampion, role);
						iterationAssignedRole = true;
						lastIterationAssignedRole = true;
						continue;
					}
					log.trace("{}Obtaining champion with the role with the highest win-rate", logID);
					Champion foundChampion = getHighestWinRateForRole(championsThatCanBeInThatRole, role);
					log.debug("{}ASSIGNED - No primary role but found secondary on champion:{} to role:{}", logID, foundChampion, role);
					unassignedRoles.remove(role);
					unassignedChampions.remove(foundChampion);
					guesstimate.put(foundChampion, role);
				}
			}
			if((!lastIterationAssignedRole && iterationAssignedRole) || unassignedRoles.isEmpty()) break;
			lastIterationAssignedRole = iterationAssignedRole;
		}
		
		log.debug("{}Adding the rest of the Champions:{} that could not find any role of:{}", logID, unassignedChampions, unassignedRoles);
		
		for (int i = 0; i < unassignedChampions.size();i++)  guesstimate.put(unassignedChampions.get(i), unassignedRoles.get(i));
		
		log.info("{}Team Composition Guessed: {}", logID, guesstimate);
		return guesstimate;
	}
	
	private Optional<Champion> only1ChampionHasThisRoleAndTheRestHaveMoreRoles(List<Role> unassignedRoles, List<Champion> unassignedChampions, Role role) {
		String logID="::only1ChampionHasThisRoleAndTheRestHaveMoreRoles([unassignedRoles, unassignedChampions, role]): ";
		log.debug("{}Start - unassignedRoles:{}.  role:{}", logID, unassignedRoles, role);
		Set<ChampionRole<Champion, Role>> unassignedChampionsWithUnassignedRoles =
				championRoles.stream()
						.filter(cr->unassignedChampions.contains(cr.champion) && unassignedRoles.contains(cr.role))
						.collect(Collectors.toSet());
		log.debug("{}unassignedChampionsWithUnassignedRoles:{}", logID, unassignedChampionsWithUnassignedRoles);
		Champion singleRoleChampion = null;
		for(ChampionRole<Champion, Role> championRoleEntity: unassignedChampionsWithUnassignedRoles){
			log.debug("{}Checking championRoleEntity:{}", logID, championRoleEntity);
			Set<ChampionRole<Champion, Role>> thisChampionRoles = unassignedChampionsWithUnassignedRoles.stream().filter(cr->Objects.equals(cr,championRoleEntity)).collect(Collectors.toSet());
			log.debug("{}thisChampionRoles:{}", logID, thisChampionRoles);
			if(thisChampionRoles.size() == 1 && Objects.equals(thisChampionRoles.iterator().next().role,role) ){
				log.debug("{}Champion with single rol found:{}", logID, thisChampionRoles);
				if(singleRoleChampion == null) singleRoleChampion = thisChampionRoles.iterator().next().getChampion();
				else return Optional.empty();
			}
		}
		log.debug("{}Petty Champion found: {}", logID, singleRoleChampion);
		return singleRoleChampion == null?Optional.empty():Optional.of(singleRoleChampion);
	}
	
	public Champion getHighestWinRateForRole(Set<Champion> champions, Role role) {
		String logID="::getHighestWinRate([championsThatCanBeInThatRole]): ";
		log.trace("{}Start ", logID);
		Set<ChampionRole<Champion, Role>> filteredChampionRoles = championRoles.stream().filter(cr->champions.contains(cr.champion) && Objects.equals(cr.role, role)).collect(Collectors.toSet());
		log.debug("{}Champions to compare:{}", logID, filteredChampionRoles);
		Champion max = filteredChampionRoles.stream().max(Comparator.comparingDouble(ChampionRole::getWinRate)).map(cr->cr.champion).orElseThrow(()->new NoSuchElementException("No champion found"));
		log.debug("{}Champion with the highest win-rate: {}", logID,max);
		return max;
	}
	
	public Set<Champion> getChampionsWithPrimaryRole(Role role, List<Champion> champions, Set<ChampionRole<Champion, Role>> primaryChampionsRole){
		String logID="::getChampionsWithPrimaryRole([role, champions]): ";
		log.trace("{}Start ", logID);
		return primaryChampionsRole.stream()
				.filter(cr->champions.contains(cr.champion) && Objects.equals(cr.role, role))
				.map(cr->cr.champion)
				.collect(Collectors.toSet());
	}
	
	public Set<ChampionRole<Champion, Role>> getPrimaryChampionsRole(Set<Champion> champions){
		return new HashSet<>(championRoles.stream()
									 .filter(cr -> champions.contains(cr.champion))
									 .collect(Collectors.toMap(
											 cr -> cr.champion,
											 cr -> cr,
											 (cr1, cr2) -> cr1.winRate > cr2.winRate ? cr1 : cr2))
									 .values());
	}
	
	public Set<Champion> getChampionsWithRole(Role role, List<Champion> champions){
		return championRoles.stream()
				.filter(cr->champions.contains(cr.champion) && Objects.equals(cr.role, role))
				.map(cr->cr.champion)
				.collect(Collectors.toSet());
	}
	
	
	//endregion Main Functionality
	
	//endregion Methods
}