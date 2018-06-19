package me.willis.bungeetitles.configuration;

import me.willis.bungeetitles.BungeeTitles;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {

    private BungeeTitles plugin;

    private File file;
    private Configuration configuration;
    private ConfigurationProvider configurationProvider;

    public Config(BungeeTitles plugin) {
        this.plugin = plugin;
    }

    public void createConfiguration() {

        if (!plugin.getDataFolder().exists())
            plugin.getDataFolder().mkdir();

        file = new File(plugin.getDataFolder(), "config.yml");


        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        configurationProvider = ConfigurationProvider.getProvider(YamlConfiguration.class);

        try {
            configuration = configurationProvider.load(file);
            configuration.set("Title", "Alert");
            saveConfiguration();
        } catch (IOException e) {
            e.printStackTrace();;
        }
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    private void saveConfiguration() {
        try {
            configurationProvider.save(configuration, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}