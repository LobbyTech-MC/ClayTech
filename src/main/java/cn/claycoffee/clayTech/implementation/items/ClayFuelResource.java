package cn.claycoffee.clayTech.implementation.items;

import cn.claycoffee.clayTech.ClayTechItems;
import cn.claycoffee.clayTech.utils.Lang;
import cn.claycoffee.clayTech.utils.SlimefunUtil;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;

public class ClayFuelResource {
    public ClayFuelResource() {
        SlimefunUtil.newResearch()
                .withId(SlimefunUtil.getResearchId())
                .withName(Lang.readResearchesText("CLAY_FUEL"))
                .withCost(10)
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_MATERIALS)
                                .withItem(ClayTechItems.CLAY_FUEL)
                                .withRecipeType(RecipeType.GEO_MINER)
                                .withRecipe(ClayTechItems.NORECIPE)
                                .build())
                .build();
    }
}
