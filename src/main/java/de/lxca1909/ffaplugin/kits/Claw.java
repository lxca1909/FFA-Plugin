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
import org.bukkit.entity.EvokerFangs;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
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
                    Location start = p.getLocation();
                    Location start2 = p.getLocation().add(0,2,0);
                    Vector direction = start.getDirection();
                    for(int i = 1; i <= (Integer)5; i++){
                        p.getWorld().spawnEntity(start.clone().add(direction.clone().multiply(i)), EntityType.EVOKER_FANGS).setMetadata(p.getUniqueId().toString(), new FixedMetadataValue(Main.getMain(), ""));
                        p.getWorld().spawnEntity(start2.clone().add(direction.clone().multiply(i)), EntityType.EVOKER_FANGS).setMetadata(p.getUniqueId().toString(), new FixedMetadataValue(Main.getMain(), ""));
                    }
                }
            }
        }
    }
    @EventHandler
    public void on(EntityDamageByEntityEvent e){
        if(e.getEntity() instanceof Player && e.getDamager() instanceof EvokerFangs){
            Player p = (Player) e.getEntity();
            EvokerFangs evokerFangs = (EvokerFangs) e.getDamager();
            if(evokerFangs.getName().equalsIgnoreCase("§9Claw")){
                e.setCancelled(true);
            }else {
                p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20 * (Integer)5, 255));
            }
        }
    }
}