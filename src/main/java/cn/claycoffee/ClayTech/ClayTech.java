package cn.claycoffee.ClayTech;

import cn.claycoffee.ClayTech.api.ClayTechManager;
import cn.claycoffee.ClayTech.api.Planet;
import cn.claycoffee.ClayTech.implementation.Planets.Earth;
import cn.claycoffee.ClayTech.implementation.Planets.Mars;
import cn.claycoffee.ClayTech.implementation.Planets.Moon;
import cn.claycoffee.ClayTech.implementation.items.Armors;
import cn.claycoffee.ClayTech.implementation.items.ClayFuelResource;
import cn.claycoffee.ClayTech.implementation.items.Clay_basic;
import cn.claycoffee.ClayTech.implementation.items.DrinkMakingStaff;
import cn.claycoffee.ClayTech.implementation.items.Drinks;
import cn.claycoffee.ClayTech.implementation.items.EffectItems;
import cn.claycoffee.ClayTech.implementation.items.Elements;
import cn.claycoffee.ClayTech.implementation.items.FoodMakingStaff;
import cn.claycoffee.ClayTech.implementation.items.Foods;
import cn.claycoffee.ClayTech.implementation.items.Golden_things;
import cn.claycoffee.ClayTech.implementation.items.Ingots;
import cn.claycoffee.ClayTech.implementation.items.MachineMakingBasic;
import cn.claycoffee.ClayTech.implementation.items.Machines;
import cn.claycoffee.ClayTech.implementation.items.PotionAffect_Weapons;
import cn.claycoffee.ClayTech.implementation.items.Railways;
import cn.claycoffee.ClayTech.implementation.items.RocketMakings;
import cn.claycoffee.ClayTech.implementation.items.Rockets;
import cn.claycoffee.ClayTech.implementation.items.Skulls;
import cn.claycoffee.ClayTech.implementation.items.Spacethings;
import cn.claycoffee.ClayTech.implementation.items.Tools;
import cn.claycoffee.ClayTech.implementation.resources.ClayFuel;
import cn.claycoffee.ClayTech.listeners.BlockUseListener;
import cn.claycoffee.ClayTech.listeners.FoodDropListener;
import cn.claycoffee.ClayTech.listeners.FoodEatListener;
import cn.claycoffee.ClayTech.listeners.ItemInteractListener;
import cn.claycoffee.ClayTech.listeners.ItemUseListener;
import cn.claycoffee.ClayTech.listeners.PlanetBaseListener;
import cn.claycoffee.ClayTech.listeners.PlanetListener;
import cn.claycoffee.ClayTech.listeners.RailwayListener;
import cn.claycoffee.ClayTech.listeners.RocketLauncherListener;
import cn.claycoffee.ClayTech.listeners.WeaponListener;
import cn.claycoffee.ClayTech.utils.Lang;
import cn.claycoffee.ClayTech.utils.Metrics;
import cn.claycoffee.ClayTech.utils.PlanetUtils;
import cn.claycoffee.ClayTech.utils.RocketUtils;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.exceptions.IdConflictException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SuppressWarnings({"unused", "deprecation"})
public class ClayTech extends JavaPlugin implements SlimefunAddon {
    protected static ClayTech plugin;
    private static String locale;
    private static String highrailspeed;
    private static final String version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",")
            .split(",")[3];
    private static final boolean compatible = true;
    private static final List<Planet> planetList = new ArrayList<>();
    private static String overworld = "";
    private static ClayTechUpdater updater;
    private static boolean spacetravelneedperm;
    private static String updateBranch;
    private static FileConfiguration config;
    private static FileConfiguration defaultLang;
    private static boolean worldBorderEnabled;
    private static LocalizationService service;
    private static ConfigManager configManager;
    private static ConfigManager planetManager;
    private static ConfigManager planetDataManager;

    public static LocalizationService getLocalizationService() {
        return service;
    }

    public static ConfigManager getConfigManager() {
        return configManager;
    }

    public static ConfigManager getPlanetManager() {
        return planetManager;
    }

    public static ConfigManager getPlanetDataManager() {
        return planetDataManager;
    }

    public static ClayTech getInstance() {
        return plugin;
    }

    public static String getLocale() {
        return locale;
    }

    public static boolean isSpaceTravelNeedPerm() {
        return spacetravelneedperm;
    }

    public static String getHighRailSpeed() {
        return highrailspeed;
    }

    public static ClayTechUpdater getUpdater() {
        return updater;
    }

    public static boolean getCompatible() {
        return compatible;
    }

    public static List<Planet> getPlanets() {
        return planetList;
    }

    public static String getOverworld() {
        return overworld;
    }

    public static String getUpdateBranch() {
        return updateBranch;
    }

    public static FileConfiguration getDefaultLang() {
        return defaultLang;
    }

    public static boolean isWorldBorderEnabled() {
        return worldBorderEnabled;
    }

    @Override
    public void onEnable() {
        plugin = this;

        configManager = new ConfigManager("config.yml");
        config = configManager.getConfig();
        locale = config.getString("Locale");
        if (locale == null) {
            locale = "en-US";
        }
        highrailspeed = configManager.getConfig().getString("highrailspeed");
        if (highrailspeed == null) {
            highrailspeed = "3";
        }

        service = new LocalizationService(this);
        service.addLanguage(locale);
        service.addLanguage("en-US");

        overworld = config.getString("overworld");

        if (!compatible) {
            getLogger().info(Lang.readGeneralText("Not_compatible"));
        }

        Metrics mt = new Metrics(this, 6887);
        mt.addCustomChart(new Metrics.SimplePie("language", () -> languageCodeToLanguage(locale)));

        planetManager = new ConfigManager("planets.yml");
        planetDataManager = new ConfigManager("planetdata.yml");

        getLogger().info(Lang.readGeneralText("startTip"));
        getLogger().info(Lang.readGeneralText("registeringItems"));
        try {
            registerSlimefun();
            registerPlanets();
            registerResources();
        } catch (Exception e) {
            getLogger().info(Lang.readGeneralText("registeringError"));
            e.printStackTrace();
        }
        if (this.getServer().getPluginManager().isPluginEnabled("WorldBorder")) {
            getLogger().info(Lang.readGeneralText("WorldBorder"));
            worldBorderEnabled = true;
        }

        Bukkit.getPluginManager().registerEvents(new ItemInteractListener(), this);
        Bukkit.getPluginManager().registerEvents(new ItemUseListener(), this);
        Bukkit.getPluginManager().registerEvents(new FoodEatListener(), this);
        Bukkit.getPluginManager().registerEvents(new FoodDropListener(), this);
        Bukkit.getPluginManager().registerEvents(new WeaponListener(), this);
        Bukkit.getPluginManager().registerEvents(new RailwayListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlanetListener(), this);
        Bukkit.getPluginManager().registerEvents(new RocketLauncherListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlanetBaseListener(), this);
        Bukkit.getPluginManager().registerEvents(new BlockUseListener(), this);

        PluginCommand command = this.getCommand("claytech");
        if (command != null) {
            command.setExecutor(new ClayTechCommands());
        } else {
            getLogger().severe("Command /claytech not found.");
        }
        
        spacetravelneedperm = config.getBoolean("space-travel-need-perm");

        ClayTechData.currentVersion = this.getDescription().getVersion();

        autoUpdate.runTaskAsynchronously(this);

        harmInSpace.runTaskTimer(ClayTech.getInstance(), 20, 20);

        getLogger().info("ClayTech has been enabled.");
    }

    private final BukkitRunnable autoUpdate = new BukkitRunnable() {

        @Override
        public void run() {
            ChatColor yellow = ChatColor.YELLOW;
            ChatColor green = ChatColor.GREEN;
            // Updater
            updateBranch = config.getString("update-branch");
            updater = new ClayTechUpdater();
            if (!getConfig().getBoolean("disable-auto-updater")) {

                updater.tryUpdate();
                new BukkitRunnable() {

                    @Override
                    public void run() {
                        updater.tryUpdate();
                    }

                }.runTaskTimerAsynchronously(ClayTech.getInstance(), 1728000, 1728000);
            } else {
                getLogger().info(yellow + Lang.readGeneralText("Info_1"));
                getLogger().info(yellow + Lang.readGeneralText("Auto-updater_disabled"));
                getLogger().info(yellow + Lang.readGeneralText("Info_6"));
            }
            List<String> Authors = plugin.getDescription().getAuthors();
            getLogger().info(green + Lang.readGeneralText("Info_1"));
            getLogger().info(green + Lang.readGeneralText("Info_2").replaceAll("\\{version\\}",
                    plugin.getDescription().getVersion()));
            getLogger().info(
                    green + Lang.readGeneralText("Info_3").replaceAll(
                            "\\{author\\}",
                            Arrays.toString(Authors.toArray(new String[0]))));
            getLogger().info(green + Lang.readGeneralText("Info_4"));
            getLogger().info(green
                    + Lang.readGeneralText("Info_5").replaceAll("\\{issue_tracker\\}", plugin.getBugTrackerURL()));
            getLogger().info(green + Lang.readGeneralText("Info_6"));
        }

    };

    private static final BukkitRunnable harmInSpace = new BukkitRunnable() {
        @SuppressWarnings("deprecation")
        @Override
        public void run() {
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (player == null) {
                    continue;
                }

                if (!player.isOnline()) {
                    continue;
                }
                
                Planet planet = PlanetUtils.getPlanet(player.getWorld());
                if (planet == null) {
                    continue;
                }

                if (planet.getHabitable()) {
                    continue;
                }

                int harmlevel = planet.getHarmLevel();

                World PreviousWorld = player.getWorld();
                if (!PreviousWorld.equals(player.getWorld())) {
                    return;
                }

                boolean isSpaceSuit = ClayTechManager.isSpaceSuit(player.getInventory().getHelmet())
                        && ClayTechManager.isSpaceSuit(player.getInventory().getChestplate())
                        && ClayTechManager.isSpaceSuit(player.getInventory().getLeggings())
                        && ClayTechManager.isSpaceSuit(player.getInventory().getBoots());
                if (!(isSpaceSuit)) {
                    player.sendTitle(Lang.readGeneralText("SpaceSuitError"),
                            Lang.readGeneralText("SpaceSuitError_Sub"));
                    player.damage(5);
                    return;
                }

                boolean isOxygenSuit = RocketUtils.getOxygen(player.getInventory().getHelmet()) > 0
                        && RocketUtils.getOxygen(player.getInventory().getChestplate()) > 0
                        && RocketUtils.getOxygen(player.getInventory().getLeggings()) > 0
                        && RocketUtils.getOxygen(player.getInventory().getBoots()) > 0;
                if (!(isOxygenSuit)) {
                    player.sendTitle(Lang.readGeneralText("SpaceSuitError"),
                            Lang.readGeneralText("SpaceSuitError_Sub"));
                    player.damage(5);
                    return;
                }
                
                boolean isProtectSuit = 
                        RocketUtils
                        .getProtectLevel(player.getInventory().getHelmet()) > harmlevel
                        && RocketUtils.getProtectLevel(
                        player.getInventory().getChestplate()) > harmlevel
                        && RocketUtils.getProtectLevel(
                        player.getInventory().getLeggings()) > harmlevel
                        && RocketUtils.getProtectLevel(
                        player.getInventory().getBoots()) > harmlevel;

                if (!isProtectSuit) {
                    // 扣血
                    player.sendTitle(Lang.readGeneralText("SpaceSuitError"),
                            Lang.readGeneralText("SpaceSuitError_Sub"));
                    player.damage(5);
                    return;
                }
            }
        }

    };

    @Override
    public void onDisable() {
        if (ClayTech.getInstance().getConfig().getBoolean("replace-when-server-stops")) {
            if (ClayTechData.jarLocation != null & ClayTechData.updateJar != null) {
                try {
                    FileOutputStream os = new FileOutputStream(new File(ClayTechData.jarLocation));
                    os.write(ClayTechData.updateJar);
                    os.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String languageCodeToLanguage(String code) {
        return switch (code.toUpperCase()) {
            case "ZH-CN" -> "Simplified Chinese";
            case "ZH-TW" -> "Traditional Chinese";
            case "EN-US" -> "English(US)";
            case "EN-GB" -> "English(UK)";
            case "JA" -> "Japanese";
            case "PL-PL" -> "Polski";
            case "FR" -> "Français";
            default -> code;
        };
    }

    private void registerSlimefun() {
        try {
            new Machines();
        } catch (IdConflictException ignored) {

        }

        try {
            new Clay_basic();
        } catch (IdConflictException ignored) {

        }

        try {
            new PotionAffect_Weapons();
        } catch (IdConflictException ignored) {

        }

        try {
            new Golden_things();
        } catch (IdConflictException ignored) {

        }

        try {
            new Skulls();
        } catch (IdConflictException ignored) {

        }

        try {
            new Armors();
        } catch (IdConflictException ignored) {

        }

        try {
            new DrinkMakingStaff();
        } catch (IdConflictException ignored) {

        }

        try {
            new Drinks();
        } catch (IdConflictException ignored) {

        }

        try {
            new FoodMakingStaff();
        } catch (IdConflictException ignored) {

        }

        try {
            new Foods();
        } catch (IdConflictException ignored) {

        }

        try {
            new MachineMakingBasic();
        } catch (IdConflictException ignored) {

        }

        try {
            new Elements();
        } catch (IdConflictException ignored) {

        }

        try {
            new Railways();
        } catch (IdConflictException ignored) {

        }

        try {
            new EffectItems();
        } catch (IdConflictException ignored) {

        }

        try {
            new Ingots();
        } catch (IdConflictException ignored) {

        }

        try {
            new Tools();
        } catch (IdConflictException ignored) {

        }

        try {
            new ClayFuelResource();
        } catch (IdConflictException ignored) {

        }

        try {
            new RocketMakings();
        } catch (IdConflictException ignored) {

        }

        try {
            new Rockets();
        } catch (IdConflictException ignored) {

        }

        try {
            new Spacethings();
        } catch (IdConflictException ignored) {

        }
    }


    @Override
    public @NotNull JavaPlugin getJavaPlugin() {
        return this;
    }

    @Override
    public @NotNull File getFile() {
        return super.getFile();
    }

    @Override
    public String getBugTrackerURL() {
        return "https://github.com/ClayCoffee/ClayTech/issues";
    }

    private void registerPlanets() {
        // Earth(Overworld) 地球(主世界)
        new Earth();
        // Moon 月球
        new Moon();
        // Mars 火星
        new Mars();
    }

    private void registerResources() {
        new ClayFuel();
    }

    @Override
    public ChunkGenerator getDefaultWorldGenerator(@NotNull String worldName, String id) {
        List<String> PlanetNameList = new ArrayList<>();
        List<Planet> PlanetList = getPlanets();
        for (Planet p : PlanetList) {
            PlanetNameList.add(p.getPlanetWorldName());
        }
        for (String name : PlanetNameList.toArray(new String[0])) {
            if (id.equals(name)) {
                return PlanetList.get(PlanetNameList.indexOf(id)).getPlanetGenerator();
            }
        }
        return Bukkit.getWorld(getOverworld()).getGenerator();
    }
}
