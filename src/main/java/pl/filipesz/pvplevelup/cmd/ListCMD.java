package pl.filipesz.pvplevelup.cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import pl.filipesz.pvplevelup.utils.UtilManager;

public class ListCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        int players = Bukkit.getOnlinePlayers().size();

        if (sender instanceof ConsoleCommandSender) {
            ConsoleCommandSender p = (ConsoleCommandSender) sender;
            UtilManager.sendMessage(p, "&8[&e&l!&8] &8» &7Gracze online: &3" + players + "&7/&350");
            return true;
        }
        Player p = (Player) sender;
        UtilManager.sendMessage(p, "&8[&e&l!&8] &8» &7Gracze online: &3" + players + "&7/&350");
        return true;
    }
}
