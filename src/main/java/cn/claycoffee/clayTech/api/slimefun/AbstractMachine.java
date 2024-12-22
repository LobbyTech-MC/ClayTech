package cn.claycoffee.clayTech.api.slimefun;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractMachine extends AContainer {
    public AbstractMachine(@NotNull ItemGroup itemGroup, @NotNull SlimefunItemStack item, @NotNull RecipeType recipeType, ItemStack @NotNull [] recipe) {

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

    public void registerRecipe(int seconds, ItemStack @NotNull [] input, ItemStack[] output) {
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
    public abstract ItemStack getProgressBar();

    @Override
    public abstract int getEnergyConsumption();

    @Override
    public abstract int getCapacity();
}
