package de.lxca1909.ffaplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ChangekitTabComplet implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> tab = new ArrayList<>();
        tab.add("ninja");
        tab.add("stomper");
        tab.add("avatar");
        tab.add("holzfaeller");
        tab.add("kangaroo");
        tab.add("claw");
        tab.add("revive");
        tab.add("telekinese");

        return tab;
    }
}
