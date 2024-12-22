package cn.claycoffee.clayTech.implementation.machines;

import cn.claycoffee.clayTech.ClayTechItems;
import cn.claycoffee.clayTech.ClayTechMachineRecipes;
import cn.claycoffee.clayTech.aarewrite.api.abstracts.AExperimentTable;
import cn.claycoffee.clayTech.utils.Lang;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ExperimentTableNormal extends AExperimentTable {

    public ExperimentTableNormal(ItemGroup itemGroup, SlimefunItemStack item, String id, RecipeType recipeType,
                                 ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public String getInventoryTitle() {
        return Lang.readMachinesText("CLAY_EXPERIMENTTABLE_NORMAL");
    }

    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.TNT);
    }

    @Override
    public int getEnergyConsumption() {
        return 80;
    }

    @Override
    public int getCapacity() {
        return 1024;
    }

    @Override
    public void registerDefaultRecipes() {
        this.registerRecipe(20, ClayTechMachineRecipes.SILICON_INGOT, new ItemStack[]{ClayTechItems.SILICON_INGOT});
    }
}
