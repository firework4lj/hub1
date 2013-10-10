package me.EnderSlayerHD.com.util;

import me.EnderSlayerHD.com.Main;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class Droppickupitems implements Listener{

	public Droppickupitems(Main Main) {
	}
	
	@EventHandler
	public void onPlayerDropItem(PlayerDropItemEvent e){
		Player p = e.getPlayer();
		if(!p.isOp()){
		e.setCancelled(true);
		p.sendMessage(ChatColor.BLACK+"["+ChatColor.DARK_RED+"Ender"+ChatColor.BLACK+"]"+ChatColor.RED+"Hey, lets not clutter up the place shall we?");
		}else{
		e.setCancelled(false);
		p.sendMessage(ChatColor.BLACK+"["+ChatColor.DARK_RED+"Ender"+ChatColor.BLACK+"]"+ChatColor.RED+"Bypassed item dropping restrictions.");
		}
	}
	@EventHandler
	public void onPlayerPickupItem(PlayerPickupItemEvent e){
		Player p = e.getPlayer();
		if(!p.isOp()){
			e.setCancelled(true);
		}else{
			e.setCancelled(false);
		}
	}
	
}
