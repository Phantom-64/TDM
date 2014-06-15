package me.phantom64.teamdeathmatch.utils;

import java.util.ArrayList;
import java.util.List;

import me.phantom64.teamdeathmatch.TeamDeathMatch;
import me.phantom64.teamdeathmatch.utils.TeamManager.Team;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class GameManager {
	
	private TeamDeathMatch plugin;
	
	public List<Player> playing = new ArrayList<Player>();
	
	public List<Player> getPlaying() {
		return playing;
	}

	public GameManager(TeamDeathMatch plugin) {
		this.plugin = plugin;
	}
	
	public void addPlayerToGame(Player p) {
		playing.add(p);
		TeamDeathMatch.addPlayersToTeamLists();
		Team team = TeamDeathMatch.getTeamManager().getValidTeam();
		p.setGameMode(GameMode.ADVENTURE);
		TeamDeathMatch.getLocationHandler().teleportPlayerToArena(p, team);
		TeamDeathMatch.getTeamManager().givePlayerKit(p, team);
	}
	
	public void removePlayerFromGame(Player p) {
		playing.remove(p);
		TeamDeathMatch.getTeamManager().removeFromTeam(p, TeamDeathMatch.getTeamManager().getTeam(p));
		PlayerInventory inv = p.getInventory();
		inv.clear();
		inv.setHelmet(new ItemStack(Material.AIR, 1));
		inv.setChestplate(new ItemStack(Material.AIR, 1));
		inv.setLeggings(new ItemStack(Material.AIR, 1));
		inv.setBoots(new ItemStack(Material.AIR, 1));
		TeamDeathMatch.addPlayersToTeamLists();
		p.setGameMode(GameMode.SURVIVAL);
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
