package cn.claycoffee.clayTech.implementation.items;

import cn.claycoffee.clayTech.ClayTechItems;
import cn.claycoffee.clayTech.ClayTechMachineRecipes;
import cn.claycoffee.clayTech.ClayTechRecipeType;
import cn.claycoffee.clayTech.api.objects.enums.ArmorType;
import cn.claycoffee.clayTech.utils.Lang;
import cn.claycoffee.clayTech.utils.SlimefunUtil;

public class Armors {
    public Armors() {
        SlimefunUtil.newResearch()
                .withId(SlimefunUtil.getResearchId())
                .withName(Lang.readResearchesText("ANTI_SLOWNESS_ARMOR"))
                .withCost(50)
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_ARMORS)
                                .withItem(ClayTechItems.ANTI_SLOWNESS_BOOTS)
                                .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                                .withRecipe(ClayTechMachineRecipes.ANTI_SLOWNESS_BOOTS)
                                .build())
                .build();
        SlimefunUtil.newResearch()
                .withId(SlimefunUtil.getResearchId())
                .withName(Lang.readResearchesText("CLAY_ALLOY_ARMORS"))
                .withCost(65)
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_ARMORS)
                                .withItem(ClayTechItems.CLAY_ALLOY_HELMET)
                                .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                                .withRecipe(SlimefunUtil.getArmorsStack(ArmorType.HELMET, ClayTechItems.CLAY_ALLOY_INGOT))
                                .build())
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_ARMORS)
                                .withItem(ClayTechItems.CLAY_ALLOY_CHESTPLATE)
                                .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                                .withRecipe(SlimefunUtil.getArmorsStack(ArmorType.CHESTPLATE, ClayTechItems.CLAY_ALLOY_INGOT))
                                .build())
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_ARMORS)
                                .withItem(ClayTechItems.CLAY_ALLOY_LEGGINGS)
                                .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                                .withRecipe(SlimefunUtil.getArmorsStack(ArmorType.LEGGINGS, ClayTechItems.CLAY_ALLOY_INGOT))
                                .build())
                .addItem(
                        SlimefunUtil.newItem()
                                .withItemGroup(ClayTechItems.C_ARMORS)
                                .withItem(ClayTechItems.CLAY_ALLOY_BOOTS)
                                .withRecipeType(ClayTechRecipeType.CLAY_CRAFTING_TABLE)
                                .withRecipe(SlimefunUtil.getArmorsStack(ArmorType.BOOTS, ClayTechItems.CLAY_ALLOY_INGOT))
                                .build())
                .build();

    }
}
