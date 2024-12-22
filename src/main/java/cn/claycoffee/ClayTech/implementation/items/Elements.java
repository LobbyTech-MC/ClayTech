package cn.claycoffee.ClayTech.implementation.items;

import cn.claycoffee.ClayTech.ClayTech;
import cn.claycoffee.ClayTech.ClayTechItems;
import cn.claycoffee.ClayTech.ClayTechMachineRecipes;
import cn.claycoffee.ClayTech.ClayTechRecipeType;
import cn.claycoffee.ClayTech.utils.Lang;
import cn.claycoffee.ClayTech.utils.SlimefunUtils;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import org.bukkit.NamespacedKey;

public class Elements {
    public Elements() {

        SlimefunUtils.registerItem(ClayTechItems.C_ELEMENTS, "ELEMENT_UNIT", ClayTechItems.ELEMENT_UNIT, "ELEMENT_UNIT_RESEARCH",
                10, ClayTechRecipeType.CLAY_CRAFTING_TABLE, ClayTechMachineRecipes.ELEMENT_UNIT, false);
        SlimefunUtils.registerItem(ClayTechItems.C_ELEMENTS, "ELEMENT_OXYGEN", ClayTechItems.ELEMENT_OXYGEN,
                "ELEMENT_OXYGEN_RESEARCH", 10, ClayTechRecipeType.CLAY_ELEMENT_EXTRACTER, ClayTechMachineRecipes.ELEMENT_OXYGEN,
                false);
        SlimefunUtils.registerItem(ClayTechItems.C_ELEMENTS, "ELEMENT_CARBON", ClayTechItems.ELEMENT_CARBON,
                "ELEMENT_CARBON_RESEARCH", 10, ClayTechRecipeType.CLAY_ELEMENT_EXTRACTER, ClayTechMachineRecipes.ELEMENT_CARBON,
                false);
        SlimefunUtils.registerItem(ClayTechItems.C_ELEMENTS, "ELEMENT_SILICON", ClayTechItems.ELEMENT_SILICON,
                "ELEMENT_SILICON_RESEARCH", 10, ClayTechRecipeType.CLAY_ELEMENT_EXTRACTER, ClayTechMachineRecipes.ELEMENT_SILICON,
                false);

        Research before_element = new Research(new NamespacedKey(ClayTech.getInstance(), "CLAYTECH_BEFORE_ELEMENT"),
                9919, Lang.readResearchesText("CLAYTECH_ELEMENTS_I"), 50);

        before_element.addItems(SlimefunItem.getByItem(ClayTechItems.ELEMENT_UNIT),
                SlimefunItem.getByItem(ClayTechItems.ELEMENT_OXYGEN),
                SlimefunItem.getByItem(ClayTechItems.ELEMENT_CARBON),
                SlimefunItem.getByItem(ClayTechItems.ELEMENT_SILICON));
        before_element.register();
    }
}