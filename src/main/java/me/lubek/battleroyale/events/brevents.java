package me.lubek.battleroyale.events;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class brevents implements Listener {
    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent e) {
        e.getPlayer().sendActionBar("test");
    }
}
