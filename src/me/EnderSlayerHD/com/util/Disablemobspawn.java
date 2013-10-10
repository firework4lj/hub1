package me.EnderSlayerHD.com.util;

import me.EnderSlayerHD.com.Main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;


public class Disablemobspawn implements Listener{

	public Disablemobspawn(Main Main) {
	}

	@EventHandler
	public void onCreatureSpawn(CreatureSpawnEvent e){
		e.setCancelled(true);
	}
	
}
