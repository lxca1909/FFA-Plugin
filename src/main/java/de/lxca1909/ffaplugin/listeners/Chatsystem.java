package de.lxca1909.ffaplugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chatsystem implements Listener {

    @EventHandler
    public void on(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        for(Player all : Bukkit.getOnlinePlayers()) {
            if (e.getMessage().startsWith("@" + all.getName())) {
                if (p.hasPermission("rang.admin") || all.hasPermission("rang.admin")) {
                    e.setFormat("§c" + p.getName() + ": §6§l" + e.getMessage());
                } else if (p.hasPermission("rang.mod") || all.hasPermission("rang.mod")) {
                    e.setFormat("§5" + p.getName() + ": §6§l" + e.getMessage());
                } else if (p.hasPermission("rang.media") || all.hasPermission("rang.media")) {
                    e.setFormat("§b" + p.getName() + ": §6§l" + e.getMessage());
                } else if (p.hasPermission("rang.yinyang") || all.hasPermission("rang.yinyang")) {
                    e.setFormat("§9" + p.getName() + ": §6§l" + e.getMessage());
                } else {
                    e.setFormat("§8" + p.getName() + ": §6§l" + e.getMessage());
                }
                all.playSound(all.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 5, 1);
            } else {
                if (p.hasPermission("rang.admin") || all.hasPermission("rang.admin")) {
                    e.setFormat("§c" + p.getName() + ": §7" + e.getMessage());
                } else if (p.hasPermission("rang.mod") || all.hasPermission("rang.mod")) {
                    e.setFormat("§5" + p.getName() + ": §7" + e.getMessage());
                } else if (p.hasPermission("rang.media") || all.hasPermission("rang.media")) {
                    e.setFormat("§b" + p.getName() + ": §7" + e.getMessage());
                } else if (p.hasPermission("rang.yinyang") || all.hasPermission("rang.yinyang")) {
                    e.setFormat("§9" + p.getName() + ": §7" + e.getMessage());
                } else {
                    e.setFormat("§8" + p.getName() + ": §7" + e.getMessage());
                }
            }
        }
    }
}
