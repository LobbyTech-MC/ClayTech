package cn.claycoffee.clayTech.implementation.items;

import cn.claycoffee.clayTech.ClayTechItems;
import cn.claycoffee.clayTech.ClayTechMachineRecipes;
import cn.claycoffee.clayTech.ClayTechRecipeType;
import cn.claycoffee.clayTech.utils.Lang;
import cn.claycoffee.clayTech.utils.SlimefunUtil;

public class Elements {
    public Elements() {
        SlimefunUtil.newResearch()
                .withId(950244)
                .withName(Lang.readResearchesText("CLAYTECH_ELEMENTS_I"))
                .withCost(50)
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_ELEMENTS)
                                .withItem(ClayTechItems.ELEMENT_UNIT)
                                .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                                .withRecipe(ClayTechMachineRecipes.ELEMENT_UNIT)
                                .build())
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_ELEMENTS)
                                .withItem(ClayTechItems.ELEMENT_OXYGEN)
                                .withRecipeType(ClayTechRecipeType.CLAY_ELEMENT_EXTRACTER)
                                .withRecipe(ClayTechMachineRecipes.ELEMENT_OXYGEN)
                                .build())
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_ELEMENTS)
                                .withItem(ClayTechItems.ELEMENT_CARBON)
                                .withRecipeType(ClayTechRecipeType.CLAY_ELEMENT_EXTRACTER)
                                .withRecipe(ClayTechMachineRecipes.ELEMENT_CARBON)
                                .build())
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_ELEMENTS)
                                .withItem(ClayTechItems.ELEMENT_SILICON)
                                .withRecipeType(ClayTechRecipeType.CLAY_ELEMENT_EXTRACTER)
                                .withRecipe(ClayTechMachineRecipes.ELEMENT_SILICON)
                                .build())
                .build();
    }
}