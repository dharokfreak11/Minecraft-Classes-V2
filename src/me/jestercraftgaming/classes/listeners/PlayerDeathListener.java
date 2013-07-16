package me.jestercraftgaming.classes.listeners;

import java.util.List;

import me.jestercraftgaming.classes.MinecraftClasses;
import me.jestercraftgaming.classes.config.PlayerConfigHandler;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class PlayerDeathListener implements Listener {
	
	MinecraftClasses main;
	public String playerKilled;
	
	
	
	public PlayerDeathListener(MinecraftClasses main){
		main = this.main;
	}
	
	@EventHandler
	public void PlayerDeathEvent(Player player, List<ItemStack> drops, int droppedExp, int newExp, int newTotalExp, int newLevel, String deathMessage){
		Player playerKilled = (Player) player;
		FileConfiguration cfg = PlayerConfigHandler.getConfig(main, playerKilled);
		cfg.set("Class", "'**'");
		cfg.set("Specialization", "'**'");
	}
	
}
