package de.lxca1909.ffaplugin.kits;

import de.lxca1909.ffaplugin.Main;
import de.lxca1909.ffaplugin.listeners.Kits;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Map;

public class Avatar implements Listener {

    Map<String, Long> cooldowns = new HashMap<String, Long>();

    @EventHandler
    public void onRClick(PlayerInteractEntityEvent e) {
        if (!(e.getRightClicked() instanceof Player)) return;
        Player p = (Player) e.getRightClicked();
//        if(!(Kits.AvatarKit.contains(p.getName()))) return;
        if (!(e.getPlayer().getInventory().getItemInMainHand().getType() == (Material.TOTEM_OF_UNDYING))) return;
        if (cooldowns.containsKey(p.getName())) {
            if (cooldowns.get(p.getName()) > System.currentTimeMillis()) {
                long timeleft = (cooldowns.get(p.getName()) - System.currentTimeMillis()) / 1000;
                p.sendMessage("§cDeine Fähigkeit ist in §4" + timeleft + "s §cwieder bereit");
                return;
            }
        }
        cooldowns.put(p.getName(), System.currentTimeMillis() + (12 * 1000));
            new BukkitRunnable() {
                int i = 0;

                @Override
                public void run() {
                    if (i == 0) {
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 50, 4));
                    }
                    if (i >= i && i <= 4) {
                        Location loc = p.getLocation();
                        loc.setYaw(loc.getYaw() + 90);
                        p.teleport(loc);
                    }
                    if (i == 5) {
                        p.getWorld().createExplosion(p.getLocation(), 2, false, false);
                        p.getLocation().getBlock().setType(Material.COARSE_DIRT);
                        p.getLocation().add(0, 1, 0).getBlock().setType(Material.COARSE_DIRT);
                        p.playSound(p.getLocation(), Sound.BLOCK_GRAVEL_PLACE, 1, 1);
                        Vector vector = new Vector(0, 2, 0);
                        p.setVelocity(vector);
                    }
                    if (i == 7) {
                        p.playSound(p.getLocation(), Sound.BLOCK_GLASS_BREAK, 1, 1);
                        for (int r = -1; r <= 3; r++) {
                            p.getLocation().add(0, r, 0).getBlock().setType(Material.ICE);
                            p.getLocation().add(1, r, 0).getBlock().setType(Material.ICE);
                            p.getLocation().add(1, r, 1).getBlock().setType(Material.ICE);
                            p.getLocation().add(1, r, -1).getBlock().setType(Material.ICE);
                            p.getLocation().add(-1, r, 0).getBlock().setType(Material.ICE);
                            p.getLocation().add(-1, r, 1).getBlock().setType(Material.ICE);
                            p.getLocation().add(-1, r, -1).getBlock().setType(Material.ICE);
                            p.getLocation().add(0, r, 1).getBlock().setType(Material.ICE);
                            p.getLocation().add(0, r, -1).getBlock().setType(Material.ICE);
                        }
                        for (int r = 0; r <= 2; r++) {
                            p.getLocation().add(2, r, 0).getBlock().setType(Material.ICE);
                            p.getLocation().add(2, r, 1).getBlock().setType(Material.ICE);
                            p.getLocation().add(2, r, -1).getBlock().setType(Material.ICE);
                            p.getLocation().add(-2, r, 0).getBlock().setType(Material.ICE);
                            p.getLocation().add(-2, r, 1).getBlock().setType(Material.ICE);
                            p.getLocation().add(-2, r, -1).getBlock().setType(Material.ICE);
                            p.getLocation().add(0, r, 2).getBlock().setType(Material.ICE);
                            p.getLocation().add(1, r, 2).getBlock().setType(Material.ICE);
                            p.getLocation().add(-1, r, 2).getBlock().setType(Material.ICE);
                            p.getLocation().add(0, r, -2).getBlock().setType(Material.ICE);
                            p.getLocation().add(1, r, -2).getBlock().setType(Material.ICE);
                            p.getLocation().add(-1, r, 0).getBlock().setType(Material.ICE);
                        }
                    }
                    if (i == 9) {
                        p.getWorld().strikeLightningEffect(p.getLocation());
                        p.getWorld().strikeLightningEffect(p.getLocation());
                        p.getWorld().strikeLightningEffect(p.getLocation());
                        p.getWorld().strikeLightningEffect(p.getLocation());
                        p.getWorld().strikeLightningEffect(p.getLocation());
                        p.getWorld().strikeLightningEffect(p.getLocation());
                        p.setFireTicks(80);
                        p.getWorld().createExplosion(p.getLocation(), 2, true, true);
                        p.playSound(p.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 1, 1);
                    }
                    i++;
                }
            }.runTaskTimer(Main.getMain(), 0, 10);
    }
}
