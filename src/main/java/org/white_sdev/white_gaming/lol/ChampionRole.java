package org.white_sdev.white_gaming.lol;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * TODO: Complete class documentation
 */
@AllArgsConstructor
@Getter
@lombok.extern.slf4j.Slf4j
public class ChampionRole<Champion, Role> {
	public Champion champion;
	public Role role;
	public double winRate;
	
	@Override
	public String toString() {
		return "ChampionRole{" +
				"champion=" + champion +
				", role=" + role +
				", winRate=" + winRate +
				'}';
	}
}