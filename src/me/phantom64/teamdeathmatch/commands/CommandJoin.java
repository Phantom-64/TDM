package me.phantom64.teamdeathmatch.commands;

import me.phantom64.teamdeathmatch.TeamDeathMatch;

import org.bukkit.entity.Player;

public class CommandJoin {
	
	public static void execute(Player p, String[] a) {
		
		if (a.length != 1) {
			p.sendMessage("§dWrong usage!");
			p.sendMessage("§dCorrect usage: §5/tdm join");
		} else {
			if (!TeamDeathMatch.getGameManager().isPlaying(p)) {
				TeamDeathMatch.getGameManager().addPlayerToGame(p);
				TeamDeathMatch.getGameManager().broadcastMessageInGame("§5[TDM] §r" + TeamDeathMatch.getTeamManager().getPlayerNameInTeamColor(p) + " §dhas joined the game!");
			} else {
				p.sendMessage("§cYou are already in the game!");
			}
		}
		
	}

}
