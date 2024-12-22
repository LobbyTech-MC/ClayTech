package cn.claycoffee.clayTech.aarewrite.implementation.items;

import cn.claycoffee.clayTech.ClayTechItems;
import cn.claycoffee.clayTech.ClayTechMachineRecipes;
import cn.claycoffee.clayTech.ClayTechRecipeType;
import cn.claycoffee.clayTech.utils.Lang;
import cn.claycoffee.clayTech.utils.SlimefunUtils;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;

public class Ingots {
    public Ingots() {
        SlimefunUtils.newResearch()
                .withId(SlimefunUtils.getResearchId())
                .withName(Lang.readResearchesText("CLAYTECH_OREINGOTS_I"))
                .withCost(50)
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_ORESTHINGS)
                                .withItem(ClayTechItems.CLAY_FUSION_INGOT)
                                .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                                .withRecipe(ClayTechMachineRecipes.CLAY_FUSION_INGOT)
                                .build())
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_ORESTHINGS)
                                .withItem(ClayTechItems.CLAY_ALLOY_INGOT)
                                .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                                .withRecipe(ClayTechMachineRecipes.CLAY_ALLOY_INGOT)
                                .build())
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_ORESTHINGS)
                                .withItem(ClayTechItems.SILICON_INGOT)
                                .withRecipeType(ClayTechRecipeType.CLAY_EXPERIMENT_TABLE_BASIC)
                                .withRecipe(ClayTechMachineRecipes.SILICON_INGOT)
                                .build())
                .build();

        SlimefunUtils.newResearch()
                .withId(SlimefunUtils.getResearchId())
                .withName(Lang.readResearchesText("CLAYTECH_OREINGOTS_II"))
                .withCost(50)
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_ORESTHINGS)
                                .withItem(ClayTechItems.KREEP_INGOT)
                                .withRecipeType(RecipeType.SMELTERY)
                                .withRecipe(ClayTechMachineRecipes.KREEP_INGOT)
                                .build())
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_ORESTHINGS)
                                .withItem(ClayTechItems.KREEP_ROCK)
                                .withRecipeType(ClayTechRecipeType.DIG_IN_THE_MOON)
                                .withRecipe(ClayTechItems.NORECIPE)
                                .build())
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_ORESTHINGS)
                                .withItem(ClayTechItems.COPPER_ORE)
                                .withRecipeType(ClayTechRecipeType.DIG_IN_NON_EARTH)
                                .withRecipe(ClayTechItems.NORECIPE)
                                .build())
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_ORESTHINGS)
                                .withItem(ClayTechItems.CLAY_FUSION_ORE)
                                .withRecipeType(ClayTechRecipeType.DIG_IN_NON_EARTH)
                                .withRecipe(ClayTechItems.NORECIPE)
                                .build())
                .build();
    }
}
