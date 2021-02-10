package de.lxca1909.ffaplugin.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class TestListener implements Listener {

    @EventHandler
    public void onToggle(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(e.getItem().equals(Material.STRIPPED_WARPED_HYPHAE)){
                p.sendMessage("So weit geht es");
            }
        }
        e.setCancelled(true);
    }
}
