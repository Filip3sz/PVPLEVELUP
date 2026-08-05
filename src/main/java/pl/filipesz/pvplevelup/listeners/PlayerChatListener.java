package pl.filipesz.pvplevelup.listeners;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.UUID;

@SuppressWarnings("ALL")
public class PlayerChatListener implements Listener {

    @EventHandler
    public void onChat(PlayerChatEvent e) {
        Player p = e.getPlayer();

        UUID uuid = p.getUniqueId();

        e.setFormat("§7Gracz %s §8» §7%s"); // GRACZ PREFIX

        if (p.isOp()) { // OP PREFIX
            e.setFormat("§8[§6✫§8] §4§lOP §4%s §8» §4%s");
        }

        if (p.getGameMode() == GameMode.SPECTATOR) {

            e.setFormat("§fSPECTATOR §7Gracz %s §8» §7%s"); // GRACZ PREFIX

            if (p.isOp()) { // OP PREFIX
                e.setFormat("§8[§6✫§8] §fSPECTATOR §4§lOP §4%s §8» §4%s");
            }
        }
    }
}

