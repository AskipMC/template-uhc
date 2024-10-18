package fr.matt.templateuhc.config;

import fr.matt.templateuhc.TemplateUHC;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class SettingsUHC {

    private final static SettingsUHC instance = new SettingsUHC();

    private File file;
    private YamlConfiguration configuration;

    private int diamondLimit;
    private int borderSize;

    private String worldName;

    public String messageUHCCreate;
    public String messageUHCDelete;
    public String messageUHCCantDelete;
    public String messageUHCStart;
    public String messageUHCStop;
    public String messageUHCAlreadyExist;
    public String messageUHCAlreadyStarted;
    public String messageUHCNotExist;
    public String messageDiamondLimit;
    public String messageUHCHelp;
    public String messagePlayerNotExist;
    public String messageUHCNotInConfigState;
    public String messageUHCNotStarted;
    public String messageUHCAlreadyEnd;
    public String messagePlayerAlreadyList;
    public String messagePlayerAddList;
    public String messagePlayerRemoveList;
    public String messagePlayerNotInList;

    private SettingsUHC() { } // default settings

    public void load() {
        file = new File(TemplateUHC.getInstance().getDataFolder(), "settings.yml");

        if(!file.exists()) TemplateUHC.getInstance().saveResource("settings.yml", false);

        configuration = new YamlConfiguration();
        configuration.options().parseComments(true);

        try {
            configuration.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.diamondLimit = Integer.parseInt(configuration.getString("UHC.Diamond_Limit"));
        this.borderSize = Integer.parseInt(configuration.getString("UHC.Border_Size"));
        this.worldName = String.valueOf(configuration.getString("UHC.World_Name"));

        this.messageUHCAlreadyStarted = String.valueOf(configuration.getString("Messages.UHC_Already_Started"));
        this.messageUHCAlreadyExist = String.valueOf(configuration.getString("Messages.UHC_Already_Created"));
        this.messageUHCCantDelete = String.valueOf(configuration.getString("Messages.UHC_Cant_Delete"));
        this.messageUHCNotExist = String.valueOf(configuration.getString("Messages.UHC_Not_Exist"));
        this.messageUHCCreate = String.valueOf(configuration.getString("Messages.UHC_Created"));
        this.messageUHCDelete = String.valueOf(configuration.getString("Messages.UHC_Deleted"));
        this.messageUHCStop = String.valueOf(configuration.getString("Messages.UHC_Stopped"));
        this.messageUHCStart = String.valueOf(configuration.getString("Messages.UHC_Started"));
        this.messageDiamondLimit = String.valueOf(configuration.getString("Messages.UHC_Reach_Diamond_Limit"));
        this.messageUHCHelp = String.valueOf(configuration.getString("Messages.UHC_Help"));
        this.messagePlayerNotExist = String.valueOf(configuration.getString("Messages.UHC_Player_Not_Exist"));
        this.messageUHCNotInConfigState = String.valueOf(configuration.getString("Messages.UHC_Not_Config_State"));
        this.messageUHCNotStarted = String.valueOf(configuration.getString("Messages.UHC_Not_Started"));
        this.messageUHCAlreadyEnd = String.valueOf(configuration.getString("Messages.UHC_Already_End"));
        this.messagePlayerAlreadyList = String.valueOf(configuration.getString("Messages.UHC_Player_Already_In_List"));
        this.messagePlayerAddList = String.valueOf(configuration.getString("Messages.UHC_Player_Add_List"));
        this.messagePlayerRemoveList = String.valueOf(configuration.getString("Messages.UHC_Player_Remove_List"));
        this.messagePlayerNotInList = String.valueOf(configuration.getString("Messages.UHC_Player_Not_In_List"));
    }

    public static SettingsUHC getInstance() {
        return instance;
    }

    public int getDiamondLimit() {
        return this.diamondLimit;
    }

    public int getBorderSize() {
        return this.borderSize;
    }

    public String getWorldName() {
        return this.worldName;
    }
}
