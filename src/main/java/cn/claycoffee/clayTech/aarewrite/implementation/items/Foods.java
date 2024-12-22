package cn.claycoffee.clayTech.aarewrite.implementation.items;

import cn.claycoffee.clayTech.ClayTechItems;
import cn.claycoffee.clayTech.ClayTechMachineRecipes;
import cn.claycoffee.clayTech.ClayTechRecipeType;
import cn.claycoffee.clayTech.utils.Lang;
import cn.claycoffee.clayTech.utils.SlimefunUtils;
import org.bukkit.NamespacedKey;

public class Foods {
    public Foods() {
        SlimefunUtils.newResearch()
                .withId(SlimefunUtils.getResearchId())
                .withName(Lang.readResearchesText("CLAYTECH_FOOD_I"))
                .withCost(50)
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_FOOD)
                                .withItem(ClayTechItems.CHICKEN_FOOT)
                                .withRecipeType(ClayTechRecipeType.CLAY_FOOD_CAULDRON)
                                .withRecipe(ClayTechMachineRecipes.CHICKEN_FOOT)
                                .build())
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_FOOD)
                                .withItem(ClayTechItems.SPICY_CHICKEN_BURGER)
                                .withRecipeType(ClayTechRecipeType.CLAY_FOOD_CAULDRON)
                                .withRecipe(ClayTechMachineRecipes.SPICY_CHICKEN_BURGER)
                                .build())
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_FOOD)
                                .withItem(ClayTechItems.BABA_BURGER)
                                .withRecipeType(ClayTechRecipeType.CLAY_FOOD_CAULDRON)
                                .withRecipe(ClayTechMachineRecipes.BABA_BURGER)
                                .build())
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_FOOD)
                                .withItem(ClayTechItems.CHOCOLATE)
                                .withRecipeType(ClayTechRecipeType.CLAY_FOOD_CAULDRON)
                                .withRecipe(ClayTechMachineRecipes.CHOCOLATE)
                                .build())
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_FOOD)
                                .withItem(ClayTechItems.SNAIL_BAD)
                                .withRecipeType(ClayTechRecipeType.FISHING)
                                .withRecipe(ClayTechItems.NORECIPE)
                                .build())
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_FOOD)
                                .withItem(ClayTechItems.SNAIL_FOOD)
                                .withRecipeType(ClayTechRecipeType.CLAY_FOOD_CAULDRON)
                                .withRecipe(ClayTechMachineRecipes.SNAIL_FOOD)
                                .build())
                .build();

        SlimefunUtils.newResearch()
                .withId(SlimefunUtils.getResearchId())
                .withName(Lang.readResearchesText("CLAYTECH_FOOD_II"))
                .withCost(50)
                .addItem(
                        SlimefunUtils.newItem()
                            .withItemGroup(ClayTechItems.C_FOOD)
                            .withItem(ClayTechItems.HONEY_SWEET)
                            .withRecipeType(ClayTechRecipeType.CLAY_FOOD_CAULDRON)
                            .withRecipe(ClayTechMachineRecipes.HONEY_SWEET)
                            .build())
                .addItem(ClayTechItems.CLAY_SWEET_POTATO)
                .addItem(
                        SlimefunUtils.newItem()
                            .withItemGroup(ClayTechItems.C_FOOD)
                            .withItem(ClayTechItems.COOKED_SWEET_POTATO)
                            .withRecipeType(ClayTechRecipeType.CLAY_FOOD_CAULDRON)
                            .withRecipe(ClayTechMachineRecipes.COOKED_SWEET_POTATO)
                            .build())
                .addItem(
                        SlimefunUtils.newItem()
                            .withItemGroup(ClayTechItems.C_FOOD)
                            .withItem(ClayTechItems.GREEN_GRASS)
                            .withRecipeType(ClayTechRecipeType.HARVEST)
                            .withRecipe(ClayTechItems.NORECIPE)
                            .build())
                .build();

        SlimefunUtils.newResearch()
                .withId(SlimefunUtils.getResearchId())
                .withName(Lang.readResearchesText("CLAYTECH_FISH_I"))
                .withCost(30)
                .addItem(
                        SlimefunUtils.newItem()
                            .withItemGroup(ClayTechItems.C_FOOD)
                            .withItem(ClayTechItems.TUNA_FISH)
                            .withRecipeType(ClayTechRecipeType.FISHING)
                            .withRecipe(ClayTechItems.NORECIPE)
                            .build())
                .build();
    }
}