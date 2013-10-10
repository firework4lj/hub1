package com.gmail.firework4lj.commands;

import me.EnderSlayerHD.com.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Basics implements CommandExecutor{

	private Main Main;

	public Basics(Main main) {
		this.Main = main;
	}

	@Override
	public boolean onCommand(final CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("gmc")){
			if(p.isOp()){
				p.setGameMode(GameMode.CREATIVE);
			}else{
				p.sendMessage(ChatColor.BLACK+"["+ChatColor.DARK_RED+"Ender"+ChatColor.BLACK+"]"+ChatColor.RED+"What's gmc?");
			}
			}else if(cmd.getName().equalsIgnoreCase("gms")){
				if(p.isOp()){
					p.setGameMode(GameMode.SURVIVAL);
				}else{
					p.sendMessage(ChatColor.BLACK+"["+ChatColor.DARK_RED+"Ender"+ChatColor.BLACK+"]"+ChatColor.RED+"What's gms?");
				}
		}else if(cmd.getName().equalsIgnoreCase("msg")){
			if(args.length == 1){
				p.sendMessage(ChatColor.BLACK+"["+ChatColor.DARK_RED+"Ender"+ChatColor.BLACK+"]"+ChatColor.RED+"Usage: /msg (player) (message)");
			}else if(args.length > 1){
				Player targetPlayer = Bukkit.getPlayer(args[0]);
				targetPlayer.sendMessage(ChatColor.BLACK+"["+ChatColor.DARK_RED+"Ender"+ChatColor.BLACK+"]"+" "+ChatColor.GOLD+targetPlayer.getName()+" -> "+p.getName()+" "+ChatColor.AQUA+args[1]);
				p.sendMessage(ChatColor.BLACK+"["+ChatColor.DARK_RED+"Ender"+ChatColor.BLACK+"]"+" "+ChatColor.GOLD+p.getName()+" -> "+targetPlayer.getName()+" "+ChatColor.AQUA+args[1]);
			}
		}
		return false;
		
	}
	
}
