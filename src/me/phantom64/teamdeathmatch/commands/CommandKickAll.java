package me.phantom64.teamdeathmatch.commands;

import me.phantom64.teamdeathmatch.TeamDeathMatch;
import me.phantom64.teamdeathmatch.utils.GameManager;

import org.bukkit.entity.Player;

public class CommandKickAll {
	
	private static GameManager gm = TeamDeathMatch.getGameManager();
	
	public static void execute(Player p, String[] a) {
		
		if (!p.isOp()) {
			p.sendMessage("§dYou don't have permission to execute this command.");
			return;
		}
		
		if (a.length != 1) {
			p.sendMessage("§dWrong usage!");
			p.sendMessage("§dCorrect usage: §5/tdm kickall");
		} else {
			for (Player pl : p.getServer().getOnlinePlayers()) {
				if (gm.isPlaying(pl)) {
					gm.removePlayerFromGame(pl);
					p.getServer().broadcastMessage("§5[TDM] §dEveryone was kicked from the game!");
				}
			}
		}
		
	}

}
