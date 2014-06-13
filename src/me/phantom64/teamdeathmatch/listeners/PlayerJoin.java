package me.phantom64.teamdeathmatch.listeners;

import me.phantom64.teamdeathmatch.TeamDeathMatch;
import me.phantom64.teamdeathmatch.utils.LocationHandler;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
	
	LocationHandler lh = TeamDeathMatch.getLocationHandler();
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		e.setJoinMessage("§dWelcome §5" + e.getPlayer().getName() + " §dto the server.");
		e.getPlayer().teleport(TeamDeathMatch.getLocationHandler().getExitSpawn());
		if (e.getPlayer().isOp()) {
			if (lh.getRedSpawn()==null||lh.getBlueSpawn()==null||lh.getExitSpawn()==null) {
				e.getPlayer().sendMessage("§5[TDM] §dAll the spawns are not set.");
				e.getPlayer().sendMessage("§dSet them with /tdm setspawn <red/blue/exit> to be able to play.");
			}
		}
	}

}
