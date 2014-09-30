package com.zandor300.launchpad.listener.player;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import com.zandor300.launchpad.LaunchPad;
import com.zandor300.launchpad.listener.LPListener;

public class PlayerMove extends LPListener {

	public PlayerMove(LaunchPad pl) {
		super(pl);
	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		Location location = player.getLocation();
		int ID = location.getWorld().getBlockAt(location).getRelative(0, -1, 0)
				.getTypeId();
		int plate = location.getWorld().getBlockAt(location).getTypeId();
		if (ID == plugin.getConfig().getInt("bottom-block-id"))
			if (plate == 70) {
				player.setVelocity(location.getDirection().multiply(5));
				player.setVelocity(new Vector(player.getVelocity().getX(),
						1.0D, player.getVelocity().getZ()));
				player.getWorld().playSound(
						location,
						Sound.valueOf(plugin.getConfig().getString("sound")
								.toUpperCase()), 1.0F, 1.0F);
				player.getWorld().playEffect(
						location,
						Effect.valueOf(plugin.getConfig().getString("effect")
								.toUpperCase()), 4);
			}
	}
}
