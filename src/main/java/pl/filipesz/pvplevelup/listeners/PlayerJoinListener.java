package pl.filipesz.pvplevelup.listeners;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import pl.filipesz.pvplevelup.manager.LevelManager;

import java.util.concurrent.ThreadLocalRandom;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage("");

        int x = ThreadLocalRandom.current().nextInt(0, 50);
        int z = ThreadLocalRandom.current().nextInt(0, 50);
        World worldLoc = p.getWorld();
        Location randomLocation = new Location(p.getWorld(), x, worldLoc.getHighestBlockYAt(x, z), z);
        p.teleport(randomLocation);

        LevelManager.levelStart(p);

        // TITLE
        PacketPlayOutTitle title = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, IChatBaseComponent.ChatSerializer.a("{\"text\":\"§8* §3Filipesz §8*\"}"), 40, 60, 40);
        PacketPlayOutTitle subtitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, IChatBaseComponent.ChatSerializer.a("{\"text\":\"§7Polaczono z trybem §3PVPLEVELUP§7...\"}"), 40, 60, 40);
        ((CraftPlayer) e.getPlayer()).getHandle().playerConnection.sendPacket(title);
        ((CraftPlayer) e.getPlayer()).getHandle().playerConnection.sendPacket(subtitle);
    }
}
