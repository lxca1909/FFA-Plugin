package de.lxca1909.ffaplugin.kits;

import de.lxca1909.ffaplugin.listeners.Kits;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class Stomper implements Listener {

    @EventHandler
    public void onStomp(EntityDamageEvent e){
        if(!(e.getEntity() instanceof Player)) return;
        Player p = (Player) e.getEntity();
        if(!(Kits.StomperKit.contains(p.getName()))) return;
        if(e.getCause() == EntityDamageEvent.DamageCause.FALL){
            double damage = e.getDamage();
            for(Entity nearby : p.getNearbyEntities(2, 2 ,2)){
               if(nearby instanceof Player){
                   Player target = (Player) nearby;
                   if(target.getInventory().getHelmet() == null){
                       target.damage(30d);
                   }else {
                       target.damage(3.75d);
                   }
               }
            }
            if(damage > 4d){
                damage = 4d;
            }
            e.setDamage(damage);
        }
    }
}
