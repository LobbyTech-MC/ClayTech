package cn.claycoffee.clayTech.aarewrite.implementation.machines;

import cn.claycoffee.clayTech.ClayTechItems;
import cn.claycoffee.clayTech.aarewrite.api.abstracts.ANewContainer;
import cn.claycoffee.clayTech.utils.Lang;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class FoodChalkingMachine extends ANewContainer {

    public FoodChalkingMachine(ItemGroup itemGroup, SlimefunItemStack item, String id, RecipeType recipeType,
                               ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public String getInventoryTitle() {
        return Lang.readMachinesText("CLAY_FOOD_CHALKING_MACHINE");
    }

    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.REDSTONE_TORCH);
    }

    @Override
    public int getEnergyConsumption() {
        return 32;
    }

    @Override
    public int getCapacity() {
        return 512;
    }

    // == todo ==
    @Override
    public int[] getInputSlots() {
        return new int[0];
    }

    @Override
    public int[] getOutputSlots() {
        return new int[0];
    }
    @Override
    public void constructMenu(BlockMenuPreset preset) {

    }

    @Override
    public MachineRecipe findNextRecipe(BlockMenu inv) {
        return null;
    }

    // == todo ==

    @Override
    public void registerDefaultRecipes() {
        this.registerRecipe(8, new ItemStack[]{ClayTechItems.RAW_TEA}, new ItemStack[]{ClayTechItems.TEA_POWDER});
        this.registerRecipe(8, new ItemStack[]{ClayTechItems.CLAY_LEMON},
                new ItemStack[]{ClayTechItems.LEMON_POWDER});
        this.registerRecipe(8, new ItemStack[]{new ItemStack(Material.CHICKEN)},
                new ItemStack[]{ClayTechItems.RAW_CHICKEN_FOOT});
    }
}
