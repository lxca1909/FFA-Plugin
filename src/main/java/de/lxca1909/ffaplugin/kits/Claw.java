package de.lxca1909.ffaplugin.kits;

import de.lxca1909.ffaplugin.Main;
import de.lxca1909.ffaplugin.listeners.Kits;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
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

public class Claw implements Listener {

    Map<String, Long> cooldowns = new HashMap<String, Long>();

    @EventHandler
    public void on(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (Kits.ClawKit.contains(p.getName())) {
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
                if (e.getItem() == null) return;
                if(e.getItem().getType() != Material.SHEARS)return;
                e.setCancelled(true);
                if (e.getPlayer().getGameMode() != GameMode.CREATIVE) {
                    if (cooldowns.containsKey(p.getName())) {
                        if (cooldowns.get(p.getName()) > System.currentTimeMillis()) {
                            long timeleft = (cooldowns.get(p.getName()) - System.currentTimeMillis()) / 1000;
                            p.sendMessage("§cDeine Fähigkeit ist in §4" + timeleft + "s §cwieder bereit");
                            return;
                        }
                    }
                    cooldowns.put(p.getName(), System.currentTimeMillis() + (1 * 1000));

                    double newX;
                    double newZ;
                    float yaw = p.getLocation().getYaw() + 90;

                    if(yaw < 0) yaw += 360;

                    newX = Math.cos(Math.toRadians(yaw));
                    newZ = Math.sin(Math.toRadians(yaw));

                    Location loc = new Location(p.getLocation().getWorld(), p.getLocation().getX() + newX, p.getLocation().getY(), p.getLocation().getZ() + newZ, p.getLocation().getYaw(), p.getLocation().getPitch());
//                    Location loc1 = new Location(p.getLocation().getWorld(), p.getLocation().getX() + newX + newX1, p.getLocation().getY(), p.getLocation().getZ() + newZ, p.getLocation().getYaw(), p.getLocation().getPitch());
//                    Location loc2 = new Location(p.getLocation().getWorld(), p.getLocation().getX() + newX, p.getLocation().getY(), p.getLocation().getZ() + newZ, p.getLocation().getYaw(), p.getLocation().getPitch());
//                    Location loc3 = new Location(p.getLocation().getWorld(), p.getLocation().getX() + newX, p.getLocation().getY(), p.getLocation().getZ() + newZ, p.getLocation().getYaw(), p.getLocation().getPitch());
//                    Location loc4 = new Location(p.getLocation().getWorld(), p.getLocation().getX() + newX, p.getLocation().getY(), p.getLocation().getZ() + newZ, p.getLocation().getYaw(), p.getLocation().getPitch());
//                    Location loc5 = new Location(p.getLocation().getWorld(), p.getLocation().getX() + newX, p.getLocation().getY(), p.getLocation().getZ() + newZ, p.getLocation().getYaw(), p.getLocation().getPitch());
//                    Location loc6 = new Location(p.getLocation().getWorld(), p.getLocation().getX() + newX, p.getLocation().getY(), p.getLocation().getZ() + newZ, p.getLocation().getYaw(), p.getLocation().getPitch());
//                    Location loc7 = new Location(p.getLocation().getWorld(), p.getLocation().getX() + newX, p.getLocation().getY(), p.getLocation().getZ() + newZ, p.getLocation().getYaw(), p.getLocation().getPitch());
                    p.getWorld().spawnEntity(loc, EntityType.EVOKER_FANGS);
//                    p.getWorld().spawnEntity(loc1, EntityType.EVOKER_FANGS);
//                    p.getWorld().spawnEntity(loc2, EntityType.EVOKER_FANGS);
//                    p.getWorld().spawnEntity(loc3, EntityType.EVOKER_FANGS);
//                    p.getWorld().spawnEntity(loc4, EntityType.EVOKER_FANGS);
//                    p.getWorld().spawnEntity(loc5, EntityType.EVOKER_FANGS);
//                    p.getWorld().spawnEntity(loc6, EntityType.EVOKER_FANGS);
//                    p.getWorld().spawnEntity(loc7, EntityType.EVOKER_FANGS);
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