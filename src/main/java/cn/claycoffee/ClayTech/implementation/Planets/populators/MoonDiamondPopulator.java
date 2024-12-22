package cn.claycoffee.ClayTech.implementation.Planets.populators;

import cn.claycoffee.ClayTech.ClayTech;
import com.xzavier0722.mc.plugin.slimefun4.storage.util.StorageCacheUtils;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.scheduler.BukkitRunnable;

import javax.annotation.Nonnull;
import java.util.Random;

public class MoonDiamondPopulator extends BlockPopulator {

    @Override
    public void populate(@Nonnull World world, @Nonnull Random random, @Nonnull Chunk source) {
        new BukkitRunnable() {

            @Override
            public void run() {
                int tryc = 3 + random.nextInt(2);
                for (int i = 0; i < tryc; i++) {
                    int x = random.nextInt(16);
                    int y = random.nextInt(100) + 1;
                    int z = random.nextInt(16);
                    int count = 0;
                    while (count <= 7 || random.nextDouble() < 0.9D && count <= 12) {
                        final int tx = x;
                        final int ty = y;
                        final int tz = z;
                        Block sourceb = source.getBlock(x, y, z);
                        if (sourceb.getType() == Material.STONE) {
                            if (StorageCacheUtils.hasBlock(sourceb.getLocation())) return;
                            new BukkitRunnable() {

                                @Override
                                public void run() {
                                    source.getBlock(tx, ty, tz).setType(Material.DIAMOND_ORE, false);

                                }

                            }.runTask(ClayTech.getInstance());
                            count++;
                        }

                        switch (random.nextInt(6)) {
                            case 0 -> x = Math.min(x + 1, 15);
                            case 1 -> y = Math.min(y + 1, 15);
                            case 2 -> z = Math.min(z + 1, 15);
                            case 3 -> x = Math.max(x - 1, 0);
                            case 4 -> y = Math.max(y - 1, 1);
                            default -> z = Math.max(z - 1, 0);
                        }
                    }
                }

            }

        }.runTaskAsynchronously(ClayTech.getInstance());
    }

}
