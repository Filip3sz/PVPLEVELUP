package pl.filipesz.pvplevelup.listeners;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import pl.filipesz.pvplevelup.manager.LevelManager;

import java.util.concurrent.ThreadLocalRandom;

public class PlayerRespawnListener implements Listener {

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
        Player p = e.getPlayer();

        int x = ThreadLocalRandom.current().nextInt(0, 50);
        int z = ThreadLocalRandom.current().nextInt(0, 50);
        World worldLoc = p.getWorld();
        Location randomLocation = new Location(p.getWorld(), x, worldLoc.getHighestBlockYAt(x, z), z);
        e.setRespawnLocation(randomLocation);

        LevelManager.levelStartAfterDeath(p);
    }
}
