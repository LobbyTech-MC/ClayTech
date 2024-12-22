package cn.claycoffee.clayTech.implementation.items;

import cn.claycoffee.clayTech.ClayTech;
import cn.claycoffee.clayTech.ClayTechItems;
import cn.claycoffee.clayTech.ClayTechRecipeType;
import cn.claycoffee.clayTech.utils.Lang;
import cn.claycoffee.clayTech.utils.SlimefunUtils;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class Drinks {
    public Drinks() {
        SlimefunUtils.newResearch()
                .withId(SlimefunUtils.getResearchId())
                .withName(Lang.readResearchesText("CLAYTECH_DRINK_I"))
                .withCost(50)
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_DRINK)
                                .withItem(ClayTechItems.CLAY_COFFEE)
                                .withRecipeType(ClayTechRecipeType.CLAY_FOOD_CAULDRON)
                                .withRecipe(new ItemStack[]{
                                        null, ClayTechItems.COCOA_BEAN, null,
                                        null, ClayTechItems.COCOA_BEAN, null,
                                        null, ClayTechItems.DRINK_BOTTLE, null
                                })
                                .build())
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_DRINK)
                                .withItem(ClayTechItems.LEMON_POWDER_DRINK)
                                .withRecipeType(ClayTechRecipeType.CLAY_FOOD_CAULDRON)
                                .withRecipe(new ItemStack[]{
                                        null, ClayTechItems.LEMON_POWDER, null,
                                        null, ClayTechItems.LEMON_POWDER, null,
                                        null, ClayTechItems.DRINK_BOTTLE, null
                                })
                                .build())
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_DRINK)
                                .withItem(ClayTechItems.TEA_DRINK)
                                .withRecipeType(ClayTechRecipeType.CLAY_FOOD_CAULDRON)
                                .withRecipe(new ItemStack[]{
                                        null, ClayTechItems.TEA_POWDER, null,
                                        null, ClayTechItems.TEA_POWDER, null,
                                        null, ClayTechItems.DRINK_BOTTLE, null
                                })
                                .build())
                .addItem(
                        SlimefunUtils.newItem()
                                .withItemGroup(ClayTechItems.C_DRINK)
                                .withItem(ClayTechItems.LEMON_TEA_DRINK)
                                .withRecipeType(ClayTechRecipeType.CLAY_FOOD_CAULDRON)
                                .withRecipe(new ItemStack[]{
                                        null, ClayTechItems.TEA_POWDER, null,
                                        null, ClayTechItems.LEMON_POWDER, null,
                                        null, ClayTechItems.DRINK_BOTTLE, null
                                })
                                .build())
                .build();
    }
}
