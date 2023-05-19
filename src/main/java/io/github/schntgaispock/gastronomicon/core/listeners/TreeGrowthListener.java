package io.github.schntgaispock.gastronomicon.core.listeners;

import com.xzavier0722.mc.plugin.slimefun4.storage.util.StorageCacheUtils;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.StructureGrowEvent;

import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.schntgaispock.gastronomicon.api.trees.TreeStructure;

public class TreeGrowthListener implements Listener {

    @EventHandler
    public void onTreeGrow(StructureGrowEvent e) {
        final String sapling = StorageCacheUtils.getData(e.getLocation(), "id");
        if (sapling == null) return;

        final TreeStructure tree = TreeStructure.getLoadedTrees().get(sapling);
        if (tree == null) return;

        e.setCancelled(true);
        Slimefun.getDatabaseManager().getBlockDataController().removeBlock(e.getLocation());
        try {
            tree.build(e.getLocation(), sapling);
        } catch (NullPointerException | IllegalArgumentException err) {
            err.printStackTrace();
        }
    }
    
    public static void setup() {
        Bukkit.getPluginManager().registerEvents(new TreeGrowthListener(), Gastronomicon.getInstance());
    }
}
