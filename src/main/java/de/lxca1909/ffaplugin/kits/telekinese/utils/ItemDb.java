package de.lxca1909.ffaplugin.kits.telekinese.utils;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemDb {
    public static ItemStack getItem() {
        ItemStack item = new ItemStack(Material.FEATHER);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.GOLD + "Almighty Hand Item");
        List<String> loreLines = new ArrayList<>();
        loreLines.add(ChatColor.GOLD + "Right-click " + ChatColor.GRAY + "a living entity to start telekinesis.");
        loreLines.add(ChatColor.GOLD + "Right-click " + ChatColor.GRAY + "again to stop telekinesis.");
        loreLines.add(ChatColor.GRAY + "When active, " + ChatColor.GOLD + "scroll up " + ChatColor.GRAY + "to push target.");
        loreLines.add(ChatColor.GRAY + "When active, " + ChatColor.GOLD + "scroll down " + ChatColor.GRAY + "to pull target.");
        itemMeta.setLore(loreLines);
        item.setItemMeta(itemMeta);
        return item;
    }
}
