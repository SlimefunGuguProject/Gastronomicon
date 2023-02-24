package io.github.schntgaispock.gastronomicon.util;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ItemUtil {

    public static int hashIgnoreAmount(ItemStack stack) {
        int hash = 1;

        hash = hash * 31 + stack.getType().hashCode();
        hash = hash * 31 + (stack.hasItemMeta() ? stack.getItemMeta().hashCode() : 0);

        return hash;
    }

    public static int getSickleTier(ItemStack item) {
        final SlimefunItem sfItem = SlimefunItem.getByItem(item);
        if (sfItem != null) {
            return switch (sfItem.getId()) {
                case "WOODEN_SICKLE" -> 1;
                case "STEEL_SICKLE" -> 2;
                case "REINFORCED_SICKLE" -> 3;
                default -> 0;
            };
        } else {
            return 0;
        }
    }

    public static Material getPlacedBlock(Material seed) {
        return switch (seed) {
            case WHEAT_SEEDS -> Material.WHEAT;
            case POTATO -> Material.POTATOES;
            case CARROT -> Material.CARROTS;
            case BEETROOT_SEEDS -> Material.BEETROOTS;
            case PUMPKIN_SEEDS -> Material.PUMPKIN_STEM;
            case MELON_SEEDS -> Material.MELON_STEM;
            default -> Material.AIR;
        };
    }

    public static void returnItems(Player player, ItemStack[] items) {
        player.getInventory().addItem(items).forEach((__, item) -> {
            player.getWorld().dropItemNaturally(player.getLocation(), item);
        });
    }

}
