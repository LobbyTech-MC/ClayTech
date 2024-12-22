package cn.claycoffee.clayTech;

import cn.claycoffee.clayTech.utils.KeyUtil;
import cn.claycoffee.clayTech.utils.Lang;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ClayTechRecipeType {
    public static final RecipeType CLAY_CRAFTING_TABLE = new RecipeType(
            KeyUtil.newKey("CLAY_CRAFTIONG_TABLE"),
            new SlimefunItemStack("CLAY_CRAFTING_TABLE", ClayTechItems.CLAY_CRAFTING_TABLE), "",
            Lang.readMachineRecipesText("CLAY_FUSION_MACHINE"));
    public static final RecipeType CLAY_FOOD_CAULDRON = new RecipeType(
            KeyUtil.newKey("CLAY_FOOD_CAULDRON"),
            new SlimefunItemStack("CLAY_FOOD_CAULDRON", ClayTechItems.CLAY_FOOD_CAULDRON), "",
            Lang.readMachineRecipesText("CLAY_ELETRIC_CAULDRON"));
    public static final RecipeType CLAY_FOOD_CHALKING_MACHINE = new RecipeType(
            KeyUtil.newKey("CLAY_FOOD_CHALKING_MACHINE"),
            new SlimefunItemStack("CLAY_FOOD_CHALKING_MACHINE", ClayTechItems.CLAY_FOOD_CHALKING_MACHINE), "",
            Lang.readMachineRecipesText("CLAY_FOOD_CHALKING_MACHINE"));
    public static final RecipeType CLAY_ELEMENT_EXTRACTER = new RecipeType(
            KeyUtil.newKey("CLAY_ELEMENT_EXTRACTER"),
            new SlimefunItemStack("CLAY_ELEMENT_EXTRACTER", ClayTechItems.CLAY_ELEMENT_EXTRACTER), "",
            Lang.readMachineRecipesText("CLAY_ELEMENT_EXTRACTER"));
    public static final RecipeType CLAY_EXPERIMENT_TABLE_BASIC = new RecipeType(
            KeyUtil.newKey("CLAY_EXPERIMENT_TABLE_BASIC"),
            new SlimefunItemStack("CLAY_EXPERIMENT_TABLE_BASIC", ClayTechItems.CLAY_EXPERIMENT_TABLE_NORMAL), "",
            Lang.readMachineRecipesText("CLAY_EXPERIMENT_TABLE_BASIC"));
    public static final RecipeType CLAY_ROCKET_ASSEMBLING_MACHINE = new RecipeType(
            KeyUtil.newKey("CLAY_ROCKET_ASSEMBLING_MACHINE"),
            new SlimefunItemStack("CLAY_ROCKET_ASSEMBLING_MACHINE", ClayTechItems.CLAY_ROCKET_ASSEMBLING_MACHINE), "",
            Lang.readMachineRecipesText("CLAY_ROCKET_ASSEMBLING_MACHINE"));
    public static final RecipeType CLAY_ROCKET_FUEL_GENERATOR = new RecipeType(
            KeyUtil.newKey("CLAY_ROCKET_FUEL_GENERATOR"),
            new SlimefunItemStack("CLAY_ROCKET_FUEL_GENERATOR", ClayTechItems.CLAY_ROCKET_FUEL_GENERATOR), "",
            Lang.readMachineRecipesText("CLAY_ROCKET_FUEL_GENERATOR"));
    public static final RecipeType DIG_IN_THE_MOON = new RecipeType(
            KeyUtil.newKey("DIG_IN_THE_MOON"), new SlimefunItemStack("DIG_IN_THE_MOON",
            new ItemStack(Material.IRON_PICKAXE), "", Lang.readMachineRecipesText("DIG_IN_THE_MOON")));
    public static final RecipeType DIG_IN_NON_EARTH = new RecipeType(
            KeyUtil.newKey("DIG_IN_NON_EARTH"), new SlimefunItemStack("DIG_IN_NON_EARTH",
            new ItemStack(Material.IRON_PICKAXE), "", Lang.readMachineRecipesText("DIG_IN_NON_EARTH")));
    public static final RecipeType FISHING = new RecipeType(KeyUtil.newKey("FISHING"),
            new SlimefunItemStack("FISHING", new ItemStack(Material.TROPICAL_FISH), "",
                    Lang.readMachineRecipesText("FISHING")));
    public static final RecipeType HARVEST = new RecipeType(KeyUtil.newKey("HARVEST"),
            new SlimefunItemStack("HARVEST", new ItemStack(Material.DIAMOND_HOE), "",
                    Lang.readMachineRecipesText("HARVEST")));
    public static final RecipeType PLUCKING = new RecipeType(KeyUtil.newKey("PLUCKING"),
            new SlimefunItemStack("PLUCKING", new ItemStack(Material.APPLE), "",
                    Lang.readMachineRecipesText("PLUCKING")));
    public static final RecipeType CLEANING = new RecipeType(KeyUtil.newKey("CLEANING"),
            new SlimefunItemStack("CLEANING", new ItemStack(Material.WATER_BUCKET), "",
                    Lang.readMachineRecipesText("CLEANING")));
}
