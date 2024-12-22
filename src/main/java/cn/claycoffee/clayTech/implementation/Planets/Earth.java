package cn.claycoffee.clayTech.implementation.Planets;

import cn.claycoffee.clayTech.ClayTech;
import cn.claycoffee.clayTech.aarewrite.api.Planet;
import cn.claycoffee.clayTech.utils.Lang;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.World.Environment;
import org.bukkit.generator.ChunkGenerator;

public class Earth extends ChunkGenerator {
    public Earth() {
        new Planet(ClayTech.getOverworld(),
                new CustomItemStack(Material.GREEN_GLAZED_TERRACOTTA, Lang.readPlanetsText("Earth")), this,
                Environment.NORMAL, true, 1, 0, 0, false).register();
    }
}
