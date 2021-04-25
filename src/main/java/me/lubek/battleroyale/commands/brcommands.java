package me.lubek.battleroyale.commands;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import me.lubek.battleroyale.Battleroyale;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class brcommands implements CommandExecutor {
    /**
     * Executes the given command, returning its success.
     * <br>
     * If false is returned, then the "usage" plugin.yml entry for this command
     * (if defined) will be sent to the player.
     *
     * @param sender  Source of the command
     * @param command Command which was executed
     * @param label   Alias of the command which was used
     * @param args    Passed command arguments
     * @return true if a valid command, otherwise false
     */
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player))
        {
            sender.sendMessage("You must be a player to execute that command!");
            return true;
        }
        Player player = (Player) sender;
        if(command.getName().equalsIgnoreCase("holo")) {
            Plugin plugin = Battleroyale.getProvidingPlugin(this.getClass());
            Hologram hologram = HologramsAPI.createHologram(plugin,player.getLocation());
            hologram.appendTextLine("Test");
            Collection<Hologram> holograms = HologramsAPI.getHolograms(plugin);
            player.sendMessage(hologram.getLocation().toString());
            return true;
        }
        if(command.getName().equalsIgnoreCase("clearall")) {
            Plugin plugin = Battleroyale.getProvidingPlugin(this.getClass());
            for (Hologram hologram2 : HologramsAPI.getHolograms(plugin)) {
                hologram2.delete();
            }
        }
        if(command.getName().equalsIgnoreCase("dem")) {
        }
        return false;
    }
}
