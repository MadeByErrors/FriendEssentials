package eu.jxstcolin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.SkullType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class SkullCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;

        if (!player.hasPermission("lesparky.commands.skull")) {
            player.sendMessage("§cDazu bist du nicht berechtigt.");
            return true;
        }

        if (args.length == 1){
            Player target = (Player) Bukkit.getPlayer(args[0]);

            if (target != null) {

                if (!target.getName().equalsIgnoreCase("MadeByErrors") || target.getName().equalsIgnoreCase("JxstColin") || target.getName().equalsIgnoreCase("Tinte007")) {
                    ItemStack skull = new ItemStack(Material.SKULL, 1, (short) SkullType.PLAYER.ordinal());
                    SkullMeta meta = (SkullMeta) skull.getItemMeta();
                    meta.setOwner(target.getName());
                    meta.setDisplayName("§eKopf von §9" + target.getName());
                    skull.setItemMeta(meta);
                    player.getInventory().addItem(skull);

                    player.sendMessage("§aDir wurde der Kopf von §9" + target.getName() + " §agegeben.");
                } else {
                    player.sendMessage("§4Dieser Kopf ist gesperrt!");
                }
            } else {

                OfflinePlayer offlineTarget = (OfflinePlayer) Bukkit.getOfflinePlayer(args[0]);

                if (!offlineTarget.getName().equalsIgnoreCase("MadeByErrors") || offlineTarget.getName().equalsIgnoreCase("JxstColin") || offlineTarget.getName().equalsIgnoreCase("Tinte007")) {

                    ItemStack skull = new ItemStack(Material.SKULL, 1, (short) SkullType.PLAYER.ordinal());
                    SkullMeta meta = (SkullMeta) skull.getItemMeta();
                    meta.setOwner(offlineTarget.getName());
                    meta.setDisplayName("§eKopf von §9" + offlineTarget.getName());
                    skull.setItemMeta(meta);
                    player.getInventory().addItem(skull);

                    player.sendMessage("§aDir wurde der Kopf von §9" + offlineTarget.getName() + " §agegeben.");
                } else {
                    player.sendMessage("§4Dieser Kopf ist gesperrt!");
                }
            }
        } else {

            ItemStack skull = new ItemStack(Material.SKULL, 1, (short) SkullType.PLAYER.ordinal());
            SkullMeta meta = (SkullMeta) skull.getItemMeta();
            meta.setOwner(player.getName());
            meta.setDisplayName("§eKopf von §9" + player.getName());
            skull.setItemMeta(meta);
            player.getInventory().addItem(skull);

            player.sendMessage("§aDir wurde dein eigener Kopf gegeben.");
        }

        return false;
    }
}
