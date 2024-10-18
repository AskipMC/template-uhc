package fr.matt.templateuhc.command;

import fr.matt.templateuhc.config.SettingsUHC;
import fr.matt.templateuhc.game.UHCManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UHCCommand implements CommandExecutor {

    private UHCCreateCommand uhcCreateCommand;
    private UHCDeleteCommand uhcDeleteCommand;
    private UHCStartCommand uhcStartCommand;
    private UHCStopCommand uhcStopCommand;
    private UHCHelpCommand uhcHelpCommand;
    private UHCShowCommand uhcShowCommand;
    private UHCPlayerCommand uhcPlayerCommand;

    public UHCCommand(UHCManager uhcManager) {
        this.uhcCreateCommand = new UHCCreateCommand(uhcManager);
        this.uhcDeleteCommand = new UHCDeleteCommand(uhcManager);
        this.uhcStartCommand = new UHCStartCommand(uhcManager);
        this.uhcStopCommand = new UHCStopCommand(uhcManager);
        this.uhcHelpCommand = new UHCHelpCommand();
        this.uhcShowCommand = new UHCShowCommand(uhcManager);
        this.uhcPlayerCommand = new UHCPlayerCommand(uhcManager);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String msg, String[] args) {

        if(!(sender instanceof Player)) {
            sender.sendMessage("Uniquement des joueurs peuvent executer cette commande.");
            return true;
        }

        if(args.length < 1 ) return false;

        Player player = (Player) sender;
        String arg = args[0];

        if(arg.equalsIgnoreCase("create")) {
            if(!player.hasPermission("uhc.create.use")) return false;
            this.uhcCreateCommand.execute(player);
            return true;
        }
        else if(arg.equalsIgnoreCase("delete")) {
            if(!player.hasPermission("uhc.delete.use")) return false;
            this.uhcDeleteCommand.execute(player);
            return true;
        }
        else if(arg.equalsIgnoreCase("start")) {
            if(!player.hasPermission("uhc.start.use")) return false;
            this.uhcStartCommand.execute(player);
            return true;
        }
        else if(arg.equalsIgnoreCase("stop")) {
            if(!player.hasPermission("uhc.stop.use")) return false;
            this.uhcStopCommand.execute(player);
            return true;
        }
        else if(arg.equalsIgnoreCase("help")) {
            if(!player.hasPermission("uhc.help.use")) return false;
            this.uhcHelpCommand.execute(player);
            return true;
        }
        else if(arg.equalsIgnoreCase("show")) {
            if(!player.hasPermission("uhc.show.use")) return false;
            this.uhcShowCommand.execute();
            return true;
        }
        else if(arg.equalsIgnoreCase("player")) {
            if(!player.hasPermission("uhc.player.use")) return false;

            if(args.length == 2) {
                if(args[1].equalsIgnoreCase("list")) {
                    this.uhcPlayerCommand.listPlayer(player);
                    return true;
                }
            }

            if(args.length == 3) {
                String pseudoArg = args[2];
                Player playerArg = Bukkit.getPlayer(pseudoArg);

                if(playerArg == null) {
                    player.sendMessage(SettingsUHC.getInstance().messagePlayerNotExist);
                    return true;
                }

                String type = args[1];
                if(type.equalsIgnoreCase("add")){
                    this.uhcPlayerCommand.addPlayer(player, playerArg);
                    return true;
                }
                if(type.equalsIgnoreCase("remove")) {
                    this.uhcPlayerCommand.removePlayer(player, playerArg);
                    return true;
                }
            }
        }

        return false;
    }
}
