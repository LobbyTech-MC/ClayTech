package cn.claycoffee.clayTech.implementation.items;

import cn.claycoffee.clayTech.ClayTechItems;
import cn.claycoffee.clayTech.ClayTechMachineRecipes;
import cn.claycoffee.clayTech.ClayTechRecipeType;
import cn.claycoffee.clayTech.utils.Lang;
import cn.claycoffee.clayTech.utils.SlimefunUtil;

public class Foods {
    public Foods() {
        SlimefunUtil.newResearch()
                .withId(950247)
                .withName(Lang.readResearchesText("CLAYTECH_FOOD_I"))
                .withCost(50)
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_FOOD)
                                .withItem(ClayTechItems.CHICKEN_FOOT)
                                .withRecipeType(ClayTechRecipeType.CLAY_FOOD_CAULDRON)
                                .withRecipe(ClayTechMachineRecipes.CHICKEN_FOOT)
                                .build())
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_FOOD)
                                .withItem(ClayTechItems.SPICY_CHICKEN_BURGER)
                                .withRecipeType(ClayTechRecipeType.CLAY_FOOD_CAULDRON)
                                .withRecipe(ClayTechMachineRecipes.SPICY_CHICKEN_BURGER)
                                .build())
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_FOOD)
                                .withItem(ClayTechItems.BABA_BURGER)
                                .withRecipeType(ClayTechRecipeType.CLAY_FOOD_CAULDRON)
                                .withRecipe(ClayTechMachineRecipes.BABA_BURGER)
                                .build())
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_FOOD)
                                .withItem(ClayTechItems.CHOCOLATE)
                                .withRecipeType(ClayTechRecipeType.CLAY_FOOD_CAULDRON)
                                .withRecipe(ClayTechMachineRecipes.CHOCOLATE)
                                .build())
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_FOOD)
                                .withItem(ClayTechItems.SNAIL_BAD)
                                .withRecipeType(ClayTechRecipeType.FISHING)
                                .withRecipe(ClayTechItems.NORECIPE)
                                .build())
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_FOOD)
                                .withItem(ClayTechItems.SNAIL_FOOD)
                                .withRecipeType(ClayTechRecipeType.CLAY_FOOD_CAULDRON)
                                .withRecipe(ClayTechMachineRecipes.SNAIL_FOOD)
                                .build())
                .build();

        SlimefunUtil.newResearch()
                .withId(950248)
                .withName(Lang.readResearchesText("CLAYTECH_FOOD_II"))
                .withCost(50)
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_FOOD)
                                .withItem(ClayTechItems.HONEY_SWEET)
                                .withRecipeType(ClayTechRecipeType.CLAY_FOOD_CAULDRON)
                                .withRecipe(ClayTechMachineRecipes.HONEY_SWEET)
                                .build())
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_FOOD)
                                .withItem(ClayTechItems.COOKED_SWEET_POTATO)
                                .withRecipeType(ClayTechRecipeType.CLAY_FOOD_CAULDRON)
                                .withRecipe(ClayTechMachineRecipes.COOKED_SWEET_POTATO)
                                .build())
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_FOOD)
                                .withItem(ClayTechItems.CLAY_SWEET_POTATO)
                                .withRecipeType(ClayTechRecipeType.HARVEST)
                                .withRecipe(ClayTechItems.NORECIPE)
                                .build())
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_FOOD)
                                .withItem(ClayTechItems.GREEN_GRASS)
                                .withRecipeType(ClayTechRecipeType.HARVEST)
                                .withRecipe(ClayTechItems.NORECIPE)
                                .build())
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_FOOD)
                                .withItem(ClayTechItems.STARCH)
                                .withRecipeType(ClayTechRecipeType.HARVEST)
                                .withRecipe(ClayTechItems.NORECIPE)
                                .build())
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_FOOD)
                                .withItem(ClayTechItems.FLOUR)
                                .withRecipeType(ClayTechRecipeType.HARVEST)
                                .withRecipe(ClayTechItems.NORECIPE)
                                .build())
                .build();

        SlimefunUtil.newResearch()
                .withId(950249)
                .withName(Lang.readResearchesText("CLAYTECH_FISH_I"))
                .withCost(30)
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_FOOD)
                                .withItem(ClayTechItems.TUNA_FISH)
                                .withRecipeType(ClayTechRecipeType.FISHING)
                                .withRecipe(ClayTechItems.NORECIPE)
                                .build())
                .build();
    }
}