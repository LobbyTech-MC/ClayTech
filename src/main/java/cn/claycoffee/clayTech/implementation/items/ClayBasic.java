package cn.claycoffee.clayTech.implementation.items;

import cn.claycoffee.clayTech.ClayTech;
import cn.claycoffee.clayTech.ClayTechItems;
import cn.claycoffee.clayTech.utils.Lang;
import cn.claycoffee.clayTech.utils.SlimefunUtils;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class ClayBasic {
    public ClayBasic() {
        SlimefunUtils.newResearch()
                .withId(SlimefunUtils.getResearchId())
                .withName(Lang.readResearchesText("CLAYTECH_START"))
                .withCost(20)
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_BASICS)
                                .withItem(ClayTechItems.MAGIC_CLAY)
                                .withRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
                                .withRecipe(
                                        new ItemStack[] {new ItemStack(Material.COAL), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.COAL),
                                                new ItemStack(Material.IRON_INGOT), new ItemStack(Material.CLAY), new ItemStack(Material.IRON_INGOT),
                                                new ItemStack(Material.COAL), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.COAL)}
                                )
                                .build())
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_BASICS)
                                .withItem(ClayTechItems.CLAY_STICK)
                                .withRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
                                .withRecipe(
                                        new ItemStack[] {new ItemStack(Material.COAL), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.COAL),
                                                new ItemStack(Material.DIRT), new ItemStack(Material.STICK), new ItemStack(Material.DIRT),
                                                new ItemStack(Material.COAL), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.COAL)}
                                )
                                .build())
                .build();
    }
}
