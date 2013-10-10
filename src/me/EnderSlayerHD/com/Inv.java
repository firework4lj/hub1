
package me.EnderSlayerHD.com;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

public class Inv implements Listener{
  private Plugin Plugin;
private Main main;

  public Inv(Main main){
	  this.main = main;
  }

  @EventHandler
  public void onPlayerInteract(PlayerInteractEvent e){
	  Player p = e.getPlayer();
	  if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || (e.getAction().equals(Action.RIGHT_CLICK_AIR))) {
	   if (e.getItem() != null){
	   if (e.getItem().equals(new ItemStack(Material.EMERALD))){
      IconMenu Menu = new IconMenu("§4§l[]-- Gamemode Chooser --[]", 27, new IconMenu.OptionClickEventHandler(){
        public void onOptionClick(IconMenu.OptionClickEvent event) {
          event.getPlayer().sendMessage("You have chosen " + event.getName());
          event.setWillClose(true);
        }
      }
      , this.Plugin)
        .setOption(0, new ItemStack(Material.DIAMOND_SWORD, 1), "§a§lSurvival", new String[] { "§7§oObjective §7: §a§oSurvive the harsh minecraft environment!" })
        .setOption(4, new ItemStack(Material.TNT, 1), "Ctf", new String[] { "§7§oObjective §7: §a§oCapture the flag!" })
        .setOption(8, new ItemStack(Material.CHEST, 1), "§6§lSurvival Games", new String[] { "*NOT UP YET* §7§oObjective §7: §a§oBe the last player alive to win!" });
      Menu.open(e.getPlayer());
    }else if ((e.getItem().equals(new ItemStack(Material.WATCH))) && ((e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) || (e.getAction().equals(Action.RIGHT_CLICK_AIR)))) {
    	p.performCommand("spawn");
    }
    }else{
    	
    }
    }
  }

  @EventHandler
  public void onInventoryClick(InventoryClickEvent e)
  {
    if ((e.getInventory().getName().equals("§4§l[]-- Gamemode Chooser --[]")) && 
      (e.getRawSlot() < 54) && (e.getRawSlot() > -1)) {
      e.getCursor();
      ItemStack itemclicked = e.getCurrentItem();
      Player p = (Player)e.getWhoClicked();
      e.setCancelled(true);
      if (itemclicked.getTypeId() == 276){
        p.sendMessage("§9[§9§lEnder§9] §7§oTeleporting to §dsurvival§7...");
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF("Survival");
        p.sendPluginMessage(main, "BungeeCord", out.toByteArray());
      }else if (itemclicked.getTypeId() == 46){
        p.sendMessage("§9[§9§lEnder§9] §7§oTeleporting to §dCtf§7...");
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF("Ctf");
        p.sendPluginMessage(main, "BungeeCord", out.toByteArray());
      }else if (itemclicked.getTypeId() == 54){
        p.sendMessage("§9[§9§lEnder§9] §7§oTeleporting to §dSurvival Games§7...");
    }
    }
  }
}