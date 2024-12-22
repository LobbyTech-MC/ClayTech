package cn.claycoffee.clayTech.implementation.items;

import cn.claycoffee.clayTech.ClayTech;
import cn.claycoffee.clayTech.ClayTechItems;
import cn.claycoffee.clayTech.ClayTechMachineRecipes;
import cn.claycoffee.clayTech.ClayTechRecipeType;
import cn.claycoffee.clayTech.utils.Lang;
import cn.claycoffee.clayTech.utils.SlimefunUtils;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class Railways {
    public Railways() {
        SlimefunUtils.newResearch()
                .withId(SlimefunUtils.getResearchId())
                .withName(Lang.readResearchesText("CLAYTECH_RAILWAY_I"))
                .withCost(40)
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_OTHER)
                                .withItem(ClayTechItems.HIGHSPEED_RAILWAY)
                                .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                                .withRecipe(ClayTechMachineRecipes.HIGHSPEED_RAILWAY)
                                .build())
                .addItem(
                        SlimefunUtils.newItem()
                               .withItemGroup(ClayTechItems.C_OTHER)
                               .withItem(ClayTechItems.ELECTRIC_MOTOR_8)
                               .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                               .withRecipe(ClayTechMachineRecipes.ELECTRIC_MOTOR_8)
                               .build())
                .build();
    }
}
