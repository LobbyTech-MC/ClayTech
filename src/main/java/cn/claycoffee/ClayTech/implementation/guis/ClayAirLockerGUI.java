package cn.claycoffee.ClayTech.implementation.guis;

import cn.claycoffee.ClayTech.utils.Lang;
import com.xzavier0722.mc.plugin.slimefun4.storage.util.StorageCacheUtils;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * @Project: ClayTech
 * @Author: ClayCoffee
 * @Date: 2020/8/23 15:24
 * @Email: 1020757140@qq.com
 * AGPL 3.0
 */

public class ClayAirLockerGUI extends ChestMenu {
    private static int[] border = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};

    private Block b;

    private int size;
    private boolean isProtected;

    public ClayAirLockerGUI(int size, String title, boolean isProtected, Block b) {
        super(title);
        this.b = b;
        this.size = size;
        this.isProtected = isProtected;
    }

    public boolean isProtected() {
        return isProtected;
    }

    public int getSize() {
        return size;
    }

    public void init() {
        for (int v : new int[]{11, 15}) {
            this.addMenuClickHandler(v, (p, s, i, t) -> {
                String sWaitTime = StorageCacheUtils.getData(b.getLocation(), "wait-time");
                if (sWaitTime == null) {
                    return false;
                }

                int waitTime = Integer.parseInt(sWaitTime);
                if (s == 11) {
                    if (waitTime <= 1) return false;
                    waitTime--;
                    StorageCacheUtils.setData(b.getLocation(), "wait-time", waitTime + "");
                    open(p);
                } else {
                    waitTime++;
                    StorageCacheUtils.setData(b.getLocation(), "wait-time", waitTime + "");
                    open(p);
                }
                return false;
            });
        }
    }


    public void setupBlockMenu(Inventory inventory, Player player, Block b) {
        if (this.b != null) {
            int waitTime = 5;
            String sWaitTime = StorageCacheUtils.getData(b.getLocation(), "wait-time");
            if (sWaitTime != null) {
                waitTime = Integer.parseInt(sWaitTime);
            } else {
                StorageCacheUtils.setData(b.getLocation(), "wait-time", waitTime + "");
            }
            ItemStack borderItem = new CustomItemStack(Material.BLUE_STAINED_GLASS_PANE, Lang.readMachinesText("SPLIT_LINE"));
            ItemStack waitTimeItem = new CustomItemStack(Material.CLOCK, Lang.readMachinesText("wait-time").replaceAll("%TIME%", waitTime + ""));
            ItemStack add = new CustomItemStack(Material.GREEN_STAINED_GLASS_PANE, Lang.readMachinesText("add"));
            ItemStack sub = new CustomItemStack(Material.RED_STAINED_GLASS_PANE, Lang.readMachinesText("sub"));
            for (int i : border) {
                inventory.setItem(i, borderItem);
            }
            inventory.setItem(11, sub);
            inventory.setItem(15, add);
            inventory.setItem(13, waitTimeItem);
        }
    }

    public String getID() {
        return "CLAYTECH_AIR_LOCKER";
    }
}
