package fr.matt.templateuhc.command;

import fr.matt.templateuhc.config.SettingsUHC;
import fr.matt.templateuhc.game.STATE;
import fr.matt.templateuhc.game.UHCManager;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class UHCPlayerCommand {

    private UHCManager uhcManager;

    public UHCPlayerCommand(UHCManager uhcManager) {
        this.uhcManager = uhcManager;
    }

    public void addPlayer(Player sender, Player player) {
        if(!this.canUse(sender)) return;

        if(this.uhcManager.getUHC().getPlayers().contains(player)) {
            sender.sendMessage(
                   SettingsUHC.getInstance().messagePlayerAlreadyList.replace("{player}", player.getName())
            );
            return;
        }

        this.uhcManager.getUHC().addPlayer(player);
        sender.sendMessage(
                SettingsUHC.getInstance().messagePlayerAddList.replace("{player}", player.getName())
        );
    }

    public void removePlayer(Player sender, Player player) {
        if(!this.canUse(sender)) return;

        if(!this.uhcManager.getUHC().getPlayers().contains(player)) {
            sender.sendMessage(
                    SettingsUHC.getInstance().messagePlayerNotInList.replace("{player}", player.getName())
            );
            return;
        }

        this.uhcManager.getUHC().removePlayer(player);
        sender.sendMessage(
                SettingsUHC.getInstance().messagePlayerRemoveList.replace("{player}", player.getName())
        );
    }

    public void listPlayer(Player sender) {
        if(!this.canUse(sender)) return;

        ArrayList<Player> players = this.uhcManager.getUHC().getPlayers();
        String message = "Liste des joueurs : ";
        for (Player playerToShow : players ) {
            message += "\n - " + playerToShow.getName();
        }

        sender.sendMessage(message);
    }

    public boolean canUse(Player player) {
        if(!this.uhcManager.hasUHC()) {
            player.sendMessage(SettingsUHC.getInstance().messageUHCNotExist);
            return false;
        }

        if(this.uhcManager.getUHC().getState() != STATE.CONFIG) {
            player.sendMessage(SettingsUHC.getInstance().messageUHCNotInConfigState);
            return false;
        }

        return true;
    }
}
