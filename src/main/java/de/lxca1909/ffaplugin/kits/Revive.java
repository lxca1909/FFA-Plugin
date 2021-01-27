package de.lxca1909.ffaplugin.kits;

import de.lxca1909.ffaplugin.Main;
import de.lxca1909.ffaplugin.listeners.Kits;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityResurrectEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class Revive implements Listener {

    @EventHandler
    public void on(EntityResurrectEvent e){
        ItemStack totem = new ItemStack(Material.TOTEM_OF_UNDYING);
        if(Kits.ReviveKit.contains(e.getEntity().getName())) {
            if (e.getEntity() instanceof Player) {
                Player p = (Player) e.getEntity();
                Bukkit.getScheduler().runTaskTimer(Main.getMain(), new Runnable() {
                    @Override
                    public void run() {
                        p.getInventory().setItem(EquipmentSlot.OFF_HAND, totem);
                    }
                }, 20 * 300, 20 * 300);
            }
        }
    }
}
