package me.jestercraftgaming.classes.config;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import me.jestercraftgaming.classes.MinecraftClasses;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigHandler {

	File file = null;
	FileConfiguration cfg = null;
	
	public ConfigHandler(File file) {
		this.file = file;
	}
	
	public ConfigHandler(String s) {
		file = new File(MinecraftClasses.getInstance().getDataFolder(), s);
	}
	
	public FileConfiguration getConfig() {
		if (cfg != null) {
			return cfg;
		}
		reloadConfig();
		return cfg;
	}
	
	public void reloadConfig() {
		if (!file.exists()) {
			file.getParentFile().mkdirs();
			saveDefaultConfig();
		}
		cfg = YamlConfiguration.loadConfiguration(file);
	}
	
	public void saveConfig() {
		try {
			cfg.save(file);
		} catch (IOException e) {
			MinecraftClasses.getInstance().getLogger().warning("Error saving file " + file.getName() + " in " + file.getParent());
		}
	}
	
	public void saveDefaultConfig() {
		file.getParentFile().mkdirs();
		saveResource(file, file.getName());
	}
	
	private void saveResource(File file, String name) {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = MinecraftClasses.getInstance().getResource(name);
			out = new FileOutputStream(file);
			byte[] buffer = new byte[1024];
			int len = in.read(buffer);
			while (len != -1) {
			    out.write(buffer, 0, len);
			    len = in.read(buffer);
			}
		} catch (Exception e) {} finally {
			try {
			if (out != null) {
				out.close();
			}
			if (in != null) {
				in.close();
			}
			} catch (IOException e) {}
		}
	}
	
}
