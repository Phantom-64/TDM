package me.phantom64.teamdeathmatch.listeners;

import me.phantom64.teamdeathmatch.TeamDeathMatch;
import me.phantom64.teamdeathmatch.utils.GameManager;
import me.phantom64.teamdeathmatch.utils.LocationHandler;
import me.phantom64.teamdeathmatch.utils.TeamManager;
import me.phantom64.teamdeathmatch.utils.TeamManager.Team;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath implements Listener {

	GameManager gameManager = TeamDeathMatch.getGameManager();
	TeamManager teamManager = TeamDeathMatch.getTeamManager();
	LocationHandler locationHandler = TeamDeathMatch.getLocationHandler();

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		if (p.getKiller() instanceof Player) {
			Player killer = p.getKiller();
			if (gameManager.isPlaying(p)) {
				p.setHealth(20.0);
				if (teamManager.getTeam(p) == Team.RED) p.teleport(locationHandler.getRedSpawn());
				else if (teamManager.getTeam(p) == Team.BLUE) p.teleport(locationHandler.getBlueSpawn());
				gameManager.broadcastMessageInGame("§5[TDM] " + teamManager
						.getPlayerNameInTeamColor(p)
						+ " §dwas killed by §r"
						+ teamManager.getPlayerNameInTeamColor(killer) + "§d.");
			}
		}
	}

}
