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
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

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
    public void onDamage(EntityDamageEvent e){
        try{
            Player p = (Player) e.getEntity();
            if (Kits.TelekineseKit.contains(p.getName()) || Kits.ReviveKit.contains(p.getName()) || Kits.ClawKit.contains(p.getName()) || Kits.KangarooKit.contains(p.getName()) || Kits.NinjaKit.contains(p.getName()) || Kits.HolzfaellerKit.contains(p.getName()) || Kits.AvatarKit.contains(p.getName()) || Kits.StomperKit.contains(p.getName()))return;
            if(e.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK){
                e.setCancelled(true);
            }
        }catch (Exception e1){

        }
    }
}
