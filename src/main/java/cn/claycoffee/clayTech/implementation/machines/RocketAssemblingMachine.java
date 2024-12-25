package cn.claycoffee.clayTech.implementation.machines;

import cn.claycoffee.clayTech.ClayTechItems;
import cn.claycoffee.clayTech.api.slimefun.ARocketTable;
import cn.claycoffee.clayTech.utils.Lang;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class RocketAssemblingMachine extends ARocketTable {

    public RocketAssemblingMachine(ItemGroup itemGroup, SlimefunItemStack item, String id, RecipeType recipeType,
                                   ItemStack[] recipe) {
        super(itemGroup, item, id, recipeType, recipe);
    }

    @Override
    public @NotNull String getInventoryTitle() {
        return Lang.readMachinesText("CLAY_ROCKET_ASSEMBLING_MACHINE");
    }

    @Override
    public @NotNull ItemStack getProgressBar() {
        return new ItemStack(Material.REDSTONE_TORCH);
    }

    @Override
    public int getEnergyConsumption() {
        return 128;
    }

    @Override
    public void registerDefaultRecipes() {
        ItemStack[] ROCKET_1 = {
                null,
                ClayTechItems.ROCKET_GLASS, ClayTechItems.ROCKET_FUEL_TANK, ClayTechItems.ROCKET_GLASS,
                ClayTechItems.ROCKET_STEEL_PLATE, ClayTechItems.ROCKET_CONTROL_CORE, ClayTechItems.ROCKET_STEEL_PLATE,
                ClayTechItems.ROCKET_STEEL_PLATE, ClayTechItems.ROCKET_ENGINE, ClayTechItems.ROCKET_STEEL_PLATE};
        this.registerRecipe(600, ROCKET_1, new ItemStack[]{ClayTechItems.ROCKET});
    }

    @Override
    public int getCapacity() {
        return 512;
    }

}
