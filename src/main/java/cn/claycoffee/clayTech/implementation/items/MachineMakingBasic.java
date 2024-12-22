package cn.claycoffee.clayTech.implementation.items;

import cn.claycoffee.clayTech.ClayTech;
import cn.claycoffee.clayTech.ClayTechItems;
import cn.claycoffee.clayTech.ClayTechMachineRecipes;
import cn.claycoffee.clayTech.ClayTechRecipeType;
import cn.claycoffee.clayTech.utils.Lang;
import cn.claycoffee.clayTech.utils.SlimefunUtils;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import org.bukkit.NamespacedKey;

public class MachineMakingBasic {
    public MachineMakingBasic() {
        SlimefunUtils.newResearch()
                .withCost(SlimefunUtils.getResearchId())
                .withName(Lang.readResearchesText("CLAYTECH_BEFORE_ELEMENTS"))
                .withCost(50)
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_MATERIALS)
                                .withItem(ClayTechItems.BLISTERING_CORE)
                                .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                                .withRecipe(ClayTechMachineRecipes.BLISTERING_CORE)
                                .build())
                .build();

        SlimefunUtils.newResearch()
                .withCost(SlimefunUtils.getResearchId())
                .withName(Lang.readResearchesText("CLAYTECH_COPIER"))
                .withCost(50)
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_MATERIALS)
                                .withItem(ClayTechItems.COPYING_MODULE)
                                .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                                .withRecipe(ClayTechMachineRecipes.COPYING_MODULE)
                                .build())
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_MATERIALS)
                                .withItem(ClayTechItems.INK_MODULE)
                                .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                                .withRecipe(ClayTechMachineRecipes.INK_MODULE)
                                .build())
                .addItem(ClayTechItems.CLAY_ELECTRIC_COPIER)
                .build();
    }

}
