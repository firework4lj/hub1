package me.EnderSlayerHD.com.util;

import me.EnderSlayerHD.com.Main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class playerrespawn implements Listener{

	private Main main;

	public playerrespawn(Main main) {
		this.main = main;
	}

	@EventHandler
	public void onPlayerRespawn(final PlayerRespawnEvent e){
		Player p = e.getPlayer();
		int seconds = 1;
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main, new Runnable(){
			public void run(){
				Location spawn = new Location(Bukkit.getServer().getWorld("world"), main.getConfig().getDouble("spawn.x"), main.getConfig().getDouble("spawn.y"), main.getConfig().getDouble("spawn.z"));
				Player p = e.getPlayer();
		p.teleport(spawn);
			}
			}, (seconds * 20));
		p.getInventory().clear();
		p.getInventory().setBoots(new ItemStack(Material.AIR));
		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		p.getInventory().setItem(8, new ItemStack(Material.WATCH));
		p.getInventory().setItem(0, new ItemStack(Material.BOOK));
		p.getInventory().setItem(4, new ItemStack(Material.EMERALD));
	}
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		e.getDrops().clear();
		e.getDeathMessage().replaceAll(null, "");
	}
}
