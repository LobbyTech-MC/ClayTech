package cn.claycoffee.clayTech.aarewrite.implementation.items;

import cn.claycoffee.clayTech.ClayTechData;
import cn.claycoffee.clayTech.ClayTechItems;
import cn.claycoffee.clayTech.ClayTechMachineRecipes;
import cn.claycoffee.clayTech.ClayTechRecipeType;
import cn.claycoffee.clayTech.aarewrite.api.Planet;
import cn.claycoffee.clayTech.utils.Lang;
import cn.claycoffee.clayTech.utils.PlanetUtils;
import cn.claycoffee.clayTech.utils.SlimefunUtils;
import cn.claycoffee.clayTech.utils.Utils;
import com.xzavier0722.mc.plugin.slimefun4.storage.util.StorageCacheUtils;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockPlaceHandler;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class Rockets {
    private static final int[] BORDER = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 13, 17, 18, 26, 27, 35, 36, 44, 45, 47, 48, 49,
            50, 51, 53};
    private static final int[] BORDER_2 = {10, 11, 12, 14, 15, 16};
    private static final ItemStack BORDER_ITEM = new CustomItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE,
            Lang.readMachinesText("SPLIT_LINE"));
    private static final ItemStack OTHERBORDER_ITEM = new CustomItemStack(Material.LIME_STAINED_GLASS_PANE,
            Lang.readMachinesText("SPLIT_LINE"));
    private static int currentPage = 1;

    public Rockets() {
        SlimefunUtils.newResearch()
                .withId(SlimefunUtils.getResearchId())
                .withName(Lang.readResearchesText("CLAYTECH_UNIVERSE_MACHINE_II"))
                .withCost(55)
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_MACHINES)
                                .withItem(ClayTechItems.ROCKET_LAUNCHER)
                                .withRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
                                .withRecipe(new ItemStack[]{
                                        ClayTechItems.CLAY_FUSION_INGOT, ClayTechItems.CLAY_FUSION_INGOT, ClayTechItems.CLAY_FUSION_INGOT,
                                        ClayTechItems.CLAY_FUSION_INGOT, SlimefunItems.PROGRAMMABLE_ANDROID, ClayTechItems.CLAY_FUSION_INGOT,
                                        ClayTechItems.CLAY_FUSION_INGOT, ClayTechItems.CLAY_FUSION_INGOT, ClayTechItems.CLAY_FUSION_INGOT})
                                .withHandler(new BlockPlaceHandler(false) {
                                    @Override
                                    public void onPlayerPlace(@NotNull BlockPlaceEvent blockPlaceEvent) {
                                        StorageCacheUtils.setData(blockPlaceEvent.getBlock().getLocation(), "owner", blockPlaceEvent.getPlayer().getName());
                                    }

                                })
                                .withHandler((BlockUseHandler) ev -> {
                                    PlayerInteractEvent e = ev.getInteractEvent();
                                    if (e.hasBlock() && e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                                        Block b = e.getClickedBlock();
                                        SlimefunItem item = StorageCacheUtils.getSfItem(b.getLocation());
                                        if (item != null) {
                                            if (item.getId().equalsIgnoreCase("ROCKET_LAUNCHER")) {
                                                if (e.hasItem()) {
                                                    SlimefunItem item2 = SlimefunItem.getByItem(e.getItem());
                                                    if (item2 != null && !item2.getResearch().canUnlock(e.getPlayer())) {
                                                        return;
                                                    }
                                                }

                                                SlimefunItem item3 = ClayTechItems.ROCKET_LAUNCHER.getItem();
                                                if (item3 != null && !item3.getResearch().canUnlock(e.getPlayer())) {
                                                    return;
                                                }

                                                Map<String, String> jbj = StorageCacheUtils.getBlock(b.getLocation()).getAllData();
                                                String ownerName = jbj.get("owner");
                                                if (ownerName.equalsIgnoreCase(e.getPlayer().getName())) {
                                                    Planet current = PlanetUtils.getPlanet(b.getWorld());
                                                    if (current == null) {
                                                        e.getPlayer().sendMessage(Lang.readGeneralText("NotAtAPlanet"));
                                                        return;
                                                    }
                                                    if (Utils.getMetadata(b, "currentPage") != null) {
                                                        currentPage = Utils.getMetadata(b, "currentPage").asInt();
                                                    }
                                                    Inventory Preset = Bukkit.createInventory(null, 54,
                                                            Lang.readMachinesText("ROCKET_LAUNCHER"));
                                                    if (!ClayTechData.RunningLaunchersG.containsKey(Preset)) {
                                                        ClayTechData.RunningLaunchersG.put(Preset, b);
                                                    }
                                                    Preset.setItem(5, BORDER_ITEM);
                                                    for (int eachID : BORDER) {
                                                        Preset.setItem(eachID, BORDER_ITEM);
                                                    }
                                                    for (int eachID : BORDER_2) {
                                                        Preset.setItem(eachID, OTHERBORDER_ITEM);
                                                    }
                                                    Preset.setItem(5, BORDER_ITEM);

                                                    Preset = PlanetUtils.renderLauncherMenu(current, Preset, currentPage);

                                                    e.getPlayer().openInventory(Preset);
                                                } else {
                                                    e.getPlayer().sendMessage(Lang.readGeneralText("notOwner"));
                                                    e.setCancelled(true);
                                                    return;
                                                }
                                            }
                                        }
                                    }
                                })
                                .build())
                .build();

        SlimefunUtils.newItem()
                .withItemGroup(ClayTechItems.C_OTHER)
                .withItem(ClayTechItems.ROCKET)
                .withRecipeType(ClayTechRecipeType.CLAY_ROCKET_ASSEMBLING_MACHINE)
                .withRecipe(ClayTechMachineRecipes.ROCKET_1)
                .build();
    }
}
