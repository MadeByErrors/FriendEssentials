package eu.jxstcolin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetPosCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;

        if (!player.hasPermission("lesparky.commands.getpos")) {
            player.sendMessage("§cDazu bist du nicht berechtigt.");
            return true;
        }

        if (args.length == 1){
            Player target = (Player) Bukkit.getPlayer(args[0]);

            if (!target.hasPermission("lesparky.commands.getpos.admin")) {

                player.sendMessage("§aDie Position von §9" + target.getName() + " §aist§8:");
                player.sendMessage("§8» §9X: " + target.getLocation().getX());
                player.sendMessage("§8» §9Y: " + target.getLocation().getY());
                player.sendMessage("§8» §9Z: " + target.getLocation().getZ());
            } else {
                player.sendMessage("§cDu kannst die Position von §9" + target.getName() + " §cnicht einsehen, da dieser Spieler Admin ist.");
            }
        } else {
            player.sendMessage("§aDeine Position: §9");
            player.sendMessage("§8» §9X: " + player.getLocation().getX());
            player.sendMessage("§8» §9Y: " + player.getLocation().getY());
            player.sendMessage("§8» §9Z: " + player.getLocation().getZ());
        }

        return false;
    }
}
