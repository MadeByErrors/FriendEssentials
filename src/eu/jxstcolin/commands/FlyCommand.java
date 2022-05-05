package eu.jxstcolin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;

        if (!player.hasPermission("lesparky.commands.fly")) {
            player.sendMessage("§cDazu bist du nicht berechtigt.");
            return true;
        }

        if (args.length == 0) {
            if (player.isFlying()) {
                player.setFlying(false);
                player.setAllowFlight(false);
                player.sendMessage("§cDu kannst nun nicht mehr fliegen.");
            } else {
                player.setAllowFlight(true);
                player.setFlying(true);
                player.sendMessage("§aDu kannst nun fliegen.");
            }
        } else if (args.length == 1){

            Player target = (Player) Bukkit.getPlayer(args[0]);

            if (target.isFlying()) {
                target.setFlying(false);
                target.setAllowFlight(false);
                player.sendMessage("§cDer Spieler §9" + target.getName() + " §ckann nun nicht mehr fliegen.");
                target.sendMessage("§cDu kannst nun nicht mehr fliegen.");
            } else {
                target.setAllowFlight(true);
                target.setFlying(true);
                player.sendMessage("§aDer Spieler §9" + target.getName() + " §akann nun fliegen.");
                target.sendMessage("§aDu kannst nun fliegen.");
            }
        }
        return false;
    }
}