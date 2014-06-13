package me.phantom64.teamdeathmatch.utils;

import me.phantom64.teamdeathmatch.TeamDeathMatch;
import me.phantom64.teamdeathmatch.utils.TeamManager.Team;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class LocationHandler {
	
	@SuppressWarnings("unused")
	private TeamDeathMatch plugin;
	
	private Location redSpawn;
	private Location blueSpawn;
	private Location exitSpawn;
	
	public LocationHandler(TeamDeathMatch plugin) {
		this.plugin = plugin;
	}
	
	public void teleportPlayerToArena(Player p, Team team) {
		if (team == Team.RED) {p.teleport(getRedSpawn()); TeamDeathMatch.getTeamManager().setTeam(p, team);}
		else if (team == Team.BLUE) {p.teleport(getBlueSpawn()); TeamDeathMatch.getTeamManager().setTeam(p, team);}
	}
	
	@SuppressWarnings("static-access")
	public void teleportPlayerFromArena(Player p) {
		p.teleport(TeamDeathMatch.getLocationHandler().getExitSpawn());
		TeamDeathMatch.getTeamManager().teams.remove(p);
	}

	public Location getRedSpawn() {
		return redSpawn;
	}

	public void setRedSpawn(Location redSpawn) {
		this.redSpawn = redSpawn;
	}

	public Location getBlueSpawn() {
		return blueSpawn;
	}

	public void setBlueSpawn(Location blueSpawn) {
		this.blueSpawn = blueSpawn;
	}

	public Location getExitSpawn() {
		return exitSpawn;
	}

	public void setExitSpawn(Location exitSpawn) {
		this.exitSpawn = exitSpawn;
	}

}
