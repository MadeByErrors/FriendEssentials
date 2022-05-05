package eu.jxstcolin.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class HatCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;

        if (!player.hasPermission("lesparky.commands.player.hat")) {
            player.sendMessage("§cDazu bist du nicht berechtigt.");
            return true;
        }

        if (player.getInventory().getItemInHand().getType() == Material.AIR){
            player.sendMessage("§cDu kannst keine Luft, zu deinem Kopf machen.");
        } else {
            if (player.getInventory().getItemInHand().getType().isBlock()) {
                player.getInventory().setHelmet(player.getItemInHand());
                player.sendMessage("§aDu hast nun einen neuen Helm!");
                player.getInventory().setItemInHand(new ItemStack(Material.AIR));
            } else {
                player.sendMessage("§cDu kannst kein Gegenstand zu deinem Hut machen.");
            }
        }

        return false;
    }
}
