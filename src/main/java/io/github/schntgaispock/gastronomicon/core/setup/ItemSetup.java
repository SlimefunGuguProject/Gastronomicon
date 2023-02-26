package io.github.schntgaispock.gastronomicon.core.setup;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.schntgaispock.gastronomicon.core.items.UnplaceableItem;
import io.github.schntgaispock.gastronomicon.core.items.food.GastroFood;
import io.github.schntgaispock.gastronomicon.core.items.food.SimpleGastroFood;
import io.github.schntgaispock.gastronomicon.core.items.seeds.CropSeed;
import io.github.schntgaispock.gastronomicon.core.items.seeds.DuplicatingSeed;
import io.github.schntgaispock.gastronomicon.core.items.seeds.FruitingSeed;
import io.github.schntgaispock.gastronomicon.core.items.seeds.RightClickSeed;
import io.github.schntgaispock.gastronomicon.core.items.seeds.SimpleSeed;
import io.github.schntgaispock.gastronomicon.core.items.workstations.CulinaryWorkbench;
import io.github.schntgaispock.gastronomicon.core.items.workstations.MultiStove.Temperature;
import io.github.schntgaispock.gastronomicon.core.recipes.GastroRecipe.RecipeShape;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroGroups;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroRecipeType;
import io.github.schntgaispock.gastronomicon.core.slimefun.GastroStacks;
import io.github.schntgaispock.gastronomicon.util.recipe.RecipeUtil;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ItemSetup {

    public static void setup() {

        Gastronomicon gn = Gastronomicon.getInstance();
        if (gn == null) return;

        GastroGroups.MAIN.register(gn);

        final ItemStack OAK_PLANKS = new ItemStack(Material.OAK_PLANKS);
        final ItemStack OAK_SLAB = new ItemStack(Material.OAK_SLAB);
        final ItemStack OAK_FENCE = new ItemStack(Material.OAK_FENCE);
        final ItemStack STICK = new ItemStack(Material.STICK);
        final ItemStack SHEARS = new ItemStack(Material.SHEARS);
        final ItemStack IRON_BARS = new ItemStack(Material.IRON_BARS);
        final ItemStack IRON_NUGGET = new ItemStack(Material.IRON_NUGGET);
        final ItemStack IRON_TRAPDOOR = new ItemStack(Material.IRON_TRAPDOOR);
        final ItemStack BUCKET = new ItemStack(Material.BUCKET);
        final ItemStack BOWL = new ItemStack(Material.BOWL);
        final ItemStack IRON_PP = new ItemStack(Material.HEAVY_WEIGHTED_PRESSURE_PLATE);
        final ItemStack IRON_BLOCK = new ItemStack(Material.IRON_BLOCK);
        final ItemStack HOPPER = new ItemStack(Material.HOPPER);
        final ItemStack BARREL = new ItemStack(Material.BARREL);
        final ItemStack CRAFTING_TABLE = new ItemStack(Material.CRAFTING_TABLE);
        final ItemStack DISPENSER = new ItemStack(Material.DISPENSER);
        final ItemStack BLAST_FURNACE = new ItemStack(Material.BLAST_FURNACE);
        final ItemStack DRIED_KELP = new ItemStack(Material.DRIED_KELP);
        final ItemStack STRING = new ItemStack(Material.STRING);
        final ItemStack COBWEB = new ItemStack(Material.COBWEB);
        final ItemStack POLISHED_GRANITE = new ItemStack(Material.POLISHED_GRANITE);
        final ItemStack ANDESITE_SLAB = new ItemStack(Material.ANDESITE_SLAB);

        // ---- Tools ----

        // -- Workstation Tools --

        // Culinary Workbench
        new UnplaceableItem(
            GastroGroups.TOOLS,
            GastroStacks.CUTTING_BOARD,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            RecipeUtil.row(OAK_SLAB, 2)
        ).register(gn);
        new UnplaceableItem(
            GastroGroups.TOOLS,
            GastroStacks.ROLLING_PIN,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            RecipeUtil.row(STICK, 1)
        ).register(gn);
        new UnplaceableItem(
            GastroGroups.TOOLS,
            GastroStacks.MEAT_SCISSORS,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {null, SlimefunItems.STEEL_INGOT, null, SlimefunItems.STEEL_INGOT, null, SlimefunItems.STEEL_INGOT, SHEARS, SlimefunItems.STEEL_INGOT, null}
        ).register(gn);
        new UnplaceableItem(
            GastroGroups.TOOLS,
            GastroStacks.KITCHEN_KNIFE,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {null, null, null, null, SlimefunItems.STEEL_INGOT, null, null, STICK, null}
        ).register(gn);
        new UnplaceableItem(
            GastroGroups.TOOLS,
            GastroStacks.BLENDER,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {null, SlimefunItems.ELECTRIC_MOTOR, null, null, IRON_BARS, null, null, BUCKET, null}
        ).register(gn);
        new UnplaceableItem(
            GastroGroups.TOOLS,
            GastroStacks.MORTAR_AND_PESTLE,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {null, null, null, null, SlimefunItems.STEEL_INGOT, null, null, BOWL, null}
        ).register(gn);
        new UnplaceableItem(
            GastroGroups.TOOLS,
            GastroStacks.PEELER,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {null, IRON_NUGGET, null, null, IRON_NUGGET, null, null, STICK, null}
        ).register(gn);
        // Enhanced Oven
        new UnplaceableItem(
            GastroGroups.TOOLS,
            GastroStacks.BAKING_TRAY,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {SlimefunItems.STEEL_INGOT, SlimefunItems.STEEL_PLATE, SlimefunItems.STEEL_INGOT, null, null, null, null, null}
        ).register(gn);
        new UnplaceableItem(
            GastroGroups.TOOLS,
            GastroStacks.FRYING_PAN,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {SlimefunItems.STEEL_INGOT, SlimefunItems.STEEL_PLATE, SlimefunItems.STEEL_PLATE, null, null, null, null, null, null}
        ).register(gn);
        new UnplaceableItem(
            GastroGroups.TOOLS,
            GastroStacks.STEEL_POT,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                SlimefunItems.STEEL_INGOT, null, SlimefunItems.STEEL_INGOT,
                SlimefunItems.STEEL_PLATE, null, SlimefunItems.STEEL_PLATE,
                SlimefunItems.STEEL_PLATE, SlimefunItems.STEEL_PLATE, SlimefunItems.STEEL_PLATE
            }
        ).register(gn);

        // -- Traps --

        new SlimefunItem(
            GastroGroups.TOOLS,
            GastroStacks.STEEL_WIRE,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            RecipeUtil.row(SlimefunItems.STEEL_INGOT, 1)
        ).register(gn);
        new SlimefunItem(
            GastroGroups.TOOLS,
            GastroStacks.STEEL_SPRING,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            RecipeUtil.cyclicAlternating(null, GastroStacks.STEEL_WIRE)
        ).register(gn);
        new SlimefunItem(
            GastroGroups.TOOLS,
            GastroStacks.CRAB_TRAP,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {STICK, STICK, STICK, STICK, null, STICK, OAK_SLAB, OAK_SLAB, OAK_SLAB}
        ).register(gn);
        new SlimefunItem(
            GastroGroups.TOOLS,
            GastroStacks.HUNTING_TRAP,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                null, SlimefunItems.STEEL_INGOT, null,
                SlimefunItems.STEEL_INGOT, IRON_PP, SlimefunItems.STEEL_INGOT,
                GastroStacks.STEEL_SPRING, GastroStacks.STEEL_SPRING, GastroStacks.STEEL_SPRING
            }
        ).register(gn);
        new SlimefunItem(
            GastroGroups.TOOLS,
            GastroStacks.FISHING_NET,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            RecipeUtil.cyclicAlternating(STRING, COBWEB, COBWEB)
        ).register(gn);

        // -- Other --

        new SlimefunItem(
            GastroGroups.TOOLS,
            GastroStacks.WOODEN_SICKLE,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                null, OAK_PLANKS, OAK_PLANKS,
                null, STICK, null,
                STICK, null, null
            }
        ).register(gn);

        new SlimefunItem(
            GastroGroups.TOOLS,
            GastroStacks.STEEL_SICKLE,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                null, SlimefunItems.STEEL_PLATE, SlimefunItems.STEEL_PLATE,
                null, STICK, null,
                STICK, null, null
            }
        ).register(gn);

        new SlimefunItem(
            GastroGroups.TOOLS,
            GastroStacks.REINFORCED_SICKLE,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                null, SlimefunItems.REINFORCED_PLATE, SlimefunItems.REINFORCED_PLATE,
                null, STICK, null,
                STICK, null, null
            }
        ).register(gn);
        
        // ---- Basic Machines ----

        new CulinaryWorkbench(
            GastroGroups.MANUAL_WORKSTATIONS,
            GastroStacks.CULINARY_WORKBENCH,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                POLISHED_GRANITE, POLISHED_GRANITE, POLISHED_GRANITE, 
                BARREL, CRAFTING_TABLE, BARREL, 
                IRON_BLOCK, DISPENSER, IRON_BLOCK
            }
        ).register(gn);

        new SlimefunItem(
            GastroGroups.MANUAL_WORKSTATIONS,
            GastroStacks.MULTI_STOVE,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                IRON_PP, IRON_PP, IRON_PP,
                SlimefunItems.HEATING_COIL, BLAST_FURNACE, SlimefunItems.HEATING_COIL,
                SlimefunItems.HEATING_COIL, SlimefunItems.ENERGY_CONNECTOR, SlimefunItems.HEATING_COIL
            }
        ).register(gn);
        
        new SlimefunItem(
            GastroGroups.MANUAL_WORKSTATIONS,
            GastroStacks.REFRIDGERATOR,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                SlimefunItems.STEEL_INGOT, SlimefunItems.COOLING_UNIT, SlimefunItems.STEEL_INGOT,
                SlimefunItems.STEEL_INGOT, IRON_TRAPDOOR, SlimefunItems.STEEL_INGOT,
                SlimefunItems.STEEL_INGOT, SlimefunItems.COOLING_UNIT, SlimefunItems.STEEL_INGOT
            }
        ).register(gn);
        
        new SlimefunItem(
            GastroGroups.MANUAL_WORKSTATIONS,
            GastroStacks.MILL,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                null, HOPPER, null,
                IRON_BARS, SlimefunItems.DAMASCUS_STEEL_INGOT, IRON_BARS,
                null, ANDESITE_SLAB, null
            }
        ).register(gn);
        
        new SlimefunItem(
            GastroGroups.MANUAL_WORKSTATIONS,
            GastroStacks.DISTILLERY,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                OAK_FENCE, OAK_SLAB, OAK_FENCE,
                OAK_FENCE, BARREL, OAK_FENCE,
                OAK_FENCE, BARREL, OAK_FENCE
            }
        ).register(gn);

        // ---- Raw Ingredients ----

        new SimpleSeed(
            GastroStacks.RICE,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new SimpleSeed(
            GastroStacks.QUINOA,
            Material.WHEAT,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new SimpleSeed(
            GastroStacks.OATS,
            Material.WHEAT,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new SimpleSeed(
            GastroStacks.SOYBEANS,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new SlimefunItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.BARLEY,
            GastroRecipeType.HARVEST,
            RecipeUtil.singleCenter(GastroStacks.BARLEY_SEEDS)
        ).register(gn);

        new CropSeed(
            GastroStacks.BARLEY_SEEDS,
            Material.WHEAT,
            GastroStacks.BARLEY
        ).register(gn);

        new SlimefunItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.RYE,
            GastroRecipeType.HARVEST,
            RecipeUtil.singleCenter(GastroStacks.RYE_SEEDS)
        ).register(gn);

        new CropSeed(
            GastroStacks.RYE_SEEDS,
            Material.WHEAT,
            GastroStacks.RYE
        ).register(gn);

        new SlimefunItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.SORGHUM,
            GastroRecipeType.HARVEST,
            RecipeUtil.singleCenter(GastroStacks.SORGHUM_SEEDS)
        ).register(gn);

        new CropSeed(
            GastroStacks.SORGHUM_SEEDS,
            Material.WHEAT,
            GastroStacks.SORGHUM
        ).register(gn);

        new SlimefunItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.TURNIP,
            GastroRecipeType.HARVEST,
            RecipeUtil.singleCenter(GastroStacks.TURNIP_SEEDS)
        ).register(gn);

        new CropSeed(
            GastroStacks.TURNIP_SEEDS,
            Material.BEETROOTS,
            GastroStacks.TURNIP
        ).register(gn);

        new SlimefunItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.SQUASH,
            GastroRecipeType.HARVEST,
            RecipeUtil.singleCenter(GastroStacks.SQUASH_SEEDS)
        ).register(gn);

        new FruitingSeed(
            GastroStacks.SQUASH_SEEDS,
            Material.MELON_STEM,
            GastroStacks.SQUASH,
            "GN_SQUASH"
        ).register(gn);

        new DuplicatingSeed(
            GastroStacks.CELERY,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new RightClickSeed(
            GastroStacks.BOK_CHOY,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new RightClickSeed(
            GastroStacks.SNOW_PEAS,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new RightClickSeed(
            GastroStacks.BROCCOLI,
            Material.CARROTS,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new RightClickSeed(
            GastroStacks.WASABI_PLANT,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new DuplicatingSeed(
            GastroStacks.LEMONGRASS,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new RightClickSeed(
            GastroStacks.CUCUMBER,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new RightClickSeed(
            GastroStacks.BASIL,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new RightClickSeed(
            GastroStacks.SPINACH,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new RightClickSeed(
            GastroStacks.BRUSSLES_SPROUTS,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new RightClickSeed(
            GastroStacks.MINT,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new RightClickSeed(
            GastroStacks.CHILI_PEPPER,
            Material.POTATOES,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new RightClickSeed(
            GastroStacks.PARSLEY,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new SimpleSeed(
            GastroStacks.CASSAVA,
            Material.BEETROOTS,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new SimpleSeed(
            GastroStacks.LENTILS,
            Material.CARROTS,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        // -- Grown from trees

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.LYCHEE,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(GastroStacks.LYCHEE_SAPLING)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.LYCHEE_SAPLING,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.PERSIMMON,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(GastroStacks.PERSIMMON_SAPLING)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.PERSIMMON_SAPLING,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.BANANA,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(GastroStacks.BANANA_SAPLING)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.BANANA_SAPLING,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.VANILLA_BEANS,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(GastroStacks.VANILLA_SAPLING)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.VANILLA_SAPLING,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(Material.GRASS)
        ).register(gn);

        // -- Harvested --

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.FIDDLEHEADS,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(Material.FERN)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.TRUFFLES,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(Material.DIRT)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.ENOKI_MUSHROOMS,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(Material.DIRT)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.KING_OYSTER_MUSHROOM,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(Material.DIRT)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.BUTTON_MUSHROOM,
            GastroRecipeType.BREAK,
            RecipeUtil.singleCenter(Material.DIRT)
        ).register(gn);

        // -- Mob Drops --

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.RAW_CHEVON,
            GastroRecipeType.KILL,
            RecipeUtil.singleCenter(GastroStacks.GUIDE_KILL_GOAT)
        ).register(gn);

        SimpleGastroFood.stove(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.COOKED_CHEVON,
            RecipeUtil.singleCenter(GastroStacks.RAW_CHEVON),
            null,
            Temperature.MEDIUM,
            GastroStacks.FRYING_PAN
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.FROG_LEG,
            GastroRecipeType.KILL,
            RecipeUtil.singleCenter(GastroStacks.GUIDE_KILL_FROG)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.GIANT_SPIDER_LEG,
            GastroRecipeType.KILL,
            RecipeUtil.singleCenter(GastroStacks.GUIDE_KILL_SPIDER)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.SALMON_ROE,
            GastroRecipeType.KILL,
            RecipeUtil.singleCenter(GastroStacks.GUIDE_KILL_SALMON)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.GUARDIAN_FIN,
            GastroRecipeType.KILL,
            RecipeUtil.singleCenter(GastroStacks.GUIDE_KILL_GUARDIAN)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.RAW_SQUID,
            GastroRecipeType.KILL,
            RecipeUtil.singleCenter(GastroStacks.GUIDE_KILL_SQUID)
        ).register(gn);

        SimpleGastroFood.stove(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.COOKED_SQUID,
            RecipeUtil.singleCenter(GastroStacks.RAW_SQUID),
            null,
            Temperature.MEDIUM,
            GastroStacks.FRYING_PAN
        ).register(gn);

        // -- From Fishing --

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.RAW_MACKEREL,
            GastroRecipeType.TRAP,
            RecipeUtil.singleCenter(GastroStacks.FISHING_NET)
        ).register(gn);

        SimpleGastroFood.stove(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.COOKED_MACKEREL,
            RecipeUtil.singleCenter(GastroStacks.RAW_MACKEREL),
            null,
            Temperature.MEDIUM,
            GastroStacks.FRYING_PAN
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.RAW_EEL,
            GastroRecipeType.TRAP,
            RecipeUtil.singleCenter(GastroStacks.FISHING_NET)
        ).register(gn);

        SimpleGastroFood.stove(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.COOKED_EEL,
            RecipeUtil.singleCenter(GastroStacks.RAW_EEL),
            null,
            Temperature.MEDIUM,
            GastroStacks.FRYING_PAN
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.RAW_TROUT,
            GastroRecipeType.TRAP,
            RecipeUtil.singleCenter(GastroStacks.FISHING_NET)
        ).register(gn);

        SimpleGastroFood.stove(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.COOKED_TROUT,
            RecipeUtil.singleCenter(GastroStacks.RAW_TROUT),
            null,
            Temperature.MEDIUM,
            GastroStacks.FRYING_PAN
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.RAW_BASS,
            GastroRecipeType.TRAP,
            RecipeUtil.singleCenter(GastroStacks.FISHING_NET)
        ).register(gn);

        SimpleGastroFood.stove(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.COOKED_BASS,
            RecipeUtil.singleCenter(GastroStacks.RAW_BASS),
            null,
            Temperature.MEDIUM,
            GastroStacks.FRYING_PAN
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.RAW_CARP,
            GastroRecipeType.TRAP,
            RecipeUtil.singleCenter(GastroStacks.FISHING_NET)
        ).register(gn);

        SimpleGastroFood.stove(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.COOKED_CARP,
            RecipeUtil.singleCenter(GastroStacks.RAW_CARP),
            null,
            Temperature.MEDIUM,
            GastroStacks.FRYING_PAN
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.RAW_PIKE,
            GastroRecipeType.TRAP,
            RecipeUtil.singleCenter(GastroStacks.FISHING_NET)
        ).register(gn);

        SimpleGastroFood.stove(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.COOKED_PIKE,
            RecipeUtil.singleCenter(GastroStacks.RAW_PIKE),
            null,
            Temperature.MEDIUM,
            GastroStacks.FRYING_PAN
        ).register(gn);

        // -- From traps --

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.CRAB,
            GastroRecipeType.TRAP,
            RecipeUtil.singleCenter(GastroStacks.CRAB_TRAP)
        ).register(gn);

        new UnplaceableItem(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.RAW_TURKEY,
            GastroRecipeType.TRAP,
            RecipeUtil.singleCenter(GastroStacks.HUNTING_TRAP)
        ).register(gn);

        SimpleGastroFood.stove(
            GastroGroups.RAW_INGREDIENTS,
            GastroStacks.COOKED_TURKEY,
            RecipeUtil.singleCenter(GastroStacks.RAW_TURKEY),
            null,
            Temperature.MEDIUM,
            GastroStacks.FRYING_PAN
        ).register(gn);

        // ---- Food ----

        // -- Ingredients --

        SimpleGastroFood.stove(
            GastroGroups.FOOD,
            GastroStacks.COOKED_RICE,
            RecipeUtil.singleCenter(GastroStacks.RICE),
            null,
            Temperature.MEDIUM
        ).register(gn);

        SimpleGastroFood.mill(
            GastroGroups.FOOD,
            GastroStacks.BARLEY_FLOUR,
            RecipeUtil.singleCenter(GastroStacks.BARLEY)
        ).register(gn);

        // -- Cuisine --

        GastroFood.workbench(
            GastroGroups.FOOD,
            GastroStacks.RICE_BALLS,
            RecipeShape.SHAPELESS,
            RecipeUtil.collection(GastroStacks.COOKED_RICE, DRIED_KELP),
            null
        ).register(gn);
    }
}
