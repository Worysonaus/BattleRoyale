package me.lubek.battleroyale.libs;
import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import dev.lone.itemsadder.api.ItemsAdder;
import jdk.nashorn.internal.runtime.NumberToString;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
public class Manager {
    public static boolean bool1 = false;
    public static boolean bool2 = false;
    public static boolean bool3 = false;
    public static boolean bool4 = false;
    public static boolean bool5 = false;
    public static Location holo4loc = new Location(Bukkit.getWorld("world"),101,100,100);
    public static Location holo3loc = new Location(Bukkit.getWorld("world"),102,100,100);
    public static Location holo2loc = new Location(Bukkit.getWorld("world"),103,100,100);
    public static Location holo1loc = new Location(Bukkit.getWorld("world"),104,100,100);
    public static Hologram holo1 = HologramsAPI.createHologram(Bukkit.getPluginManager().getPlugin("Battleroyale"), holo1loc);
    public static Hologram holo2 = HologramsAPI.createHologram(Bukkit.getPluginManager().getPlugin("Battleroyale"), holo2loc);
    public static Hologram holo3 = HologramsAPI.createHologram(Bukkit.getPluginManager().getPlugin("Battleroyale"), holo3loc);
    public static Hologram holo4 = HologramsAPI.createHologram(Bukkit.getPluginManager().getPlugin("Battleroyale"), holo4loc);
    public int players;
    public boolean GameStarted;
    public static void GiveRandomItem(Player player, int Times){
            Random rand = new Random();
            int ID = rand.nextInt(Times);
            ID += 1;
            player.sendMessage("sending");
            if(ID > 10){
                player.sendMessage("sended");
                PlayerInventory pi = player.getInventory();
                ItemStack KnockbackStick = ItemsAdder.getCustomItem("obsidian_head");
                ItemMeta KnockbackStickMeta = KnockbackStick.getItemMeta();
                KnockbackStickMeta.addEnchant(Enchantment.KNOCKBACK, 3 , true);
                KnockbackStick.setItemMeta(KnockbackStickMeta);
                pi.addItem(KnockbackStick);

                ItemStack KnockbackStick2 = ItemsAdder.getCustomItem("emerald_chest");
                ItemMeta KnockbackStickMeta2 = KnockbackStick2.getItemMeta();
                KnockbackStick2.setItemMeta(KnockbackStickMeta2);
                pi.addItem(KnockbackStick2);

                ItemStack KnockbackStick21 = ItemsAdder.getCustomItem("ruby_head");
                ItemMeta KnockbackStickMeta21 = KnockbackStick21.getItemMeta();
                KnockbackStickMeta21.addEnchant(Enchantment.KNOCKBACK, 7 , true);
                KnockbackStick21.setItemMeta(KnockbackStickMeta21);
                pi.addItem(KnockbackStick21);
            }
            else {
                player.sendMessage("send problem");
            }

    }
    public static int GetCooldown() {
        int siema = 5*20;
        return siema;
    }
    public static int GetCustomCooldown(int seconds) {
        int returnv = seconds*20;
        return returnv;
    }
    public static void ResetHolos() {
        for (Hologram hologram2 : HologramsAPI.getHolograms(Bukkit.getPluginManager().getPlugin("Battleroyale"))) {
            hologram2.delete();
        }
    }
    public static void CooldownHolo(Hologram hologram, Boolean boolsel, String after) {
        // boolean cooldown = false;
        //if(!cooldown) {
            hologram.clearLines();
            //final cooldown=true;
            boolsel=true;
            new BukkitRunnable(){
                @Override
                public void run() {
                    hologram.clearLines();
                    hologram.insertTextLine(0,"4");
                }
            }.runTaskLater(Bukkit.getPluginManager().getPlugin("Battleroyale"), 1*20);
            new BukkitRunnable(){
                @Override
                public void run() {
                    hologram.clearLines();
                    hologram.insertTextLine(0,"3");
                    //cooldown=true;
                }
            }.runTaskLater(Bukkit.getPluginManager().getPlugin("Battleroyale"), 2*20);
            new BukkitRunnable(){
                @Override
                public void run() {
                    hologram.clearLines();
                    hologram.insertTextLine(0,"2");
                    //cooldown=true;
                }
            }.runTaskLater(Bukkit.getPluginManager().getPlugin("Battleroyale"), 3*20);
            new BukkitRunnable(){
                @Override
                public void run() {
                    hologram.clearLines();
                    hologram.insertTextLine(0,"1");
                    //cooldown=true;
                }
            }.runTaskLater(Bukkit.getPluginManager().getPlugin("Battleroyale"), 4*20);
            new BukkitRunnable(){
                @Override
                public void run() {
                    hologram.clearLines();
                    hologram.insertTextLine(0,after);
                    //cooldown=false;


                }
            }.runTaskLater(Bukkit.getPluginManager().getPlugin("Battleroyale"), 5*20);
            boolsel=false;
            hologram.clearLines();
            hologram.insertTextLine(0,after);
            //cooldown=false;


    }
}
