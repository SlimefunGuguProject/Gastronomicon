package io.github.schntgaispock.gastronomicon.core;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Climate {
    DRY(new CustomItemStack(Material.SAND, "&e干燥")),
    TEMPERATE(new CustomItemStack(Material.GRASS_BLOCK, "&e温和")),
    COLD(new CustomItemStack(Material.ICE, "&e寒冷")),
    SNOWY(new CustomItemStack(Material.SNOW, "&e下雪")),
    NETHER(new CustomItemStack(Material.CRIMSON_NYLIUM, "&e下界")),
    END(new CustomItemStack(Material.END_STONE, "&e末地"));

    private final @Getter ItemStack displayItem;

    public static Climate of(Biome b) {
        return switch (b) {
            case BADLANDS, WOODED_BADLANDS, ERODED_BADLANDS, DESERT, 
                SAVANNA, WINDSWEPT_SAVANNA, SAVANNA_PLATEAU -> Climate.DRY;
            case DEEP_FROZEN_OCEAN, OLD_GROWTH_PINE_TAIGA, TAIGA, 
                OLD_GROWTH_SPRUCE_TAIGA, WINDSWEPT_HILLS, WINDSWEPT_FOREST, 
                WINDSWEPT_GRAVELLY_HILLS, STONY_SHORE -> Climate.COLD;
            case SNOWY_BEACH, SNOWY_PLAINS, ICE_SPIKES, FROZEN_RIVER, 
                FROZEN_OCEAN, GROVE, SNOWY_SLOPES, SNOWY_TAIGA, 
                JAGGED_PEAKS, FROZEN_PEAKS -> Climate.SNOWY;
            case NETHER_WASTES, CRIMSON_FOREST, WARPED_FOREST, 
                SOUL_SAND_VALLEY, BASALT_DELTAS -> Climate.NETHER;
            case THE_END, SMALL_END_ISLANDS, END_BARRENS, END_MIDLANDS, 
                END_HIGHLANDS, THE_VOID -> Climate.END;
            default -> Climate.TEMPERATE;
        };
    }

    public static Climate of(Block b) {
        return of(b.getBiome());
    }

    public static Climate of(Location l) {
        return of(l.getBlock().getBiome());
    }
}