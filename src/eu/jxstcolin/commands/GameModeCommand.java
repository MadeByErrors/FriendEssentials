package eu.jxstcolin.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameModeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;

        if (!sender.hasPermission("lesparky.commands.gamemode")) {
            sender.sendMessage("§cDazu bist du nicht berechtigt.");
            return true;
        }

        if (args.length == 1) {
            if (sender.equals(Bukkit.getConsoleSender())) {
                sender.sendMessage("Das können nur Spieler!");
                return true;
            }

            switch (args[0]) {
                case "0":
                    player.sendMessage("§7Du wurdest in den Spielmodus §9SURVIVAL §7gesetzt.");
                    player.setGameMode(GameMode.SURVIVAL);
                    break;
                case "1":
                    player.sendMessage("§7Du wurdest in den Spielmodus §9CREATIVE §7gesetzt.");
                    player.setGameMode(GameMode.CREATIVE);
                    break;
                case "2":
                    player.sendMessage("§7Du wurdest in den Spielmodus §9ADVENTURE §7gesetzt.");
                    player.setGameMode(GameMode.ADVENTURE);
                    break;
                case "3":
                    player.sendMessage("§7Du wurdest in den Spielmodus §9SPECTATOR §7gesetzt.");
                    player.setGameMode(GameMode.SPECTATOR);
                    break;
                default:
                    break;
            }
        } else if (args.length == 2) {
            Player target = Bukkit.getPlayer(args[1]);

            switch (args[0]) {
                case "0":
                    player.sendMessage("§7Der Spieler §9" + target.getName() + " §7wurde in den Spielmodus §9SURVIVAL §7gesetzt.");
                    target.sendMessage("§7Du wurdest von §9" + player.getName() + " §7in den Spielmodus §9SURVIVAL §7gesetzt.");
                    target.setGameMode(GameMode.SURVIVAL);
                    break;
                case "1":
                    player.sendMessage("§7Der Spieler §9" + target.getName() + " §7wurde in den Spielmodus §9CREATIVE §7gesetzt.");
                    target.sendMessage("§7Du wurdest von §9" + player.getName() + " §7in den Spielmodus §9CREATIVE §7gesetzt.");
                    target.setGameMode(GameMode.CREATIVE);
                    break;
                case "2":
                    player.sendMessage("§7Der Spieler §9" + target.getName() + " §7wurde in den Spielmodus §9ADVENTURE §7gesetzt.");
                    target.sendMessage("§7Du wurdest von §9" + player.getName() + " §7in den Spielmodus §9ADVENTURE §7gesetzt.");
                    target.setGameMode(GameMode.ADVENTURE);
                    break;
                case "3":
                    player.sendMessage("§7Der Spieler §9" + target.getName() + " §7wurde in den Spielmodus §9SPECTATOR §7gesetzt.");
                    target.sendMessage("§7Du wurdest von §9" + player.getName() + " §7in den Spielmodus §9SPECTATOR §7gesetzt.");
                    target.setGameMode(GameMode.SPECTATOR);
                    break;
                default:
                    break;
            }
        } else {
            sender.sendMessage("§cSyntax: §9/gamemode <Spielmodus> [Spieler]");
        }
        return false;
    }
}
