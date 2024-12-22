package cn.claycoffee.clayTech;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class ClayTechData {
    public static String currentVersion = "";
    public static String jarLocation;
    public static byte[] updateJar;
    public static Map<Inventory, Block> RunningInjectors = new HashMap<>();
    public static Map<Inventory, Block> RunningInjectorsOxygen = new HashMap<>();
    public static Map<Inventory, Block> RunningLaunchersG = new HashMap<>();
    public static Set<UUID> InRocketPlayers = new HashSet<>();
    public static Set<Location> CantBreakBlocks = new HashSet<>();
    public static Map<UUID, Long> LastUseTNTCreaterTime = new HashMap<>();
    public static Set<UUID> AllowSpaceTeleport = new HashSet<>();
    public static Map<Location, Integer> CurrentPage = new HashMap<>();
    public static Set<UUID> SpaceSuitNoCostDurability = new HashSet<>();
}
