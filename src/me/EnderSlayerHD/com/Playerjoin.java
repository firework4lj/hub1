package me.EnderSlayerHD.com;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class Playerjoin implements Listener{

	public Playerjoin(Main main) {
	}

	  @EventHandler
	  public void onPlayerJoin(PlayerJoinEvent e)
	  {
	    Player p = e.getPlayer();
	    p.getInventory().clear();
	    p.getInventory().setBoots(new ItemStack(Material.AIR));
	    p.getInventory().setChestplate(new ItemStack(Material.AIR));
	    p.getInventory().setLeggings(new ItemStack(Material.AIR));
	    p.getInventory().setHelmet(new ItemStack(Material.AIR));
	    p.getInventory().setItem(4, new ItemStack(Material.WATCH));
	    p.getInventory().setItem(1, new ItemStack(Material.BOOK));
	    p.getInventory().setItem(0, new ItemStack(Material.NETHER_STAR));
	    p.sendMessage(ChatColor.AQUA + "§b[§6§l*§b]------------------------------------------------[§6§l*§b]");
	    p.sendMessage(ChatColor.GRAY + "§9§lWelcome §a§l" + p.getName() + " §9§lto §6§lThe DreadSword Network§9§l!");
	    p.sendMessage(ChatColor.GRAY + " ");
	    p.sendMessage(ChatColor.GRAY + "§7- §a§oRight Click your NetherStar to choose a warp to a MiniGame!");
	    p.sendMessage(ChatColor.GRAY + "§7- §a§oDon't forget to vote for us to earn §e§oCrystals §a§owith §e§o/vote");
	    p.sendMessage(ChatColor.GRAY + "§7- §a§oJump twice to §e§oDouble Jump§a!");
	    p.sendMessage(ChatColor.AQUA + "§b[§6§l*§b]------------------------------------------------[§6§l*§b]");
	  }
	}
