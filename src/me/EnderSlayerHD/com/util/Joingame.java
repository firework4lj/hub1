package me.EnderSlayerHD.com.util;

import me.EnderSlayerHD.com.Main;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

public class Joingame implements Listener{

	
	private Main main;
	public Joingame(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onSignChange(SignChangeEvent e){
		Player p = e.getPlayer();
		if(e.getLine(0).equalsIgnoreCase("[join]")){
			p.sendMessage(ChatColor.GOLD+"Join game sign created!");
			e.setLine(0, ChatColor.AQUA+"[Join]");
			e.setLine(1, e.getLine(1));
		}
	}
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event){
		Player player = event.getPlayer();
		if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
		if(event.getClickedBlock().getType() == Material.WALL_SIGN || event.getClickedBlock().getType() == Material.SIGN_POST){
			Sign sign = (Sign) event.getClickedBlock().getState();
			if(sign.getLine(0).equals("§b[Join]")){
		        ByteArrayDataOutput out = ByteStreams.newDataOutput();
		        out.writeUTF("Connect");
		        out.writeUTF(sign.getLine(1));
		        player.sendPluginMessage(main, "BungeeCord", out.toByteArray());
			}
		}
		}	
	}
	
}
