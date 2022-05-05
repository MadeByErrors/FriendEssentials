package eu.jxstcolin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportHereCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;

        if (!player.hasPermission("lesparky.commands.teleporthere")) {
            player.sendMessage("§cDazu bist du nicht berechtigt.");
            return true;
        }

        if (args.length == 1){
            Player target = (Player) Bukkit.getPlayer(args[0]);

            target.teleport(player);
            player.sendMessage("§aDer Spieler §9" + target.getName() + " §awurde zu dir teleportiert.");
            target.sendMessage("§aDu wurdest zu §9" + player.getName() + " §ateleportiert.");
        } else {
            player.sendMessage("§cSyntax: §9/tphere <Spieler>");
        }
        return false;
    }
}
