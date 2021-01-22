package de.lxca1909.ffaplugin.kits.telekinese.utils;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;

public class Permissions {
    private static final String BASE_NODE = "almightyhand";

    private static final String ENTITY_NODE = "almightyhand.entity";

    public static String forReload() {
        return "almightyhand.reload";
    }

    public static String forWGBypass() {
        return "almightyhand.wgbypass";
    }

    public static String forAdmin() {
        return "almightyhand.admin";
    }

    public static String forCreate() {
        return "almightyhand.create";
    }

    public static String forAlmightyHandUse() {
        return "almightyhand.use";
    }

    public static String forEntityType(EntityType entityType) {
        return "almightyhand.entity." + entityType.name();
    }

    public static String forAllEntityTypes() {
        return "almightyhand.entity.ALL";
    }

    public static boolean hasPermission(CommandSender commandSender, String permission) {
        return (commandSender instanceof org.bukkit.command.ConsoleCommandSender || commandSender
                .hasPermission(permission) || commandSender
                .hasPermission(forAdmin()));
    }
}
