package fr.matt.templateuhc.command;

import fr.matt.templateuhc.config.SettingsUHC;
import fr.matt.templateuhc.game.STATE;
import fr.matt.templateuhc.game.UHCManager;
import org.bukkit.entity.Player;

public class UHCStopCommand {

    private UHCManager uhcManager;
    public UHCStopCommand(UHCManager uhcManager) {
        this.uhcManager = uhcManager;
    }

    public void execute(Player player) {
        if(!this.uhcManager.hasUHC()) {
            player.sendMessage(SettingsUHC.getInstance().messageUHCNotExist);
            return;
        }

        if(this.uhcManager.getUHC().getState() == STATE.CONFIG || this.uhcManager.getUHC().getState() == STATE.STARTING) {
            player.sendMessage(SettingsUHC.getInstance().messageUHCNotStarted);
            return;
        }

        if(this.uhcManager.getUHC().getState() == STATE.END) {
            player.sendMessage(SettingsUHC.getInstance().messageUHCAlreadyEnd);
            return;
        }

        this.uhcManager.getUHC().stop();
        player.sendMessage(SettingsUHC.getInstance().messageUHCStop);
    }
}
