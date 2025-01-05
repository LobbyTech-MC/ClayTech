package cn.claycoffee.clayTech.implementation.items;

import cn.claycoffee.clayTech.ClayTechItems;
import cn.claycoffee.clayTech.ClayTechMachineRecipes;
import cn.claycoffee.clayTech.ClayTechRecipeType;
import cn.claycoffee.clayTech.utils.Lang;
import cn.claycoffee.clayTech.utils.SlimefunUtil;

public class MachineMakingBasic {
    public MachineMakingBasic() {
        SlimefunUtil.newResearch()
                .withCost(950255)
                .withName(Lang.readResearchesText("CLAYTECH_BEFORE_ELEMENTS"))
                .withCost(50)
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_MATERIALS)
                                .withItem(ClayTechItems.BLISTERING_CORE)
                                .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                                .withRecipe(ClayTechMachineRecipes.BLISTERING_CORE)
                                .build())
                .build();

        SlimefunUtil.newResearch()
                .withCost(950256)
                .withName(Lang.readResearchesText("CLAYTECH_COPIER"))
                .withCost(50)
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_MATERIALS)
                                .withItem(ClayTechItems.COPYING_MODULE)
                                .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                                .withRecipe(ClayTechMachineRecipes.COPYING_MODULE)
                                .build())
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_MATERIALS)
                                .withItem(ClayTechItems.INK_MODULE)
                                .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                                .withRecipe(ClayTechMachineRecipes.INK_MODULE)
                                .build())
                .addItem(ClayTechItems.CLAY_ELECTRIC_COPIER)
                .build();
    }

}
