package de.lxca1909.ffaplugin.listeners;

import de.lxca1909.ffaplugin.kits.telekinese.utils.ItemDb;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;

public class Kits implements Listener {

    public static ArrayList<String> AvatarKit = new ArrayList<>();
    public static ArrayList<String> StomperKit = new ArrayList<>();
    public static ArrayList<String> NinjaKit = new ArrayList<>();
    public static ArrayList<String> HolzfaellerKit = new ArrayList<>();
    public static ArrayList<String> KangarooKit = new ArrayList<>();
    public static ArrayList<String> ClawKit = new ArrayList<>();
    public static ArrayList<String> ReviveKit = new ArrayList<>();
    public static ArrayList<String> TelekineseKit = new ArrayList<>();
    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Player p = event.getPlayer();
        try{
            if(event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§2Kits")){
                if(event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
                    Inventory inv = Bukkit.createInventory(null, InventoryType.CHEST, "§2Kits");

                    //Kits

                    //Mythic
                    ItemStack Avatar = new ItemStack(Material.TOTEM_OF_UNDYING);
                    ItemMeta AvatarMeta = Avatar.getItemMeta();
                    AvatarMeta.setLore(null);
                    AvatarMeta.setDisplayName("§8Avatar");
                    Avatar.setItemMeta(AvatarMeta);

                    //Legendarys
                    ItemStack Stomper = new ItemStack(Material.DIAMOND_BOOTS);
                    ItemMeta StomperMeta = Stomper.getItemMeta();
                    StomperMeta.setLore(null);
                    StomperMeta.setDisplayName("§6Stomper");
                    Stomper.setItemMeta(StomperMeta);

                    ItemStack Ninja = new ItemStack(Material.INK_SAC);
                    ItemMeta NinjaMeta = Ninja.getItemMeta();
                    NinjaMeta.setLore(null);
                    NinjaMeta.setDisplayName("§6Ninja");
                    Ninja.setItemMeta(NinjaMeta);

                    ItemStack Revieve = new ItemStack(Material.TOTEM_OF_UNDYING);
                    ItemMeta RVMeta = Revieve.getItemMeta();
                    RVMeta.getItemFlags().add(ItemFlag.HIDE_ATTRIBUTES);
                    RVMeta.setDisplayName("§6Revive");
                    Revieve.setItemMeta(RVMeta);

                    ItemStack Telekinese = new ItemStack(Material.FEATHER);
                    ItemMeta tmeta = Telekinese.getItemMeta();
                    tmeta.setDisplayName("§6Telekinese");
                    Telekinese.setItemMeta(tmeta);

                    //Rare
                    ItemStack Holzfaeller = new ItemStack(Material.STONE_AXE);
                    ItemMeta HFMeta = Holzfaeller.getItemMeta();
                    HFMeta.getItemFlags().add(ItemFlag.HIDE_ATTRIBUTES);
                    HFMeta.setLore(null);
                    HFMeta.setDisplayName("§9Holzfäller");
                    Holzfaeller.setItemMeta(HFMeta);

                    ItemStack Kangaroo = new ItemStack(Material.FIREWORK_ROCKET);
                    ItemMeta KangarooMeta = Kangaroo.getItemMeta();
                    KangarooMeta.setLore(null);
                    KangarooMeta.setDisplayName("§9Kangaroo");
                    Kangaroo.setItemMeta(KangarooMeta);

                    ItemStack Claw = new ItemStack(Material.SHEARS);
                    ItemMeta ClawMeta = Claw.getItemMeta();
                    ClawMeta.setLore(null);
                    ClawMeta.setDisplayName("§9Claw");
                    Claw.setItemMeta(ClawMeta);

                    //Set Kits
                    inv.setItem(0, Avatar);
                    inv.setItem(1, Stomper);
                    inv.setItem(2, Ninja);
                    inv.setItem(3, Holzfaeller);
                    inv.setItem(4, Kangaroo);
                    inv.setItem(5, Claw);
                    inv.setItem(6, Revieve);
                    inv.setItem(7, Telekinese);
                    p.openInventory(inv);

                }
            }
        }catch (NullPointerException e1){

        }
    }
    @EventHandler
    public void onClick(InventoryClickEvent event){
        Player p = (Player)event.getWhoClicked();
        ItemStack Avatar = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemMeta AvatarMeta = Avatar.getItemMeta();
        AvatarMeta.setDisplayName("§8Avatar");
        Avatar.setItemMeta(AvatarMeta);

        ItemStack Stomper = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta StomperMeta = Stomper.getItemMeta();
        StomperMeta.setDisplayName("§6Stomper");
        Stomper.setItemMeta(StomperMeta);

        ItemStack Ninja = new ItemStack(Material.INK_SAC);
        ItemMeta NinjaMeta = Ninja.getItemMeta();
        NinjaMeta.setDisplayName("§6Ninja");
        Ninja.setItemMeta(NinjaMeta);

        ItemStack Holzfaeller = new ItemStack(Material.STONE_AXE);
        ItemMeta HFMeta = Holzfaeller.getItemMeta();
        HFMeta.setUnbreakable(true);
        HFMeta.setDisplayName("§9Holzfäller");
        Holzfaeller.setItemMeta(HFMeta);

        ItemStack Kangaroo = new ItemStack(Material.FIREWORK_ROCKET);
        ItemMeta KangarooMeta = Kangaroo.getItemMeta();
        KangarooMeta.setLore(null);
        KangarooMeta.setDisplayName("§9Kangaroo");
        Kangaroo.setItemMeta(KangarooMeta);

        ItemStack Claw = new ItemStack(Material.SHEARS);
        ItemMeta ClawMeta = Claw.getItemMeta();
        ClawMeta.setLore(null);
        ClawMeta.setDisplayName("§9Claw");
        Claw.setItemMeta(ClawMeta);

        ItemStack Revive = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemMeta RVMeta = Revive.getItemMeta();
        RVMeta.setDisplayName("§6Revive");
        Revive.setItemMeta(RVMeta);

        ItemStack Telekinese = new ItemStack(Material.FEATHER);
        ItemMeta tmeta = Telekinese.getItemMeta();
        tmeta.setDisplayName(ChatColor.GOLD + "Almighty Hand Item");
        Telekinese.setItemMeta(tmeta);

        ItemStack tracker = new ItemStack(Material.COMPASS);
        ItemMeta trackermeta = tracker.getItemMeta();
        trackermeta.setDisplayName("§fTracker §8(Rechtsclick)");
        tracker.setItemMeta(trackermeta);

        try{
            if(event.getView().getTitle().equals("§2Kits")){
                event.setCancelled(true);
                try {
                    if(event.getCurrentItem().getType() == Material.TOTEM_OF_UNDYING) {
                        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8Avatar")) {
                            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§7Du hast "+ event.getCurrentItem().getItemMeta().getDisplayName() +" §7ausgewählt"));
                            Location loc = p.getLocation();
                            Block b = event.getWhoClicked().getWorld().getBlockAt(event.getWhoClicked().getLocation().subtract(0, 2, 0));
                            if(b.getType().equals(Material.AIR)){
                                loc.setY(loc.getY()-52);
                            }
                            p.teleport(loc);
                            AvatarKit.add(p.getName());
                            NinjaKit.remove(p.getName());
                            TelekineseKit.remove(p.getName());
                            StomperKit.remove(p.getName());
                            HolzfaellerKit.remove(p.getName());
                            ReviveKit.remove(p.getName());
                            KangarooKit.remove(p.getName());
                            ClawKit.remove(p.getName());
                            p.getInventory().clear();
                            p.getInventory().setItem(1, Avatar);
                            p.getInventory().setItem(8, tracker);
                            p.closeInventory();
                        }
                    }
                    if(event.getCurrentItem().getType() == Material.DIAMOND_BOOTS) {
                        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Stomper")) {
                            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§7Du hast "+ event.getCurrentItem().getItemMeta().getDisplayName() +" §7ausgewählt"));
                            Location loc = p.getLocation();
                            Block b = event.getWhoClicked().getWorld().getBlockAt(event.getWhoClicked().getLocation().subtract(0, 2, 0));
                            if(b.getType().equals(Material.AIR)){
                                loc.setY(loc.getY()-52);
                            }
                            p.teleport(loc);
                            AvatarKit.remove(p.getName());
                            TelekineseKit.remove(p.getName());
                            StomperKit.add(p.getName());
                            NinjaKit.remove(p.getName());
                            HolzfaellerKit.remove(p.getName());
                            ClawKit.remove(p.getName());
                            ReviveKit.remove(p.getName());
                            KangarooKit.remove(p.getName());
                            p.getInventory().clear();
//                            p.getInventory().setItem(1, Stomper);
                            p.getInventory().setItem(8, tracker);
                            p.closeInventory();
                        }
                    }
                    if(event.getCurrentItem().getType() == Material.INK_SAC) {
                        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Ninja")) {
                            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§7Du hast "+ event.getCurrentItem().getItemMeta().getDisplayName() +" §7ausgewählt"));
                            p.getInventory().clear();
                            Location loc = p.getLocation();
                            Block b = event.getWhoClicked().getWorld().getBlockAt(event.getWhoClicked().getLocation().subtract(0, 2, 0));
                            if(b.getType().equals(Material.AIR)){
                                loc.setY(loc.getY()-52);
                            }
                            p.teleport(loc);
                            TelekineseKit.remove(p.getName());
                            NinjaKit.add(p.getName());
                            AvatarKit.remove(p.getName());
                            ReviveKit.remove(p.getName());
                            HolzfaellerKit.remove(p.getName());
                            KangarooKit.remove(p.getName());
                            ClawKit.remove(p.getName());
                            StomperKit.remove(p.getName());
//                            p.getInventory().setItem(1, Ninja);
                            p.getInventory().setItem(8, tracker);
                            p.closeInventory();
                        }
                    }
                    if(event.getCurrentItem().getType() == Material.STONE_AXE) {
                        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§9Holzfäller")) {
                            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§7Du hast "+ event.getCurrentItem().getItemMeta().getDisplayName() +" §7ausgewählt"));
                            p.getInventory().clear();
                            Location loc = p.getLocation();
                            Block b = event.getWhoClicked().getWorld().getBlockAt(event.getWhoClicked().getLocation().subtract(0, 2, 0));
                            if(b.getType().equals(Material.AIR)){
                                loc.setY(loc.getY()-52);
                            }
                            p.teleport(loc);
                            HolzfaellerKit.add(p.getName());
                            NinjaKit.remove(p.getName());
                            AvatarKit.remove(p.getName());
                            KangarooKit.remove(p.getName());
                            TelekineseKit.remove(p.getName());
                            StomperKit.remove(p.getName());
                            ClawKit.remove(p.getName());
                            ReviveKit.remove(p.getName());
                            p.getInventory().setItem(1, Holzfaeller);
                            p.getInventory().setItem(8, tracker);
                            p.closeInventory();
                        }
                    }
                    if(event.getCurrentItem().getType() == Material.FIREWORK_ROCKET) {
                        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§9Kangaroo")) {
                            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§7Du hast "+ event.getCurrentItem().getItemMeta().getDisplayName() +" §7ausgewählt"));
                            p.getInventory().clear();
                            Location loc = p.getLocation();
                            Block b = event.getWhoClicked().getWorld().getBlockAt(event.getWhoClicked().getLocation().subtract(0, 2, 0));
                            if(b.getType().equals(Material.AIR)){
                                loc.setY(loc.getY()-52);
                            }
                            p.teleport(loc);
                            HolzfaellerKit.remove(p.getName());
                            NinjaKit.remove(p.getName());
                            TelekineseKit.remove(p.getName());
                            AvatarKit.remove(p.getName());
                            ClawKit.remove(p.getName());
                            KangarooKit.add(p.getName());
                            ReviveKit.remove(p.getName());
                            StomperKit.remove(p.getName());
                            p.getInventory().setItemInOffHand(Kangaroo);
                            p.getInventory().setItem(8, tracker);
                            p.closeInventory();
                        }
                    }
                    if(event.getCurrentItem().getType() == Material.SHEARS) {
                        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§9Claw")) {
                            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§7Du hast "+ event.getCurrentItem().getItemMeta().getDisplayName() +" §7ausgewählt"));
                            Location loc = p.getLocation();
                            Block b = event.getWhoClicked().getWorld().getBlockAt(event.getWhoClicked().getLocation().subtract(0, 2, 0));
                            if(b.getType().equals(Material.AIR)){
                                loc.setY(loc.getY()-52);
                            }
                            p.teleport(loc);
                            AvatarKit.remove(p.getName());
                            ClawKit.add(p.getName());
                            NinjaKit.remove(p.getName());
                            StomperKit.remove(p.getName());
                            HolzfaellerKit.remove(p.getName());
                            TelekineseKit.remove(p.getName());
                            KangarooKit.remove(p.getName());
                            ReviveKit.remove(p.getName());
                            p.getInventory().clear();
                            p.getInventory().setItem(1, Claw);
                            p.getInventory().setItem(8, tracker);
                            p.closeInventory();
                        }
                    }
                    if(event.getCurrentItem().getType() == Material.TOTEM_OF_UNDYING) {
                        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Revive")) {
                            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§7Du hast "+ event.getCurrentItem().getItemMeta().getDisplayName() +" §7ausgewählt"));
                            Location loc = p.getLocation();
                            Block b = event.getWhoClicked().getWorld().getBlockAt(event.getWhoClicked().getLocation().subtract(0, 2, 0));
                            if(b.getType().equals(Material.AIR)){
                                loc.setY(loc.getY()-52);
                            }
                            p.teleport(loc);
                            AvatarKit.remove(p.getName());
                            NinjaKit.remove(p.getName());
                            StomperKit.remove(p.getName());
                            HolzfaellerKit.remove(p.getName());
                            KangarooKit.remove(p.getName());
                            ClawKit.remove(p.getName());
                            ReviveKit.add(p.getName());
                            TelekineseKit.remove(p.getName());
                            p.getInventory().clear();
//                            p.getInventory().setItem(1, Revive);
                            p.getInventory().setItemInOffHand(Revive);
                            p.getInventory().setItem(8, tracker);
                            p.closeInventory();
                        }
                    }
                    if(event.getCurrentItem().getType() == Material.FEATHER) {
                        if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Telekinese")) {
                            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§7Du hast "+ event.getCurrentItem().getItemMeta().getDisplayName() +" §7ausgewählt"));
                            Location loc = p.getLocation();
                            Block b = event.getWhoClicked().getWorld().getBlockAt(event.getWhoClicked().getLocation().subtract(0, 2, 0));
                            if(b.getType().equals(Material.AIR)){
                                loc.setY(loc.getY()-52);
                            }
                            p.teleport(loc);
                            AvatarKit.remove(p.getName());
                            NinjaKit.remove(p.getName());
                            StomperKit.remove(p.getName());
                            HolzfaellerKit.remove(p.getName());
                            KangarooKit.remove(p.getName());
                            ClawKit.remove(p.getName());
                            ReviveKit.remove(p.getName());
                            TelekineseKit.add(p.getName());
                            p.getInventory().clear();
//                            p.getInventory().setItem(1, Revive);
//                            ItemDb.getItem();
                            p.getInventory().setItemInOffHand(Telekinese);
                            p.getInventory().setItem(8, tracker);
                            p.closeInventory();
                        }
                    }
                }catch(NullPointerException e2){

                }
            }
        }catch(NullPointerException e1){

        }
    }
}
