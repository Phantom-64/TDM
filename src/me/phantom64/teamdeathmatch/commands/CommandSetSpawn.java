package me.phantom64.teamdeathmatch.commands;

import me.phantom64.teamdeathmatch.TeamDeathMatch;

import org.bukkit.entity.Player;

public class CommandSetSpawn {
	
	public static void execute(Player p, String[] a) {
		
		if (!p.isOp()) {
			p.sendMessage("§dYou don't have permission to execute this command.");
			return;
		}
		
		if (a.length != 2) {
			p.sendMessage("§dWrong usage!");
			p.sendMessage("§dCorrect usage: §5/tdm setspawn <red/blue/exit>");
		} else {
			if (a[1].equalsIgnoreCase("red")) {
				TeamDeathMatch.getLocationHandler().setRedSpawn(p.getLocation());
				p.sendMessage("§dRed spawn set!");
			} else if (a[1].equalsIgnoreCase("blue")) {
				TeamDeathMatch.getLocationHandler().setBlueSpawn(p.getLocation());
				p.sendMessage("§dBlue spawn set!");
			} else if (a[1].equalsIgnoreCase("exit")) {
				TeamDeathMatch.getLocationHandler().setExitSpawn(p.getLocation());
				p.sendMessage("§dExit spawn set!");
			} else {
				p.sendMessage("§dInvalid spawn type.");
				p.sendMessage("§dAvailable spawn types: §5Red, Blue, Exit");
			}
		}
		
	}

}
