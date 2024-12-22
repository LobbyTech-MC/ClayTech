package cn.claycoffee.ClayTech.implementation.items;

import cn.claycoffee.ClayTech.ClayTechItems;
import cn.claycoffee.ClayTech.utils.SlimefunUtils;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;

public class ClayFuelResource {
    public ClayFuelResource() {
        SlimefunUtils.registerItem(ClayTechItems.C_MATERIALS, "CLAY_FUEL", ClayTechItems.CLAY_FUEL, "CLAY_FUEL_RESEARCH", 10,
                RecipeType.GEO_MINER, ClayTechItems.NORECIPE, false);
    }
}
