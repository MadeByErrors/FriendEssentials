package eu.jxstcolin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RepairCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;

        if (!player.hasPermission("lesparky.commands.repair")) {
            player.sendMessage("§cDazu bist du nicht berechtigt.");
            return true;
        }

        if (player.getItemInHand().getDurability() == 0) {
            player.sendMessage("§cDieses Item kann nicht repariert werden.");
            return true;
        } else {
            player.getItemInHand().setDurability((short) 0);
            player.sendMessage("§aDas Werkzeug was du in deiner Hand hälst, wurde Repairiert.");
        }

        return false;
    }
}
