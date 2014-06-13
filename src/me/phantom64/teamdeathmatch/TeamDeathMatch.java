package me.phantom64.teamdeathmatch;

import java.util.ArrayList;
import java.util.List;

import me.phantom64.teamdeathmatch.commands.CommandSetSpawn;
import me.phantom64.teamdeathmatch.listeners.PlayerDeath;
import me.phantom64.teamdeathmatch.listeners.PlayerJoin;
import me.phantom64.teamdeathmatch.utils.GameManager;
import me.phantom64.teamdeathmatch.utils.LocationHandler;
import me.phantom64.teamdeathmatch.utils.TeamManager;
import me.phantom64.teamdeathmatch.utils.TeamManager.Team;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Color symbol: §
 * Red team color: §c
 * Blue team color: §9
 */

public class TeamDeathMatch extends JavaPlugin {
	
	public static GameManager gameManager;
	public static TeamManager teamManager;
	public static LocationHandler locationHandler;
	
	public static GameManager getGameManager() {
		return gameManager;
	}

	public static TeamManager getTeamManager() {
		return teamManager;
	}

	public static LocationHandler getLocationHandler() {
		return locationHandler;
	}
	
	public static List<Player> red = new ArrayList<Player>();
	public static List<Player> blue = new ArrayList<Player>();
	
	public static List<Player> getRed() {
		return red;
	}
	
	public static List<Player> getBlue() {
		return blue;
	}

	@Override
	public void onEnable() {
		registerListeners(new PlayerDeath(), new PlayerJoin());
		gameManager = new GameManager(this);
		teamManager = new TeamManager(this);
		locationHandler = new LocationHandler(this);
	}
	
	private void registerListeners(Listener... listeners) {
		for (Listener listener : listeners) {
			getServer().getPluginManager().registerEvents(listener, this);
			getLogger().info("Event " + listener.getClass().getSimpleName() + " has been registered.");
		}
		getLogger().info("All events registered.");
	}
	
	public static void addPlayersToTeamLists() {
		red.clear();
		blue.clear();
		for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
			if (TeamDeathMatch.getGameManager().isPlaying(pl)) {
				if (TeamDeathMatch.getTeamManager().getTeam(pl) == Team.RED) {
					red.add(pl);
				} else if (TeamDeathMatch.getTeamManager().getTeam(pl) == Team.BLUE) {
					blue.add(pl);
				}
			}
		}
	}
	
	@Override
	public boolean onCommand (CommandSender sender, Command cmd, String label, String[] args) {
		
		if (label.equalsIgnoreCase("tdm")) {
			
			if (sender instanceof Player) {
				if (args[0].equalsIgnoreCase("setspawn")) {
					CommandSetSpawn.execute((Player)sender, args);
				}
			} else {
				sender.sendMessage(ChatColor.RED + "Only players can use this command.");
			}
			
		}
		
		return true;
		
	}

}
