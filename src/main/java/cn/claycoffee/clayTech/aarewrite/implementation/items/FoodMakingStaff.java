package cn.claycoffee.clayTech.aarewrite.implementation.items;

import cn.claycoffee.clayTech.ClayTechItems;
import cn.claycoffee.clayTech.ClayTechMachineRecipes;
import cn.claycoffee.clayTech.ClayTechRecipeType;
import cn.claycoffee.clayTech.utils.Lang;
import cn.claycoffee.clayTech.utils.SlimefunUtils;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class FoodMakingStaff {
    public FoodMakingStaff() {
        SlimefunUtils.newResearch()
                .withId(SlimefunUtils.getResearchId())
                .withName(Lang.readResearchesText("CLAYTECH_FOOD_MAKINGS_I"))
                .withCost(50)
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_FOODMATERIALS)
                                .withItem(ClayTechItems.RAW_CHICKEN_FOOT)
                                .withRecipeType(ClayTechRecipeType.CLAY_FOOD_CHALKING_MACHINE)
                                .withRecipe(ClayTechMachineRecipes.RAW_CHICKEN_FOOT)
                                .build())
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_FOODMATERIALS)
                                .withItem(ClayTechItems.RAW_BREAD)
                                .withRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
                                .withRecipe(new ItemStack[]{
                                        null, new ItemStack(Material.BREAD), null,
                                        null, ClayTechItems.MAGIC_CLAY, null,
                                        null, new ItemStack(Material.BREAD), null})
                                .build())
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_FOODMATERIALS)
                                .withItem(ClayTechItems.RAW_VEGETABLE)
                                .withRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
                                .withRecipe(new ItemStack[]{
                                        null, new ItemStack(Material.KELP), null,
                                        null, ClayTechItems.MAGIC_CLAY, null,
                                        null, new ItemStack(Material.BAMBOO), null})
                                .build())
                .build();

        SlimefunUtils.newResearch()
                .withId(SlimefunUtils.getResearchId())
                .withName(Lang.readResearchesText("CLAYTECH_FOOD_MAKINGS_II"))
                .withCost(50)
                .addItem(ClayTechItems.FLOUR)
                .build();

        SlimefunUtils.newResearch()
                .withId(SlimefunUtils.getResearchId())
                .withName(Lang.readResearchesText("CLAYTECH_FRUIT_I"))
                .withCost(50)
                .addItem(ClayTechItems.CLAY_LEMON)
                .build();
    }
}