package pl.filipesz.pvplevelup;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import pl.filipesz.pvplevelup.cmd.ListCMD;
import pl.filipesz.pvplevelup.listeners.*;
import pl.filipesz.pvplevelup.systems.RefreshAPISystem;

public class Main extends JavaPlugin {

    public static Main instance;

    public static Main getInstance() {
        return Main.instance;
    }

    private void registerEvent(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, this);
    }

    public void onEnable() {

        //getConfig().options().copyDefaults(true);
        //saveConfig();

        Main.instance = this;

        Bukkit.setWhitelist(false);

        // START SYSTEMS
        RefreshAPISystem.start();

        // SET WORLD BORDER
        World world = Bukkit.getWorld("world");
        WorldBorder wb = world.getWorldBorder();
        wb.setCenter(0.0, 0.0);
        wb.setSize(100.0);

        getCommand("list").setExecutor(new ListCMD());
        registerEvent(new BlockFromToListener());
        registerEvent(new CancelListeners());
        registerEvent(new EntityDamageByEntityListener());
        registerEvent(new PlayerChatListener());
        registerEvent(new PlayerDeathListener());
        registerEvent(new PlayerFishListener());
        registerEvent(new PlayerJoinListener());
        registerEvent(new PlayerLoginListener());
        registerEvent(new PlayerQuitListener());
        registerEvent(new PlayerRespawnListener());
    }
}



