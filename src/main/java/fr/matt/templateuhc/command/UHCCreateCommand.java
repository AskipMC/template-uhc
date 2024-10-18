package fr.matt.templateuhc.command;

import fr.matt.templateuhc.config.SettingsUHC;
import fr.matt.templateuhc.game.UHCManager;
import org.bukkit.entity.Player;

public class UHCCreateCommand {

    private UHCManager uhcManager;
    public UHCCreateCommand(UHCManager uhcManager) {
        this.uhcManager = uhcManager;
    }

    public void execute(Player player) {
        if(this.uhcManager.hasUHC()) {
            player.sendMessage(SettingsUHC.getInstance().messageUHCAlreadyExist);
            return;
        }

        this.uhcManager.createUHC();
        player.sendMessage(SettingsUHC.getInstance().messageUHCCreate);
    }
}
