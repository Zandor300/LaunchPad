package com.zandor300.launchpad;

import java.io.IOException;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;

import com.zandor300.launchpad.listener.player.PlayerMove;
import com.zandor300.launchpad.utilities.Chat;

public class LaunchPad extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		Chat.init(this);

		Chat.sendConsoleMessage("Setting up events...");
		PluginManager manager = getServer().getPluginManager();
		manager.registerEvents(new PlayerMove(this), this);
		Chat.sendConsoleMessage("Setting up events done!");

		Chat.sendConsoleMessage("Sending stats to MCStats...");
		try {
			Metrics metrics = new Metrics(this);
			metrics.start();
			Chat.sendConsoleMessage("Sending stats to MCStats done!");
		} catch (IOException e) {
			Chat.sendConsoleMessage("Sending stats to MCStats failed!");
		}

		Chat.sendConsoleMessage("LaunchPad is enabled!");
	}

	@Override
	public void onDisable() {
		Chat.sendConsoleMessage("LaunchPad is disabled!");
	}
}
