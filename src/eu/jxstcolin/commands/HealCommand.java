package eu.jxstcolin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;

        if (!player.hasPermission("lesparky.commands.heal")) {
            player.sendMessage("§cDazu bist du nicht berechtigt.");
            return true;
        }

        if (args.length == 0) {
            player.setHealth(20);
            player.setFoodLevel(20);
            player.sendMessage("§aDu wurdest geheilt.");
        } else if (args.length == 1){
            Player target = (Player) Bukkit.getPlayer(args[0]);

            target.setHealth(20);
            target.setFoodLevel(20);
            target.sendMessage("§aDu wurdest geheilt.");
            player.sendMessage("§aDer Spieler §9" + target.getName() + " §awurde geheilt.");
        }

        return false;
    }
}
