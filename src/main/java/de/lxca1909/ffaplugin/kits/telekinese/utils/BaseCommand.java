package de.lxca1909.ffaplugin.kits.telekinese.utils;

import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class BaseCommand {
    private CommandSender commandSender;

    private String[] args;

    public BaseCommand(CommandSender commandSender, String[] args) {
        this.commandSender = commandSender;
        this.args = args;
    }

    public void execute() {
        String spawnPermission = Permissions.forCreate();
        if (!Permissions.hasPermission(this.commandSender, spawnPermission)) {
            this.commandSender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
            return;
        }
        if (this.args.length == 0) {
            if (this.commandSender instanceof Player) {
                Player player = (Player)this.commandSender;
                tryGivingItem((CommandSender)player, player);
            } else {
                this.commandSender.sendMessage(ChatColor.RED + "Please run this command as a player, or type '/almightyhand <player name>' to give this to another player.");
            }
        } else {
            Player receivingPlayer = Bukkit.getPlayer(this.args[0]);
            if (receivingPlayer == null)
                return;
            tryGivingItem(this.commandSender, receivingPlayer);
        }
    }

    private static void tryGivingItem(CommandSender giver, Player receiver) {
        ItemStack item = ItemDb.getItem();
        HashMap<Integer, ItemStack> result = receiver.getInventory().addItem(new ItemStack[] { item });
        if (result.size() == 0) {
            if (giver != null)
                giver.sendMessage(ChatColor.GREEN + "Success!");
            receiver.sendMessage(ChatColor.GRAY + "Received an almighty hand item");
        } else {
            giver.sendMessage(ChatColor.RED + "The player's inventory doesn't have enough space.");
        }
    }
}