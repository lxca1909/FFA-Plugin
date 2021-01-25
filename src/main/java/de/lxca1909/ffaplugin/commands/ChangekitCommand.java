package de.lxca1909.ffaplugin.commands;

import de.lxca1909.ffaplugin.util.GetKitItems;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChangekitCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
//            p.sendMessage("Test");
            if(args.length == 0){
                p.sendMessage("§cDas reicht nicht. Richtiger Syntax: /changekit <kit>");
            }else if(args.length > 1){
                switch (args[0]){
                    case "ninja":
                        p.sendMessage("ninja");
                        break;
                    case "stomper":
                        p.sendMessage("Stomper");
                        break;
                    case "avatar":
                        p.sendMessage("Avatar");
                        break;
                    case "holzfaeller":
                        p.sendMessage("Holzfaeller");
                        break;
                    case "kangaroo":
                        p.sendMessage("Kangaroo");
                        break;
                    case "claw":
                        p.sendMessage("Claw");
                        break;
                    case "revive":
                        p.sendMessage("Revive");
                        break;
                    case "telekinese":
                        p.sendMessage("Telekinese");
                        break;
                    default:
                        p.sendMessage("Das ist kein richtiges Kit oder du hast es falsch geschrieben");
                }

            }
        }
        return true;
    }
}
