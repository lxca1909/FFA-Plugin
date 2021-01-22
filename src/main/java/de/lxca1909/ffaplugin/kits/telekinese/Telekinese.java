package de.lxca1909.ffaplugin.kits.telekinese;

import de.lxca1909.ffaplugin.Main;
import de.lxca1909.ffaplugin.kits.telekinese.utils.LocationUtil;
import de.lxca1909.ffaplugin.kits.telekinese.utils.UseListener;
import de.lxca1909.ffaplugin.listeners.Kits;
import de.lxca1909.ffaplugin.util.Vector3D;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
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

public class Telekinese implements Listener {

    Map<String, Long> cooldowns = new HashMap<String, Long>();
    int ATTACK_REACH = 100;

    @EventHandler
    public void on(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (Kits.TelekineseKit.contains(p.getName())) {
                if (e.getItem() == null) {
                    e.setCancelled(true);
                    if (e.getPlayer().getGameMode() != GameMode.CREATIVE) {
                        if (cooldowns.containsKey(p.getName())) {
                            if (cooldowns.get(p.getName()) > System.currentTimeMillis()) {
                                long timeleft = (cooldowns.get(p.getName()) - System.currentTimeMillis()) / 1000;
                                p.sendMessage("§cDeine Fähigkeit ist in §4" + timeleft + "s §cwieder bereit");
                                return;
                            }
                        }
                        cooldowns.put(p.getName(), System.currentTimeMillis() + (30 * 1000));
                        if(e.getAction() == Action.RIGHT_CLICK_AIR){
                            if(p.getInventory().getItemInMainHand().getType() == Material.FEATHER){
                                LivingEntity target = LocationUtil.getEntityInLineOfSight((LivingEntity)p, 12.0D);
                                if(target==null){
                                    UseListener.
                                }
                            }
                        }

                    }
                }
        }
    }
    private boolean hasIntersection(Vector3D p1, Vector3D p2, Vector3D min, Vector3D max){
        double epsilon = 0.0001f;

        Vector3D d = p2.subtract(p1).multiply(0.5);
        Vector3D e = max.subtract(min).multiply(0.5);
        Vector3D c = p1.add(d).subtract(min.add(max).multiply(0.5));
        Vector3D ad = d.abs();

        if (Math.abs(c.x) > e.x + ad.x)
            return false;
        if (Math.abs(c.y) > e.y + ad.y)
            return false;
        if (Math.abs(c.z) > e.z + ad.z)
            return false;

        if (Math.abs(d.y * c.z - d.z * c.y) > e.y * ad.z + e.z * ad.y + epsilon)
            return false;
        if (Math.abs(d.z * c.x - d.x * c.z) > e.z * ad.x + e.x * ad.z + epsilon)
            return false;
        if (Math.abs(d.x * c.y - d.y * c.x) > e.x * ad.y + e.y * ad.x + epsilon)
            return false;

        return true;
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