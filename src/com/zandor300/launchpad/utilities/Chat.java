package com.zandor300.launchpad.utilities;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import com.zandor300.launchpad.LaunchPad;

public class Chat {

	private static LaunchPad plugin;
	private static ConsoleCommandSender console;
	private static String prefix = "§3[LaunchPad]§f ";

	public static void init(LaunchPad pl) {
		plugin = pl;
		console = plugin.getServer().getConsoleSender();
	}

	public static void sendConsoleMessage(String message) {
		console.sendMessage(prefix + message);
	}

	public static void sendMessage(Player player, String message) {
		player.sendMessage(prefix + message);
	}

	public static void broadcastMessage(String message) {
		for (Player player : Bukkit.getOnlinePlayers())
			player.sendMessage(prefix + message);
	}
}
