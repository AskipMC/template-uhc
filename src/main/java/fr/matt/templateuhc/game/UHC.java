package fr.matt.templateuhc.game;

import fr.matt.templateuhc.config.ConfigUHC;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class UHC {

    private STATE state;
    private ConfigUHC config;
    private ArrayList<Player> players;
    private ArrayList<Player> alivePlayers;
    HashMap<Player, Integer> diamondCounter = new HashMap<Player, Integer>();

    public UHC() {
        this.state = STATE.CONFIG;
        this.config = new ConfigUHC();
        this.players = new ArrayList<Player>();
    }

    public STATE getState() {
        return this.state;
    }

    public void start() {
        this.state = STATE.STARTING;

        this.randomTeleport();
        this.setDiamondLimitCounter();
        this.setBorder();
        this.alivePlayers = players;

        this.state = STATE.RUN;
    }

    public void stop() {
        this.state = STATE.END;
    }

    public void randomTeleport() {
        int borderSize = this.config.getBorderSize();
        int maxCo = borderSize % 2 == 0 ? borderSize / 2 : (borderSize -1)/2;

        for(Player player : this.players) {
            double x = ThreadLocalRandom.current().nextDouble(-maxCo, maxCo);
            double z = ThreadLocalRandom.current().nextDouble(-maxCo, maxCo);

            double y = 150;
            World world = Bukkit.getWorld(this.config.getWorldName());
            while(world.getBlockAt(new Location(world,x,y,z)).getType() == Material.AIR) {
                y--;
            }
            player.teleport(new Location(world, x, y+2, z));
        }
    }

    public void setDiamondLimitCounter() {
        for(Player player : this.players) {
            this.diamondCounter.put(player, 0);
        }
    }

    public void setBorder() {
        int borderSize = this.config.getBorderSize();
        World world = Bukkit.getWorld(this.config.getWorldName());

        org.bukkit.WorldBorder border = world.getWorldBorder();
        border.setSize(borderSize);
        border.setCenter(0,0);
    }

    public Integer getPlayerDiamondLimit(Player player) {
        return this.diamondCounter.get(player);
    }

    public void setPlayerDiamondLimit(Player player, int value) {
        this.diamondCounter.replace(player, value);
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(Player player) {
        this.players.remove(player);
    }

    public ConfigUHC getConfig() {
        return this.config;
    }

    public void removeAlivePlayer(Player player) {
        this.alivePlayers.remove(player);
        this.checkWin();
    }

    public void checkWin() {
        if(alivePlayers.size() == 1) {
            Bukkit.broadcastMessage("Le joueur " + this.alivePlayers.get(0).getName() + " a gagné la partie !");
            this.stop();
        }
    }


}
