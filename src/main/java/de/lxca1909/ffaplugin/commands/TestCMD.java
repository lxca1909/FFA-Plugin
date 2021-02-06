package de.lxca1909.ffaplugin.commands;

import de.lxca1909.ffaplugin.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Vector;

public class TestCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("Das geht");
        if(sender instanceof Player){
            Player p = (Player) sender;
            
        }
        return false;
    }
}
