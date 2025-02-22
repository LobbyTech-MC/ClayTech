package cn.claycoffee.clayTech.implementation.items;

import cn.claycoffee.clayTech.ClayTechItems;
import cn.claycoffee.clayTech.ClayTechMachineRecipes;
import cn.claycoffee.clayTech.ClayTechRecipeType;
import cn.claycoffee.clayTech.utils.Lang;
import cn.claycoffee.clayTech.utils.SlimefunUtil;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;

public class PotionAffectWeapons {
    public PotionAffectWeapons() {
        SlimefunUtil.newResearch()
                .withId(950262)
                .withName(Lang.readResearchesText("CLAYTECH_BEFORE_AFFECT_WEAPONS"))
                .withCost(50)
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_MATERIALS)
                                .withItem(ClayTechItems.BLIND_CORE)
                                .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                                .withRecipe(ClayTechMachineRecipes.BLIND_CORE)
                                .build())
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_MATERIALS)
                                .withItem(ClayTechItems.CONFUSION_CORE)
                                .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                                .withRecipe(ClayTechMachineRecipes.CONFUSION_CORE)
                                .build())
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_MATERIALS)
                                .withItem(ClayTechItems.SLOWNESS_CORE)
                                .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                                .withRecipe(ClayTechMachineRecipes.SLOWNESS_CORE)
                                .build())
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_MATERIALS)
                                .withItem(ClayTechItems.POISON_CORE)
                                .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                                .withRecipe(ClayTechMachineRecipes.POISON_CORE)
                                .build())
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_MATERIALS)
                                .withItem(ClayTechItems.POISON_EYE)
                                .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                                .withRecipe(ClayTechMachineRecipes.POISON_EYE)
                                .build())
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_MATERIALS)
                                .withItem(ClayTechItems.BLACK_ROCK_BLOCK)
                                .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                                .withRecipe(ClayTechMachineRecipes.BLACK_ROCK_BLOCK)
                                .build())
                .build();

        SlimefunUtil.newResearch()
                .withId(950263)
                .withName(Lang.readResearchesText("CLAYTECH_AFFECT_WEAPONS"))
                .withCost(50)
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_WEAPONS)
                                .withItem(ClayTechItems.BLIND_SWORD)
                                .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                                .withRecipe(ClayTechMachineRecipes.BLIND_SWORD)
                                .build())
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_WEAPONS)
                                .withItem(ClayTechItems.POISON_SWORD)
                                .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                                .withRecipe(ClayTechMachineRecipes.POISON_SWORD)
                                .build())
                .build();

        SlimefunUtil.newResearch()
                .withId(950264)
                .withName(Lang.readResearchesText("CLAYTECH_BEFORE_ADVANCED_AFFECT_WEAPONS"))
                .withCost(75)
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_MATERIALS)
                                .withItem(ClayTechItems.ADVANCED_BLIND_CORE)
                                .withRecipeType(RecipeType.ANCIENT_ALTAR)
                                .withRecipe(ClayTechMachineRecipes.ADVANCED_BLIND_CORE)
                                .build())
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_MATERIALS)
                                .withItem(ClayTechItems.ADVANCED_CONFUSION_CORE)
                                .withRecipeType(RecipeType.ANCIENT_ALTAR)
                                .withRecipe(ClayTechMachineRecipes.ADVANCED_CONFUSION_CORE)
                                .build())
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_MATERIALS)
                                .withItem(ClayTechItems.ADVANCED_SLOWNESS_CORE)
                                .withRecipeType(RecipeType.ANCIENT_ALTAR)
                                .withRecipe(ClayTechMachineRecipes.ADVANCED_SLOWNESS_CORE)
                                .build())
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_MATERIALS)
                                .withItem(ClayTechItems.ADVANCED_POISON_CORE)
                                .withRecipeType(RecipeType.ANCIENT_ALTAR)
                                .withRecipe(ClayTechMachineRecipes.ADVANCED_POISON_CORE)
                                .build())
                .build();

        SlimefunUtil.newResearch()
                .withId(950265)
                .withName(Lang.readResearchesText("CLAYTECH_ADVANCED_AFFECT_WEAPONS"))
                .withCost(100)
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_WEAPONS)
                                .withItem(ClayTechItems.FOUR_BOW)
                                .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                                .withRecipe(ClayTechMachineRecipes.FOUR_BOW)
                                .build())
                .build();
    }
}
