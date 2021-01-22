package de.lxca1909.ffaplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitsCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
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

        ItemStack Revive = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemMeta RVMeta = Revive.getItemMeta();
        RVMeta.setDisplayName("§6Revive");
        Revive.setItemMeta(RVMeta);

        ItemStack Telekinese = new ItemStack(Material.FEATHER);
        ItemMeta tmeta = Telekinese.getItemMeta();
        tmeta.setDisplayName("§6Telekinese");
        Telekinese.setItemMeta(tmeta);

        //Rare
        ItemStack Holzfaeller = new ItemStack(Material.WOODEN_AXE);
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
        inv.setItem(6, Revive);
        inv.setItem(7, Telekinese);
        p.openInventory(inv);
        return false;
    }
}
