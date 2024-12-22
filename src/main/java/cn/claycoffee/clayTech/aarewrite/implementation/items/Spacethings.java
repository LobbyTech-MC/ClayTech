package cn.claycoffee.clayTech.aarewrite.implementation.items;

import cn.claycoffee.clayTech.ClayTechItems;
import cn.claycoffee.clayTech.utils.Lang;
import cn.claycoffee.clayTech.utils.SlimefunUtils;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * @Project: ClayTech
 * @Author: ClayCoffee
 * @Date: 2020/8/23 15:38
 * @Email: 1020757140@qq.com
 * AGPL 3.0
 */

public class Spacethings {
    public Spacethings() {
        SlimefunUtils.newResearch()
                .withId(SlimefunUtils.getResearchId())
                .withName(Lang.readResearchesText("CLAYTECH_SPACETHINGS_I"))
                .withCost(70)
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_OTHER)
                                .withItem(ClayTechItems.CLAY_AIR_LOCK_BLOCK)
                                .withRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
                                .withRecipe(new ItemStack[]{
                                        SlimefunItems.LEAD_INGOT, SlimefunItems.LEAD_INGOT, SlimefunItems.LEAD_INGOT,
                                        SlimefunItems.LEAD_INGOT, null, SlimefunItems.LEAD_INGOT,
                                        SlimefunItems.LEAD_INGOT, SlimefunItems.LEAD_INGOT, SlimefunItems.LEAD_INGOT})
                                .build())
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_OTHER)
                                .withItem(ClayTechItems.CLAY_AIR_LOCK_PLATE)
                                .withRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
                                .withRecipe(new ItemStack[]{
                                        new ItemStack(Material.STICKY_PISTON), new ItemStack(Material.STONE_PRESSURE_PLATE), new ItemStack(Material.STICKY_PISTON),
                                        new ItemStack(Material.STICKY_PISTON), SlimefunItems.ELECTRIC_MOTOR, new ItemStack(Material.STICKY_PISTON),
                                        ClayTechItems.BLISTERING_CORE, ClayTechItems.BLISTERING_CORE, ClayTechItems.BLISTERING_CORE})
                                .build())
                .build();
    }
}
