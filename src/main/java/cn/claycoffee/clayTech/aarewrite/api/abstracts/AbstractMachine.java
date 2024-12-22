package cn.claycoffee.clayTech.aarewrite.api.abstracts;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractMachine extends AContainer {
    public AbstractMachine(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType,
                           ItemStack[] recipe) {

        super(itemGroup, item, recipeType, recipe);

        createPreset(this, getInventoryTitle(), this::constructMenu);
    }

    @Override
    public int getSpeed() {
        return 1;
    }

    public @NotNull String getInventoryTitle() {
        return getItemName();
    }

    public @NotNull String getMachineIdentifier() {
        return getId();
    }

    @Override
    public @NotNull EnergyNetComponentType getEnergyComponentType() {
        return EnergyNetComponentType.CONSUMER;
    }

    public void registerRecipe(int seconds, ItemStack[] input, ItemStack[] output) {
        if (input.length > 9) {
            if (output[0].hasItemMeta()) {
                Bukkit.getLogger()
                        .warning("There is an error when registering the recipe.Please contact the author.Error recipe:"
                                + output[0].getItemMeta().getDisplayName());
                return;
            } else {
                Bukkit.getLogger()
                        .warning("There is an error when registering the recipe.Please contact the author.Error recipe:"
                                + output[0].getType());
                return;
            }
        }
        registerRecipe(new MachineRecipe(seconds, input, output));
    }

    @Override
    public abstract int[] getInputSlots();
    @Override
    public abstract int[] getOutputSlots();
    @Override
    public abstract ItemStack getProgressBar();
    @Override
    public abstract int getEnergyConsumption();
    @Override
    public abstract int getCapacity();
    public abstract void constructMenu(BlockMenuPreset preset);
    public abstract MachineRecipe findNextRecipe(BlockMenu inv);
}
