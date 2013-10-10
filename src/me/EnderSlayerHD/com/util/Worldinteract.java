package me.EnderSlayerHD.com.util;

import java.util.EventListener;

import me.EnderSlayerHD.com.Main;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class Worldinteract implements Listener{

	public Worldinteract(Main main) {
		
	}
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e){
		Player p = e.getPlayer();
		if(!p.isOp()){
			e.setCancelled(true);
			p.sendMessage(ChatColor.BLACK+"["+ChatColor.DARK_RED+"EnderDragon"+ChatColor.BLACK+"]"+ChatColor.RED+"You cannot break blocks here!");
		}else if(p.isOp()){
			e.setCancelled(false);
		}else{
			e.setCancelled(true);
		}
		
	}
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e){
		Player p = e.getPlayer();
		if(!p.isOp()){
			e.setCancelled(true);
			p.sendMessage(ChatColor.BLACK+"["+ChatColor.DARK_RED+"EnderDragon"+ChatColor.BLACK+"]"+ChatColor.RED+"You cannot place blocks here!");
		}else if(p.isOp()){
			e.setCancelled(false);
		}else{
			e.setCancelled(true);
		}
	}
	
}
