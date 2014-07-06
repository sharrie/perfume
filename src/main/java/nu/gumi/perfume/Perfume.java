package nu.gumi.perfume;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Perfume extends JavaPlugin implements Listener {
	
	private Set<Player> perfume = new HashSet<Player>();
	
	@Override
	public void onEnable() {
		getLogger().info("onEnable has been invoked!");
		getServer().getPluginManager().registerEvents(new EventListener(this), this);
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
					sender.sendMessage("Try the command again.");
					return false;
				} else {
					Player player = (Player)sender;
					enablePerfume(player, !checkPerfume(player));
					return true;
				}
			}
		} 
		return false;
	}
	
	public boolean checkPerfume(Player player) {
		return perfume.contains(player);
	}
	
	public void enablePerfume(Player player, boolean on) {
		if(on){
			perfume.add(player);
			player.sendMessage("Perfume is enabled.");
		} else {
			perfume.remove(player);
			player.sendMessage("Perfume is disabled.");
		}
	}
	
}
