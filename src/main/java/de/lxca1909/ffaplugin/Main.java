package de.lxca1909.ffaplugin;

import de.lxca1909.ffaplugin.commands.*;
import de.lxca1909.ffaplugin.kits.*;
import de.lxca1909.ffaplugin.kits.telekinese.Telekinese;
import de.lxca1909.ffaplugin.kits.telekinese.utils.UseListener;
import de.lxca1909.ffaplugin.listeners.*;
import de.lxca1909.ffaplugin.recipe.RecipeLoader;
import de.lxca1909.ffaplugin.util.PlayerCompass;
import de.slikey.effectlib.EffectManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main main;
    public EffectManager effectManager;

    @Override
    public void onEnable() {
        main = this;
        Bukkit.getConsoleSender().sendMessage("§aPlugin fährt hoch...");
        cmdregi();
        listregi();
        new RecipeLoader().registerRecipes();
        effectManager = new EffectManager(this);

    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§aPlugin fährt runter...");
    }
    public void cmdregi(){
        getCommand("kits").setExecutor(new KitsCMD());
        getCommand("build").setExecutor(new Build());
        getCommand("test").setExecutor(new TestCMD());
        getCommand("changekit").setExecutor(new ChangekitCommand());
        getCommand("changekit").setTabCompleter(new ChangekitTabComplet());
    }
    public void listregi(){
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new Join(), this); 
        pluginManager.registerEvents(new Kits(), this); 
        pluginManager.registerEvents(new Soup(), this); 
        pluginManager.registerEvents(new MoreListeners(), this); 
        pluginManager.registerEvents(new PlayerCompass(), this);
        pluginManager.registerEvents(new Chatsystem(), this);

        //Kits

        //Avatar
        pluginManager.registerEvents(new Avatar(), this); // CHeck
        //Stomper
        pluginManager.registerEvents(new Stomper(), this); //Check
        //Ninja
        pluginManager.registerEvents(new Ninja(), this); //CHeck
        //Holzfäller
        pluginManager.registerEvents(new Holzfaeller(), this); 
        //Kangaroo
        pluginManager.registerEvents(new Kangaroo(), this);// FEHLER nicht mehr
        //Claw
        pluginManager.registerEvents(new Claw(), this);
        //Revive
        pluginManager.registerEvents(new Revive(), this);
        //Telekinese
        pluginManager.registerEvents(new UseListener(), this);
        pluginManager.registerEvents(new Telekinese(), this);
    }
    public static Main getMain() {
        return main;
    }
}
