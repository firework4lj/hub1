package me.EnderSlayerHD.com;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class Playerjoin implements Listener{

	private Main main;

	public Playerjoin(Main main) {
		this.main = main;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		Location spawn = new Location(Bukkit.getServer().getWorld("world"), main.getConfig().getDouble("spawn.x"), main.getConfig().getDouble("spawn.y"), main.getConfig().getDouble("spawn.z"));
		p.teleport(spawn);
		p.getInventory().clear();
		p.getInventory().setBoots(new ItemStack(Material.AIR));
		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		p.getInventory().setItem(8, new ItemStack(Material.WATCH));
		p.getInventory().setItem(0, new ItemStack(Material.BOOK));
		p.getInventory().setItem(4, new ItemStack(Material.EMERALD));
	    p.sendMessage(ChatColor.AQUA + "§b[§6§l*§b]------------------------------------------------[§6§l*§b]");
	    p.sendMessage(ChatColor.GRAY + "§9§lWelcome §e§o" + p.getName() + " §9§lto §6§lThe EnderDragon Network§9§l!");
	    p.sendMessage(ChatColor.GRAY + "                           §7§oTotal Players §7: §a0 ");
	    p.sendMessage(ChatColor.GRAY + "§7- §a§oRight click with your book to get information!");
	    p.sendMessage(ChatColor.GRAY + "§7- §a§oRight click your emerald to choose a gamemode!");
	    p.sendMessage(ChatColor.GRAY + "§7- §a§oRight click your clock to teleport to spawn!");
	    p.sendMessage(ChatColor.AQUA + "§b[§6§l*§b]------------------------------------------------[§6§l*§b]");
	    String test = p.getServer().getServerName();
	    p.sendMessage(test);
	}
	
}
