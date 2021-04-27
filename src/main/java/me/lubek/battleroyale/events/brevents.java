package me.lubek.battleroyale.events;
import me.lubek.battleroyale.Battleroyale;
import me.lubek.battleroyale.libs.Manager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;
import me.lubek.battleroyale.commands.brcommands;
import org.bukkit.scheduler.BukkitRunnable;

public class brevents implements Listener {
    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent e) {
        e.getPlayer().sendActionBar("Witaj na serwerze "+ ChatColor.RED +"LUBEK.NET!");
    }
    @EventHandler
    public static void onPlayerWalk(PlayerMoveEvent e) {
        Plugin plugin = Bukkit.getPluginManager().getPlugin("Battleroyale");
        Player p = e.getPlayer();
        int x = p.getLocation().getBlockX();
        int y = p.getLocation().getBlockY();
        int z = p.getLocation().getBlockZ();
        if(p.getWorld().getName().equals("world")) {
            Material block = p.getWorld().getBlockAt(x,y-1,z).getType();
            if (block.equals(Material.DIAMOND_BLOCK)) {
                Manager.GiveRandomItem(p,20);
                Manager.CooldownHolo(Manager.holo1, Manager.bool1, "Ready!");

            }
        }

    }
 }
