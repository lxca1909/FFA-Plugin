package de.lxca1909.ffaplugin.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Soup implements Listener {

    @EventHandler
    public void onSoup(PlayerInteractEvent e){
        Player p = e.getPlayer();
        Damageable player = p;
        try {
            if(e.getAction() == Action.RIGHT_CLICK_AIR | e.getAction() == Action.RIGHT_CLICK_BLOCK){
                try{
                    if(p.getInventory().getItemInMainHand().getType() == Material.MUSHROOM_STEW) {
                        if (e.getItem() == null) return;
                        if ((player.getHealth() < 20D) || (p.getFoodLevel() < 20D)) {
                            double health = player.getHealth() + 8D;
                            double food = p.getFoodLevel() + 8D;
                            if (health > 20D) {
                                health = 20D;
                            }
                            if (p.getHealth() == 20) {
                                p.setFoodLevel((int) food);
                            }
                            p.setFoodLevel((int) food);
                            p.setHealth(health);
                            p.getInventory().getItemInMainHand().setType(Material.BOWL);
                        }
                    }
                }catch (Exception e1){

                }
            }
        }catch (Exception e2){

        }
    }
}
