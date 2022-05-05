package eu.jxstcolin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SuicideCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;

        if (!player.hasPermission("lesparky.commands.player.hat")) {
            player.sendMessage("§cDazu bist du nicht berechtigt.");
            return true;
        }

        player.setHealth(0);
        player.sendMessage("§cDu bist Selbstmord begangen!");

        return false;
    }
}
