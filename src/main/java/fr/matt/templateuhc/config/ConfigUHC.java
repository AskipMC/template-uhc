package fr.matt.templateuhc.config;

public class ConfigUHC {

    private int diamondLimit;
    private int borderSize;
    private String worldName;

    public ConfigUHC() { // can be change by the owner of the UHC with a GUI (future) ...
        this.diamondLimit = SettingsUHC.getInstance().getDiamondLimit();
        this.borderSize = SettingsUHC.getInstance().getBorderSize();
        this.worldName = SettingsUHC.getInstance().getWorldName();
    }

    public int getBorderSize() {
        return this.borderSize;
    }

    public int getDiamondLimit() {
        return this.diamondLimit;
    }

    public String getWorldName() {
        return this.worldName;
    }
}
