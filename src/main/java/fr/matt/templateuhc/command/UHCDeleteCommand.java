package fr.matt.templateuhc.command;

import fr.matt.templateuhc.config.SettingsUHC;
import fr.matt.templateuhc.game.STATE;
import fr.matt.templateuhc.game.UHCManager;
import org.bukkit.entity.Player;

public class UHCDeleteCommand {
    private UHCManager uhcManager;
    public UHCDeleteCommand(UHCManager uhcManager) {
        this.uhcManager = uhcManager;
    }

    public void execute(Player player) {
        if(!this.uhcManager.hasUHC()) {
            player.sendMessage(SettingsUHC.getInstance().messageUHCNotExist);
            return;
        }

        if(this.uhcManager.getUHC().getState() != STATE.END) {
            player.sendMessage(SettingsUHC.getInstance().messageUHCCantDelete);
            return;
        }

        this.uhcManager.deleteUHC();
        player.sendMessage(SettingsUHC.getInstance().messageUHCDelete);
    }
}
