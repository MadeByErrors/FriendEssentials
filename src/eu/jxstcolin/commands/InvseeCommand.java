package eu.jxstcolin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class InvseeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        Player player = (Player) commandSender;

        if (!player.hasPermission("lesparky.commands.invsee")) {
            player.sendMessage("§cDazu bist du nicht berechtigt.");
            return true;
        }

        if (args.length == 1){
            Player target = (Player) Bukkit.getPlayer(args[0]);

            if (target.hasPermission("lesparky.comamnds.invsee.admin")){
                player.sendMessage("§cDu kannst nicht in das Inventar von §9" + target.getName() + " §cschauen, da es gesichert ist.");
            } else {

                Inventory inventory = (Inventory) target.getInventory();

                player.sendMessage("§aDas Inventar von dem Spieler §9" + target.getName() + " §awurde geöffnet.");
                player.openInventory(inventory);

            }
        } else {
            player.sendMessage("§cSyntax: §9/invsee [Spieler]");
        }

        return false;
    }
}
