package cn.claycoffee.ClayTech;

import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerHead;
import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerSkin;
import org.bukkit.inventory.ItemStack;

public class SkullItem {
    public static ItemStack fromHash(String hash) {
        PlayerSkin skin = PlayerSkin.fromHashCode(hash);
        return PlayerHead.getItemStack(skin);
    }

    public static ItemStack fromURL(String url) {
        PlayerSkin skin = PlayerSkin.fromURL(url);
        return PlayerHead.getItemStack(skin);
    }
}
