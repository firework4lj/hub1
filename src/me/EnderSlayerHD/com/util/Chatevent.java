package me.EnderSlayerHD.com.util;

import me.EnderSlayerHD.com.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chatevent implements Listener{

	private Main main;

	public Chatevent(Main main) {
	this.main = main;
	}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		if(p.isOp() || main.getConfig().contains("groups.owner."+p.getName())){
			Bukkit.broadcastMessage(ChatColor.BLACK+"["+ChatColor.RED+"Op"+ChatColor.BLACK+"] "+ChatColor.DARK_RED+p.getName()+": "+ChatColor.DARK_GREEN+e.getMessage());
			e.setCancelled(true);
		}else if(p.hasPermission("hub.vip") || main.getConfig().contains("groups.vip."+p.getName())){
			Bukkit.broadcastMessage(ChatColor.BLACK+"["+ChatColor.DARK_AQUA+"Vip"+ChatColor.BLACK+"]"+ChatColor.YELLOW+p.getName()+": "+ChatColor.WHITE+e.getMessage());
			e.setCancelled(true);
		}else{
			Bukkit.broadcastMessage(ChatColor.YELLOW+p.getName()+": "+ChatColor.WHITE+e.getMessage());
			e.setCancelled(true);
		}
	}
	
}
