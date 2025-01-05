package cn.claycoffee.clayTech.implementation.items;

import cn.claycoffee.clayTech.ClayTechItems;
import cn.claycoffee.clayTech.ClayTechMachineRecipes;
import cn.claycoffee.clayTech.ClayTechRecipeType;
import cn.claycoffee.clayTech.utils.Lang;
import cn.claycoffee.clayTech.utils.SlimefunUtil;

public class Tools {
    public Tools() {
        SlimefunUtil.newResearch()
                .withId(950276)
                .withName(Lang.readResearchesText("CLAYTECH_TOOLS_I"))
                .withCost(35)
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_TOOLS)
                                .withItem(ClayTechItems.REINFORCED_ALLOY_PICKAXE)
                                .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                                .withRecipe(ClayTechMachineRecipes.REINFORCED_ALLOY_PICKAXE)
                                .build())
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_TOOLS)
                                .withItem(ClayTechItems.CLAY_ALLOY_PICKAXE)
                                .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                                .withRecipe(ClayTechMachineRecipes.CLAY_ALLOY_PICKAXE)
                                .build())
                .build();
    }
}
