package cn.claycoffee.clayTech.core.worlds.decorators;

import cn.claycoffee.clayTech.ClayTech;
import cn.claycoffee.clayTech.ClayTechItems;
import com.xzavier0722.mc.plugin.slimefun4.storage.util.StorageCacheUtils;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.scheduler.BukkitRunnable;

import javax.annotation.Nonnull;
import java.util.Random;

public class MoonCopperOrePopulator extends BlockPopulator {

    @Override
    public void populate(@Nonnull World world, @Nonnull Random random, @Nonnull Chunk source) {
        new BukkitRunnable() {

            @Override
            public void run() {
                int tryc = 5 + random.nextInt(4);
                for (int i = 0; i < tryc; i++) {
                    int x = random.nextInt(16);
                    int y = random.nextInt(100) + 1;
                    int z = random.nextInt(16);
                    int count = 0;
                    while (count <= 5 || random.nextDouble() < 0.92D && count <= 8) {
                        final int tx = x;
                        final int ty = y;
                        final int tz = z;
                        Block sourceb = source.getBlock(x, y, z);
                        if (sourceb.getType() == Material.STONE) {
                            if (StorageCacheUtils.hasBlock(sourceb.getLocation())) {
                                return;
                            }
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    sourceb.setType(ClayTechItems.COPPER_ORE.getType(), false);
                                    if (Slimefun.getDatabaseManager().getBlockDataController().getBlockData(sourceb.getLocation()) != null) {
                                        cancel();
                                        return;
                                    }
                                    Slimefun.getDatabaseManager().getBlockDataController().createBlock(sourceb.getLocation(), ClayTechItems.COPPER_ORE.getItemId());
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
