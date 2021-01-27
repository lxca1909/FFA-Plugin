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
        if(e.getEntity().getInventory().getItem(0).equals(Material.TOTEM_OF_UNDYING) ||
           e.getEntity().getInventory().getItem(1).equals(Material.TOTEM_OF_UNDYING) ||
           e.getEntity().getInventory().getItem(2).equals(Material.TOTEM_OF_UNDYING) ||
           e.getEntity().getInventory().getItem(3).equals(Material.TOTEM_OF_UNDYING) ||
           e.getEntity().getInventory().getItem(4).equals(Material.TOTEM_OF_UNDYING) ||
           e.getEntity().getInventory().getItem(5).equals(Material.TOTEM_OF_UNDYING) ||
           e.getEntity().getInventory().getItem(6).equals(Material.TOTEM_OF_UNDYING) ||
           e.getEntity().getInventory().getItem(7).equals(Material.TOTEM_OF_UNDYING) ||
           e.getEntity().getInventory().getItem(8).equals(Material.TOTEM_OF_UNDYING) ||
           e.getEntity().getInventory().getItem(9).equals(Material.TOTEM_OF_UNDYING) ||
           e.getEntity().getInventory().getItem(10).equals(Material.TOTEM_OF_UNDYING) ||
           e.getEntity().getInventory().getItem(11).equals(Material.TOTEM_OF_UNDYING) ||
           e.getEntity().getInventory().getItem(12).equals(Material.TOTEM_OF_UNDYING) ||
           e.getEntity().getInventory().getItem(13).equals(Material.TOTEM_OF_UNDYING) ||
           e.getEntity().getInventory().getItem(14).equals(Material.TOTEM_OF_UNDYING) ||
           e.getEntity().getInventory().getItem(15).equals(Material.TOTEM_OF_UNDYING) ||
           e.getEntity().getInventory().getItem(16).equals(Material.TOTEM_OF_UNDYING) ||
           e.getEntity().getInventory().getItem(17).equals(Material.TOTEM_OF_UNDYING) ||
           e.getEntity().getInventory().getItem(18).equals(Material.TOTEM_OF_UNDYING) ||
           e.getEntity().getInventory().getItem(19).equals(Material.TOTEM_OF_UNDYING) ||
           e.getEntity().getInventory().getItem(20).equals(Material.TOTEM_OF_UNDYING) ||
           e.getEntity().getInventory().getItem(21).equals(Material.TOTEM_OF_UNDYING) ||
           e.getEntity().getInventory().getItem(22).equals(Material.TOTEM_OF_UNDYING) ||
           e.getEntity().getInventory().getItem(23).equals(Material.TOTEM_OF_UNDYING) ||
           e.getEntity().getInventory().getItem(24).equals(Material.TOTEM_OF_UNDYING) ||
           e.getEntity().getInventory().getItem(25).equals(Material.TOTEM_OF_UNDYING) ||
           e.getEntity().getInventory().getItem(26).equals(Material.TOTEM_OF_UNDYING) ||
           e.getEntity().getInventory().getItem(27).equals(Material.TOTEM_OF_UNDYING) ||
           e.getEntity().getInventory().getItem(28).equals(Material.TOTEM_OF_UNDYING) ||
           e.getEntity().getInventory().getItem(29).equals(Material.TOTEM_OF_UNDYING) ||
           e.getEntity().getInventory().getItem(30).equals(Material.TOTEM_OF_UNDYING) ||
           e.getEntity().getInventory().getItem(31).equals(Material.TOTEM_OF_UNDYING) ||
           e.getEntity().getInventory().getItem(32).equals(Material.TOTEM_OF_UNDYING) ||
           e.getEntity().getInventory().getItem(33).equals(Material.TOTEM_OF_UNDYING) ||
           e.getEntity().getInventory().getItem(34).equals(Material.TOTEM_OF_UNDYING) ||
           e.getEntity().getInventory().getItem(35).equals(Material.TOTEM_OF_UNDYING)){
            e.getDrops().remove(totem);
        }else if(e.getEntity().getInventory().getItem(0).equals(Material.FEATHER) ||
                e.getEntity().getInventory().getItem(1).equals(Material.FEATHER) ||
                e.getEntity().getInventory().getItem(2).equals(Material.FEATHER) ||
                e.getEntity().getInventory().getItem(3).equals(Material.FEATHER) ||
                e.getEntity().getInventory().getItem(4).equals(Material.FEATHER) ||
                e.getEntity().getInventory().getItem(5).equals(Material.FEATHER) ||
                e.getEntity().getInventory().getItem(6).equals(Material.FEATHER) ||
                e.getEntity().getInventory().getItem(7).equals(Material.FEATHER) ||
                e.getEntity().getInventory().getItem(8).equals(Material.FEATHER) ||
                e.getEntity().getInventory().getItem(9).equals(Material.FEATHER) ||
                e.getEntity().getInventory().getItem(10).equals(Material.FEATHER) ||
                e.getEntity().getInventory().getItem(11).equals(Material.FEATHER) ||
                e.getEntity().getInventory().getItem(12).equals(Material.FEATHER) ||
                e.getEntity().getInventory().getItem(13).equals(Material.FEATHER) ||
                e.getEntity().getInventory().getItem(14).equals(Material.FEATHER) ||
                e.getEntity().getInventory().getItem(15).equals(Material.FEATHER) ||
                e.getEntity().getInventory().getItem(16).equals(Material.FEATHER) ||
                e.getEntity().getInventory().getItem(17).equals(Material.FEATHER) ||
                e.getEntity().getInventory().getItem(18).equals(Material.FEATHER) ||
                e.getEntity().getInventory().getItem(19).equals(Material.FEATHER) ||
                e.getEntity().getInventory().getItem(20).equals(Material.FEATHER) ||
                e.getEntity().getInventory().getItem(21).equals(Material.FEATHER) ||
                e.getEntity().getInventory().getItem(22).equals(Material.FEATHER) ||
                e.getEntity().getInventory().getItem(23).equals(Material.FEATHER) ||
                e.getEntity().getInventory().getItem(24).equals(Material.FEATHER) ||
                e.getEntity().getInventory().getItem(25).equals(Material.FEATHER) ||
                e.getEntity().getInventory().getItem(26).equals(Material.FEATHER) ||
                e.getEntity().getInventory().getItem(27).equals(Material.FEATHER) ||
                e.getEntity().getInventory().getItem(28).equals(Material.FEATHER) ||
                e.getEntity().getInventory().getItem(29).equals(Material.FEATHER) ||
                e.getEntity().getInventory().getItem(30).equals(Material.FEATHER) ||
                e.getEntity().getInventory().getItem(31).equals(Material.FEATHER) ||
                e.getEntity().getInventory().getItem(32).equals(Material.FEATHER) ||
                e.getEntity().getInventory().getItem(33).equals(Material.FEATHER) ||
                e.getEntity().getInventory().getItem(34).equals(Material.FEATHER) ||
                e.getEntity().getInventory().getItem(35).equals(Material.FEATHER)){
            e.getDrops().remove(feather);
        }else if(e.getEntity().getInventory().getItem(0).equals(Material.FIREWORK_ROCKET) ||
                e.getEntity().getInventory().getItem(1).equals(Material.FIREWORK_ROCKET) ||
                e.getEntity().getInventory().getItem(2).equals(Material.FIREWORK_ROCKET) ||
                e.getEntity().getInventory().getItem(3).equals(Material.FIREWORK_ROCKET) ||
                e.getEntity().getInventory().getItem(4).equals(Material.FIREWORK_ROCKET) ||
                e.getEntity().getInventory().getItem(5).equals(Material.FIREWORK_ROCKET) ||
                e.getEntity().getInventory().getItem(6).equals(Material.FIREWORK_ROCKET) ||
                e.getEntity().getInventory().getItem(7).equals(Material.FIREWORK_ROCKET) ||
                e.getEntity().getInventory().getItem(8).equals(Material.FIREWORK_ROCKET) ||
                e.getEntity().getInventory().getItem(9).equals(Material.FIREWORK_ROCKET) ||
                e.getEntity().getInventory().getItem(10).equals(Material.FIREWORK_ROCKET) ||
                e.getEntity().getInventory().getItem(11).equals(Material.FIREWORK_ROCKET) ||
                e.getEntity().getInventory().getItem(12).equals(Material.FIREWORK_ROCKET) ||
                e.getEntity().getInventory().getItem(13).equals(Material.FIREWORK_ROCKET) ||
                e.getEntity().getInventory().getItem(14).equals(Material.FIREWORK_ROCKET) ||
                e.getEntity().getInventory().getItem(15).equals(Material.FIREWORK_ROCKET) ||
                e.getEntity().getInventory().getItem(16).equals(Material.FIREWORK_ROCKET) ||
                e.getEntity().getInventory().getItem(17).equals(Material.FIREWORK_ROCKET) ||
                e.getEntity().getInventory().getItem(18).equals(Material.FIREWORK_ROCKET) ||
                e.getEntity().getInventory().getItem(19).equals(Material.FIREWORK_ROCKET) ||
                e.getEntity().getInventory().getItem(20).equals(Material.FIREWORK_ROCKET) ||
                e.getEntity().getInventory().getItem(21).equals(Material.FIREWORK_ROCKET) ||
                e.getEntity().getInventory().getItem(22).equals(Material.FIREWORK_ROCKET) ||
                e.getEntity().getInventory().getItem(23).equals(Material.FIREWORK_ROCKET) ||
                e.getEntity().getInventory().getItem(24).equals(Material.FIREWORK_ROCKET) ||
                e.getEntity().getInventory().getItem(25).equals(Material.FIREWORK_ROCKET) ||
                e.getEntity().getInventory().getItem(26).equals(Material.FIREWORK_ROCKET) ||
                e.getEntity().getInventory().getItem(27).equals(Material.FIREWORK_ROCKET) ||
                e.getEntity().getInventory().getItem(28).equals(Material.FIREWORK_ROCKET) ||
                e.getEntity().getInventory().getItem(29).equals(Material.FIREWORK_ROCKET) ||
                e.getEntity().getInventory().getItem(30).equals(Material.FIREWORK_ROCKET) ||
                e.getEntity().getInventory().getItem(31).equals(Material.FIREWORK_ROCKET) ||
                e.getEntity().getInventory().getItem(32).equals(Material.FIREWORK_ROCKET) ||
                e.getEntity().getInventory().getItem(33).equals(Material.FIREWORK_ROCKET) ||
                e.getEntity().getInventory().getItem(34).equals(Material.FIREWORK_ROCKET) ||
                e.getEntity().getInventory().getItem(35).equals(Material.FIREWORK_ROCKET)){
            e.getDrops().remove(firework);
        }else if(e.getEntity().getInventory().getItem(0).equals(Material.STONE_AXE) ||
                e.getEntity().getInventory().getItem(1).equals(Material.STONE_AXE) ||
                e.getEntity().getInventory().getItem(2).equals(Material.STONE_AXE) ||
                e.getEntity().getInventory().getItem(3).equals(Material.STONE_AXE) ||
                e.getEntity().getInventory().getItem(4).equals(Material.STONE_AXE) ||
                e.getEntity().getInventory().getItem(5).equals(Material.STONE_AXE) ||
                e.getEntity().getInventory().getItem(6).equals(Material.STONE_AXE) ||
                e.getEntity().getInventory().getItem(7).equals(Material.STONE_AXE) ||
                e.getEntity().getInventory().getItem(8).equals(Material.STONE_AXE) ||
                e.getEntity().getInventory().getItem(9).equals(Material.STONE_AXE) ||
                e.getEntity().getInventory().getItem(10).equals(Material.STONE_AXE) ||
                e.getEntity().getInventory().getItem(11).equals(Material.STONE_AXE) ||
                e.getEntity().getInventory().getItem(12).equals(Material.STONE_AXE) ||
                e.getEntity().getInventory().getItem(13).equals(Material.STONE_AXE) ||
                e.getEntity().getInventory().getItem(14).equals(Material.STONE_AXE) ||
                e.getEntity().getInventory().getItem(15).equals(Material.STONE_AXE) ||
                e.getEntity().getInventory().getItem(16).equals(Material.STONE_AXE) ||
                e.getEntity().getInventory().getItem(17).equals(Material.STONE_AXE) ||
                e.getEntity().getInventory().getItem(18).equals(Material.STONE_AXE) ||
                e.getEntity().getInventory().getItem(19).equals(Material.STONE_AXE) ||
                e.getEntity().getInventory().getItem(20).equals(Material.STONE_AXE) ||
                e.getEntity().getInventory().getItem(21).equals(Material.STONE_AXE) ||
                e.getEntity().getInventory().getItem(22).equals(Material.STONE_AXE) ||
                e.getEntity().getInventory().getItem(23).equals(Material.STONE_AXE) ||
                e.getEntity().getInventory().getItem(24).equals(Material.STONE_AXE) ||
                e.getEntity().getInventory().getItem(25).equals(Material.STONE_AXE) ||
                e.getEntity().getInventory().getItem(26).equals(Material.STONE_AXE) ||
                e.getEntity().getInventory().getItem(27).equals(Material.STONE_AXE) ||
                e.getEntity().getInventory().getItem(28).equals(Material.STONE_AXE) ||
                e.getEntity().getInventory().getItem(29).equals(Material.STONE_AXE) ||
                e.getEntity().getInventory().getItem(30).equals(Material.STONE_AXE) ||
                e.getEntity().getInventory().getItem(31).equals(Material.STONE_AXE) ||
                e.getEntity().getInventory().getItem(32).equals(Material.STONE_AXE) ||
                e.getEntity().getInventory().getItem(33).equals(Material.STONE_AXE) ||
                e.getEntity().getInventory().getItem(34).equals(Material.STONE_AXE) ||
                e.getEntity().getInventory().getItem(35).equals(Material.STONE_AXE)){
            e.getDrops().remove(stoneaxe);
        }
        e.getDrops().add(brown);
        e.getDrops().add(red);
        e.getDrops().add(bowl);
    }
}
