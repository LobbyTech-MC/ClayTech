package cn.claycoffee.clayTech.core.listeners;

import cn.claycoffee.clayTech.ClayTech;
import com.xzavier0722.mc.plugin.slimefun4.storage.util.StorageCacheUtils;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Minecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;

public class RailwayListener implements Listener {
    @EventHandler
    public void VehicleMoveEvent(VehicleMoveEvent e) {
        if (e.getVehicle() instanceof Minecart ve) {
            World veworld = ve.getWorld();
            Location veloc = ve.getLocation();
            Block rail = veworld.getBlockAt(veloc);
            if (rail.getBlockData().getMaterial() == Material.POWERED_RAIL) {
                SlimefunItem item = StorageCacheUtils.getSfItem(rail.getLocation());
                if (item != null) {
                    if (item.getId().equals("CLAY_HIGHSPEED_RAILWAY")) {
                        ve.setMaxSpeed(0.4d * Double.parseDouble(ClayTech.getHighRailSpeed()));
                    } else {
                        ve.setMaxSpeed(0.4d);
                    }
                } else {
                    ve.setMaxSpeed(0.4d);
                }
            } else {
                ve.setMaxSpeed(0.4d);
            }
        }
    }
}
