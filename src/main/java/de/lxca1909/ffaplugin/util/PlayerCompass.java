package de.lxca1909.ffaplugin.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerCompass implements Listener {

    @EventHandler
    public void on(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
            try{
                if(p.getItemInHand().getType() == Material.COMPASS){
                    for(Entity ent : p.getNearbyEntities(500D, 256D, 500D)){
                        if(ent instanceof Player) {
                            Player near = (Player) ent;
                            p.setCompassTarget(near.getLocation());
                            p.sendMessage("§eDer Spieler " + near.getName()+ " ist " + ((int) p.getLocation().distance(near.getLocation())) + " Blöcke entfernt");
                        }
                    }
                }
            }catch (Exception e1){

            }
        }
    }
}
