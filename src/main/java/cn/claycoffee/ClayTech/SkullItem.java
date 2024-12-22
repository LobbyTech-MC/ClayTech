package cn.claycoffee.ClayTech;

import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerHead;
import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerSkin;
import org.bukkit.inventory.ItemStack;

public class SkullItem {
    public static ItemStack fromHash(String hash) {
        PlayerSkin skin = PlayerSkin.fromHashCode(hash);
        ItemStack head = PlayerHead.getItemStack(skin);
        return head;
    }

    public static ItemStack fromURL(String url) {
        PlayerSkin skin = PlayerSkin.fromURL(url);
        ItemStack head = PlayerHead.getItemStack(skin);
        return head;
    }
}
