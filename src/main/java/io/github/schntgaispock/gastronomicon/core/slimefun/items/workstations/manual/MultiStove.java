package io.github.schntgaispock.gastronomicon.core.slimefun.items.workstations.manual;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.xzavier0722.mc.plugin.slimefun4.storage.util.StorageCacheUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.api.recipes.GastroRecipe;
import io.github.schntgaispock.gastronomicon.api.recipes.MultiStoveRecipe;
import io.github.schntgaispock.gastronomicon.core.slimefun.recipes.GastroRecipeType;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetComponent;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.common.CommonPatterns;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;

@Getter
@SuppressWarnings("deprecation")
public class MultiStove extends GastroWorkstation implements EnergyNetComponent {

    @RequiredArgsConstructor
    public enum Temperature {
        LOW(TEMPERATURE_BUTTON_LOW, "低"),
        MEDIUM(TEMPERATURE_BUTTON_MEDIUM, "中"),
        HIGH(TEMPERATURE_BUTTON_HIGH, "高");

        private final @Getter ItemStack item;

        private final @Getter String text;

        public static @Nonnull Temperature fromText(String text) {
            for (Temperature temp : values()) {
                if (temp.getText().equals(text)) {
                    return temp;
                }
            }
            throw new IllegalArgumentException(text + " is now a valid value");
        }

        public @Nullable Temperature next() {
            if (ordinal() == values().length - 1) {
                return null;
            }

            return values()[ordinal() + 1];
        }

        public @Nullable Temperature prev() {
            if (ordinal() == 0) {
                return null;
            }

            return values()[ordinal() - 1];
        }
    }

    public static final ItemStack TEMPERATURE_BUTTON_LOW = new CustomItemStack(
        Material.YELLOW_STAINED_GLASS_PANE,
        "&7温度: &e低",
        "",
        "&b左键点击 &7提高温度");
    public static final ItemStack TEMPERATURE_BUTTON_MEDIUM = new CustomItemStack(
        Material.ORANGE_STAINED_GLASS_PANE,
        "&7温度: &6中",
        "",
        "&b左键点击 &7提高温度",
        "&b右键点击 &7降低温度");
    public static final ItemStack TEMPERATURE_BUTTON_HIGH = new CustomItemStack(
        Material.RED_STAINED_GLASS_PANE,
        "&7温度: &c高",
        "",
        "&b右键点击 &7降低温度");
    public static final int TEMPERATURE_BUTTON_SLOT = 52;
    public static final String TEMPERATURE_KEY = "gastronomicon:multi_stove/temperature";

    private final int capacity;
    private final int energyPerUse;

    public MultiStove(SlimefunItemStack item, ItemStack[] recipe, int capacity, int energyPerUse) {
        super(item, recipe);

        this.capacity = capacity;
        this.energyPerUse = energyPerUse;
    }

    @Override
    protected void setup(BlockMenuPreset preset) {
        super.setup(preset);

        preset.drawBackground(TEMPERATURE_BUTTON_LOW, new int[] { TEMPERATURE_BUTTON_SLOT });
    }

    @Override
    protected void onNewInstance(BlockMenu menu, Block b) {
        super.onNewInstance(menu, b);

        menu.addMenuOpeningHandler(player -> {
            final String temp = StorageCacheUtils.getData(menu.getLocation(), TEMPERATURE_KEY);
            menu.replaceExistingItem(TEMPERATURE_BUTTON_SLOT,
                temp == null ? TEMPERATURE_BUTTON_LOW : Temperature.valueOf(temp).getItem(), false);
        });

        menu.addMenuClickHandler(TEMPERATURE_BUTTON_SLOT, (player, slot, item, action) -> {
            String temp = CommonPatterns.COLON.split(ChatColor.stripColor(item.getItemMeta().getDisplayName()))[1].trim();
            final Temperature t = Temperature.fromText(temp);
            changeTemperature(menu, action.isRightClicked() ? t.prev() : t.next());
            return false;
        });
    }

    public static void changeTemperature(@Nonnull BlockMenu menu, @Nullable Temperature t) {
        if (t == null) {
            return;
        }
        menu.replaceExistingItem(TEMPERATURE_BUTTON_SLOT, t.getItem());
        StorageCacheUtils.setData(menu.getLocation(), TEMPERATURE_KEY, t.name());
    }

    @Override
    public GastroRecipeType getGastroRecipeType() {
        return GastroRecipeType.MULTI_STOVE;
    }

    @Override
    public EnergyNetComponentType getEnergyComponentType() {
        return EnergyNetComponentType.CONSUMER;
    }

    @Override
    @Nullable
    protected GastroRecipe findRecipe(ItemStack[] ingredients, List<ItemStack> containers, List<ItemStack> tools,
        Player player, BlockMenu menu) {
        final GastroRecipe recipe = super.findRecipe(ingredients, containers, tools, player, menu);
        if (recipe instanceof final MultiStoveRecipe msRecipe) {
            if (msRecipe.getTemperature().getItem().isSimilar(menu.getItemInSlot(TEMPERATURE_BUTTON_SLOT))) {
                return msRecipe;
            } else {
                return null;
            }
        } else {
            return recipe;
        }
    }

    @Override
    protected int getOtherHash(Player player, BlockMenu menu) {
        return menu.getItemInSlot(TEMPERATURE_BUTTON_SLOT).getType().ordinal(); // Doesn't have to be a hash, just
                                                                                // unique
    }

    @Override
    protected boolean canCraft(BlockMenu menu, Block b, Player p) {
        final int charge = getCharge(b.getLocation());
        if (charge < getEnergyPerUse()) return false;

        setCharge(b.getLocation(), charge - getEnergyPerUse());
        return true;
    }

}
