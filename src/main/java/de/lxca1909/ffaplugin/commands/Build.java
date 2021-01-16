package de.lxca1909.ffaplugin.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Build implements CommandExecutor {
    public static ArrayList<Player> allowed = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if(sender instanceof Player){
            if(p.hasPermission("ffa.build")) {
                if (allowed.contains(p)) {
                    allowed.remove(p);
                    p.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage("§7Du kannst nun nicht mehr bauen!");
                } else {
                    allowed.add(p);
                    p.setGameMode(GameMode.CREATIVE);
                    p.sendMessage("§7Du kannst nun bauen!");
                }
            }else{
                p.sendMessage("§cDazu hast du keine Rechte!");
            }
        }else {
            sender.sendMessage("§cDu musst ein Spieler sein um das zu machen!");
        }
        return false;
    }
}
