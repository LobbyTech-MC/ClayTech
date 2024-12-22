package cn.claycoffee.clayTech.utils;

import cn.claycoffee.clayTech.ClayTech;
import cn.claycoffee.clayTech.ClayTechItems;
import com.xzavier0722.mc.plugin.slimefun4.storage.util.StorageCacheUtils;
import io.github.thebusybiscuit.slimefun4.api.geo.GEOResource;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.ItemHandler;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SlimefunUtils {
    public static ItemBuilder newItem() {
        return new ItemBuilder();
    }

    public static class ItemBuilder {
        private ItemGroup itemGroup;
        private SlimefunItemStack itemStack;
        private RecipeType recipeType;
        private ItemStack[] recipe;
        private final List<ItemHandler> handlers = new ArrayList<>();

        public ItemBuilder withItemGroup(ItemGroup itemGroup) {
            this.itemGroup = itemGroup;
            return this;
        }

        public ItemBuilder withItem(SlimefunItemStack itemStack) {
            this.itemStack = itemStack;
            return this;
        }

        public ItemBuilder withItem(ItemStack itemStack) {
            if (itemStack instanceof SlimefunItemStack slimefunItemStack) {
                return withItem(slimefunItemStack);
            }

            return this;
        }

        public ItemBuilder withRecipeType(RecipeType recipeType) {
            this.recipeType = recipeType;
            return this;
        }

        public ItemBuilder withRecipe(ItemStack[] recipe) {
            this.recipe = recipe;
            return this;
        }

        public ItemBuilder withHandler(ItemHandler handler) {
            this.handlers.add(handler);
            return this;
        }

        public ItemBuilder withHandlers(ItemHandler... handlers) {
            this.handlers.addAll(Arrays.asList(handlers));
            return this;
        }

        public SlimefunItem build() {
            if (itemGroup == null) {
                throw new IllegalArgumentException("Item Group cannot be null");
            }
            if (itemStack == null) {
                throw new IllegalArgumentException("Item Stack cannot be null");
            }
            if (recipeType == null) {
                throw new IllegalArgumentException("Recipe Type cannot be null");
            }
            if (recipe == null) {
                throw new IllegalArgumentException("Recipe cannot be null");
            }

            SlimefunItem slimefunItem = new SlimefunItem(itemGroup, itemStack, recipeType, recipe);
            for (ItemHandler handler : handlers) {
                slimefunItem.addItemHandler(handler);
            }
            slimefunItem.register(ClayTech.getInstance());
            return slimefunItem;
        }

        public SlimefunItem go() {
            return build();
        }
    }

    public static ResearchBuilder newResearch() {
        return new ResearchBuilder();
    }

    public static class ResearchBuilder {
        private String name;
        private int id;
        private int cost;
        private final List<SlimefunItem> items = new ArrayList<>();
        public ResearchBuilder addItems(SlimefunItem... items) {
            this.items.addAll(Arrays.asList(items));
            return this;
        }

        public ResearchBuilder addItems(SlimefunItemStack... items) {
            for (SlimefunItemStack item : items) {
                this.items.add(SlimefunItem.getByItem(item));
            }
            return this;
        }

        public ResearchBuilder addItems(ItemStack... items) {
            for (ItemStack item : items) {
                this.items.add(SlimefunItem.getByItem(item));
            }
            return this;
        }

        public ResearchBuilder addItem(SlimefunItem item) {
            this.items.add(item);
            return this;
        }

        public ResearchBuilder addItem(SlimefunItemStack item) {
            this.items.add(SlimefunItem.getByItem(item));
            return this;
        }

        public ResearchBuilder addItem(ItemStack item) {
            this.items.add(SlimefunItem.getByItem(item));
            return this;
        }

        public ResearchBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public ResearchBuilder withCost(int cost) {
            this.cost = cost;
            return this;
        }

        public ResearchBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public Research build() {
            if (items.isEmpty()) {
                throw new IllegalArgumentException("Items cannot be empty");
            }

            Research research = new Research(KeyUtil.newKey(name), id, name, cost);
            for (SlimefunItem item : items) {
                research.addItems(item);
            }
            research.register();
            return research;
        }

        public Research go() {
            return build();
        }
    }

    public static void registerItem(ItemGroup itemGroup, String id, SlimefunItemStack item, String ResearchName, int cost, RecipeType Recipetype, ItemStack[] recipe, boolean registerResearch) {
        item = new SlimefunItemStack("CLAYTECH_" + id, item);
        SlimefunItem slimefunItem = new SlimefunItem(itemGroup, item, Recipetype, recipe);
        slimefunItem.setResearch(new Research(new NamespacedKey(ClayTech.getInstance(), ResearchName), id.hashCode(), ResearchName, cost));
        slimefunItem.register(ClayTech.getInstance());
    }

    public static void registerItem(ItemGroup itemGroup, String id, SlimefunItemStack item, String ResearchName, int cost, RecipeType Recipetype, ItemStack[] recipe, boolean registerResearch, ItemHandler[] handlers) {
        item = new SlimefunItemStack("CLAYTECH_" + id, item);
        SlimefunItem slimefunItem = new SlimefunItem(itemGroup, item, Recipetype, recipe);
        slimefunItem.setResearch(new Research(new NamespacedKey(ClayTech.getInstance(), ResearchName), id.hashCode(), ResearchName, cost));
        for (ItemHandler handler : handlers) {
            slimefunItem.addItemHandler(handler);
        }
        slimefunItem.register(ClayTech.getInstance());
    }

    public static void registerItem(ItemGroup itemGroup, String id, ItemStack itemStack, String ResearchName, int cost, RecipeType Recipetype, ItemStack[] recipe, boolean registerResearch) {
        registerItem(itemGroup, id, new SlimefunItemStack(id, itemStack), ResearchName, cost, Recipetype, recipe, registerResearch);
    }

    public static void registerArmors(ItemGroup itemGroup, String nameprefix, ItemStack[] ItemStack, String ResearchName,
                                      int cost, RecipeType Recipetype, ItemStack MaterialStack, boolean registerResearch) {

        nameprefix = "CLAYTECH_" + nameprefix;
        SlimefunItemStack HELMET = new SlimefunItemStack(nameprefix + "_HELMET", ItemStack[0]);
        SlimefunItem HELMET_I = new SlimefunItem(itemGroup, HELMET, Recipetype, getArmorsStack(1, MaterialStack));
        HELMET_I.register(ClayTech.getInstance());
        SlimefunItemStack CHESTPLATE = new SlimefunItemStack(nameprefix + "_CHESTPLATE", ItemStack[1]);
        SlimefunItem CHESTPLATE_I = new SlimefunItem(itemGroup, CHESTPLATE, Recipetype,
                getArmorsStack(2, MaterialStack));
        CHESTPLATE_I.register(ClayTech.getInstance());
        SlimefunItemStack LEGGINGS = new SlimefunItemStack(nameprefix + "_LEGGINGS", ItemStack[2]);
        SlimefunItem LEGGINGS_I = new SlimefunItem(itemGroup, LEGGINGS, Recipetype, getArmorsStack(3, MaterialStack));
        LEGGINGS_I.register(ClayTech.getInstance());
        SlimefunItemStack BOOTS = new SlimefunItemStack(nameprefix + "_BOOTS", ItemStack[3]);
        SlimefunItem BOOTS_I = new SlimefunItem(itemGroup, BOOTS, Recipetype, getArmorsStack(4, MaterialStack));
        BOOTS_I.register(ClayTech.getInstance());
    }

    public static ItemStack[] getArmorsStack(int type, ItemStack Material) {
        if (type == 1) {
            return new ItemStack[]{Material, Material, Material, Material, null, Material, null, null, null};
        }
        if (type == 2) {
            return new ItemStack[]{Material, null, Material, Material, Material, Material, Material, Material,
                    Material};
        }
        if (type == 3) {
            return new ItemStack[]{Material, Material, Material, Material, null, Material, Material, null, Material};
        }
        return new ItemStack[]{null, null, null, Material, null, Material, Material, null, Material};
    }

    public static void registerResource(GEOResource res) {
        res.register();
        Slimefun.getRegistry().getGEOResources().add(res);
    }

    public static void doAirlock(Block plate, BlockFace face) {
        Block a1 = plate.getRelative(face);
        int waitTime = 5;
        String sWaitTime = StorageCacheUtils.getData(plate.getLocation(), "wait-time");
        if (sWaitTime != null) {
            waitTime = Integer.parseInt(sWaitTime);
        }

        SlimefunItem item1 = StorageCacheUtils.getSfItem(a1.getLocation());
        if (item1 != null && item1.getId().equals("CLAY_AIR_LOCK_BLOCK")) {
            List<Block> block = new ArrayList<>();
            List<Block> blocks = new ArrayList<>();
            int[] range = new int[]{0, 1, 2, 3, 4};
            if (face == BlockFace.NORTH || face == BlockFace.SOUTH) {
                int l = 0;
                boolean bo = false;
                for (int x : range) {
                    Block a2 = a1.getRelative(BlockFace.WEST, x);
                    Block a3 = a1.getRelative(BlockFace.EAST, x);
                    SlimefunItem item2 = StorageCacheUtils.getSfItem(a2.getLocation());
                    SlimefunItem item3 = StorageCacheUtils.getSfItem(a3.getLocation());
                    if (item2 != null && item2.getId().equals("CLAY_AIR_LOCK_BLOCK")) {
                        l++;
                        block.add(a2);
                        bo = true;
                    }
                    if (item3 != null && item3.getId().equals("CLAY_AIR_LOCK_BLOCK") && x != 0) {
                        l++;
                        block.add(a3);
                        bo = true;
                    } else if (bo && x != 0) {
                        break;
                    }
                }
                if (l > 0) {
                    blocks.addAll(block);
                    for (Block b : block) {
                        for (int i = 1; i < l; i++) {
                            Block a2 = b.getRelative(BlockFace.UP, i);
                            SlimefunItem item2 = StorageCacheUtils.getSfItem(a2.getLocation());
                            if (item2 == null || !item2.getId().equals("CLAY_AIR_LOCK_BLOCK")) {
                                return;
                            }
                            blocks.add(a2);
                        }
                    }
                }
            } else if (face == BlockFace.EAST || face == BlockFace.WEST) {
                int l = 0;
                boolean bo = false;
                for (int x : range) {
                    Block a2 = a1.getRelative(BlockFace.NORTH, x);
                    Block a3 = a1.getRelative(BlockFace.SOUTH, x);
                    SlimefunItem item2 = StorageCacheUtils.getSfItem(a2.getLocation());
                    SlimefunItem item3 = StorageCacheUtils.getSfItem(a3.getLocation());
                    if (item2 != null && item2.getId().equals("CLAY_AIR_LOCK_BLOCK")) {
                        l++;
                        block.add(a2);
                        bo = true;
                    }
                    if (item3 != null && item3.getId().equals("CLAY_AIR_LOCK_BLOCK") && x != 0) {
                        l++;
                        block.add(a3);
                        bo = true;
                    } else if (bo && x != 0) {
                        break;
                    }
                }
                if (l > 0) {
                    blocks.addAll(block);
                    for (Block b : block) {
                        for (int i = 1; i < l; i++) {
                            Block a2 = b.getRelative(BlockFace.UP, i);
                            SlimefunItem item2 = StorageCacheUtils.getSfItem(a2.getLocation());
                            if (item2 == null || !item2.getId().equals("CLAY_AIR_LOCK_BLOCK")) {
                                return;
                            }
                            blocks.add(a2);
                        }
                    }
                }
            }
            if (blocks.size() > 1) {
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        for (Block b : blocks) {
                            b.setType(Material.AIR);
                        }
                    }
                }.runTask(ClayTech.getInstance());
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        for (Block b : blocks) {
                            b.setType(ClayTechItems.CLAY_AIR_LOCK_BLOCK.getType());
                        }
                    }
                }.runTaskLater(ClayTech.getInstance(), waitTime * 20L);
            }
        }

    }

    public static int id = 950230;
    public static int getResearchId() {
        return id++;
    }
}
