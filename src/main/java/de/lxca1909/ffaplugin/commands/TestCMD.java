package de.lxca1909.ffaplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if (command.getName().equals("test 1")) {
                p.sendMessage("Test 1");
            }
            if (command.getName().equals("test 2")){
                p.sendMessage("Test 2");
            }
        }else {
            sender.sendMessage("Du musst spieler sein um das auszuführen!");
        }
        return false;
    }
}
