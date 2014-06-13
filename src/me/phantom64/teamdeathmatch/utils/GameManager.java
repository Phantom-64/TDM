package me.phantom64.teamdeathmatch.utils;

import java.util.ArrayList;
import java.util.List;

import me.phantom64.teamdeathmatch.TeamDeathMatch;

import org.bukkit.entity.Player;

public class GameManager {
	
	private TeamDeathMatch plugin;
	
	public List<Player> playing = new ArrayList<Player>();
	
	public GameManager(TeamDeathMatch plugin) {
		this.plugin = plugin;
	}
	
	public void addPlayerToGame(Player p) {
		playing.add(p);
		TeamDeathMatch.addPlayersToTeamLists();
		TeamDeathMatch.getLocationHandler().teleportPlayerToArena(p, TeamDeathMatch.getTeamManager().getValidTeam());
	}
	
	public void removePlayerFromGame(Player p) {
		playing.remove(p);
		TeamDeathMatch.addPlayersToTeamLists();
		TeamDeathMatch.getLocationHandler().teleportPlayerFromArena(p);
	}
	
	public boolean isPlaying(Player p) {
		return playing.contains(p);
	}
	
	public void broadcastMessageInGame(String message) {
		for (Player p : plugin.getServer().getOnlinePlayers()) {
			if (TeamDeathMatch.getGameManager().isPlaying(p)) {
				p.sendMessage(message);
			}
		}
	}

}
