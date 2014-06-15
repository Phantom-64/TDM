package me.phantom64.teamdeathmatch.listeners;

import me.phantom64.teamdeathmatch.TeamDeathMatch;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncPlayerChat implements Listener {
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if (!TeamDeathMatch.getGameManager().isPlaying(p)) {
			e.setFormat("§7" + p.getName() + " §f> " + "§8" + e.getMessage());
		} else {
			e.setFormat("§5[TDM] §r" + TeamDeathMatch.getTeamManager().getPlayerNameInTeamColor(p) + " §7> §f" + e.getMessage());
		}
	}

}
