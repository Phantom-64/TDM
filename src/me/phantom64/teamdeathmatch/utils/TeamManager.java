package me.phantom64.teamdeathmatch.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import me.phantom64.teamdeathmatch.TeamDeathMatch;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class TeamManager {
	
	public static Map<Player, Team> teams = new HashMap<Player, Team>();
	
	@SuppressWarnings("unused")
	private TeamDeathMatch plugin;
	
	public enum Team {
		RED,
		BLUE;
	}
	
	public TeamManager(TeamDeathMatch plugin) {
		this.plugin = plugin;
	}
	
	public Team getTeam(Player p) {
		return teams.get(p);
	}
	
	public void setTeam(Player p, Team team) {
		teams.put(p, team);
		if (team == Team.RED) p.sendMessage("§5[TDM] §dYour team was set to §cRed§d.");
		else if (team == Team.BLUE) p.sendMessage("§5[TDM] §dYour team was set to §9Blue§d.");
	}
	
	public void removeFromTeam(Player p, Team team) {
		teams.remove(p);
	}
	
	public Team getValidTeam() {
		if (TeamDeathMatch.getRed().size() > TeamDeathMatch.getBlue().size()) return Team.BLUE;
		else if (TeamDeathMatch.getBlue().size() > TeamDeathMatch.getRed().size()) return Team.RED;
		else if (TeamDeathMatch.getRed().size() == TeamDeathMatch.getBlue().size()) {
			int randomTeam = new Random().nextInt(2);
			if (randomTeam == 0 || randomTeam == 1) {
				return Team.BLUE;
			} else if (randomTeam == 2) {
				return Team.RED;
			}
		} return null;
	}
	
	public void givePlayerKit(Player p, Team team) {
		PlayerInventory inv = p.getInventory();
		inv.clear();
		inv.setHelmet(new ItemStack(Material.AIR, 1));
		inv.setChestplate(new ItemStack(Material.AIR, 1));
		inv.setLeggings(new ItemStack(Material.AIR, 1));
		inv.setBoots(new ItemStack(Material.AIR, 1));
		if (getTeam(p) == Team.RED) {
			inv.setHelmet(new ItemStack(Material.REDSTONE_BLOCK, 1));
			inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE, 1));
			inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS, 1));
			inv.setBoots(new ItemStack(Material.IRON_BOOTS, 1));
			inv.addItem(new ItemStack(Material.IRON_SWORD, 1));
			inv.addItem(new ItemStack(Material.BOW, 1));
			inv.addItem(new ItemStack(Material.ARROW, 32));
			p.sendMessage("§5[TDM] §dYou were given kit §cRed§d.");
		} else if (getTeam(p) == Team.BLUE) {
			inv.setHelmet(new ItemStack(Material.LAPIS_BLOCK, 1));
			inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE, 1));
			inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS, 1));
			inv.setBoots(new ItemStack(Material.IRON_BOOTS, 1));
			inv.addItem(new ItemStack(Material.IRON_SWORD, 1));
			inv.addItem(new ItemStack(Material.BOW, 1));
			inv.addItem(new ItemStack(Material.ARROW, 32));
			p.sendMessage("§5[TDM] §dYou were given kit §9Blue§d.");
		}
	}
	
	public String getPlayerNameInTeamColor(Player p) {
		if (getTeam(p) == (Team.RED)) return "§c" + p.getName();
		else if (getTeam(p) == (Team.BLUE)) return "§9" + p.getName();
		else return "§7" + p.getName();
	}

}
