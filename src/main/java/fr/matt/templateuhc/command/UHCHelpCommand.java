package fr.matt.templateuhc.command;

import fr.matt.templateuhc.config.SettingsUHC;
import org.bukkit.entity.Player;

public class UHCHelpCommand {

    public UHCHelpCommand() {}

    public void execute(Player player) {
        player.sendMessage(SettingsUHC.getInstance().messageUHCHelp);
    }

}
