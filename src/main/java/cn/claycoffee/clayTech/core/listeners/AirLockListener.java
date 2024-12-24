package cn.claycoffee.clayTech.core.listeners;

import cn.claycoffee.clayTech.ClayTechItems;
import com.xzavier0722.mc.plugin.slimefun4.storage.util.StorageCacheUtils;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class AirLockListener implements Listener {
    private static final BlockFace[] FACES = {BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST};
    @EventHandler
    public void onAirLockPlatePress(PlayerInteractEvent event) {
        if (event.getAction() == Action.PHYSICAL) {
            Block plate = event.getClickedBlock();
            if (plate == null) {
                return;
            }

            SlimefunItem item = StorageCacheUtils.getSfItem(plate.getLocation());
            if (item == null) {
                return;
            }

            if (!item.getId().equals(ClayTechItems.CLAY_AIR_LOCK_PLATE.getItemId())) {
                return;
            }

            for (BlockFace face : FACES) {
                checkAirLock(plate, face);
            }
        }
    }

    public void checkAirLock(Block plate, BlockFace face) {
        // todo
    }
}
