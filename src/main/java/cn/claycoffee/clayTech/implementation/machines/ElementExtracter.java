package cn.claycoffee.clayTech.implementation.machines;

import cn.claycoffee.clayTech.ClayTechItems;
import cn.claycoffee.clayTech.aarewrite.api.abstracts.AExtracter;
import cn.claycoffee.clayTech.utils.Lang;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ElementExtracter extends AExtracter {
    public ElementExtracter(ItemGroup itemGroup, SlimefunItemStack item, String id, RecipeType recipeType,
                            ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    public String getInventoryTitle() {
        return Lang.readMachinesText("CLAY_ELEMENT_EXTRACTER");
    }

    public ItemStack getProgressBar() {
        return new ItemStack(Material.REDSTONE_TORCH);
    }

    public int getEnergyConsumption() {
        return 64;
    }

    @Override
    public int getCapacity() {
        return 1024;
    }

    public void registerDefaultRecipes() {
        registerRecipe(10, new ItemStack[]{new ItemStack(Material.DIRT, 3)},
                new ItemStack[]{ClayTechItems.ELEMENT_OXYGEN});
        registerRecipe(10, new ItemStack[]{new ItemStack(Material.COAL, 8)},
                new ItemStack[]{ClayTechItems.ELEMENT_CARBON});
        registerRecipe(10, new ItemStack[]{new ItemStack(Material.SAND, 10)},
                new ItemStack[]{ClayTechItems.ELEMENT_SILICON});
    }
}
