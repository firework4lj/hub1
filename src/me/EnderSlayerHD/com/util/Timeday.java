package me.EnderSlayerHD.com.util;

import me.EnderSlayerHD.com.Main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Timeday implements Listener{

	public Timeday(Main Main) {
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		Bukkit.getPlayer(p.getName()).getWorld().setTime(0);
	}
}
