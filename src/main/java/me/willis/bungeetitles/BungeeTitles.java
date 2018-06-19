package me.willis.bungeetitles;

import me.willis.bungeetitles.command.Command;
import me.willis.bungeetitles.configuration.Config;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public class BungeeTitles extends Plugin {

    private Config config;

    @Override
    public void onEnable() {

        //Configuration
        config = new Config(this);
        config.createConfiguration();

        //Command
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new Command(this));

    }

    public Config getConfig() {
        return config;
    }
}
