package nu.gumi.perfume;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Perfume extends JavaPlugin{

	@Override
	public void onEnable() {
		getLogger().info("onEnable has been invoked!");
	}
	 
	@Override
	public void onDisable() {
		getLogger().info("onDisable has been invoked!");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("perfume")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("This command can only be run by a player.");
			} else {
				if (args.length != 0) {
			           sender.sendMessage("No arguments allowed!");
			           return false;
				} else {
					Player player = (Player) sender;
					player.sendMessage("harro");
				}
			}
		}
		
		return false; 
	}
	
}
