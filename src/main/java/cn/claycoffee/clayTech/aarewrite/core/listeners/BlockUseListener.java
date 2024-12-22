package cn.claycoffee.clayTech.aarewrite.core.listeners;

import cn.claycoffee.clayTech.implementation.guis.ClayAirLockerGUI;
import cn.claycoffee.clayTech.utils.Lang;
import cn.claycoffee.clayTech.utils.SlimefunUtils;
import com.xzavier0722.mc.plugin.slimefun4.storage.util.StorageCacheUtils;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * @Project: ClayTech
 * @Author: ClayCoffee
 * @Date: 2020/8/23 15:55
 * @Email: 1020757140@qq.com
 * AGPL 3.0
 */

public class BlockUseListener implements Listener {
    @EventHandler
    public void onInteractBlock(PlayerInteractEvent e) {
        if (e.getAction() == Action.PHYSICAL) {
            SlimefunItem item = StorageCacheUtils.getSfItem(e.getClickedBlock().getLocation());
            if (item != null && item.getId().equals("CLAY_AIR_LOCK_PLATE")) {
                Block plate = e.getClickedBlock();
                BlockFace[] lf = new BlockFace[]{BlockFace.NORTH, BlockFace.SOUTH, BlockFace.EAST, BlockFace.WEST};
                for (BlockFace face : lf) {
                    SlimefunUtils.doAirlock(plate, face);
                }
            }
        } else if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            SlimefunItem item = StorageCacheUtils.getSfItem(e.getClickedBlock().getLocation());
            if (item != null && item.getId().equals("CLAY_AIR_LOCK_PLATE")) {
                new ClayAirLockerGUI(27, Lang.readMachinesText("CLAY_AIR_LOCKER"), true, e.getClickedBlock());
                return;
            }
        }
    }
}
