package cn.claycoffee.clayTech.core.listeners;

import cn.claycoffee.clayTech.ClayTech;
import cn.claycoffee.clayTech.ClayTechItems;
import cn.claycoffee.clayTech.utils.StaffUtil;
import com.xzavier0722.mc.plugin.slimefun4.storage.util.StorageCacheUtils;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class AirLockListener implements Listener {
    private static final String PLATE_ID = ClayTechItems.CLAY_AIR_LOCK_PLATE.getItemId();
    private static final int MAX_SEARCH_DISTANCE = 8;
    private static final Material BLOCK_TYPE = ClayTechItems.CLAY_AIR_LOCK_BLOCK.getType();
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

            if (!item.getId().equals(PLATE_ID)) {
                return;
            }

            for (BlockFace face : FACES) {
                checkAirLock(plate, face);
            }
        }
    }

    public void checkAirLock(Block plate, BlockFace doorFace) {
        Location plateLocation = plate.getLocation();
        Location centerLocation = plateLocation.clone().toBlockLocation().add(doorFace.getDirection());
        List<BlockFace> AvailableFaces = new ArrayList<>(List.of(BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST, BlockFace.UP, BlockFace.DOWN));
        AvailableFaces.remove(doorFace);
        AvailableFaces.remove(doorFace.getOppositeFace());

        Set<Location> searchedLocations = StaffUtil.getLocations(centerLocation.getBlock(), doorFace, MAX_SEARCH_DISTANCE, this::isAirLock);

        Set<Location> locationsToOpen = new HashSet<>();
        Set<Location> locationsToClose = new HashSet<>();
        for (Location location : searchedLocations) {
            Block block = location.getBlock();
            if (block.getType() == BLOCK_TYPE) {
                locationsToOpen.add(location);
            } else {
                locationsToClose.add(location);
            }
        }

        Bukkit.getServer().getScheduler().runTaskLater(ClayTech.getInstance(), () -> {
            for (Location location : locationsToOpen) {
                location.getBlock().setType(Material.AIR);
            }
        }, 1);

        Bukkit.getServer().getScheduler().runTaskLater(ClayTech.getInstance(), () -> {
            for (Location location : locationsToClose) {
                location.getBlock().setType(BLOCK_TYPE);
            }
        }, 25);
    }

    public boolean isAirLock(Location location) {
        SlimefunItem item = StorageCacheUtils.getSfItem(location);
        if (item == null) {
            return false;
        }

        return item.getId().equals(ClayTechItems.CLAY_AIR_LOCK_BLOCK.getItemId());
    }
}
