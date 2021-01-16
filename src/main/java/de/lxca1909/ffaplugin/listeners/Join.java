package de.lxca1909.ffaplugin.listeners;

import de.lxca1909.ffaplugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityResurrectEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class Join implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        resetCooldown(p);
        e.setJoinMessage(null);
        p.getInventory().clear();
        p.setMaxHealth(20);
        p.setHealth(20);
        p.setFoodLevel(20);

        ItemStack Kits = new ItemStack(Material.CHEST);
        ItemMeta KitsMeta = Kits.getItemMeta();
        KitsMeta.setDisplayName("§2Kits");
        Kits.setItemMeta(KitsMeta);

        p.getInventory().setItem(0, Kits);
        new BukkitRunnable(){
            @Override
            public void run() {
                resetCooldown(p);
            }

        }.runTaskLater(Main.getMain(), 20);
    }
    @EventHandler
    public void onwiederbeleben(EntityResurrectEvent event){
        if(!(event.getEntity() instanceof Player))return;
        Player p = (Player) event.getEntity();
        ItemStack totem = new ItemStack(Material.TOTEM_OF_UNDYING);
        if(Kits.ReviveKit.contains(event.getEntity().getName())) {
            if(p.getInventory().getItemInMainHand().equals(totem) || p.getInventory().getItemInOffHand().equals(totem)) {
                event.setCancelled(false);
            }
        }else {
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        Player p = (Player) e.getEntity();
        Kits.AvatarKit.remove(p.getName());
        Kits.NinjaKit.remove(p.getName());
        Kits.StomperKit.remove(p.getName());
        Kits.HolzfaellerKit.remove(p.getName());
        Kits.ReviveKit.remove(p.getName());
        Kits.ClawKit.remove(p.getName());
    }
    @EventHandler
    public void onRespawn(PlayerRespawnEvent e){
        Player p = e.getPlayer();
        ItemStack Kits = new ItemStack(Material.CHEST);
        ItemMeta KitsMeta = Kits.getItemMeta();
        KitsMeta.setDisplayName("§2Kits");
        Kits.setItemMeta(KitsMeta);
        p.getInventory().setItem(0, Kits);
        p.teleport(p.getLocation().getWorld().getSpawnLocation());
        new BukkitRunnable(){
            @Override
            public void run() {
                resetCooldown(p);
            }

        }.runTaskLater(Main.getMain(), 20);
    }
    @EventHandler
    public void on(PlayerQuitEvent e){

    }
    private void resetCooldown(Player p){
        p.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(100D);
    }
    }
