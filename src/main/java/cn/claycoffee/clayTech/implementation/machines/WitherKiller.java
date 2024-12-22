package cn.claycoffee.clayTech.implementation.machines;

import cn.claycoffee.clayTech.aarewrite.api.abstracts.ACraftingTable;
import cn.claycoffee.clayTech.utils.Lang;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * @Project: ClayTech
 * @Author: ClayCoffee
 * @Date: 2020/8/3 20:36
 * @Email: 1020757140@qq.com
 * AGPL 3.0
 */

public class WitherKiller extends ACraftingTable {
    public WitherKiller(ItemGroup itemGroup, SlimefunItemStack item, String id, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public @NotNull String getInventoryTitle() {
        return Lang.readMachinesText("CLAY_WITHER_KILLER");
    }

    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.WITHER_SKELETON_SKULL);
    }

    @Override
    public int getEnergyConsumption() {
        return 128;
    }

    @Override
    public int getCapacity() {
        return 5120;
    }

    @Override
    public void registerDefaultRecipes() {
        ItemStack SOUL_SAND = new ItemStack(Material.SOUL_SAND);
        ItemStack WITHER_SKELETON_SKULL = new ItemStack(Material.WITHER_SKELETON_SKULL);
        this.registerRecipe(40, new ItemStack[]{WITHER_SKELETON_SKULL, WITHER_SKELETON_SKULL, WITHER_SKELETON_SKULL, SOUL_SAND, SOUL_SAND, SOUL_SAND, null, SOUL_SAND, null}, new ItemStack[]{new ItemStack(Material.NETHER_STAR)});
    }
}
