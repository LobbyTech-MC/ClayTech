package cn.claycoffee.clayTech.implementation.machines;

import cn.claycoffee.clayTech.api.slimefun.ANewContainer;
import cn.claycoffee.clayTech.utils.Lang;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ElectricStoneCrusher extends ANewContainer {

    public ElectricStoneCrusher(ItemGroup itemGroup, SlimefunItemStack item, String id, RecipeType recipeType,
                                ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public @NotNull String getInventoryTitle() {
        return Lang.readMachinesText("CLAY_ELECTRIC_STONE_CRUSHER");
    }

    @Override
    public @NotNull ItemStack getProgressBar() {
        return new ItemStack(Material.REDSTONE_TORCH);
    }

    @Override
    public int getEnergyConsumption() {
        return 16;
    }

    @Override
    public void registerDefaultRecipes() {
        this.registerRecipe(2, new ItemStack[]{new ItemStack(Material.COBBLESTONE)},
                new ItemStack[]{new ItemStack(Material.GRAVEL)});
    }

    @Override
    public int getCapacity() {
        return 128;
    }
}
