package pl.filipesz.pvplevelup.systems;

import org.bukkit.scheduler.BukkitRunnable;
import pl.filipesz.pvplevelup.Main;
import pl.filipesz.pvplevelup.utils.UtilManager;

public class RefreshAPISystem {

    public static void start() {
        new BukkitRunnable() {
            @Override
            public void run() {
                UtilManager.updateScoreboard();
            }
        }.runTaskTimer(Main.getInstance(), 20L, 20L);
    }
}

