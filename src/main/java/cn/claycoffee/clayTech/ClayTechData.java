package cn.claycoffee.clayTech;

import org.bukkit.block.Block;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;

public class ClayTechData {
    public static String currentVersion = "";
    public static String jarLocation;
    public static byte[] updateJar;
    public static Map<Inventory, Block> RunningInjectors = new HashMap<>();
    public static Map<Inventory, Block> RunningInjectorsOxygen = new HashMap<>();
    public static Map<Inventory, Block> RunningLaunchersG = new HashMap<>();
}
