package cn.claycoffee.ClayTech;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import javax.annotation.ParametersAreNonnullByDefault;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ConfigManager {
    private final FileConfiguration existingConfig;
    private final File existingFile;

    public ConfigManager(String ymlName) {
        existingFile = new File(ClayTech.getInstance().getDataFolder(), ymlName);
        existingConfig = YamlConfiguration.loadConfiguration(existingFile);
        setupDefaultConfig(ymlName);
    }

    public FileConfiguration getConfig() {
        return existingConfig;
    }

    public File getFile() {
        return existingFile;
    }

    private void setupDefaultConfig(String ymlName) {
        final ClayTech plugin = ClayTech.getInstance();
        final InputStream inputStream = plugin.getResource(ymlName);

        if (inputStream == null) {
            return;
        }

        final Reader reader = new InputStreamReader(inputStream);
        final FileConfiguration resourceConfig = YamlConfiguration.loadConfiguration(reader);

        for (String key : resourceConfig.getKeys(false)) {
            checkKey(existingConfig, resourceConfig, key);
        }

        try {
            existingConfig.save(existingFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ParametersAreNonnullByDefault
    private void checkKey(FileConfiguration existingConfig, FileConfiguration resourceConfig, String key) {
        final Object currentValue = existingConfig.get(key);
        final Object newValue = resourceConfig.get(key);
        if (newValue instanceof ConfigurationSection section) {
            for (String sectionKey : section.getKeys(false)) {
                checkKey(existingConfig, resourceConfig, key + "." + sectionKey);
            }
        } else if (currentValue == null) {
            existingConfig.set(key, newValue);
        }
    }
}
