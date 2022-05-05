package eu.jxstcolin.commands;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NightCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        Player player = (Player) commandSender;

        if (!player.hasPermission("lesparky.commands.time.night")) {
            player.sendMessage("§cDazu bist du nicht berechtigt.");
            return true;
        }

        if (args.length == 0) {

            World playerWorld = player.getWorld();

            playerWorld.setFullTime(13000);

            player.sendMessage("§7Die Tageszeit wurde auf §913000 §aaktuallisiert.");

        } else {
            player.sendMessage("§cSyntax: §9/night");
        }

        return false;
    }
}
