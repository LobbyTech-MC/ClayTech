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
import org.bukkit.inventory.ItemStack;

public class Armors {
    public Armors() {

        SlimefunUtils.registerItem(ClayTechItems.C_ARMORS, "ANTI_SLOWNESS_BOOTS", ClayTechItems.ANTI_SLOWNESS_BOOTS,
                "ANTI_SLOWNESS_ARMOR_RESEARCH", 10, ClayTechRecipeType.CLAY_CRAFTING_TABLE, ClayTechMachineRecipes.ANTI_SLOWNESS_BOOTS,
                false);

        Research basic = new Research(new NamespacedKey(ClayTech.getInstance(), "ANTI_SLOWNESS_ARMOR_RESEARCH"), 9908,
                Lang.readResearchesText("ANTI_SLOWNESS_ARMOR_RESEARCH"), 50);
        basic.addItems(SlimefunItem.getByItem(ClayTechItems.ANTI_SLOWNESS_BOOTS));
        basic.register();

        SlimefunUtils.registerArmors(ClayTechItems.C_ARMORS, "CLAY_ALLOY_ARMORS",
                new ItemStack[]{ClayTechItems.CLAY_ALLOY_HELMET, ClayTechItems.CLAY_ALLOY_CHESTPLATE,
                        ClayTechItems.CLAY_ALLOY_LEGGINGS, ClayTechItems.CLAY_ALLOY_BOOTS},
                "CLAY_ALLOY_ARMORS_RESEARCH", 10, ClayTechRecipeType.CLAY_CRAFTING_TABLE, ClayTechItems.CLAY_ALLOY_INGOT, false);
        Research clayalloy = new Research(new NamespacedKey(ClayTech.getInstance(), "CLAY_ALLOY_ARMORS_RESEARCH"),
                9924, Lang.readResearchesText("CLAY_ALLOY_ARMORS_RESEARCH"), 65);
        clayalloy.addItems(SlimefunItem.getByItem(ClayTechItems.CLAY_ALLOY_HELMET),
                SlimefunItem.getByItem(ClayTechItems.CLAY_ALLOY_CHESTPLATE),
                SlimefunItem.getByItem(ClayTechItems.CLAY_ALLOY_LEGGINGS),
                SlimefunItem.getByItem(ClayTechItems.CLAY_ALLOY_BOOTS));
        clayalloy.register();
    }
}
