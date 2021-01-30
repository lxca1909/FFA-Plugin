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
        String msg = e.getMessage();
        String colorcodes = msg.replace("&1", "§1").replace("&1", "§1").replace("&2", "§2").replace("&3", "§3").replace("&4", "§4").replace("&5", "§5").replace("&6", "§6").replace("&7", "§7").replace("&8", "§8").replace("&9", "§9").replace("&0", "§0").replace("&k", "§k").replace("&m", "§m").replace("&o", "§o").replace("&l", "§l").replace("&n", "§n").replace("&a", "§a").replace("&b", "§b").replace("&c", "§c").replace("&d", "§d").replace("&e", "§e").replace("&f", "§f");
        for(Player all : Bukkit.getOnlinePlayers()) {
            if (e.getMessage().startsWith("@" + all.getName())) {
                if(p.hasPermission("lobby.rang.admin")){
                    e.setFormat("§8[§c§lAdmin§8] §7"+p.getName() + " §8➜§7§r "  + colorcodes);
                }else if(p.hasPermission("lobby.rang.mod")){
                    e.setFormat("§8[§5§lMod§8] §7"+p.getName() + " §8➜§7§r "  + colorcodes);
                }else if(p.hasPermission("lobby.rang.sup")){
                    e.setFormat("§8[§9§lSup§8] §7"+p.getName() + " §8➜§7§r "  + colorcodes);
                }else if(p.hasPermission("lobby.rang.bekannt")){
                    e.setFormat("§8[§e§lFreund§8] §7"+p.getName() + " §8➜§7§r "  + colorcodes);
                }else if(p.hasPermission("lobby.rang.vip")){
                    e.setFormat("§8[§6§lVIP§8] §7"+p.getName() + " §8➜§7§r "  + colorcodes);
                }else if(p.hasPermission("lobby.rang.king")){
                    e.setFormat("§8[§f§l☯§8] §7"+p.getName() + " §8➜§7§r "  + colorcodes);
                }else {
                    e.setFormat("§8[§7§lSpieler§8] §7"+p.getName() + " §8➜§7§r "  + colorcodes);
                }
                all.playSound(all.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 5, 1);
            } else {
                if(p.hasPermission("lobby.rang.admin")){
                    e.setFormat("§8[§c§lAdmin§8] §7"+p.getName() + " §8➜§7§r "  + colorcodes);
                }else if(p.hasPermission("lobby.rang.mod")){
                    e.setFormat("§8[§5§lMod§8] §7"+p.getName() + " §8➜§7§r "  + colorcodes);
                }else if(p.hasPermission("lobby.rang.sup")){
                    e.setFormat("§8[§9§lSup§8] §7"+p.getName() + " §8➜§7§r "  + colorcodes);
                }else if(p.hasPermission("lobby.rang.bekannt")){
                    e.setFormat("§8[§e§lFreund§8] §7"+p.getName() + " §8➜§7§r "  + colorcodes);
                }else if(p.hasPermission("lobby.rang.vip")){
                    e.setFormat("§8[§6§lVIP§8] §7"+p.getName() + " §8➜§7§r "  + colorcodes);
                }else if(p.hasPermission("lobby.rang.king")){
                    e.setFormat("§8[§f§l☯§8] §7"+p.getName() + " §8➜§7§r "  + colorcodes);
                }else {
                    e.setFormat("§8[§7§lSpieler§8] §7"+p.getName() + " §8➜§7§r "  + colorcodes);
                }
            }
        }
    }
}
