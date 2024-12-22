package cn.claycoffee.clayTech.implementation.items;

import cn.claycoffee.clayTech.ClayTech;
import cn.claycoffee.clayTech.ClayTechItems;
import cn.claycoffee.clayTech.ClayTechMachineRecipes;
import cn.claycoffee.clayTech.ClayTechRecipeType;
import cn.claycoffee.clayTech.utils.Lang;
import cn.claycoffee.clayTech.utils.SlimefunUtils;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class FoodMakingStaff {
    public FoodMakingStaff() {
        // rewrite
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
                                        null, new ItemStack(Material.BAMBOO), null
                                })
                                .build())
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_FOODMATERIALS)
                                .withItem(ClayTechItems.RAW_VEGETABLE)
                                .withRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
                                .withRecipe(new ItemStack[]{
                                        null, new ItemStack(Material.KELP), null,
                                        null, ClayTechItems.MAGIC_CLAY, null,
                                        null, new ItemStack(Material.BREAD), null
                                })
                                .build())
                .build();

        SlimefunUtils.newResearch()
                .withId(SlimefunUtils.getResearchId())
                .withName(Lang.readResearchesText("CLAYTECH_FOOD_MAKINGS_II"))
                .withCost(50)
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_FOODMATERIALS)
                                .withItem(ClayTechItems.FLOUR)
                                .withRecipeType(ClayTechRecipeType.HARVEST)
                                .withRecipe(ClayTechItems.NORECIPE)
                                .build())
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_FOODMATERIALS)
                                .withItem(ClayTechItems.STARCH)
                                .withRecipeType(ClayTechRecipeType.HARVEST)
                                .withRecipe(ClayTechItems.NORECIPE)
                                .build())
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_FOODMATERIALS)
                                .withItem(ClayTechItems.SNAIL_HEALTHY)
                                .withRecipeType(ClayTechRecipeType.FISHING)
                                .withRecipe(ClayTechItems.NORECIPE)
                                .build())
                .build();

        SlimefunUtils.newResearch()
                .withId(SlimefunUtils.getResearchId())
                .withName(Lang.readResearchesText("CLAYTECH_FRUIT_I"))
                .withCost(50)
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_FOODMATERIALS)
                                .withItem(ClayTechItems.CLAY_LEMON)
                                .withRecipeType(ClayTechRecipeType.PLUCKING)
                                .withRecipe(ClayTechItems.NORECIPE)
                                .build())
                .build();

        SlimefunUtils.newResearch()
                .withId(SlimefunUtils.getResearchId())
                .withName(Lang.readResearchesText("CLAYTECH_STARCH_RESEARCH"))
                .withCost(50)
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_FOODMATERIALS)
                                .withItem(ClayTechItems.STARCH)
                                .withRecipeType(ClayTechRecipeType.HARVEST)
                                .withRecipe(ClayTechItems.NORECIPE)
                                .build())
                .build();

        SlimefunUtils.newResearch()
                .withId(SlimefunUtils.getResearchId())
                .withName(Lang.readResearchesText("CLAYTECH_FLOUR_RESEARCH"))
                .withCost(50)
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_FOODMATERIALS)
                                .withItem(ClayTechItems.FLOUR)
                                .withRecipeType(ClayTechRecipeType.HARVEST)
                                .withRecipe(ClayTechItems.NORECIPE)
                                .build())
                .build();

        SlimefunUtils.newResearch()
                .withId(SlimefunUtils.getResearchId())
                .withName(Lang.readResearchesText("CLAYTECH_SNAIL_HEALTHY_RESEARCH"))
                .withCost(50)
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_FOODMATERIALS)
                                .withItem(ClayTechItems.SNAIL_HEALTHY)
                                .withRecipeType(ClayTechRecipeType.FISHING)
                                .withRecipe(ClayTechItems.NORECIPE)
                                .build())
                .build();

        SlimefunUtils.newResearch()
                .withId(SlimefunUtils.getResearchId())
                .withName(Lang.readResearchesText("CLAYTECH_CLAY_SWEET_POTATO_RESEARCH"))
                .withCost(50)
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_FOODMATERIALS)
                                .withItem(ClayTechItems.CLAY_SWEET_POTATO)
                                .withRecipeType(ClayTechRecipeType.HARVEST)
                                .withRecipe(ClayTechItems.NORECIPE)
                                .build())
                .build();
    }
}
