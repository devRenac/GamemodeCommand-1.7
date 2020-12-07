package dev.rena.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.rena.core.base.Main;
import dev.rena.core.utils.CC;

public class Gamemode implements CommandExecutor{
	final Main plugin;
	public Gamemode (Main plugin) {
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("Console no command");
			return true;
		}
		Player player = (Player) sender;
		if(args.length < 0 || args.length >= 3) {
			player.sendMessage(CC.translate("&cUsage: /gamemode <0|1|2|3> <target opcional>"));
			return true;
		}
		Player target = Bukkit.getPlayer(args[1]);
		if(args.length == 2) {
			if(target == null) {
				player.sendMessage(CC.translate(plugin.getConfig().getString("PLAYER_NOT_FOUND")));
				return true;
			}else if(player == target) {
				player.sendMessage(CC.translate(plugin.getConfig().getString("COMMAND_NOT_YOURSELF")));
				return true;
			}else {
			if(args[0].equalsIgnoreCase("SUVIVAL") || args[0].equalsIgnoreCase("0")) {
				target.setGameMode(GameMode.SURVIVAL);
		}else if(args[0].equalsIgnoreCase("CREATIVE") || args[0].equalsIgnoreCase("1")) {
				target.setGameMode(GameMode.CREATIVE);
			}else if(args[0].equalsIgnoreCase("ADVENTURE") || args[0].equalsIgnoreCase("2")) {
				target.setGameMode(GameMode.ADVENTURE);
		}else {
			player.sendMessage(CC.translate("&cArgument '"+args[0]+ "' not found"));
			return true;
		}
			player.sendMessage(CC.translate(plugin.getConfig().getString("GAMEMODE_OTHER")));
			target.sendMessage(CC.translate(plugin.getConfig().getString("GAMEMODE_PLAYER")));
			return true;
			}
}
			if(args[0].equalsIgnoreCase("SUVIVAL") || args[0].equalsIgnoreCase("0")) {
				player.setGameMode(GameMode.SURVIVAL);
		}else if(args[0].equalsIgnoreCase("CREATIVE") || args[0].equalsIgnoreCase("1")) {
				player.setGameMode(GameMode.CREATIVE);
			}else if(args[0].equalsIgnoreCase("ADVENTURE") || args[0].equalsIgnoreCase("2")) {
				player.setGameMode(GameMode.ADVENTURE);
		}else {
			player.sendMessage(CC.translate("&cArgument "+args[0]+ " not found"));
			return true;
		}
		player.sendMessage(CC.translate(plugin.getConfig().getString("GAMEMODE"))
				.replace("{player_gamemode}", player.getGameMode().toString()));
		return true;
	}

}
