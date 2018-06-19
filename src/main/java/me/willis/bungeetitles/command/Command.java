package me.willis.bungeetitles.command;

import com.google.common.base.Joiner;
import me.willis.bungeetitles.BungeeTitles;
import me.willis.bungeetitles.util.Util;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Command extends net.md_5.bungee.api.plugin.Command {

    private BungeeTitles plugin;

    private Util util;

    public Command(BungeeTitles plugin) {
        super("BungeeTitle", "BungeeTitle.access", "bt");
        this.plugin = plugin;
        this.util = new Util(plugin);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (args.length > 0) {

            String m = Joiner.on(" ").join(args);

            for (ProxiedPlayer proxiedPlayer : ProxyServer.getInstance().getPlayers()) {
                util.sendTitle(proxiedPlayer, m);
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Please specify a message!");
        }
    }
}