package cn.claycoffee.clayTech.implementation.items;

import cn.claycoffee.clayTech.ClayTechItems;
import cn.claycoffee.clayTech.ClayTechMachineRecipes;
import cn.claycoffee.clayTech.ClayTechRecipeType;
import cn.claycoffee.clayTech.utils.Lang;
import cn.claycoffee.clayTech.utils.SlimefunUtil;

public class Railways {
    public Railways() {
        SlimefunUtil.newResearch()
                .withId(950266)
                .withName(Lang.readResearchesText("CLAYTECH_RAILWAY_I"))
                .withCost(40)
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_OTHER)
                                .withItem(ClayTechItems.HIGHSPEED_RAILWAY)
                                .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                                .withRecipe(ClayTechMachineRecipes.HIGHSPEED_RAILWAY)
                                .build())
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_OTHER)
                                .withItem(ClayTechItems.ELECTRIC_MOTOR_8)
                                .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                                .withRecipe(ClayTechMachineRecipes.ELECTRIC_MOTOR_8)
                                .build())
                .build();
    }
}
