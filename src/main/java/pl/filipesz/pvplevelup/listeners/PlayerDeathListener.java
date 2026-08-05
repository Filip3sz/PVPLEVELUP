package pl.filipesz.pvplevelup.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import pl.filipesz.pvplevelup.manager.LevelManager;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onKill(PlayerDeathEvent e) {
        Player p = e.getEntity();
        Player t = e.getEntity().getKiller();

        e.setDeathMessage("");

        p.getWorld().strikeLightningEffect(p.getLocation());
        e.getDrops().clear();
        e.setDroppedExp(0);

        if (t != null) {
            LevelManager.levelUp(t);

            p.getWorld().strikeLightningEffect(p.getLocation());
            e.getDrops().clear();
            e.setDroppedExp(0);
        }
    }
}

