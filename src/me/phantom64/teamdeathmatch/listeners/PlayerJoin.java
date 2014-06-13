package me.phantom64.teamdeathmatch.listeners;

import me.phantom64.teamdeathmatch.TeamDeathMatch;
import me.phantom64.teamdeathmatch.utils.LocationHandler;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class PlayerJoin implements Listener {
	
	LocationHandler lh = TeamDeathMatch.getLocationHandler();
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage("§dWelcome §5" + e.getPlayer().getName() + " §dto the server.");
		PlayerInventory inv = p.getInventory();
		inv.clear();
		inv.setHelmet(new ItemStack(Material.AIR, 1));
		inv.setChestplate(new ItemStack(Material.AIR, 1));
		inv.setLeggings(new ItemStack(Material.AIR, 1));
		inv.setBoots(new ItemStack(Material.AIR, 1));
		p.teleport(TeamDeathMatch.getLocationHandler().getExitSpawn());
		if (e.getPlayer().isOp()) {
			if (lh.getRedSpawn()==null||lh.getBlueSpawn()==null||lh.getExitSpawn()==null) {
				e.getPlayer().sendMessage("§5[TDM] §dAll the spawns are not set.");
				e.getPlayer().sendMessage("§dSet them with /tdm setspawn <red/blue/exit> to be able to play.");
			}
		}
	}

}
