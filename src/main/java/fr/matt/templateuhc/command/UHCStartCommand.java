package fr.matt.templateuhc.command;

import fr.matt.templateuhc.config.SettingsUHC;
import fr.matt.templateuhc.game.STATE;
import fr.matt.templateuhc.game.UHCManager;
import org.bukkit.entity.Player;

public class UHCStartCommand {

    private UHCManager uhcManager;
    public UHCStartCommand(UHCManager uhcManager) {
        this.uhcManager = uhcManager;
    }

    public void execute(Player player) {
        if(!this.uhcManager.hasUHC()) {
            player.sendMessage(SettingsUHC.getInstance().messageUHCNotExist);
            return;
        }

        if(this.uhcManager.getUHC().getState() != STATE.CONFIG) {
            player.sendMessage(SettingsUHC.getInstance().messageUHCNotInConfigState);
            return;
        }

        this.uhcManager.getUHC().start();
        player.sendMessage(SettingsUHC.getInstance().messageUHCStart);
    }
}
