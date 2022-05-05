package eu.jxstcolin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WorkbenchCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;

        if (!player.hasPermission("lesparky.commands.workbench")) {
            player.sendMessage("§cDazu bist du nicht berechtigt.");
            return true;
        }

        player.openWorkbench(player.getLocation(), false);
        player.sendMessage("§aDie Werkbank wurde geöffnet.");

        return false;
    }
}
