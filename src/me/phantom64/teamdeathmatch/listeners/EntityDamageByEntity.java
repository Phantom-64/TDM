package me.phantom64.teamdeathmatch.listeners;

import me.phantom64.teamdeathmatch.TeamDeathMatch;
import me.phantom64.teamdeathmatch.utils.GameManager;
import me.phantom64.teamdeathmatch.utils.TeamManager;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageByEntity implements Listener {
	
	private TeamDeathMatch plugin;
	
	GameManager gm = TeamDeathMatch.getGameManager();
	TeamManager tm = TeamDeathMatch.getTeamManager();
	
	@EventHandler
	public void onPlayerDamageByPlayer(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (e.getDamager() instanceof Player) {
				Player damager = (Player) e.getDamager();
				if (gm.isPlaying(p) && gm.isPlaying(damager)) {
					if (tm.getTeam(p) == tm.getTeam(damager)) {
						e.setCancelled(true);
						damager.sendMessage("§cThat's your teammate!");
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onPlayerDamageByArrow(EntityDamageByEntityEvent e) {
		try {
			if (e.getEntity() instanceof Player) {
				Player p = (Player) e.getEntity();
				if (e.getDamager() instanceof Arrow) {
					Arrow arrow = (Arrow) e.getDamager();
					if (arrow.getShooter() instanceof Player) {
						Player shooter = (Player) arrow.getShooter();
						if (gm.isPlaying(p) && gm.isPlaying(shooter)) {
							if (tm.getTeam(p) == tm.getTeam(shooter)) {
								if (shooter == p) {
									e.setCancelled(true);
								} else if (shooter != p) {
									e.setCancelled(true);
									shooter.sendMessage("§cThat's your teammate!");
								}
							}
						}
					}
				}
			}
		} catch (NullPointerException npe) {
			plugin.getLogger().info("Null pointer exception? .-.");
		}
	}

}
