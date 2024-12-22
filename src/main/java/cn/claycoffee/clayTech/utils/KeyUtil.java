package cn.claycoffee.clayTech.utils;

import cn.claycoffee.clayTech.ClayTech;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public class KeyUtil {
    public static NamespacedKey newKey(JavaPlugin plugin, String key) {
        return new NamespacedKey(plugin, key);
    }
    public static NamespacedKey newKey(String namespace, String key) {
        return new NamespacedKey(namespace, key);
    }

    public static NamespacedKey newKey(String key) {
        return new NamespacedKey(ClayTech.getInstance(), key);
    }
}
