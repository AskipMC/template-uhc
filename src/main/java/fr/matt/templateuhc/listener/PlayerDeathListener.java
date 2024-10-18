package fr.matt.templateuhc.listener;

import fr.matt.templateuhc.game.STATE;
import fr.matt.templateuhc.game.UHCManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    private UHCManager uhcManager;
    public PlayerDeathListener(UHCManager uhcManager) {
        this.uhcManager = uhcManager;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        if(!this.uhcManager.hasUHC()) return;
        if(this.uhcManager.getUHC().getState() != STATE.RUN) return;

        Player player = event.getEntity();
        this.uhcManager.getUHC().removeAlivePlayer(player);
    }
}
