package fr.matt.templateuhc;

import fr.matt.templateuhc.command.UHCCommand;
import fr.matt.templateuhc.config.SettingsUHC;
import fr.matt.templateuhc.game.UHCManager;
import fr.matt.templateuhc.listener.BlockBreakListener;
import fr.matt.templateuhc.listener.PlayerDeathListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class TemplateUHC extends JavaPlugin {

    @Override
    public void onEnable() {
        SettingsUHC.getInstance().load();
        UHCManager uhcManager = new UHCManager();

        getCommand("uhc").setExecutor(new UHCCommand(uhcManager));
        getServer().getPluginManager().registerEvents(new BlockBreakListener(uhcManager), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(uhcManager), this);
    }

    @Override
    public void onDisable() { }

    public static TemplateUHC getInstance() {
        return getPlugin(TemplateUHC.class);
    }
}