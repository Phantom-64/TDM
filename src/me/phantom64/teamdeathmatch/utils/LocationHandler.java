package me.phantom64.teamdeathmatch.utils;

import me.phantom64.teamdeathmatch.TeamDeathMatch;
import me.phantom64.teamdeathmatch.utils.TeamManager.Team;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class LocationHandler {

	private TeamDeathMatch plugin;

	@SuppressWarnings("unused")
	private Location redSpawn;
	@SuppressWarnings("unused")
	private Location blueSpawn;
	@SuppressWarnings("unused")
	private Location exitSpawn;

	public LocationHandler(TeamDeathMatch plugin) {
		this.plugin = plugin;
	}

	public void teleportPlayerToArena(Player p, Team team) {
		if (team == Team.RED) {
			p.teleport(getRedSpawn());
			TeamDeathMatch.getTeamManager().setTeam(p, team);
		} else if (team == Team.BLUE) {
			p.teleport(getBlueSpawn());
			TeamDeathMatch.getTeamManager().setTeam(p, team);
		}
	}

	@SuppressWarnings("static-access")
	public void teleportPlayerFromArena(Player p) {
		p.teleport(TeamDeathMatch.getLocationHandler().getExitSpawn());
		TeamDeathMatch.getTeamManager().teams.remove(p);
	}

	public Location getRedSpawn() {
		return new Location(plugin.getServer().getWorld(
				plugin.getConfig().getString("Spawns.red.world")), plugin
				.getConfig().getInt("Spawns.red.x"), plugin.getConfig().getInt(
				"Spawns.red.y"), plugin.getConfig().getInt("Spawns.red.z"));
	}

	public void setRedSpawn(Location redSpawn) {
		this.redSpawn = redSpawn;
		plugin.getConfig().set("Spawns.red.world",
				redSpawn.getWorld().getName());
		plugin.getConfig().set("Spawns.red.x", redSpawn.getBlockX());
		plugin.getConfig().set("Spawns.red.y", redSpawn.getBlockY());
		plugin.getConfig().set("Spawns.red.z", redSpawn.getBlockZ());
		plugin.saveConfig();
	}

	public Location getBlueSpawn() {
		return new Location(plugin.getServer().getWorld(
				plugin.getConfig().getString("Spawns.blue.world")), plugin
				.getConfig().getInt("Spawns.blue.x"), plugin.getConfig().getInt(
				"Spawns.blue.y"), plugin.getConfig().getInt("Spawns.blue.z"));
	}

	public void setBlueSpawn(Location blueSpawn) {
		this.blueSpawn = blueSpawn;
		plugin.getConfig().set("Spawns.blue.world",
				blueSpawn.getWorld().getName());
		plugin.getConfig().set("Spawns.blue.x", blueSpawn.getBlockX());
		plugin.getConfig().set("Spawns.blue.y", blueSpawn.getBlockY());
		plugin.getConfig().set("Spawns.blue.z", blueSpawn.getBlockZ());
		plugin.saveConfig();
	}

	public Location getExitSpawn() {
		return new Location(plugin.getServer().getWorld(
				plugin.getConfig().getString("Spawns.exit.world")), plugin
				.getConfig().getInt("Spawns.exit.x"), plugin.getConfig().getInt(
				"Spawns.exit.y"), plugin.getConfig().getInt("Spawns.exit.z"));
	}

	public void setExitSpawn(Location exitSpawn) {
		this.exitSpawn = exitSpawn;
		plugin.getConfig().set("Spawns.exit.world",
				exitSpawn.getWorld().getName());
		plugin.getConfig().set("Spawns.exit.x", exitSpawn.getBlockX());
		plugin.getConfig().set("Spawns.exit.y", exitSpawn.getBlockY());
		plugin.getConfig().set("Spawns.exit.z", exitSpawn.getBlockZ());
		plugin.saveConfig();
	}

}
