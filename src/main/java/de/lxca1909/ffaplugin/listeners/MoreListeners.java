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
        if(e.getEntity().getInventory().getHelmet().equals(Material.DIA))
        e.getDrops().add(brown);
        e.getDrops().add(red);
        e.getDrops().add(bowl);
    }
}
