package io.github.pinont.smp;

import io.github.pinont.smp.Cosmetic.Sparking;
import io.github.pinont.smp.Database.Connector;
import io.github.pinont.smp.Events.*;
import io.github.pinont.smp.GlobalEvent.ChatGame;
import io.github.pinont.smp.GlobalEvent.Contest;
import io.github.pinont.smp.Utils.DiscordWebhook;
import io.github.pinont.smp.Utils.GlobalEventUtils;
import io.github.pinont.smp.Utils.Msg;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public final class Core extends JavaPlugin {

    public static Core plugin;

    public Core() {
        plugin = this;
    }

    @Override
    public void onEnable() {
        registerConfig();
        registerEvents();
        new GlobalEventUtils();
        GlobalEventUtils.start();
        try {
            initDatabase();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            registerRecipes();
        } catch (Exception e) {
            Msg.console("Error while registering recipes: " + e.getMessage());
            Msg.console(e.getMessage());
            try {
                DiscordWebhook.sendEmbedMessage("Shutting Down Server", e.getMessage(), "990000");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            Bukkit.getServer().shutdown();
        }

        getLogger().info("Plugin enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled");
    }

    private void registerConfig() {
        // get Default config and lines
        if (this.getConfig().get("config.yml") == null) {
            ArrayList<String> lines = new ArrayList<>();
            getConfig().addDefault("config.yml", lines);
            getConfig().options().copyDefaults();
            saveDefaultConfig();
        }
    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new ChestLock(), this);
        getServer().getPluginManager().registerEvents(new PlaceBlock(), this);
        getServer().getPluginManager().registerEvents(new MobBreedingChance(), this);
        getServer().getPluginManager().registerEvents(new MithrilDrops(), this);
        getServer().getPluginManager().registerEvents(new ChatGame(), this);
        getServer().getPluginManager().registerEvents(new Contest(), this);
        getServer().getPluginManager().registerEvents(new PlantCrops(), this);
        getServer().getPluginManager().registerEvents(new InventoryFull(), this);
        getServer().getPluginManager().registerEvents(new JoinEvents(), this);
        getServer().getPluginManager().registerEvents(new TreeFeller(), this);
        getServer().getPluginManager().registerEvents(new Sparking(), this);
    }

    private void registerRecipes() {
        Sparking.Recipe();
    }

    private void initDatabase() throws IOException {
        try {
            Connector.init();
        } catch (SQLException e) {
            Msg.console("Error while connecting to database: " + e.getMessage());
            Msg.console(e.getMessage());
            DiscordWebhook.sendEmbedMessage("Shutting Down Server", e.getMessage(), "990000");
            Bukkit.getServer().shutdown();
        }
    }

    public @NotNull NamespacedKey key(String cosmetic) {
        return cosmetic == null ? null : new NamespacedKey(this, cosmetic);
    }
}
