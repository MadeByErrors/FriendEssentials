package eu.jxstcolin.main;

import eu.jxstcolin.commands.*;
import eu.jxstcolin.listener.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;
    private static String prefix;

    @Override
    public void onEnable() {
        instance = this;
        prefix = "§8[§9Server§8] §7";

        register();

        System.out.println("Das Plugin wurde aktiviert.");
    }

    public void register(){
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("gamemode").setExecutor(new GameModeCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("teleport").setExecutor(new TeleportCommand());
        getCommand("teleporthere").setExecutor(new TeleportHereCommand());
        getCommand("hat").setExecutor(new HatCommand());
        getCommand("suicide").setExecutor(new SuicideCommand());
        getCommand("invsee").setExecutor(new InvseeCommand());
        getCommand("workbench").setExecutor(new WorkbenchCommand());
        getCommand("repair").setExecutor(new RepairCommand());
        getCommand("skull").setExecutor(new SkullCommand());
        getCommand("getposition").setExecutor(new GetPosCommand());
        getCommand("day").setExecutor(new DayCommand());
        getCommand("night").setExecutor(new NightCommand());
        getCommand("clearchat").setExecutor(new ClearChatCommand());

        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
    }

    @Override
    public void onDisable() {
        System.out.println("Das Plugin wurde deaktiviert.");
    }

    public static Main getInstance() {
        return instance;
    }

    public String getPrefix() {
        return prefix;
    }
}
