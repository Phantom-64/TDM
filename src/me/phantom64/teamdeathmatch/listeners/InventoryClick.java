package me.phantom64.teamdeathmatch.listeners;

import me.phantom64.teamdeathmatch.TeamDeathMatch;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClick implements Listener {
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (e.getWhoClicked() instanceof Player) {
			Player p = (Player) e.getWhoClicked();
			if (TeamDeathMatch.getGameManager().isPlaying(p)) {
				e.setCancelled(true);
				p.closeInventory();
			}
		}
	}
	
}
