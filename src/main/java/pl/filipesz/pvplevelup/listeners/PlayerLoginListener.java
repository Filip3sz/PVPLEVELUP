package pl.filipesz.pvplevelup.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerLoginListener implements Listener {

    @EventHandler
    public void onLogin(PlayerLoginEvent e) {
        Player p = e.getPlayer();

        if (e.getResult() == PlayerLoginEvent.Result.KICK_BANNED) {
            e.setKickMessage("§cZostales zbanowany.");
        }
        if (e.getResult() == PlayerLoginEvent.Result.KICK_WHITELIST) {
            e.setKickMessage("§cSerwer jest zajety!");
        }
        if (e.getResult() == PlayerLoginEvent.Result.KICK_FULL) {
            e.setKickMessage("§cSerwer jest pelny!");
        }
    }
}
