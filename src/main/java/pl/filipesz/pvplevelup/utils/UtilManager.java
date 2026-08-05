package pl.filipesz.pvplevelup.utils;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;
import pl.filipesz.pvplevelup.Main;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("ALL")
public class UtilManager {

    //ChatUtil
    public static String fixColor(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    public static void sendMessage(CommandSender commandSender, String string) {
        commandSender.sendMessage(fixColor(string));
    }

    private static void sendPacket(Player p, Packet packet) {
        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
    }

    public static void sendActionbar(Player p, String msg) {
        IChatBaseComponent cmp = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + ChatColor.translateAlternateColorCodes('&', msg) + "\"}");
        PacketPlayOutChat bar = new PacketPlayOutChat(cmp, (byte) 2);
        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(bar);
    }

    public static void sendTitle(Player p, String title) {
        IChatBaseComponent iChatBaseComponent = IChatBaseComponent.ChatSerializer.a(fixColor("{\"text\": \"" + title + "\"}"));
        PacketPlayOutTitle packetPlayOutTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, iChatBaseComponent);
        PacketPlayOutTitle length = new PacketPlayOutTitle(40, 60, 40);
        sendPacket(p, packetPlayOutTitle);
        sendPacket(p, length);
    }

    public static void sendSubTitle(Player p, String subtitle) {
        IChatBaseComponent iChatBaseComponent = IChatBaseComponent.ChatSerializer.a(fixColor("{\"text\": \"" + subtitle + "\"}"));
        PacketPlayOutTitle packetPlayOutTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, iChatBaseComponent);
        PacketPlayOutTitle length = new PacketPlayOutTitle(40, 60, 40);
        sendPacket(p, packetPlayOutTitle);
        sendPacket(p, length);
    }

    // ScoreboardUtil
    private static final DecimalFormat dfBorder = new DecimalFormat("0");

    public static void createScoreboard(Player p) {
        ScoreboardManager m = Bukkit.getScoreboardManager();
        Scoreboard b = m.getNewScoreboard();
        Objective o = b.registerNewObjective("Stats", "dummy");
        o.setDisplayName(UtilManager.fixColor("&3&lPVPLEVELUP"));
        o.setDisplaySlot(DisplaySlot.SIDEBAR);

        World world = Bukkit.getWorld("world");

        UUID uuid = p.getUniqueId();
        int players = Bukkit.getOnlinePlayers().size();
        int ping = ((CraftPlayer) p).getHandle().ping;

        Score s = o.getScore(UtilManager.fixColor(""));
        s.setScore(10);

        Score s2 = o.getScore(UtilManager.fixColor("&7Gracze online:"));
        s2.setScore(9);

        Score s3 = o.getScore(UtilManager.fixColor("&8» &3" + players + "&7/&350"));
        s3.setScore(8);

        Score s4 = o.getScore(UtilManager.fixColor(" "));
        s4.setScore(7);

        if (p.getLevel() > 0) {
            Score s5 = o.getScore(UtilManager.fixColor("&8» &7Level: &3" + p.getLevel()));
            s5.setScore(6);
        }
        if (p.getLevel() == 0) {
            Score s5 = o.getScore(UtilManager.fixColor("&8» &7Level: &31"));
            s5.setScore(6);
        }
        if (p.getLevel() == 10) {
            Score s5 = o.getScore(UtilManager.fixColor("&8» &7Level: &310 &7(&3MAKSYMALNY LEVEL!&7)"));
            s5.setScore(6);
        }

        Map<String, Integer> level = new HashMap<String, Integer>();

        for (OfflinePlayer op : Bukkit.getOfflinePlayers()) {
            level.put(p.getName(), p.getLevel());
        }

        Score s6 = o.getScore(UtilManager.fixColor("  "));
        s6.setScore(5);

        Score s7 = o.getScore(UtilManager.fixColor("&3&lTOP 3 LEVEL"));
        s7.setScore(4);

        AtomicInteger counter = new AtomicInteger();

        level.entrySet()
                .stream()
                .sorted()
                .limit(3)
                .forEach(e -> {
                    String num = counter.incrementAndGet() + ". ";
                    Score s8 = o.getScore(UtilManager.fixColor("&8» &7" + num + e.getKey() + "&3 " + e.getValue()));
                    s8.setScore(3);
                });

        Score s9 = o.getScore(UtilManager.fixColor("   "));
        s9.setScore(2);

        Score s10 = o.getScore(UtilManager.fixColor("&7Faza testowa &3&lFILIPESZ-CORE"));
        s10.setScore(1);

        p.setScoreboard(b);
    }

    public static void updateScoreboard() {
        for (Player everyone : Bukkit.getOnlinePlayers()) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    createScoreboard(everyone);
                }
            }.runTaskTimer(Main.getInstance(), 40L, 40L);
        }
    }
}
