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