package de.lxca1909.ffaplugin.listeners;

import de.lxca1909.ffaplugin.commands.Build;
import org.bukkit.Material;
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
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

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
        ItemStack brown = new ItemStack(Material.BROWN_MUSHROOM, 32);
        ItemStack red = new ItemStack(Material.RED_MUSHROOM, 32);
        ItemStack bowl = new ItemStack(Material.BOWL, 32);
        if(e.getDrops().contains(Material.TOTEM_OF_UNDYING)){
            e.getDrops().remove(Material.TOTEM_OF_UNDYING);
        }
        if(e.getDrops().contains(Material.FEATHER)){
            e.getDrops().remove(Material.FEATHER);
        }
        if(Kits.HolzfaellerKit.contains(e.getEntity().getName())){
            if(e.getDrops().contains(Material.STONE_AXE)){
                e.getDrops().remove(Material.STONE_AXE);
            }
        }
        if(e.getDrops().contains(Material.FIREWORK_ROCKET)){
            e.getDrops().remove(Material.FIREWORK_ROCKET);
        }
        if(e.getDrops().contains(Material.SHEARS)){
            e.getDrops().remove(Material.SHEARS);
        }
        e.getDrops().add(brown);
        e.getDrops().add(red);
        e.getDrops().add(bowl);
    }

}
