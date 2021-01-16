package de.lxca1909.ffaplugin.kits;

import de.lxca1909.ffaplugin.Main;
import de.lxca1909.ffaplugin.listeners.Kits;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import java.text.DecimalFormat;
import java.util.HashMap;

public class Ninja implements Listener {

    public static HashMap<String, Long> cooldown = new HashMap<>();
    public HashMap<Player, Player> a = new HashMap<>();
    public HashMap<Player, Long> b = new HashMap<>();
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){
        if((e.getDamager() instanceof Player) && (e.getEntity() instanceof Player)){
            Player p = (Player) e.getDamager();
            Player p1 = (Player) e.getEntity();
            if(Kits.NinjaKit.contains(p.getName()));
            a.put(p, p1);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getMain(), new Runnable() {
                @Override
                public void run() {
                cooldown.remove(p);
                }
            }, 150L);
        }
    }
    @EventHandler
    public void onSneak(PlayerToggleSneakEvent e){
        Player p = e.getPlayer();
        if((e.isSneaking()) && (Kits.NinjaKit.contains(p.getName())) && (a.containsKey(p))){
            Player p1 = a.get(p);
            if((p1 != null) && (!p1.isDead())) {
                String str = null;
                if (b.get(p) != null) {
                    long l = ((Long) b.get(p)).longValue() - System.currentTimeMillis();
                    DecimalFormat decimalFormat = new DecimalFormat("##");
                    int i = (int) 1 / 1000;
                    str = decimalFormat.format(i);
                }
                if ((b.get(p) == null || (int) b.get(p).longValue() < System.currentTimeMillis())) {
                    if (p.getLocation().distance(p1.getLocation()) < 55.0D) {
                        double newX;
                        double newZ;
                        float nang = p1.getLocation().getYaw() + 90;

                        if(nang < 0) nang += 360;

                        newX = Math.cos(Math.toRadians(nang));
                        newZ = Math.sin(Math.toRadians(nang));

                        Location newDamagerLoc = new Location(p1.getLocation().getWorld(), p1.getLocation().getX() - newX,
                                p1.getLocation().getY(), p1.getLocation().getZ() - newZ, p1.getLocation().getYaw(), p1.getLocation().getPitch());

                        p.teleport(newDamagerLoc);
//                        p.teleport(p1.getLocation());
                        p.sendMessage("§7Du hast dich Teleportiert");
                        b.put(p, Long.valueOf(System.currentTimeMillis() + 10000L));
                    } else {
                        p.sendMessage("§cDer Gegner ist zu weit weg!");
                    }
                } else {
                    p.sendMessage("§cDu hast noch ein cooldown von §4" + str + " §csekunden");
                }
            }
        }
    }
}
