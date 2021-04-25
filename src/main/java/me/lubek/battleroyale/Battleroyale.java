package me.lubek.battleroyale;

import me.lubek.battleroyale.commands.brcommands;
import me.lubek.battleroyale.events.brevents;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Battleroyale extends JavaPlugin {
    FileConfiguration config = getConfig();
    @Override
    public void onEnable() {
        // Plugin startup logic

        getCommand("holo").setExecutor(new brcommands());
        getCommand("clearall").setExecutor(new brcommands());
        getServer().getPluginManager().registerEvents(new brevents(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
