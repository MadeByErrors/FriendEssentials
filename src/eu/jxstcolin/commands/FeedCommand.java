package eu.jxstcolin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;

        if (!player.hasPermission("lesparky.commands.feed")) {
            player.sendMessage("§cDazu bist du nicht berechtigt.");
            return true;
        }

        if (args.length == 0) {
            if (player.getFoodLevel() == 20) {
                player.sendMessage("§cDein Hunger ist bereits bei §920§8.");
            } else {
                player.setFoodLevel(20);
                player.sendMessage("§aDu wurdest gefüttert.");
            }
        } else if (args.length == 1){
            Player target = (Player) Bukkit.getPlayer(args[0]);

            if (target.getFoodLevel() == 20) {
                player.sendMessage("§cDer Hunger des Spielers §9" + target.getName() + " §cist bereits bei §920§8.");
            } else {
                target.setFoodLevel(20);
                target.sendMessage("§aDu wurdest gefüttert.");
                player.sendMessage("§aDer Spieler §9" + target.getName() + " §awurde gefüttert.");
            }
        }

        return false;
    }
}