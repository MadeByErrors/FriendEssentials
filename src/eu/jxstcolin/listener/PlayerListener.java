package eu.jxstcolin.listener;

import eu.jxstcolin.main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        // event.setJoinMessage(Main.getInstance().getPrefix() + "§7Der Spieler §9" + event.getPlayer().getName() + " §7hat den Server §abetreten§8.");
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        // event.setQuitMessage(Main.getInstance().getPrefix() + "§7Der Spieler §9" + event.getPlayer().getName() + " §7hat den Server §cverlassen§8.");
    }

    @EventHandler
    public void onWeather(WeatherChangeEvent event){
        event.setCancelled(true);
    }
}
