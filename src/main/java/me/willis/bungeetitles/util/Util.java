package me.willis.bungeetitles.util;

import me.willis.bungeetitles.BungeeTitles;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Util {

    private BungeeTitles plugin;

    public Util(BungeeTitles plugin) {
        this.plugin = plugin;
    }

    private String color(String i) {
        return ChatColor.translateAlternateColorCodes('&', i);
    }

    public void sendTitle(ProxiedPlayer proxiedPlayer, String subTitle) {

        String title = plugin.getConfig().getConfiguration().getString("Title");

        ProxyServer.getInstance().createTitle()
                .title(new ComponentBuilder(color(title)).create())
                .subTitle(new ComponentBuilder(color(subTitle)).create())
                .fadeIn(20)
                .stay(100)
                .fadeOut(20)
                .send(proxiedPlayer);
    }
}
