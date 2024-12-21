package cn.claycoffee.ClayTech;

import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import org.bukkit.inventory.ItemStack;

public class SkullItem {
    public static ItemStack fromHash(String hash) {
        return new CustomItemStack(SlimefunUtils.getCustomHead(hash));
    }
    public static ItemStack fromURL(String url) {
        return new CustomItemStack(SlimefunUtils.getCustomHead(url));
    }
}
