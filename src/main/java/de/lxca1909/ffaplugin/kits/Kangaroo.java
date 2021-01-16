package de.lxca1909.ffaplugin.kits;

import de.lxca1909.ffaplugin.Main;
import de.lxca1909.ffaplugin.listeners.Kits;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Map;

public class Kangaroo implements Listener {

    Map<String, Long> cooldowns = new HashMap<String, Long>();

    @EventHandler
    public void onJump(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (Kits.KangarooKit.contains(p.getName())) {
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
                if (e.getItem() == null) return;
                if(e.getItem().getType() != Material.FIREWORK_ROCKET)return;
                e.setCancelled(true);
                if (e.getPlayer().getGameMode() != GameMode.CREATIVE) {
                    if (cooldowns.containsKey(p.getName())) {
                        if (cooldowns.get(p.getName()) > System.currentTimeMillis()) {
                            long timeleft = (cooldowns.get(p.getName()) - System.currentTimeMillis()) / 1000;
                            p.sendMessage("§cDeine Fähigkeit ist in §4" + timeleft + "s §cwieder bereit");
                            return;
                        }
                    }
                    cooldowns.put(p.getName(), System.currentTimeMillis() + (3 * 1000));


                    Block b = e.getPlayer().getWorld().getBlockAt(e.getPlayer().getLocation().subtract(0, 1, 0));
                    Block b1 = e.getPlayer().getWorld().getBlockAt(e.getPlayer().getLocation().subtract(0, 2, 0));
                    Block b2 = e.getPlayer().getWorld().getBlockAt(e.getPlayer().getLocation().subtract(0, 3, 0));
                    Block b3 = e.getPlayer().getWorld().getBlockAt(e.getPlayer().getLocation().subtract(0, 4, 0));
                    Block b4 = e.getPlayer().getWorld().getBlockAt(e.getPlayer().getLocation().subtract(0, 5, 0));
                    Block b5 = e.getPlayer().getWorld().getBlockAt(e.getPlayer().getLocation().subtract(0, 6, 0));
                    Block b6 = e.getPlayer().getWorld().getBlockAt(e.getPlayer().getLocation().subtract(0, 7, 0));
                    Block b7 = e.getPlayer().getWorld().getBlockAt(e.getPlayer().getLocation().subtract(0, 8, 0));
                    if (!b.getType().equals(Material.AIR) || !b1.getType().equals(Material.AIR) || !b2.getType().equals(Material.AIR) || !b3.getType().equals(Material.AIR) || !b4.getType().equals(Material.AIR) || !b5.getType().equals(Material.AIR) || !b6.getType().equals(Material.AIR) || !b7.getType().equals(Material.AIR)) {
                        Vector v = e.getPlayer().getLocation().getDirection().multiply(1).setY(1);
                        e.getPlayer().setVelocity(v);
                        if(p.isSneaking()){

                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
            if (Kits.KangarooKit.contains(e.getEntity().getName())) {
                e.setCancelled(true);
            }
        }
    }
}