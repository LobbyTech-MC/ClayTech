package cn.claycoffee.clayTech.aarewrite.implementation.items;

import cn.claycoffee.clayTech.ClayTechItems;
import cn.claycoffee.clayTech.utils.Lang;
import cn.claycoffee.clayTech.utils.SlimefunUtils;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class GoldenThings {
    public GoldenThings() {
        SlimefunUtils.newResearch()
                .withId(SlimefunUtils.getResearchId())
                .withName(Lang.readResearchesText("CLAYTECH_ARTIFICIAL_I"))
                .withCost(45)
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_MATERIALS)
                                .withItem(ClayTechItems.ARTIFICIAL_GOLD_NUGGET)
                                .withRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
                                .withRecipe(new ItemStack[]{
                                        new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.GOLD_INGOT),
                                        new ItemStack(Material.GOLD_INGOT), ClayTechItems.MAGIC_CLAY, new ItemStack(Material.GOLD_INGOT),
                                        new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.GOLD_INGOT), new ItemStack(Material.GOLD_INGOT)})
                                .build())
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_MATERIALS)
                                .withItem(ClayTechItems.ARTIFICIAL_GOLD_INGOT)
                                .withRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
                                .withRecipe(new ItemStack[]{
                                        null, ClayTechItems.MAGIC_CLAY, null,
                                        null, ClayTechItems.ARTIFICIAL_GOLD_INGOT_O, null,
                                        null, null, null})
                                .build())
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_MATERIALS)
                                .withItem(ClayTechItems.ARTIFICIAL_GOLD_BLOCK)
                                .withRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
                                .withRecipe(new ItemStack[]{
                                        ClayTechItems.ARTIFICIAL_GOLD_INGOT, ClayTechItems.ARTIFICIAL_GOLD_INGOT, ClayTechItems.ARTIFICIAL_GOLD_INGOT,
                                        ClayTechItems.ARTIFICIAL_GOLD_INGOT, ClayTechItems.ARTIFICIAL_GOLD_INGOT, ClayTechItems.ARTIFICIAL_GOLD_INGOT,
                                        ClayTechItems.ARTIFICIAL_GOLD_INGOT, ClayTechItems.ARTIFICIAL_GOLD_INGOT, ClayTechItems.ARTIFICIAL_GOLD_INGOT})
                                .build())
                .build();

        SlimefunUtils.newResearch()
                .withId(SlimefunUtils.getResearchId())
                .withName(Lang.readResearchesText("CLAYTECH_ARTIFICIAL_ORE_I"))
                .withCost(30)
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_MATERIALS)
                                .withItem(ClayTechItems.ARTIFICIAL_GOLD_INGOT_O)
                                .withRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
                                .withRecipe(new ItemStack[]{
                                        ClayTechItems.ARTIFICIAL_GOLD_NUGGET, ClayTechItems.ARTIFICIAL_GOLD_NUGGET, ClayTechItems.ARTIFICIAL_GOLD_NUGGET,
                                        ClayTechItems.ARTIFICIAL_GOLD_NUGGET, ClayTechItems.MAGIC_CLAY, ClayTechItems.ARTIFICIAL_GOLD_NUGGET,
                                        ClayTechItems.ARTIFICIAL_GOLD_NUGGET, ClayTechItems.ARTIFICIAL_GOLD_NUGGET, ClayTechItems.ARTIFICIAL_GOLD_NUGGET})
                                .build())
                .build();

        SlimefunUtils.newResearch()
                .withId(SlimefunUtils.getResearchId())
                .withName(Lang.readResearchesText("CLAYTECH_ARTIFICIAL_ENCHANTED_GOLDEN_APPLE"))
                .withCost(100)
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_FOOD)
                                .withItem(ClayTechItems.ARTIFICIAL_ENCHANTED_GOLDEN_APPLE)
                                .withRecipeType(RecipeType.ANCIENT_ALTAR)
                                .withRecipe(new ItemStack[]{
                                        ClayTechItems.ARTIFICIAL_GOLD_BLOCK, ClayTechItems.ARTIFICIAL_GOLD_BLOCK, ClayTechItems.ARTIFICIAL_GOLD_BLOCK,
                                        ClayTechItems.ARTIFICIAL_GOLD_BLOCK, new ItemStack(Material.GOLDEN_APPLE), ClayTechItems.ARTIFICIAL_GOLD_BLOCK,
                                        ClayTechItems.ARTIFICIAL_GOLD_BLOCK, ClayTechItems.ARTIFICIAL_GOLD_BLOCK, ClayTechItems.ARTIFICIAL_GOLD_BLOCK})
                                .build())
                .build();
    }
}
