package de.lxca1909.ffaplugin.kits.telekinese;

import de.lxca1909.ffaplugin.listeners.Kits;
import net.minecraft.server.v1_16_R3.PacketPlayOutWorldParticles;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

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
                    if(e.getItem().getType() == Material.FEATHER){
                        World world = p.getWorld();
//                        createHelix(p);
                        }
                }
        }
    }

//    public void createHelix(Player player) {
//        Location loc = player.getLocation();
//        int radius = 2;
//        for (double y = 0; y <= 50; y += 0.05) {
//            double x = radius * Math.cos(y);
//            double z = radius * Math.sin(y);
//            PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(EnumParticle.DRIP_LAVA, true, (float) (loc.getX() + x), (float) (loc.getY() + y), (float) (loc.getZ() + z), 0, 0, 0, 0, 1);
//            for (Player online : Bukkit.getOnlinePlayers()) {
//                ((CraftPlayer) online).getHandle().playerConnection.sendPacket(packet);
//            }
//        }
//    }
}