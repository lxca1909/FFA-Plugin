package de.lxca1909.ffaplugin.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GetKitItems {

    public static ItemStack getAvatarItems(){
        ItemStack Avatar = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemMeta AvatarMeta = Avatar.getItemMeta();
        AvatarMeta.setDisplayName("§8Avatar");
        Avatar.setItemMeta(AvatarMeta);
        return Avatar;
    }
    public static ItemStack getStomperItems(){
        ItemStack Stomper = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta StomperMeta = Stomper.getItemMeta();
        StomperMeta.setLore(null);
        StomperMeta.setDisplayName("§6Stomper");
        Stomper.setItemMeta(StomperMeta);
        return Stomper;
    }
    public static ItemStack getNinjaItems(){
        ItemStack Ninja = new ItemStack(Material.INK_SAC);
        ItemMeta NinjaMeta = Ninja.getItemMeta();
        NinjaMeta.setLore(null);
        NinjaMeta.setDisplayName("§6Ninja");
        Ninja.setItemMeta(NinjaMeta);
        return Ninja;
    }
    public static ItemStack getHolzfaeller(){
        ItemStack Holzfaeller = new ItemStack(Material.STONE_AXE);
        ItemMeta HFMeta = Holzfaeller.getItemMeta();
        HFMeta.getItemFlags().add(ItemFlag.HIDE_ATTRIBUTES);
        HFMeta.setLore(null);
        HFMeta.setDisplayName("§9Holzfäller");
        Holzfaeller.setItemMeta(HFMeta);
        return Holzfaeller;
    }
    public static ItemStack getKangarooItems(){
        ItemStack Kangaroo = new ItemStack(Material.FIREWORK_ROCKET);
        ItemMeta KangarooMeta = Kangaroo.getItemMeta();
        KangarooMeta.setLore(null);
        KangarooMeta.setDisplayName("§9Kangaroo");
        Kangaroo.setItemMeta(KangarooMeta);
        return Kangaroo;
    }
    public static ItemStack getClawItems(){
        ItemStack Claw = new ItemStack(Material.SHEARS);
        ItemMeta ClawMeta = Claw.getItemMeta();
        ClawMeta.setLore(null);
        ClawMeta.setDisplayName("§9Claw");
        Claw.setItemMeta(ClawMeta);
        return Claw;
    }
    public static ItemStack getReviveItems(){
        ItemStack Revive = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemMeta RVMeta = Revive.getItemMeta();
        RVMeta.getItemFlags().add(ItemFlag.HIDE_ATTRIBUTES);
        RVMeta.setDisplayName("§6Revive");
        Revive.setItemMeta(RVMeta);
        return Revive;
    }
    public static ItemStack getTelekineseItems(){
        ItemStack Telekinese = new ItemStack(Material.FEATHER);
        ItemMeta tmeta = Telekinese.getItemMeta();
        tmeta.setDisplayName("§6Telekinese");
        Telekinese.setItemMeta(tmeta);
        return Telekinese;
    }


}