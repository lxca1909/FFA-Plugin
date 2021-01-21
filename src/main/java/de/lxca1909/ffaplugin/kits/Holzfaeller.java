package de.lxca1909.ffaplugin.kits;

import de.lxca1909.ffaplugin.listeners.Kits;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class Holzfaeller implements Listener {

    @EventHandler
    public void onbreak(BlockBreakEvent e){
        Player p = e.getPlayer();
        if(p.getGameMode().equals(GameMode.CREATIVE)) return;
            if(Kits.HolzfaellerKit.contains(p.getName())) {
                breakBlock(e.getBlock());
            }
    }
    void breakBlock(Block b) {
        if(b.getType() != Material.OAK_LOG && b.getType() != Material.SPRUCE_LOG && b.getType() != Material.BIRCH_LOG && b.getType() != Material.JUNGLE_LOG && b.getType() != Material.ACACIA_LOG && b.getType() != Material.DARK_OAK_LOG && b.getType() != Material.CRIMSON_STEM && b.getType() != Material.WARPED_STEM && b.getType() != Material.STRIPPED_ACACIA_LOG && b.getType() != Material.STRIPPED_ACACIA_WOOD && b.getType() != Material.STRIPPED_BIRCH_LOG && b.getType() != Material.STRIPPED_BIRCH_WOOD && b.getType() != Material.STRIPPED_CRIMSON_STEM && b.getType() != Material.STRIPPED_CRIMSON_HYPHAE && b.getType() != Material.STRIPPED_DARK_OAK_LOG && b.getType() != Material.STRIPPED_DARK_OAK_WOOD && b.getType() != Material.STRIPPED_JUNGLE_LOG && b.getType() != Material.STRIPPED_JUNGLE_WOOD && b.getType() != Material.STRIPPED_OAK_LOG && b.getType() != Material.STRIPPED_OAK_WOOD && b.getType() != Material.STRIPPED_SPRUCE_LOG && b.getType() != Material.STRIPPED_SPRUCE_WOOD && b.getType() != Material.STRIPPED_WARPED_STEM && b.getType() != Material.STRIPPED_WARPED_HYPHAE)return;
        b.getWorld().playSound(b.getLocation(), Sound.BLOCK_WOOD_HIT, 1, 1);
        b.breakNaturally();
        breakBlock(b.getLocation().add(0, 1, 0).getBlock());
        breakBlock(b.getLocation().add(1, 0, 0).getBlock());
        breakBlock(b.getLocation().add(0, 0, 1).getBlock());
        breakBlock(b.getLocation().add(0, 2, 0).getBlock());
        breakBlock(b.getLocation().add(2, 0, 0).getBlock());
        breakBlock(b.getLocation().add(0, 0, 0).getBlock());
        breakBlock(b.getLocation().add(0, 20, 0).getBlock());


        breakBlock(b.getLocation().subtract(0, 1, 0).getBlock());
        breakBlock(b.getLocation().subtract(1, 0, 0).getBlock());
        breakBlock(b.getLocation().subtract(0, 0, 1).getBlock());
        breakBlock(b.getLocation().subtract(0, 2, 0).getBlock());
        breakBlock(b.getLocation().subtract(2, 0, 0).getBlock());
        breakBlock(b.getLocation().subtract(0, 0, 2).getBlock());
        breakBlock(b.getLocation().subtract(0, 20, 0).getBlock());
    }
}
