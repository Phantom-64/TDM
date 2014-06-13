package me.phantom64.teamdeathmatch.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import me.phantom64.teamdeathmatch.TeamDeathMatch;

import org.bukkit.entity.Player;

public class TeamManager {
	
	public static Map<Player, Team> teams = new HashMap<Player, Team>();
	
	@SuppressWarnings("unused")
	private TeamDeathMatch plugin;
	
	public enum Team {
		RED,
		BLUE;
	}
	
	public TeamManager(TeamDeathMatch plugin) {
		this.plugin = plugin;
	}
	
	public Team getTeam(Player p) {
		return teams.get(p);
	}
	
	public void setTeam(Player p, Team team) {
		teams.put(p, team);
		if (team == Team.RED) p.sendMessage("§dYour team was set to §cRed§d.");
		else if (team == Team.BLUE) p.sendMessage("§dYour team was set to §9Blue§d.");
	}
	
	public void removeFromTeam(Player p, Team team) {
		teams.remove(p);
	}
	
	public Team getValidTeam() {
		if (TeamDeathMatch.getRed().size() > TeamDeathMatch.getBlue().size()) return Team.BLUE;
		else if (TeamDeathMatch.getBlue().size() > TeamDeathMatch.getRed().size()) return Team.RED;
		else if (TeamDeathMatch.getRed().size() == TeamDeathMatch.getBlue().size()) {
			int randomTeam = new Random().nextInt(1);
			if (randomTeam == 0) {
				return Team.RED;
			} else if (randomTeam == 1) {
				return Team.BLUE;
			}
		} return null;
	}
	
	public String getPlayerNameInTeamColor(Player p) {
		if (getTeam(p) == (Team.RED)) return "§c" + p.getName();
		else if (getTeam(p) == (Team.BLUE)) return "§9" + p.getName();
		else return "§7" + p.getName();
	}

}
