package eu.jxstcolin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChatCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        Player player = (Player) commandSender;

        if (!player.hasPermission("lesparky.commands.clearchat")){
            player.sendMessage("§cDazu bist du nicht berechtigt.");
            return false;
        }

        if (args.length == 0) {

            for (Player players : Bukkit.getOnlinePlayers()) {
                if (players.hasPermission("lesparky.commands.clearchat.bypass")) {
                    players.sendMessage("§7Der Chat wurde von §9" + player.getName() + " §7geleert.");
                    return false;
                } else {
                    for (int x = 0; x < 150; x++) {
                        players.sendMessage("");
                    }

                    players.sendMessage("§7Der Chat wurde von §9" + player.getName() + " §7geleert.");
                    return false;
                }
            }
        } else {
            player.sendMessage("§cSyntax: §9/clearchat");
        }

        return false;
    }
}
