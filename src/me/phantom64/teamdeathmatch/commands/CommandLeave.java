package me.phantom64.teamdeathmatch.commands;

import me.phantom64.teamdeathmatch.TeamDeathMatch;

import org.bukkit.entity.Player;

public class CommandLeave {
	
	public static void execute(Player p, String[] a) {
		
		if (a.length != 1) {
			p.sendMessage("§dWrong usage!");
			p.sendMessage("§dCorrect usage: §d/tdm leave");
		} else {
			if (TeamDeathMatch.getGameManager().isPlaying(p)) {
				TeamDeathMatch.getGameManager().broadcastMessageInGame("§5[TDM] §r" + TeamDeathMatch.getTeamManager().getPlayerNameInTeamColor(p) + " §dhas left the game!");
				TeamDeathMatch.getGameManager().removePlayerFromGame(p);
			} else {
				p.sendMessage("§cYou are not in the game!");
			}
		}
		
	}

}
