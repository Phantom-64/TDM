package me.phantom64.teamdeathmatch.listeners;

import me.phantom64.teamdeathmatch.TeamDeathMatch;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		TeamDeathMatch.getGameManager().getPlaying().remove(p);
		TeamDeathMatch.getTeamManager().removeFromTeam(p, TeamDeathMatch.getTeamManager().getTeam(p));
		e.setQuitMessage("§5" + p.getName() + " §dleft the server.");
	}

}
