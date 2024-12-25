package cn.claycoffee.clayTech.core.worlds;

import cn.claycoffee.clayTech.api.objects.Planet;
import cn.claycoffee.clayTech.core.worlds.decorators.AsteroidBeltCraterPopulator;
import cn.claycoffee.clayTech.utils.Lang;
import com.google.common.collect.ImmutableList;

import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;

/**
 * @author Narcissu14
 */
@SuppressWarnings("deprecation")
public class AsteroidBelt extends ChunkGenerator {
	public AsteroidBelt() {
		new Planet("CAsteroidBelt",
				new CustomItemStack(Material.COBBLESTONE, Lang.readPlanetsText("AsteroidBelt")), this,
				World.Environment.THE_END, false, 0.16, 382500000, 1, true, 1).register();
	}

	@Override
	public Location getFixedSpawnLocation(World world, @NotNull Random random) {
		world.getBlockAt(0, 59, 0).setType(Material.BEDROCK);

		return new Location(world, 0, 60, 0);
	}

	@Override
	public @NotNull List<BlockPopulator> getDefaultPopulators(@NotNull World world) {
		return ImmutableList.of(new AsteroidBeltCraterPopulator());
	}

	@Override
	public @NotNull ChunkData generateChunkData(@NotNull World world, @NotNull Random random, int x, int z, @NotNull BiomeGrid biome) {

        return Bukkit.createChunkData(world);
	}
}