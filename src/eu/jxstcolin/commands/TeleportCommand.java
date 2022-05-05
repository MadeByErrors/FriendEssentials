package eu.jxstcolin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;

        if (!player.hasPermission("lesparky.commands.teleport")) {
            player.sendMessage("§cDazu bist du nicht berechtigt.");
            return true;
        }

        if (args.length == 1){
            Player target = (Player) Bukkit.getPlayer(args[0]);

            player.teleport(target);
            player.sendMessage("§aDu wurdest zu §9" + target.getName() + " §ateleportiert.");
        } else if (args.length >= 2){
            Player target01 = (Player) Bukkit.getPlayer(args[0]);
            Player target02 = (Player) Bukkit.getPlayer(args[1]);

            target01.teleport(target02);
            target01.sendMessage("§aDu wurdest zu §9" + target02.getName() + " §ateleportiert.");
            player.sendMessage("§aDer Spieler §9" + target01.getName() + " §awurde zu §9" + target02.getName() + " §ateleportiert.");
        } if (args.length == 0){
            player.sendMessage("§cSyntax: §9/tp <Spieler> [Spieler]");
        }
        return false;
    }
}
