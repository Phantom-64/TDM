package me.phantom64.teamdeathmatch.listeners;

import me.phantom64.teamdeathmatch.TeamDeathMatch;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockListener implements Listener {
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if (TeamDeathMatch.getGameManager().isPlaying(p)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		if (TeamDeathMatch.getGameManager().isPlaying(p)) {
			e.setCancelled(true);
		}
	}

}
