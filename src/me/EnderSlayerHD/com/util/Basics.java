package me.EnderSlayerHD.com.util;

import me.EnderSlayerHD.com.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
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
		if(cmd.getName().equalsIgnoreCase("setspawn")){
			if(p.hasPermission("hub.setspawn") || p.isOp()){
				Main.getConfig().set("spawn.x", p.getLocation().getX());
				Main.getConfig().set("spawn.y", p.getLocation().getY());
				Main.getConfig().set("spawn.z", p.getLocation().getZ());
				Main.getConfig().set("spawn.pitch", p.getLocation().getPitch());
				Main.getConfig().set("spawn.yaw", p.getLocation().getYaw());
				Main.saveConfig();
				p.sendMessage(ChatColor.GOLD+"Spawn set!");
			}
		}
		if(cmd.getName().equalsIgnoreCase("spawn")){
			Location spawn = new Location(Bukkit.getWorld("world"), Main.getConfig().getDouble("spawn.x"), Main.getConfig().getDouble("spawn.y"), Main.getConfig().getDouble("spawn.z"));
			p.teleport(spawn);
			p.sendMessage("§9[§9§lEnder§9] §7§oTeleporting to spawn...");
		}
		return false;
	}

	
	
}
