package fr.matt.templateuhc.listener;

import fr.matt.templateuhc.config.SettingsUHC;
import fr.matt.templateuhc.game.STATE;
import fr.matt.templateuhc.game.UHCManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    private UHCManager uhcManager;

    public BlockBreakListener(UHCManager uhcManager) {
        this.uhcManager = uhcManager;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if(!this.uhcManager.hasUHC()) return;
        if(this.uhcManager.getUHC().getState() != STATE.RUN) return;
        if(event.getBlock().getType() != Material.DIAMOND_ORE) return;

        Player player = event.getPlayer();

        int limit = this.uhcManager.getUHC().getPlayerDiamondLimit(player);
        if(limit < uhcManager.getUHC().getConfig().getDiamondLimit()) {
            this.uhcManager.getUHC().setPlayerDiamondLimit(
                    player, limit + 1
            );
            return;
        }

        player.sendMessage(SettingsUHC.getInstance().messageDiamondLimit);
        event.setCancelled(true);
    }


}
