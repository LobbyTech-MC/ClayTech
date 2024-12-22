package cn.claycoffee.clayTech.aarewrite.implementation.items;

import cn.claycoffee.clayTech.ClayTechItems;
import cn.claycoffee.clayTech.ClayTechMachineRecipes;
import cn.claycoffee.clayTech.ClayTechRecipeType;
import cn.claycoffee.clayTech.utils.Lang;
import cn.claycoffee.clayTech.utils.SlimefunUtils;

public class Elements {
    public Elements() {
        SlimefunUtils.newResearch()
                .withId(SlimefunUtils.getResearchId())
                .withName(Lang.readResearchesText("CLAYTECH_ELEMENTS_I"))
                .withCost(50)
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_ELEMENTS)
                                .withItem(ClayTechItems.ELEMENT_UNIT)
                                .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                                .withRecipe(ClayTechMachineRecipes.ELEMENT_UNIT)
                                .build())
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_ELEMENTS)
                                .withItem(ClayTechItems.ELEMENT_OXYGEN)
                                .withRecipeType(ClayTechRecipeType.CLAY_ELEMENT_EXTRACTER)
                                .withRecipe(ClayTechMachineRecipes.ELEMENT_OXYGEN)
                                .build())
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_ELEMENTS)
                                .withItem(ClayTechItems.ELEMENT_CARBON)
                                .withRecipeType(ClayTechRecipeType.CLAY_ELEMENT_EXTRACTER)
                                .withRecipe(ClayTechMachineRecipes.ELEMENT_CARBON)
                                .build())
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_ELEMENTS)
                                .withItem(ClayTechItems.ELEMENT_SILICON)
                                .withRecipeType(ClayTechRecipeType.CLAY_ELEMENT_EXTRACTER)
                                .withRecipe(ClayTechMachineRecipes.ELEMENT_SILICON)
                                .build())
                .build();
    }
}