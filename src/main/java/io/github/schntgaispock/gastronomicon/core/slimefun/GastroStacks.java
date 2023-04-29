package io.github.schntgaispock.gastronomicon.core.slimefun;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import io.github.schntgaispock.gastronomicon.api.food.FoodEffect;
import io.github.schntgaispock.gastronomicon.api.items.FoodItemStack;
import io.github.schntgaispock.gastronomicon.api.items.FoodItemStackBuilder;
import io.github.schntgaispock.gastronomicon.api.items.GastroTheme;
import io.github.schntgaispock.gastronomicon.api.items.ThemedItemStack;
import io.github.schntgaispock.gastronomicon.api.loot.LootTable;
import io.github.schntgaispock.gastronomicon.core.Climate;
import io.github.schntgaispock.gastronomicon.core.listeners.WildHarvestListener;
import io.github.schntgaispock.gastronomicon.util.StringUtil;
import io.github.schntgaispock.gastronomicon.util.item.HeadTextures;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineTier;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.HeadTexture;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import lombok.experimental.UtilityClass;
import net.md_5.bungee.api.ChatColor;

@UtilityClass
@SuppressWarnings("deprecation")
public class GastroStacks {

    // ---- Utility ----

    public static final ItemStack WATER_BOTTLE = new ItemStack(Material.POTION);
    static {
        final PotionMeta meta = (PotionMeta) WATER_BOTTLE.getItemMeta();
        final PotionData data = new PotionData(PotionType.WATER);
        meta.setBasePotionData(data);
        WATER_BOTTLE.setItemMeta(meta);
    }

    // ---- Guide Only Items ----

    public static final ItemStack GUIDE_ITEM_TOOLS = new CustomItemStack(
        Material.IRON_HOE,
        GastroTheme.TOOL.getColor() + "工具");

    public static final ItemStack GUIDE_ITEM_BASIC_MACHINES = new CustomItemStack(
        Material.CRAFTING_TABLE,
        GastroTheme.MECHANICAL.getColor() + "基础机器");

    public static final ItemStack GUIDE_ITEM_ELECTRIC_MACHINES = new CustomItemStack(
        Material.FURNACE,
        GastroTheme.ELECTRIC.getColor() + "电力机器");

    public static final ItemStack GUIDE_ITEM_RAW_INGREDIENTS = new CustomItemStack(
        Material.SUGAR,
        GastroTheme.INGREDIENT.getColor() + "原料");

    public static final ItemStack GUIDE_ITEM_FOOD = new CustomItemStack(
        Material.COOKED_BEEF,
        GastroTheme.REGULAR_FOOD.getColor() + "食物");

    public static final ItemStack GUIDE_ITEM_MAIN = new CustomItemStack(
        Material.COOKED_BEEF,
        GastroTheme.PERFECT_FOOD.getColor() + "美食家");

    public static final ItemStack GUIDE_RECIPE_BREAK = new CustomItemStack(
        Material.IRON_PICKAXE,
        "&b破坏方块",
        "&7破坏指定的方块",
        "&7以获取该物品");

    public static final ItemStack GUIDE_RECIPE_HARVEST = new CustomItemStack(
        Material.IRON_HOE,
        "&b收获作物",
        "&7收获指定的作物",
        "&7以获取该物品");

    public static final ItemStack GUIDE_RECIPE_KILL = new CustomItemStack(
        Material.IRON_SWORD,
        "&b击杀生物",
        "&7击杀指定的生物",
        "&7有几率掉落该物品");

    public static final ItemStack GUIDE_RECIPE_TRAP = new CustomItemStack(
        Material.COBWEB,
        "&b陷阱",
        "&7通过指定的陷阱抓捕",
        "&7以获取该物品");

    public static final ItemStack GUIDE_RECIPE_CULINARY_WORKBENCH = new CustomItemStack(
        Material.CRAFTING_TABLE,
        "&b烹饪工作台",
        "&7在烹饪工作台中",
        "&7放入指定的工具与容器",
        "&7来制作该物品");

    public static final ItemStack GUIDE_RECIPE_MULTI_STOVE = new CustomItemStack(
        Material.BLAST_FURNACE,
        "&b多用炉",
        "&7在多用炉中",
        "&7放入指定的工具与容器",
        "&7来制作该物品");

    public static final ItemStack GUIDE_RECIPE_REFRIDGERATOR = new CustomItemStack(
        Material.IRON_BLOCK,
        "&b冰箱",
        "&7在冰箱中",
        "&7放入指定的工具与容器",
        "&7来制作该物品");

    public static final ItemStack GUIDE_RECIPE_MILL = new CustomItemStack(
        Material.CAULDRON,
        "&b磨坊",
        "&7在磨坊中",
        "&7放入指定的工具与容器",
        "&7来制作该物品");

    public static final ItemStack GUIDE_RECIPE_FERMENTER = new CustomItemStack(
        Material.BARREL,
        "&b发酵罐",
        "&7在发酵罐中",
        "&7放入指定的工具与容器",
        "&7来制作该物品");

    public static final ItemStack GUIDE_TOOLS_REQUIRED = new CustomItemStack(
        Material.BLACK_STAINED_GLASS_PANE,
        ChatColor.of("#999999") + "所需工具");

    public static final ItemStack GUIDE_CONTAINER_REQUIRED = new CustomItemStack(
        Material.PURPLE_STAINED_GLASS_PANE,
        "&5所需容器");

    public static final ItemStack GUIDE_BIOME_REQUIRED = new CustomItemStack(
        Material.LIME_STAINED_GLASS_PANE,
        "&a所需生物群系");

    public static final ItemStack GUIDE_CLIMATE_REQUIRED = new CustomItemStack(
        Material.LIGHT_BLUE_STAINED_GLASS_PANE,
        "&b所需环境");

    public static final ItemStack GUIDE_NONE = new CustomItemStack(
        Material.BARRIER,
        "&c无");

    public static final ItemStack GUIDE_KILL_GOAT = new CustomItemStack(
        Material.GOAT_SPAWN_EGG,
        "&f山羊");

    public static final ItemStack GUIDE_KILL_SALMON = new CustomItemStack(
        Material.SALMON_SPAWN_EGG,
        "&f鲑鱼");

    public static final ItemStack GUIDE_KILL_GUARDIAN = new CustomItemStack(
        Material.GUARDIAN_SPAWN_EGG,
        "&f守卫者");

    public static final ItemStack GUIDE_KILL_SQUID = new CustomItemStack(
        Material.SQUID_SPAWN_EGG,
        "&f鱿鱼");

    // ---- Menu Only ----

    public static final ItemStack MENU_BACKGROUND_ITEM = new CustomItemStack(Material.GRAY_STAINED_GLASS_PANE, "");
    public static final ItemStack MENU_INGREDIENT_BORDER = new CustomItemStack(Material.BLUE_STAINED_GLASS_PANE,
        "&9原料");
    public static final ItemStack MENU_CONTAINER_BORDER = new CustomItemStack(Material.PURPLE_STAINED_GLASS_PANE,
        "&5容器");
    public static final ItemStack MENU_TOOL_BORDER = new CustomItemStack(Material.BLACK_STAINED_GLASS_PANE,
        ChatColor.of("#999999") + "工具");
    public static final ItemStack MENU_OUTPUT_BORDER = new CustomItemStack(Material.ORANGE_STAINED_GLASS_PANE,
        "&6输出");
    public static final ItemStack MENU_CRAFT_BUTTON = new CustomItemStack(Material.LIME_STAINED_GLASS_PANE,
        "&a点击合成");
    public static final ItemStack MENU_PROGRESS_BAR = new ItemStack(Material.FLINT_AND_STEEL);
    public static final ItemStack MENU_FOOD_BORDER = new CustomItemStack(Material.CYAN_STAINED_GLASS_PANE,
        "&f食物栏", "", "&7在下方放入食物");
    public static final ItemStack MENU_TRAIN_BUTTON = new CustomItemStack(Material.LIME_STAINED_GLASS_PANE,
        "&a点击训练");
    public static final ItemStack MENU_INPUT_BORDER = new CustomItemStack(Material.BLUE_STAINED_GLASS_PANE,
        "&9输入");
    public static final ItemStack MENU_ANDROID_BORDER = new CustomItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE,
        GastroTheme.ELECTRIC.getColor() + "厨师机器人");
    public static final ItemStack MENU_NOT_ENOUGH_ENERGY = new CustomItemStack(Material.RED_STAINED_GLASS_PANE,
        "&c能量不足");
    public static final ItemStack MENU_NO_ANDROID = new CustomItemStack(Material.RED_STAINED_GLASS_PANE,
        "&c没有机器人");
    public static final ItemStack MENU_INCORRECT_RECIPE = new CustomItemStack(Material.RED_STAINED_GLASS_PANE,
        "&c配方错误");
    public static final ItemStack MENU_NOT_WATERLOGGED = new CustomItemStack(Material.RED_STAINED_GLASS_PANE,
        "&c不在水中");

    // ---- Dummy ----

    public static final ItemStack DUMMY_FISHING_NET = new CustomItemStack(Material.IRON_BARS,
        GastroTheme.ELECTRIC.getColor() + "捕鱼网");

    // ---- Tools ----

    // -- Workstation Tools --

    // Culinary Workbench

    public static final SlimefunItemStack KITCHEN_KNIFE = ThemedItemStack.of(
        GastroTheme.WORKSTATION_TOOL,
        "GN_KITCHEN_KNIFE",
        Material.IRON_SWORD,
        "厨房刀").addFlags(ItemFlag.HIDE_ATTRIBUTES);

    public static final SlimefunItemStack ROLLING_PIN = ThemedItemStack.of(
        GastroTheme.WORKSTATION_TOOL,
        "GN_ROLLING_PIN",
        Material.STICK,
        "擀面杖");

    public static final SlimefunItemStack BLENDER = ThemedItemStack.of(
        GastroTheme.WORKSTATION_TOOL,
        "GN_BLENDER",
        Material.BUCKET,
        "搅拌机");

    public static final SlimefunItemStack MORTAR_AND_PESTLE = ThemedItemStack.of(
        GastroTheme.WORKSTATION_TOOL,
        "GN_MORTAR_AND_PESTLE",
        Material.BOWL,
        "研磨研钵");

    public static final SlimefunItemStack PEELER = ThemedItemStack.of(
        GastroTheme.WORKSTATION_TOOL,
        "GN_PEELER",
        Material.IRON_HOE,
        "剥皮器").addFlags(ItemFlag.HIDE_ATTRIBUTES);

    public static final SlimefunItemStack WHISK = ThemedItemStack.of(
        GastroTheme.WORKSTATION_TOOL,
        "GN_WHISK",
        Material.IRON_SHOVEL,
        "打蛋器").addFlags(ItemFlag.HIDE_ATTRIBUTES);

    public static final SlimefunItemStack DISTILLATION_CHAMBER = ThemedItemStack.of(
        GastroTheme.WORKSTATION_TOOL,
        "GN_DISTILLATION_CHAMBER",
        Material.CAULDRON,
        "蒸馏仓");

    // Enhanced Oven

    public static final SlimefunItemStack BAKING_TRAY = ThemedItemStack.of(
        GastroTheme.WORKSTATION_TOOL,
        "GN_BAKING_TRAY",
        Material.LIGHT_GRAY_CARPET,
        "烘焙盘");

    public static final SlimefunItemStack FRYING_PAN = ThemedItemStack.of(
        GastroTheme.WORKSTATION_TOOL,
        "GN_FRYING_PAN",
        Material.GRAY_CARPET,
        "煎锅");

    public static final SlimefunItemStack STEEL_POT = ThemedItemStack.of(
        GastroTheme.WORKSTATION_TOOL,
        "GN_STEEL_POT",
        Material.CAULDRON,
        "钢锅");

    // -- Containers --

    public static final SlimefunItemStack STEEL_BOWL = ThemedItemStack.of(
        GastroTheme.WORKSTATION_TOOL,
        "GN_STEEL_BOWL",
        Material.BUCKET,
        "钢碗");

    // -- Traps --

    public static final SlimefunItemStack STEEL_WIRE = ThemedItemStack.of(
        GastroTheme.TRAP,
        "GN_STEEL_WIRE",
        Material.STRING,
        "钢丝");

    public static final SlimefunItemStack STEEL_SPRING = ThemedItemStack.of(
        GastroTheme.TRAP,
        "GN_STEEL_SPRING",
        Material.STRING,
        "钢制弹簧");

    public static final SlimefunItemStack CRAB_TRAP = ThemedItemStack.of(
        GastroTheme.TRAP,
        "GN_CRAB_TRAP",
        Material.OAK_TRAPDOOR,
        "捕蟹器",
        "用于捕捉螃蟹.",
        "将其放置在地上,",
        "等白色粒子出现时右键点击");

    public static final SlimefunItemStack HUNTING_TRAP = ThemedItemStack.of(
        GastroTheme.TRAP,
        "GN_HUNTING_TRAP",
        Material.IRON_TRAPDOOR,
        "捕猎器",
        "用于捕捉指定的动物.",
        "将其放置在地上,",
        "等白色粒子出现时右键点击");

    // -- Other --

    public static final SlimefunItemStack CHEFS_HAT = ThemedItemStack.of(
        GastroTheme.TOOL,
        "GN_CHEFS_HAT",
        Material.LEATHER_HELMET,
        "厨师帽");
    static {
        final LeatherArmorMeta meta = (LeatherArmorMeta) CHEFS_HAT.getItemMeta();
        meta.setColor(Color.WHITE);
        CHEFS_HAT.setItemMeta(meta);
    }

    public static final SlimefunItemStack WOODEN_SICKLE = ThemedItemStack.of(
        GastroTheme.TOOL,
        "GN_WOODEN_SICKLE",
        Material.WOODEN_HOE,
        "木镰刀",
        "增加作物掉落");

    public static final SlimefunItemStack STEEL_SICKLE = ThemedItemStack.of(
        GastroTheme.TOOL,
        "GN_STEEL_SICKLE",
        Material.IRON_HOE,
        "钢镰刀",
        "增加作物掉落");

    public static final SlimefunItemStack REINFORCED_SICKLE = ThemedItemStack.of(
        GastroTheme.TOOL,
        "GN_REINFORCED_SICKLE",
        Material.NETHERITE_HOE,
        "强化合金镰刀",
        "增加作物掉落");

    // ---- Basic Machines ----

    public static final SlimefunItemStack CULINARY_WORKBENCH = ThemedItemStack.of(
        GastroTheme.MECHANICAL,
        "GN_CULINARY_WORKBENCH",
        Material.CRAFTING_TABLE,
        "烹饪工作台");

    public static final SlimefunItemStack MULTI_STOVE = ThemedItemStack.of(
        GastroTheme.MECHANICAL,
        "GN_MULTI_STOVE",
        Material.BLAST_FURNACE,
        "多用炉",
        LoreBuilder.powerBuffer(1024),
        LoreBuilder.power(64, " 每次合成"));

    public static final SlimefunItemStack REFRIDGERATOR = ThemedItemStack.of(
        GastroTheme.MECHANICAL,
        "GN_REFRIDGERATOR",
        Material.IRON_BLOCK,
        "冰箱",
        LoreBuilder.powerBuffer(1024),
        LoreBuilder.power(64, " 每次合成"));

    public static final SlimefunItemStack MILL = ThemedItemStack.of(
        GastroTheme.MECHANICAL,
        "GN_MILL",
        Material.CAULDRON,
        "磨坊");

    public static final SlimefunItemStack FERMENTER = ThemedItemStack.of(
        GastroTheme.MECHANICAL,
        "GN_FERMENTER",
        Material.BARREL,
        "发酵罐",
        "&7使用水桶或水瓶",
        "&eShift + 右键点击",
        "&7来填充",
        StringUtil.waterUsed(2000, " 可存储"),
        StringUtil.waterUsed(125, " 每次合成"));

    public static final SlimefunItemStack LARGE_FERMENTER = ThemedItemStack.of(
        GastroTheme.MECHANICAL,
        "GN_LARGE_FERMENTER",
        Material.BARREL,
        "大发酵罐",
        "&7使用水桶或水瓶",
        "&eShift + 右键点击",
        "&7来填充",
        StringUtil.waterUsed(16000, " 可存储"),
        StringUtil.waterUsed(125, " 每次合成"));

    public static final SlimefunItemStack CHEF_ANDROID = ThemedItemStack.of(
        GastroTheme.ELECTRIC,
        "GN_CHEF_ANDROID",
        HeadTexture.PROGRAMMABLE_ANDROID_BUTCHER.getTexture(),
        "厨师机器人");

    public static final SlimefunItemStack CHEF_ANDROID_TRAINER = ThemedItemStack.of(
        GastroTheme.ELECTRIC,
        "GN_CHEF_ANDROID_TRAINER",
        Material.SMITHING_TABLE,
        "厨师机器人训练装置");

    public static final SlimefunItemStack FISHING_NET_I = ThemedItemStack.of(
        GastroTheme.ELECTRIC,
        "GN_FISHING_NET_I",
        Material.IRON_BARS,
        "捕鱼网",
        LoreBuilder.speed(1));

    public static final SlimefunItemStack FISHING_NET_II = ThemedItemStack.of(
        GastroTheme.ELECTRIC,
        "GN_FISHING_NET_II",
        Material.IRON_BARS,
        "捕鱼网 &7- &eII",
        LoreBuilder.speed(2));

    public static final SlimefunItemStack FISHING_NET_III = ThemedItemStack.of(
        GastroTheme.ELECTRIC,
        "GN_FISHING_NET_III",
        Material.IRON_BARS,
        "捕鱼网 &7- &eIII",
        LoreBuilder.speed(4));

    public static final SlimefunItemStack ELECTRIC_KITCHEN_I = ThemedItemStack.of(
        GastroTheme.ELECTRIC,
        "GN_ELECTRIC_KITCHEN_I",
        Material.FURNACE,
        "电动厨房",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
        LoreBuilder.powerBuffer(256),
        LoreBuilder.powerPerSecond(16),
        LoreBuilder.speed(1));

    public static final SlimefunItemStack ELECTRIC_KITCHEN_II = ThemedItemStack.of(
        GastroTheme.ELECTRIC,
        "GN_ELECTRIC_KITCHEN_II",
        Material.FURNACE,
        "电动厨房 &7- &eII",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
        LoreBuilder.powerBuffer(1024),
        LoreBuilder.powerPerSecond(64),
        LoreBuilder.speed(3));

    public static final SlimefunItemStack ELECTRIC_KITCHEN_III = ThemedItemStack.of(
        GastroTheme.ELECTRIC,
        "GN_ELECTRIC_KITCHEN_III",
        Material.FURNACE,
        "电动厨房 &7- &eIII",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
        LoreBuilder.powerBuffer(4096),
        LoreBuilder.powerPerSecond(256),
        LoreBuilder.speed(10));

    // ---- Raw Ingredients ----

    // -- Crops --

    public static final SlimefunItemStack RICE = ThemedItemStack.ingredient(
        "GN_RICE",
        Material.PUMPKIN_SEEDS,
        "大米");

    public static final SlimefunItemStack QUINOA = ThemedItemStack.ingredient(
        "GN_QUINOA",
        Material.PUMPKIN_SEEDS,
        "藜麦");

    public static final SlimefunItemStack OATS = ThemedItemStack.ingredient(
        "GN_OATS",
        Material.BEETROOT_SEEDS,
        "燕麦");

    public static final SlimefunItemStack SOYBEANS = ThemedItemStack.ingredient(
        "GN_SOYBEANS",
        Material.BEETROOT_SEEDS,
        "大豆");

    public static final SlimefunItemStack BARLEY = ThemedItemStack.ingredient(
        "GN_BARLEY",
        Material.WHEAT,
        "大麦");

    public static final SlimefunItemStack BARLEY_SEEDS = ThemedItemStack.ingredient(
        "GN_BARLEY_SEEDS",
        Material.WHEAT_SEEDS,
        "大麦种子");

    public static final SlimefunItemStack RYE = ThemedItemStack.ingredient(
        "GN_RYE",
        Material.WHEAT,
        "黑麦");

    public static final SlimefunItemStack RYE_SEEDS = ThemedItemStack.ingredient(
        "GN_RYE_SEEDS",
        Material.PUMPKIN_SEEDS,
        "黑麦种子");

    public static final SlimefunItemStack SORGHUM = ThemedItemStack.ingredient(
        "GN_SORGHUM",
        Material.WHEAT,
        "高粱");

    public static final SlimefunItemStack SORGHUM_SEEDS = ThemedItemStack.ingredient(
        "GN_SORGHUM_SEEDS",
        Material.BEETROOT_SEEDS,
        "高粱种子");

    public static final SlimefunItemStack TURNIP = ThemedItemStack.ingredient(
        "GN_TURNIP",
        Material.BEETROOT,
        "芜菁");

    public static final SlimefunItemStack TURNIP_SEEDS = ThemedItemStack.ingredient(
        "GN_TURNIP_SEEDS",
        Material.MELON_SEEDS,
        "芜菁种子");

    public static final SlimefunItemStack SQUASH = ThemedItemStack.ingredient(
        "GN_SQUASH",
        Material.MELON,
        "南瓜");

    public static final SlimefunItemStack SQUASH_SEEDS = ThemedItemStack.ingredient(
        "GN_SQUASH_SEEDS",
        Material.PUMPKIN_SEEDS,
        "南瓜种子");

    public static final SlimefunItemStack CELERY = ThemedItemStack.ingredient(
        "GN_CELERY",
        Material.SUGAR_CANE,
        "芹菜");

    public static final SlimefunItemStack BOK_CHOY = ThemedItemStack.ingredient(
        "GN_BOK_CHOY",
        Material.MANGROVE_PROPAGULE,
        "小白菜");

    public static final SlimefunItemStack BOK_CHOY_SEEDS = ThemedItemStack.ingredient(
        "GN_BOK_CHOY_SEEDS",
        Material.MELON_SEEDS,
        "Bok Choy Seeds");

    public static final SlimefunItemStack BROCCOLI = ThemedItemStack.ingredient(
        "GN_BROCCOLI",
        Material.OAK_SAPLING,
        "西兰花");

    public static final SlimefunItemStack BROCCOLI_SEEDS = ThemedItemStack.ingredient(
        "GN_BROCCOLI_SEEDS",
        Material.MELON_SEEDS,
        "西兰花种子");

    public static final SlimefunItemStack CUCUMBER = ThemedItemStack.ingredient(
        "GN_CUCUMBER",
        Material.SEA_PICKLE,
        "黄瓜");

    public static final SlimefunItemStack CUCUMBER_SEEDS = ThemedItemStack.ingredient(
        "GN_CUCUMBER_SEEDS",
        Material.PUMPKIN_SEEDS,
        "黄瓜种子");

    public static final SlimefunItemStack BASIL = ThemedItemStack.ingredient(
        "GN_BASIL",
        Material.KELP,
        "罗勒");

    public static final SlimefunItemStack BASIL_SEEDS = ThemedItemStack.ingredient(
        "GN_BASIL_SEEDS",
        Material.MELON_SEEDS,
        "罗勒种子");

    public static final SlimefunItemStack SPINACH = ThemedItemStack.ingredient(
        "GN_SPINACH",
        Material.BIG_DRIPLEAF,
        "菠菜");

    public static final SlimefunItemStack SPINACH_SEEDS = ThemedItemStack.ingredient(
        "GN_SPINACH_SEEDS",
        Material.BEETROOT_SEEDS,
        "菠菜种子");

    public static final SlimefunItemStack BRUSSLES_SPROUTS = ThemedItemStack.ingredient(
        "GN_BRUSSLES_SPROUTS",
        Material.SMALL_DRIPLEAF,
        "球子甘蓝");

    public static final SlimefunItemStack MINT = ThemedItemStack.ingredient(
        "GN_MINT",
        Material.FERN,
        "薄荷");

    public static final SlimefunItemStack MINT_SEEDS = ThemedItemStack.ingredient(
        "GN_MINT_SEEDS",
        Material.MELON_SEEDS,
        "薄荷种子");

    public static final SlimefunItemStack CHILI_PEPPER = ThemedItemStack.ingredient(
        "GN_CHILI_PEPPER",
        Material.RED_CANDLE,
        "辣椒");

    public static final SlimefunItemStack CHILI_PEPPER_SEEDS = ThemedItemStack.ingredient(
        "GN_CHILI_PEPPER_SEEDS",
        Material.PUMPKIN_SEEDS,
        "辣椒种子");

    public static final SlimefunItemStack PARSLEY = ThemedItemStack.ingredient(
        "GN_PARSLEY",
        Material.SMALL_DRIPLEAF,
        "欧芹");

    public static final SlimefunItemStack PARSLEY_SEEDS = ThemedItemStack.ingredient(
        "GN_PARSLEY_SEEDS",
        Material.MELON_SEEDS,
        "欧芹种子");

    public static final SlimefunItemStack CASSAVA = ThemedItemStack.ingredient(
        "GN_CASSAVA",
        Material.CARROT,
        "木薯");

    public static final SlimefunItemStack LENTILS = ThemedItemStack.ingredient(
        "GN_LENTILS",
        Material.PUMPKIN_SEEDS,
        "小扁豆");

    public static final SlimefunItemStack PEANUTS = ThemedItemStack.ingredient(
        "GN_PEANUTS",
        Material.PUMPKIN_SEEDS,
        "花生");

    public static final SlimefunItemStack BEANS = ThemedItemStack.ingredient(
        "GN_BEANS",
        Material.BEETROOT_SEEDS,
        "豆子");

    public static final SlimefunItemStack PEAS = ThemedItemStack.ingredient(
        "GN_PEAS",
        Material.WHEAT_SEEDS,
        "豌豆");

    public static final SlimefunItemStack ASPARAGUS = ThemedItemStack.ingredient(
        "GN_ASPARAGUS",
        Material.BAMBOO,
        "芦笋");

    public static final SlimefunItemStack ASPARAGUS_SEEDS = ThemedItemStack.ingredient(
        "GN_ASPARAGUS_SEEDS",
        Material.MELON_SEEDS,
        "芦笋种子");

    public static final SlimefunItemStack GREEN_ONION = ThemedItemStack.ingredient(
        "GN_GREEN_ONION",
        Material.MANGROVE_PROPAGULE,
        "葱");

    public static final SlimefunItemStack GREEN_ONION_SEEDS = ThemedItemStack.ingredient(
        "GN_GREEN_ONION_SEEDS",
        Material.MELON_SEEDS,
        "葱种子");

    public static final SlimefunItemStack CAULIFLOWER = ThemedItemStack.ingredient(
        "GN_CAULIFLOWER",
        Material.BIRCH_SAPLING,
        "花椰菜");

    public static final SlimefunItemStack CAULIFLOWER_SEEDS = ThemedItemStack.ingredient(
        "GN_CAULIFLOWER_SEEDS",
        Material.PUMPKIN_SEEDS,
        "花椰菜种子");

    public static final SlimefunItemStack AVOCADO = ThemedItemStack.ingredient(
        "GN_AVOCADO",
        Material.LIME_DYE,
        "牛油果");

    public static final SlimefunItemStack AVOCADO_PIT = ThemedItemStack.ingredient(
        "GN_AVOCADO_PIT",
        Material.DARK_OAK_BUTTON,
        "牛油果核");

    public static final SlimefunItemStack TURMERIC = ThemedItemStack.ingredient(
        "GN_TURMERIC",
        Material.POTATO,
        "姜黄");

    public static final SlimefunItemStack CUMIN_SEEDS = ThemedItemStack.ingredient(
        "GN_CUMIN_SEEDS",
        Material.PUMPKIN_SEEDS,
        "孜然籽");

    public static final SlimefunItemStack RED_BEANS = ThemedItemStack.ingredient(
        "GN_RED_BEANS",
        Material.COCOA_BEANS,
        "红腰豆");

    public static final SlimefunItemStack CANTALOUPE = ThemedItemStack.ingredient(
        "GN_CANTALOUPE",
        Material.MELON,
        "哈密瓜");

    public static final SlimefunItemStack CANTALOUPE_SEEDS = ThemedItemStack.ingredient(
        "GN_CANTALOUPE_SEEDS",
        Material.PUMPKIN_SEEDS,
        "哈密瓜种子");

    public static final SlimefunItemStack HONEYDEW_MELON = ThemedItemStack.ingredient(
        "GN_HONEYDEW_MELON",
        Material.MELON,
        "香瓜");

    public static final SlimefunItemStack HONEYDEW_MELON_SEEDS = ThemedItemStack.ingredient(
        "GN_HONEYDEW_MELON_SEEDS",
        Material.PUMPKIN_SEEDS,
        "香瓜种子");

    public static final SlimefunItemStack SESAME_SEEDS = ThemedItemStack.ingredient(
        "GN_SESAME_SEEDS",
        Material.PUMPKIN_SEEDS,
        "芝麻籽");

    public static final SlimefunItemStack VANILLA_BEANS = ThemedItemStack.ingredient(
        "GN_VANILLA_BEANS",
        HeadTextures.VANILLA,
        "香草豆");

    public static final SlimefunItemStack VANILLA_PLANT = ThemedItemStack.ingredient(
        "GN_VANILLA_PLANT",
        Material.VINE,
        "香草种子");

    // -- Grown from trees --

    public static final SlimefunItemStack LYCHEE = ThemedItemStack.ingredient(
        "GN_LYCHEE",
        HeadTextures.LYCHEE,
        "荔枝");
    public static final SlimefunItemStack LYCHEE_SAPLING = ThemedItemStack.ingredient(
        "GN_LYCHEE_SAPLING",
        Material.OAK_SAPLING,
        "荔枝树苗");
    public static final SlimefunItemStack BANANA = ThemedItemStack.ingredient(
        "GN_BANANA",
        HeadTextures.BANANA,
        "香蕉");
    public static final SlimefunItemStack BANANA_SAPLING = ThemedItemStack.ingredient(
        "GN_BANANA_SAPLING",
        Material.OAK_SAPLING,
        "香蕉树苗");

    // -- Harvested --

    public static final SlimefunItemStack FIDDLEHEADS = ThemedItemStack.ingredient(
        "GN_FIDDLEHEADS",
        Material.FERN,
        "蕨菜");

    public static final SlimefunItemStack TRUFFLE = ThemedItemStack.ingredient(
        "GN_TRUFFLE",
        Material.BROWN_MUSHROOM,
        "松露");

    public static final SlimefunItemStack ENOKI_MUSHROOMS = ThemedItemStack.ingredient(
        "GN_ENOKI_MUSHROOMS",
        Material.BROWN_MUSHROOM,
        "金针菇");

    public static final SlimefunItemStack KING_OYSTER_MUSHROOM = ThemedItemStack.ingredient(
        "GN_KING_OYSTER_MUSHROOM",
        Material.BROWN_MUSHROOM,
        "杏鮑菇");

    public static final SlimefunItemStack BUTTON_MUSHROOM = ThemedItemStack.ingredient(
        "GN_BUTTON_MUSHROOM",
        Material.BROWN_MUSHROOM,
        "纽扣蘑菇");

    public static final SlimefunItemStack CLAM = ThemedItemStack.ingredient(
        "GN_CLAM",
        Material.NAUTILUS_SHELL,
        "蛤");

    // -- Dropped from mobs --

    public static final SlimefunItemStack RAW_CHEVON = ThemedItemStack.ingredient(
        "GN_RAW_CHEVON",
        Material.MUTTON,
        "生山羊肉");

    public static final SlimefunItemStack COOKED_CHEVON = ThemedItemStack.ingredient(
        "GN_COOKED_CHEVON",
        Material.COOKED_MUTTON,
        "熟山羊肉");

    public static final SlimefunItemStack SALMON_ROE = ThemedItemStack.ingredient(
        "GN_SALMON_ROE",
        Material.PUMPKIN_SEEDS,
        "鲑鱼子");

    public static final SlimefunItemStack GUARDIAN_FIN = ThemedItemStack.ingredient(
        "GN_GUARDIAN_FIN",
        Material.PRISMARINE_SHARD,
        "守护者鳍");

    public static final SlimefunItemStack RAW_SQUID = ThemedItemStack.ingredient(
        "GN_RAW_SQUID",
        Material.PORKCHOP,
        "生鱿鱼");

    public static final SlimefunItemStack COOKED_SQUID = ThemedItemStack.ingredient(
        "GN_COOKED_SQUID",
        Material.COOKED_PORKCHOP,
        "熟鱿鱼");

    // -- From fishing --

    public static final SlimefunItemStack RAW_MACKEREL = ThemedItemStack.ingredient(
        "GN_RAW_MACKEREL",
        Material.COD,
        "生鲭鱼");
    public static final SlimefunItemStack COOKED_MACKEREL = ThemedItemStack.ingredient(
        "GN_COOKED_MACKEREL",
        Material.COOKED_COD,
        "熟鲭鱼");

    public static final SlimefunItemStack RAW_EEL = ThemedItemStack.ingredient(
        "GN_RAW_EEL",
        Material.SALMON,
        "生鳗鱼");
    public static final SlimefunItemStack COOKED_EEL = ThemedItemStack.ingredient(
        "GN_COOKED_EEL",
        Material.COOKED_SALMON,
        "熟鳗鱼");

    public static final SlimefunItemStack RAW_TROUT = ThemedItemStack.ingredient(
        "GN_RAW_TROUT",
        Material.COD,
        "生鳟鱼");
    public static final SlimefunItemStack COOKED_TROUT = ThemedItemStack.ingredient(
        "GN_COOKED_TROUT",
        Material.COOKED_COD,
        "熟鳟鱼");

    public static final SlimefunItemStack RAW_BASS = ThemedItemStack.ingredient(
        "GN_RAW_BASS",
        Material.COD,
        "生鲈鱼");
    public static final SlimefunItemStack COOKED_BASS = ThemedItemStack.ingredient(
        "GN_COOKED_BASS",
        Material.COOKED_COD,
        "熟鲈鱼");

    public static final SlimefunItemStack RAW_CARP = ThemedItemStack.ingredient(
        "GN_RAW_CARP",
        Material.COD,
        "生鲤鱼");
    public static final SlimefunItemStack COOKED_CARP = ThemedItemStack.ingredient(
        "GN_COOKED_CARP",
        Material.COOKED_COD,
        "熟鲤鱼");

    public static final SlimefunItemStack RAW_PIKE = ThemedItemStack.ingredient(
        "GN_RAW_PIKE",
        Material.COD,
        "生梭鱼");
    public static final SlimefunItemStack COOKED_PIKE = ThemedItemStack.ingredient(
        "GN_COOKED_PIKE",
        Material.COOKED_COD,
        "熟梭鱼");

    public static final SlimefunItemStack RAW_TUNA = ThemedItemStack.ingredient(
        "GN_RAW_TUNA",
        Material.COD,
        "生金枪鱼");

    public static final SlimefunItemStack COOKED_TUNA = ThemedItemStack.ingredient(
        "GN_COOKED_TUNA",
        Material.COOKED_COD,
        "熟金枪鱼");

    public static final SlimefunItemStack SHRIMP = ThemedItemStack.ingredient(
        "GN_SHRIMP",
        Material.COD,
        "虾");

    static {
        final LootTable<ItemStack> DRY_CLIMATE_GRASS_DROPS = LootTable.builder(ItemStack.class)
            .add(GastroStacks.CASSAVA,
                GastroStacks.LENTILS,
                GastroStacks.CUMIN_SEEDS,
                GastroStacks.HONEYDEW_MELON_SEEDS)
            .build();
        final LootTable<ItemStack> TEMPERATE_CLIMATE_GRASS_DROPS = LootTable.builder(ItemStack.class)
            .add(6,
                GastroStacks.RICE,
                GastroStacks.OATS,
                GastroStacks.SOYBEANS,
                GastroStacks.BARLEY_SEEDS,
                GastroStacks.RYE_SEEDS)
            .add(4,
                GastroStacks.TURNIP_SEEDS,
                GastroStacks.RED_BEANS,
                GastroStacks.CANTALOUPE_SEEDS,
                GastroStacks.HONEYDEW_MELON_SEEDS,
                GastroStacks.SESAME_SEEDS,
                GastroStacks.PEANUTS,
                GastroStacks.PEAS)
            .add(3,
                GastroStacks.BOK_CHOY_SEEDS,
                GastroStacks.CUCUMBER_SEEDS,
                GastroStacks.BASIL_SEEDS,
                GastroStacks.SPINACH_SEEDS,
                GastroStacks.MINT_SEEDS,
                GastroStacks.CHILI_PEPPER_SEEDS,
                GastroStacks.PARSLEY_SEEDS,
                GastroStacks.CASSAVA,
                GastroStacks.LENTILS,
                GastroStacks.ASPARAGUS_SEEDS,
                GastroStacks.GREEN_ONION_SEEDS,
                GastroStacks.CAULIFLOWER_SEEDS,
                GastroStacks.AVOCADO_PIT,
                GastroStacks.TURMERIC,
                GastroStacks.CUMIN_SEEDS,
                GastroStacks.VANILLA_PLANT)
            .add(2,
                GastroStacks.LYCHEE_SAPLING,
                GastroStacks.BANANA_SAPLING)
            .build();
        final LootTable<ItemStack> COLD_CLIMATE_GRASS_DROPS = LootTable.builder(ItemStack.class)
            .add(6,
                GastroStacks.QUINOA,
                GastroStacks.OATS,
                GastroStacks.RYE_SEEDS)
            .add(4,
                GastroStacks.TURNIP_SEEDS,
                GastroStacks.SQUASH_SEEDS,
                GastroStacks.PEAS)
            .add(3,
                GastroStacks.CELERY,
                GastroStacks.BROCCOLI_SEEDS,
                GastroStacks.BRUSSLES_SPROUTS)
            .add(2,
                GastroStacks.LYCHEE_SAPLING)
            .build();
        final LootTable<ItemStack> SNOWY_CLIMATE_GRASS_DROPS = LootTable.builder(ItemStack.class)
            .add(GastroStacks.RYE_SEEDS)
            .build();
        final LootTable<ItemStack> FERN_DROPS = LootTable.builder(ItemStack.class)
            .add(GastroStacks.FIDDLEHEADS)
            .build();
        final LootTable<ItemStack> DIRT_DROPS = LootTable.builder(ItemStack.class)
            .add(GastroStacks.ENOKI_MUSHROOMS,
                GastroStacks.KING_OYSTER_MUSHROOM,
                GastroStacks.BUTTON_MUSHROOM)
            .build();
        final LootTable<ItemStack> PODZOL_DROPS = LootTable.builder(ItemStack.class)
            .add(4,
                GastroStacks.ENOKI_MUSHROOMS,
                GastroStacks.KING_OYSTER_MUSHROOM,
                GastroStacks.BUTTON_MUSHROOM)
            .add(GastroStacks.TRUFFLE)
            .build();
        final LootTable<ItemStack> SEAGRASS_DROPS = LootTable.builder(ItemStack.class)
            .add(GastroStacks.CLAM)
            .build();

        final LootTable<ItemStack> SQUID_DROPS = LootTable.builder(ItemStack.class)
            .add(GastroStacks.RAW_SQUID)
            .build();
        final LootTable<ItemStack> GUARDIAN_DROPS = LootTable.builder(ItemStack.class)
            .add(GastroStacks.GUARDIAN_FIN)
            .build();
        final LootTable<ItemStack> GOAT_DROPS = LootTable.builder(ItemStack.class)
            .add(GastroStacks.RAW_CHEVON)
            .build();
        final LootTable<ItemStack> SALMON_DROPS = LootTable.builder(ItemStack.class)
            .add(GastroStacks.SALMON_ROE)
            .build();

        WildHarvestListener.registerBlockDrops(Material.GRASS, DRY_CLIMATE_GRASS_DROPS, Climate.DRY);
        WildHarvestListener.registerBlockDrops(Material.TALL_GRASS, DRY_CLIMATE_GRASS_DROPS, Climate.DRY);
        WildHarvestListener.registerBlockDrops(Material.GRASS, TEMPERATE_CLIMATE_GRASS_DROPS, Climate.TEMPERATE);
        WildHarvestListener.registerBlockDrops(Material.TALL_GRASS, TEMPERATE_CLIMATE_GRASS_DROPS, Climate.TEMPERATE);
        WildHarvestListener.registerBlockDrops(Material.GRASS, COLD_CLIMATE_GRASS_DROPS, Climate.COLD);
        WildHarvestListener.registerBlockDrops(Material.TALL_GRASS, COLD_CLIMATE_GRASS_DROPS, Climate.COLD);
        WildHarvestListener.registerBlockDrops(Material.GRASS, SNOWY_CLIMATE_GRASS_DROPS, Climate.SNOWY);
        WildHarvestListener.registerBlockDrops(Material.TALL_GRASS, SNOWY_CLIMATE_GRASS_DROPS, Climate.SNOWY);
        WildHarvestListener.registerBlockDrops(Material.FERN, FERN_DROPS);
        WildHarvestListener.registerBlockDrops(Material.LARGE_FERN, FERN_DROPS);
        WildHarvestListener.registerBlockDrops(Material.PODZOL, PODZOL_DROPS);
        WildHarvestListener.registerBlockDrops(Material.DIRT, DIRT_DROPS);
        WildHarvestListener.registerBlockDrops(Material.GRASS_BLOCK, DIRT_DROPS);
        WildHarvestListener.registerBlockDrops(Material.ROOTED_DIRT, DIRT_DROPS);
        WildHarvestListener.registerBlockDrops(Material.MYCELIUM, DIRT_DROPS);
        WildHarvestListener.registerBlockDrops(Material.SEAGRASS, SEAGRASS_DROPS);
        WildHarvestListener.registerMobDrops(EntityType.SQUID, SQUID_DROPS);
        WildHarvestListener.registerMobDrops(EntityType.GUARDIAN, GUARDIAN_DROPS);
        WildHarvestListener.registerMobDrops(EntityType.GOAT, GOAT_DROPS);
        WildHarvestListener.registerMobDrops(EntityType.SALMON, SALMON_DROPS);
    }

    // -- From traps --

    public static final SlimefunItemStack CRAB = ThemedItemStack.ingredient(
        "GN_CRAB",
        Material.RED_DYE,
        "螃蟹");

    public static final SlimefunItemStack RAW_TURKEY = ThemedItemStack.ingredient(
        "GN_RAW_TURKEY",
        Material.CHICKEN,
        "生火鸡");
    public static final SlimefunItemStack COOKED_TURKEY = ThemedItemStack.ingredient(
        "GN_COOKED_TURKEY",
        Material.COOKED_CHICKEN,
        "熟火鸡");

    // ---- Food ----

    // -- Ingredients --

    public static final SlimefunItemStack COOKED_RICE = ThemedItemStack.ingredient(
        "GN_COOKED_RICE",
        Material.SUGAR,
        "米饭");

    public static final SlimefunItemStack BARLEY_FLOUR = ThemedItemStack.ingredient(
        "GN_BARLEY_FLOUR",
        Material.SUGAR,
        "大麦粉");

    public static final SlimefunItemStack SORGHUM_FLOUR = ThemedItemStack.ingredient(
        "GN_SORGHUM_FLOUR",
        Material.SUGAR,
        "高粱粉");

    public static final SlimefunItemStack RYE_FLOUR = ThemedItemStack.ingredient(
        "GN_RYE_FLOUR",
        Material.SUGAR,
        "黑麦面粉");

    public static final SlimefunItemStack DOUGH = ThemedItemStack.ingredient(
        "GN_DOUGH",
        Material.POTATO,
        "面团");

    public static final SlimefunItemStack TOAST = ThemedItemStack.ingredient(
        "GN_TOAST",
        Material.BREAD,
        "吐司");

    public static final SlimefunItemStack NAAN_BREAD = ThemedItemStack.ingredient(
        "GN_NAAN_BREAD",
        Material.BREAD,
        "印度烤饼");

    public static final SlimefunItemStack PEANUT_BUTTER = ThemedItemStack.ingredient(
        "GN_PEANUT_BUTTER",
        Material.POTION,
        "花生酱");
    static {
        final PotionMeta meta = (PotionMeta) PEANUT_BUTTER.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.THICK));
        meta.setColor(Color.fromRGB(0xbf7715));
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_POTION_EFFECTS);
        PEANUT_BUTTER.setItemMeta(meta);
    }

    public static final SlimefunItemStack FRIED_EGG = ThemedItemStack.ingredient(
        "GN_FRIED_EGG",
        Material.EGG,
        "煎蛋");

    public static final SlimefunItemStack HARD_BOILED_EGG = ThemedItemStack.ingredient(
        "GN_HARD_BOILED_EGG",
        Material.EGG,
        "水煮蛋");

    public static final SlimefunItemStack SCRAMBLED_EGGS = ThemedItemStack.ingredient(
        "GN_SCRAMBLED_EGGS",
        Material.YELLOW_DYE,
        "炒滑蛋");

    public static final SlimefunItemStack CUSTARD = ThemedItemStack.ingredient(
        "GN_CUSTARD",
        Material.YELLOW_DYE,
        "蛋奶冻");

    public static final SlimefunItemStack CARAMEL = ThemedItemStack.ingredient(
        "GN_CARAMEL",
        Material.BROWN_DYE,
        "焦糖");

    public static final SlimefunItemStack MARMALADE = ThemedItemStack.ingredient(
        "GN_MARMALADE",
        Material.HONEY_BOTTLE,
        "柑橘酱");

    public static final SlimefunItemStack KETCHUP = ThemedItemStack.ingredient(
        "GN_KETCHUP",
        Material.POTION,
        "蕃茄酱");
    static {
        final PotionMeta meta = (PotionMeta) KETCHUP.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.WATER));
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setColor(Color.RED);
        KETCHUP.setItemMeta(meta);
    }

    public static final SlimefunItemStack PULLED_PORK = ThemedItemStack.ingredient(
        "GN_PULLED_PORK",
        Material.BROWN_DYE,
        "撕猪肉");

    public static final SlimefunItemStack GROUND_BEEF = ThemedItemStack.ingredient(
        "GN_GROUND_BEEF",
        Material.BROWN_DYE,
        "碎牛肉");

    public static final SlimefunItemStack BAKED_BEANS = ThemedItemStack.ingredient(
        "GN_BAKED_BEANS",
        Material.BEETROOT_SEEDS,
        "焗豆");

    public static final SlimefunItemStack MISO = ThemedItemStack.ingredient(
        "GN_MISO",
        Material.GLOWSTONE_DUST,
        "味噌");

    public static final SlimefunItemStack TOFU = ThemedItemStack.ingredient(
        "GN_TOFU",
        Material.BIRCH_BUTTON,
        "豆腐");

    public static final SlimefunItemStack SOY_SAUCE = ThemedItemStack.ingredient(
        "GN_SOY_SAUCE",
        Material.POTION,
        "酱油");
    static {
        final PotionMeta meta = (PotionMeta) SOY_SAUCE.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.MUNDANE));
        meta.setColor(Color.fromRGB(0x1d0a03));
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_POTION_EFFECTS);
        SOY_SAUCE.setItemMeta(meta);
    }

    public static final SlimefunItemStack TURMERIC_POWDER = ThemedItemStack.ingredient(
        "GN_TURMERIC_POWDER",
        Material.GLOWSTONE_DUST,
        "姜黄粉");

    public static final SlimefunItemStack RED_BEAN_PASTE = ThemedItemStack.ingredient(
        "GN_RED_BEAN_PASTE",
        Material.RED_DYE,
        "红豆沙");

    public static final SlimefunItemStack TAPIOCA_STARCH = ThemedItemStack.ingredient(
        "GN_TAPIOCA_STARCH",
        Material.SUGAR,
        "木薯淀粉");

    public static final SlimefunItemStack TAPIOCA_PEARLS = ThemedItemStack.ingredient(
        "GN_TAPIOCA_PEARLS",
        Material.PRISMARINE_CRYSTALS,
        "珍珠粉圆");

    // -- Cuisine --

    // Sandwiches

    public static final FoodItemStack PBJ_SANDWICH = new FoodItemStackBuilder()
        .id("GN_PBJ_SANDWICH")
        .texture(HeadTextures.SANDWICH_RED_OCHRE)
        .name("花生果酱三明治")
        .hunger(8)
        .effects(FoodEffect.chanceOf(FoodEffect.positivePotionEffect(PotionEffectType.INCREASE_DAMAGE, 90), 0.5))
        .build();

    public static final FoodItemStack MARMALADE_SANDWICH = new FoodItemStackBuilder()
        .id("GN_MARMALADE_SANDWICH")
        .texture(HeadTextures.SANDWICH_ORANGE)
        .name("果酱三明治")
        .hunger(8)
        .effects(FoodEffect.positivePotionEffect(PotionEffectType.INCREASE_DAMAGE, 30))
        .build();

    public static final FoodItemStack BAKED_BEANS_AND_TOAST = new FoodItemStackBuilder()
        .id("GN_BAKED_BEANS_AND_TOAST")
        .texture(HeadTextures.TOAST_ORANGE)
        .name("烤豆吐司")
        .hunger(8)
        .effects(FoodEffect.chanceOf(FoodEffect.positivePotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 90), 0.5))
        .build();

    public static final FoodItemStack AVOCADO_TOAST = new FoodItemStackBuilder()
        .id("GN_AVOCADO_TOAST")
        .texture(HeadTextures.TOAST_GREEN)
        .name("牛油果吐司")
        .hunger(8)
        .effects(FoodEffect.chanceOf(FoodEffect.positivePotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 90), 0.5))
        .build();

    public static final FoodItemStack TUNA_SANDWICH = new FoodItemStackBuilder()
        .id("GN_TUNA_SANDWICH")
        .texture(HeadTextures.SANDWICH_RED_GREEN)
        .name("金枪鱼三明治")
        .hunger(8)
        .effects(FoodEffect.positivePotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 30))
        .build();

    public static final FoodItemStack BREAKFAST_SANDWICH = new FoodItemStackBuilder()
        .id("GN_BREAKFAST_SANDWICH")
        .texture(HeadTextures.SANDWICH_ORANGE)
        .name("早餐三明治")
        .hunger(8)
        .effects(FoodEffect.chanceOf(FoodEffect.positivePotionEffect(PotionEffectType.REGENERATION, 90), 0.5))
        .build();

    public static final FoodItemStack HAM_SANDWICH = new FoodItemStackBuilder()
        .id("GN_HAM_SANDWICH")
        .texture(HeadTextures.SANDWICH_ORANGE)
        .name("火腿三明治")
        .hunger(8)
        .effects(FoodEffect.positivePotionEffect(PotionEffectType.REGENERATION, 30))
        .build();

    public static final FoodItemStack EGG_SALAD_SANDWICH = new FoodItemStackBuilder()
        .id("GN_EGG_SALAD_SANDWICH")
        .texture(HeadTextures.SANDWICH_WHITE_GREEN)
        .name("鸡蛋沙拉三明治")
        .hunger(8)
        .effects(FoodEffect.positivePotionEffect(PotionEffectType.SPEED, 30))
        .build();

    public static final FoodItemStack ROAST_BEEF_SANDWICH = new FoodItemStackBuilder()
        .id("GN_ROAST_BEEF_SANDWICH")
        .texture(HeadTextures.SANDWICH_RED_GREEN)
        .name("烤牛肉三明治")
        .hunger(8)
        .effects(FoodEffect.chanceOf(FoodEffect.positivePotionEffect(PotionEffectType.SPEED, 90), 0.5))
        .build();

    // Salads

    public static final FoodItemStack GREEK_SALAD = new FoodItemStackBuilder()
        .id("GN_GREEK_SALAD")
        .texture(HeadTextures.SALAD)
        .name("希腊沙拉")
        .hunger(7)
        .effects(
            FoodEffect.heal(1),
            FoodEffect.positivePotionEffect(PotionEffectType.ABSORPTION, 30))
        .build();

    public static final FoodItemStack CAESAR_SALAD = new FoodItemStackBuilder()
        .id("GN_CAESAR_SALAD")
        .texture(HeadTextures.SALAD)
        .name("凯撒沙拉")
        .hunger(7)
        .effects(
            FoodEffect.heal(1),
            FoodEffect.positivePotionEffect(PotionEffectType.ABSORPTION, 30))
        .build();

    public static final FoodItemStack FIDDLEHEAD_SALAD = new FoodItemStackBuilder()
        .id("GN_FIDDLEHEAD_SALAD")
        .texture(HeadTextures.SALAD)
        .name("蕨菜沙拉")
        .hunger(7)
        .effects(
            FoodEffect.heal(1),
            FoodEffect.positivePotionEffect(PotionEffectType.ABSORPTION, 30))
        .build();

    // Fried

    public static final FoodItemStack PAN_SEARED_SALMON = new FoodItemStackBuilder()
        .id("GN_PAN_SEARED_SALMON")
        .material(Material.COOKED_SALMON)
        .name("奶油香煎鲑鱼")
        .hunger(7)
        .build();

    public static final FoodItemStack FRIED_SHRIMP = new FoodItemStackBuilder()
        .id("GN_FRIED_SHRIMP")
        .material(Material.NAUTILUS_SHELL)
        .name("炸虾")
        .hunger(3)
        .effects(FoodEffect.positivePotionEffect(PotionEffectType.ABSORPTION, 30))
        .build();

    public static final FoodItemStack TEMPURA_SHRIMP = new FoodItemStackBuilder()
        .id("GN_TEMPURA_SHRIMP")
        .material(Material.NAUTILUS_SHELL)
        .name("天妇罗虾")
        .hunger(4)
        .effects(FoodEffect.positivePotionEffect(PotionEffectType.ABSORPTION, 30))
        .build();

    public static final FoodItemStack TEMPURA_BROCCOLI = new FoodItemStackBuilder()
        .id("GN_TEMPURA_BROCCOLI")
        .material(Material.BAKED_POTATO)
        .name("天妇罗西兰花")
        .hunger(3)
        .effects(FoodEffect.positivePotionEffect(PotionEffectType.ABSORPTION, 30))
        .build();

    public static final FoodItemStack FRIED_CALAMARI = new FoodItemStackBuilder()
        .id("GN_FRIED_CALAMARI")
        .material(Material.COOKED_CHICKEN)
        .name("炸鱿鱼")
        .hunger(5)
        .build();

    // Pastas

    public static final FoodItemStack CHICKEN_PESTO_PASTA = new FoodItemStackBuilder()
        .id("GN_CHICKEN_PESTO_PASTA")
        .texture(HeadTextures.PASTA_GREEN)
        .name("鸡肉香蒜酱意面")
        .hunger(14)
        .effects(FoodEffect.removePotionEffect(PotionEffectType.WEAKNESS))
        .build();

    public static final FoodItemStack SQUID_INK_PASTA = new FoodItemStackBuilder()
        .id("GN_SQUID_INK_PASTA")
        .texture(HeadTextures.PASTA_BLACK)
        .name("鱿鱼汁意面")
        .hunger(14)
        .build();

    public static final FoodItemStack GLOWING_SQUID_INK_PASTA = new FoodItemStackBuilder()
        .id("GN_GLOWING_SQUID_INK_PASTA")
        .texture(HeadTextures.PASTA_BLACK)
        .name("发光鱿鱼汁意面")
        .hunger(14)
        .effects(FoodEffect.positivePotionEffect(PotionEffectType.GLOWING, 120, 0))
        .build();

    public static final FoodItemStack TUNA_CASSEROLE = new FoodItemStackBuilder()
        .id("GN_TUNA_CASSEROLE")
        .texture(HeadTextures.PASTA_GREEN)
        .name("金枪鱼砂锅")
        .hunger(14, 1)
        .effects(FoodEffect.positivePotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20, 1))
        .build();

    public static final FoodItemStack CHICKEN_RAVIOLI = new FoodItemStackBuilder()
        .id("GN_CHICKEN_RAVIOLI")
        .texture(HeadTextures.PASTA_RED)
        .name("鸡肉馅意大利饺子")
        .hunger(12)
        .effects(FoodEffect.removePotionEffect(PotionEffectType.WEAKNESS))
        .build();

    public static final FoodItemStack MUSHROOM_RAVIOLI = new FoodItemStackBuilder()
        .id("GN_MUSHROOM_RAVIOLI")
        .texture(HeadTextures.PASTA_RED)
        .name("蘑菇馅意大利饺子")
        .hunger(12)
        .effects(FoodEffect.removePotionEffect(PotionEffectType.WEAKNESS))
        .build();

    // Soups and Stews

    public static final FoodItemStack OATMEAL = new FoodItemStackBuilder()
        .id("GN_OATMEAL")
        .texture(HeadTextures.PORRIDGE)
        .name("燕麦片")
        .hunger(10, 1.25)
        .effects(
            FoodEffect.removePotionEffect(PotionEffectType.POISON),
            FoodEffect.removePotionEffect(PotionEffectType.HUNGER))
        .build();

    public static final FoodItemStack BARLEY_PORRIDGE = new FoodItemStackBuilder()
        .id("GN_BARLEY_PORRIDGE")
        .texture(HeadTextures.PORRIDGE)
        .name("大麦粥")
        .hunger(10, 1.25)
        .effects(
            FoodEffect.removePotionEffect(PotionEffectType.POISON),
            FoodEffect.removePotionEffect(PotionEffectType.HUNGER))
        .build();

    public static final FoodItemStack CONGEE = new FoodItemStackBuilder()
        .id("GN_CONGEE")
        .texture(HeadTextures.PORRIDGE)
        .name("粥")
        .hunger(10, 1.25)
        .effects(
            FoodEffect.removePotionEffect(PotionEffectType.POISON),
            FoodEffect.removePotionEffect(PotionEffectType.HUNGER))
        .build();

    public static final FoodItemStack CHICKEN_SOUP = new FoodItemStackBuilder()
        .id("GN_CHICKEN_SOUP")
        .texture(HeadTextures.SOUP)
        .name("鸡汤")
        .hunger(12, 1.25)
        .effects(
            FoodEffect.removePotionEffect(PotionEffectType.POISON),
            FoodEffect.removePotionEffect(PotionEffectType.HUNGER))
        .build();

    public static final FoodItemStack CHICKEN_AND_QUINOA_SOUP = new FoodItemStackBuilder()
        .id("GN_CHICKEN_AND_QUINOA_SOUP")
        .texture(HeadTextures.SOUP)
        .name("鸡肉和藜麦汤")
        .hunger(14, 1.25)
        .effects(
            FoodEffect.removePotionEffect(PotionEffectType.POISON),
            FoodEffect.removePotionEffect(PotionEffectType.HUNGER))
        .build();

    public static final FoodItemStack CHICKEN_NOODLE_SOUP = new FoodItemStackBuilder()
        .id("GN_CHICKEN_NOODLE_SOUP")
        .texture(HeadTextures.SOUP)
        .name("鸡肉面汤")
        .hunger(14, 1.75)
        .effects(
            FoodEffect.removePotionEffect(PotionEffectType.POISON),
            FoodEffect.removePotionEffect(PotionEffectType.WITHER),
            FoodEffect.removePotionEffect(PotionEffectType.HUNGER))
        .build();

    public static final FoodItemStack CHICKEN_NOODLE_SOUP_WITH_BOK_HOY = new FoodItemStackBuilder()
        .id("GN_CHICKEN_NOODLE_SOUP_WITH_BOK_CHOY")
        .texture(HeadTextures.SOUP)
        .name("白菜鸡肉面汤")
        .hunger(16, 1.75)
        .effects(
            FoodEffect.removePotionEffect(PotionEffectType.POISON),
            FoodEffect.removePotionEffect(PotionEffectType.WITHER),
            FoodEffect.removePotionEffect(PotionEffectType.HUNGER))
        .build();

    public static final FoodItemStack SPLIT_PEA_SOUP = new FoodItemStackBuilder()
        .id("GN_SPLIT_PEA_SOUP")
        .texture(HeadTextures.SOUP)
        .name("豌豆汤")
        .hunger(10, 1.75)
        .effects(FoodEffect.removePotionEffect(PotionEffectType.CONFUSION))
        .build();

    public static final FoodItemStack HAM_AND_SPLIT_PEA_SOUP = new FoodItemStackBuilder()
        .id("GN_HAM_AND_SPLIT_PEA_SOUP")
        .texture(HeadTextures.SOUP)
        .name("火腿豌豆汤")
        .hunger(14, 1.75)
        .effects(FoodEffect.removePotionEffect(PotionEffectType.CONFUSION))
        .build();

    public static final FoodItemStack LENTIL_SOUP = new FoodItemStackBuilder()
        .id("GN_LENTIL_SOUP")
        .texture(HeadTextures.SOUP)
        .name("扁豆汤")
        .hunger(10, 1.75)
        .effects(FoodEffect.positivePotionEffect(PotionEffectType.SATURATION, 5))
        .build();

    public static final FoodItemStack BEEF_AND_LENTIL_SOUP = new FoodItemStackBuilder()
        .id("GN_BEEF_AND_LENTIL_SOUP")
        .texture(HeadTextures.SOUP)
        .name("牛肉扁豆汤")
        .hunger(14, 1.75)
        .effects(FoodEffect.positivePotionEffect(PotionEffectType.SATURATION, 10, 1))
        .build();

    public static final FoodItemStack CARROT_SOUP = new FoodItemStackBuilder()
        .id("GN_CARROT_SOUP")
        .texture(HeadTextures.SOUP)
        .name("胡萝卜汤")
        .hunger(12, 1.75)
        .effects(FoodEffect.removePotionEffect(PotionEffectType.BLINDNESS))
        .build();

    public static final FoodItemStack MUSHROOM_BARLEY_SOUP = new FoodItemStackBuilder()
        .id("GN_MUSHROOM_BARLEY_SOUP")
        .texture(HeadTextures.SOUP)
        .name("蘑菇大麦汤")
        .hunger(12, 2)
        .effects(FoodEffect.warm(70))
        .build();

    public static final FoodItemStack CHICKEN_BARLEY_SOUP = new FoodItemStackBuilder()
        .id("GN_CHICKEN_BARLEY_SOUP")
        .texture(HeadTextures.SOUP)
        .name("鸡肉大麦汤")
        .hunger(14, 2)
        .effects(FoodEffect.warm(70))
        .build();

    public static final FoodItemStack BEEF_BARLEY_SOUP = new FoodItemStackBuilder()
        .id("GN_BEEF_BARLEY_SOUP")
        .texture(HeadTextures.SOUP)
        .name("牛肉大麦汤")
        .hunger(14, 2)
        .effects(FoodEffect.warm(70))
        .build();

    public static final FoodItemStack CREAM_OF_MUSHROOM_SOUP = new FoodItemStackBuilder()
        .id("GN_CREAM_OF_MUSHROOM_SOUP")
        .texture(HeadTextures.CREAM_SOUP)
        .name("奶油蘑菇汤")
        .hunger(9, 1.75)
        .effects(FoodEffect.heal(2))
        .build();

    public static final FoodItemStack CREAM_OF_BROCCOLI_SOUP = new FoodItemStackBuilder()
        .id("GN_CREAM_OF_BROCCOLI_SOUP")
        .texture(HeadTextures.CREAM_SOUP)
        .name("奶油西兰花汤")
        .hunger(9, 1.75)
        .effects(FoodEffect.heal(2))
        .build();

    public static final FoodItemStack CREAM_OF_ASPARAGUS_SOUP = new FoodItemStackBuilder()
        .id("GN_CREAM_OF_ASPARAGUS_SOUP")
        .texture(HeadTextures.CREAM_SOUP)
        .name("奶油芦笋汤")
        .hunger(9, 1.75)
        .effects(FoodEffect.heal(2))
        .build();

    public static final FoodItemStack CREAM_OF_CAULIFLOWER_SOUP = new FoodItemStackBuilder()
        .id("GN_CREAM_OF_CAULIFLOWER_SOUP")
        .texture(HeadTextures.CREAM_SOUP)
        .name("奶油花椰菜汤")
        .hunger(9, 1.75)
        .effects(FoodEffect.heal(2))
        .build();

    public static final FoodItemStack MISO_SOUP = new FoodItemStackBuilder()
        .id("GN_MISO_SOUP")
        .texture(HeadTextures.MISO_SOUP)
        .name("味噌汤")
        .hunger(7, 1.75)
        .effects(FoodEffect.warm(50))
        .build();

    public static final FoodItemStack GUARDIAN_FIN_SOUP = new FoodItemStackBuilder()
        .id("GN_GUARDIAN_FIN_SOUP")
        .texture(HeadTextures.SOUP)
        .name("守护者翅汤")
        .hunger(12, 1.75)
        .effects(FoodEffect.warm(50))
        .build();

    public static final FoodItemStack BROCCOLI_CHOWDER = new FoodItemStackBuilder()
        .id("GN_BROCCOLI_CHOWDER")
        .texture(HeadTextures.CHOWDER)
        .name("西兰花浓汤")
        .hunger(10, 1.75)
        .build();

    public static final FoodItemStack SALMON_CHOWDER = new FoodItemStackBuilder()
        .id("GN_SALMON_CHOWDER")
        .texture(HeadTextures.CHOWDER)
        .name("鲑鱼浓汤")
        .hunger(12, 1.75)
        .build();

    public static final FoodItemStack POTATO_CHOWDER = new FoodItemStackBuilder()
        .id("GN_POTATO_CHOWDER")
        .texture(HeadTextures.CHOWDER)
        .name("土豆浓汤")
        .hunger(10, 1.75)
        .build();

    public static final FoodItemStack CORN_CHOWDER = new FoodItemStackBuilder()
        .id("GN_CORN_CHOWDER")
        .texture(HeadTextures.CHOWDER)
        .name("玉米浓汤")
        .hunger(10, 1.75)
        .build();

    public static final FoodItemStack BEEF_STEW = new FoodItemStackBuilder()
        .id("GN_BEEF_STEW")
        .texture(HeadTextures.STEW)
        .name("炖牛肉")
        .hunger(16, 1.75)
        .effects(FoodEffect.warm(140))
        .build();

    public static final FoodItemStack CLAM_STEW = new FoodItemStackBuilder()
        .id("GN_CLAM_STEW")
        .texture(HeadTextures.STEW)
        .name("炖蛤蜊")
        .hunger(14, 1.75)
        .effects(FoodEffect.warm(50))
        .build();

    public static final FoodItemStack CRAB_HOTPOT = new FoodItemStackBuilder()
        .id("GN_CRAB_HOTPOT")
        .texture(HeadTextures.STEW)
        .name("蟹肉火锅")
        .hunger(17, 1.75)
        .effects(FoodEffect.warm(140))
        .build();

    // Meats

    public static final FoodItemStack BBQ_STEAK = new FoodItemStackBuilder()
        .id("GN_BBQ_STEAK")
        .material(Material.COOKED_BEEF)
        .name("烤牛排")
        .hunger(9, 1.5)
        .build();

    public static final FoodItemStack BBQ_PORK = new FoodItemStackBuilder()
        .id("GN_BBQ_PORK")
        .material(Material.COOKED_PORKCHOP)
        .name("烤猪排")
        .hunger(9, 1.5)
        .build();

    public static final FoodItemStack BBQ_CHICKEN = new FoodItemStackBuilder()
        .id("GN_BBQ_CHICKEN")
        .material(Material.COOKED_CHICKEN)
        .name("烤鸡排")
        .hunger(7, 1.5)
        .build();

    public static final FoodItemStack BBQ_MUTTON = new FoodItemStackBuilder()
        .id("GN_BBQ_MUTTON")
        .material(Material.COOKED_MUTTON)
        .name("烤羊排")
        .hunger(7, 1.5)
        .build();

    public static final FoodItemStack BUTTER_CHICKEN = new FoodItemStackBuilder()
        .id("GN_BUTTER_CHICKEN")
        .texture(HeadTextures.STEW)
        .name("印度牛油鸡")
        .hunger(7)
        .effects(FoodEffect.positivePotionEffect(PotionEffectType.INCREASE_DAMAGE, 30))
        .build();

    // Rice

    public static final FoodItemStack BUTTER_CHICKEN_WITH_NAAN_BREAD = new FoodItemStackBuilder()
        .id("GN_BUTTER_CHICKEN_WITH_NAAN_BREAD")
        .texture(HeadTextures.STEW)
        .name("印度牛油鸡配大蒜烤饼")
        .hunger(12)
        .effects(FoodEffect.positivePotionEffect(PotionEffectType.INCREASE_DAMAGE, 30, 1))
        .build();

    public static final FoodItemStack SHRIMP_FRIED_RICE = new FoodItemStackBuilder()
        .id("GN_SHRIMP_FRIED_RICE")
        .texture(HeadTextures.RICE_PINK)
        .name("虾炒饭")
        .hunger(10)
        .build();

    public static final FoodItemStack CURRY_RICE = new FoodItemStackBuilder()
        .id("GN_CURRY_RICE")
        .texture(HeadTextures.RICE_BROWN)
        .name("咖哩饭")
        .hunger(10)
        .effects(FoodEffect.positivePotionEffect(PotionEffectType.INCREASE_DAMAGE, 30))
        .build();

    public static final FoodItemStack RICE_OMELETTE = new FoodItemStackBuilder()
        .id("GN_RICE_OMELETTE")
        .texture(HeadTextures.RICE_YELLOW)
        .name("蛋包饭")
        .hunger(8)
        .effects(FoodEffect.heal(1))
        .build();

    public static final FoodItemStack RICE_BALL = new FoodItemStackBuilder()
        .id("GN_RICE_BALL")
        .texture(HeadTextures.RICE_BALL)
        .name("饭团")
        .hunger(4)
        .build();

    // Noodles

    public static final FoodItemStack BEEF_UDON = new FoodItemStackBuilder()
        .id("GN_BEEF_UDON")
        .texture(HeadTextures.UDON)
        .name("牛肉乌冬面")
        .hunger(13)
        .effects(FoodEffect.heal(2))
        .build();

    public static final FoodItemStack CHICKEN_UDON = new FoodItemStackBuilder()
        .id("GN_CHICKEN_UDON")
        .texture(HeadTextures.UDON)
        .name("鸡肉乌冬面")
        .hunger(11)
        .effects(FoodEffect.heal(2))
        .build();

    public static final FoodItemStack VEGETABLE_UDON = new FoodItemStackBuilder()
        .id("GN_VEGETABLE_UDON")
        .texture(HeadTextures.UDON)
        .name("蔬菜乌冬面")
        .hunger(11)
        .effects(FoodEffect.heal(2))
        .build();

    public static final FoodItemStack STIR_FRY_NOODLES = new FoodItemStackBuilder()
        .id("GN_STIR_FRY_NOODLES")
        .texture(HeadTextures.NOODLES)
        .name("炒面")
        .hunger(10)
        .build();

    public static final FoodItemStack SHRIMP_DUMPLINGS = new FoodItemStackBuilder()
        .id("GN_SHRIMP_DUMPLINGS")
        .texture(HeadTextures.DUMPLINGS)
        .name("虾饺")
        .hunger(5)
        .build();

    public static final FoodItemStack CHICKEN_POTSTICKERS = new FoodItemStackBuilder()
        .id("GN_CHICKEN_POTSTICKERS")
        .material(Material.COOKED_PORKCHOP)
        .name("鸡肉锅贴")
        .hunger(9)
        .build();

    public static final FoodItemStack BEEF_POTSTICKERS = new FoodItemStackBuilder()
        .id("GN_BEEF_POTSTICKERS")
        .material(Material.COOKED_PORKCHOP)
        .name("牛肉锅贴")
        .hunger(11)
        .build();

    public static final FoodItemStack PIEROGIES = new FoodItemStackBuilder()
        .id("GN_PIEROGIES")
        .material(Material.COOKED_PORKCHOP)
        .name("波兰饺子")
        .hunger(9)
        .build();

    public static final FoodItemStack BACON_PIEROGIES = new FoodItemStackBuilder()
        .id("GN_BACON_PIEROGIES")
        .material(Material.COOKED_PORKCHOP)
        .name("培根波兰饺子")
        .hunger(10)
        .build();

    public static final FoodItemStack CUSTARD_BUNS = new FoodItemStackBuilder()
        .id("GN_CUSTARD_BUNS")
        .texture(HeadTextures.DUMPLINGS)
        .name("奶黄包")
        .hunger(7)
        .build();

    public static final FoodItemStack RED_BEAN_BUNS = new FoodItemStackBuilder()
        .id("GN_RED_BEAN_BUNS")
        .texture(HeadTextures.DUMPLINGS)
        .name("豆沙包")
        .hunger(7)
        .build();

    public static final FoodItemStack TAIYAKI = new FoodItemStackBuilder()
        .id("GN_TAIYAKI")
        .material(Material.COD)
        .name("鲷鱼烧")
        .hunger(6)
        .build();

    // Sushi

    public static final FoodItemStack TEMPURA_SHRIMP_ROLL = new FoodItemStackBuilder()
        .id("GN_TEMPURA_SHRIMP_ROLL")
        .texture(HeadTextures.SUSHI_ROLL)
        .name("天妇罗虾卷")
        .hunger(7, 0.75)
        .build();

    public static final FoodItemStack DYNAMITE_ROLL = new FoodItemStackBuilder()
        .id("GN_DYNAMITE_ROLL")
        .texture(HeadTextures.SUSHI_ROLL)
        .name("世纪卷")
        .hunger(7, 0.75)
        .build();

    public static final FoodItemStack KAPPA_ROLL = new FoodItemStackBuilder()
        .id("GN_KAPPA_ROLL")
        .texture(HeadTextures.SUSHI_ROLL)
        .name("黄瓜卷")
        .hunger(7, 0.75)
        .build();

    public static final FoodItemStack CALIFORNIA_ROLL = new FoodItemStackBuilder()
        .id("GN_CALIFORNIA_ROLL")
        .texture(HeadTextures.SUSHI_ROLL)
        .name("加州卷")
        .hunger(7, 0.75)
        .build();

    public static final FoodItemStack SALMON_ROE_SUSHI_ROLL = new FoodItemStackBuilder()
        .id("GN_SALMON_ROE_SUSHI_ROLL")
        .texture(HeadTextures.IKURA_ROLL)
        .name("鲑鱼籽寿司卷")
        .hunger(6, 0.75)
        .build();

    public static final FoodItemStack RED_BEAN_GLUTINOUS_RICE_BALLS = new FoodItemStackBuilder()
        .id("GN_RED_BEAN_GLUTINOUS_RICE_BALLS")
        .texture(HeadTextures.GLUTINOUS_RICE_BALLS)
        .name("红豆沙汤圆")
        .hunger(7, 0.75)
        .build();

    public static final FoodItemStack PEANUT_GLUTINOUS_RICE_BALLS = new FoodItemStackBuilder()
        .id("GN_PEANUT_GLUTINOUS_RICE_BALLS")
        .texture(HeadTextures.GLUTINOUS_RICE_BALLS)
        .name("花生汤圆")
        .hunger(7, 0.75)
        .build();

    public static final FoodItemStack SESAME_GLUTINOUS_RICE_BALLS = new FoodItemStackBuilder()
        .id("GN_SESAME_GLUTINOUS_RICE_BALLS")
        .texture(HeadTextures.GLUTINOUS_RICE_BALLS)
        .name("黑芝麻汤圆")
        .hunger(7, 0.75)
        .build();

    // Random stuff

    public static final FoodItemStack MASHED_POTATOES = new FoodItemStackBuilder()
        .id("GN_MASHED_POTATOES")
        .material(Material.BAKED_POTATO)
        .name("土豆泥")
        .hunger(5, 1)
        .build();

    public static final FoodItemStack MASHED_TURNIPS = new FoodItemStackBuilder()
        .id("GN_MASHED_TURNIPS")
        .material(Material.FERMENTED_SPIDER_EYE)
        .name("芜菁泥")
        .hunger(5, 1)
        .build();

    public static final FoodItemStack FISH_AND_CHIPS = new FoodItemStackBuilder()
        .id("GN_FISH_AND_CHIPS")
        .material(Material.COOKED_COD)
        .name("炸鱼薯条")
        .hunger(10, 0.75)
        .build();

    public static final FoodItemStack TURKEY_ROAST = new FoodItemStackBuilder()
        .id("GN_TURKEY_ROAST")
        .material(Material.COOKED_CHICKEN)
        .name("烤火鸡")
        .hunger(12, 0.75)
        .build();

    public static final FoodItemStack CHOCOLATE_TRUFFLE = new FoodItemStackBuilder()
        .id("GN_CHOCOLATE_TRUFFLE")
        .material(Material.BROWN_MUSHROOM)
        .name("松露巧克力")
        .hunger(5, 0.75)
        .build();

    // Baked

    public static final FoodItemStack DOUBLE_CHOCOLATE_MUFFIN = new FoodItemStackBuilder()
        .id("GN_DOUBLE_CHOCOLATE_MUFFIN")
        .texture(HeadTextures.MUFFIN)
        .name("双层巧克力松饼")
        .hunger(4, 0.75)
        .build();

    public static final FoodItemStack CARROT_MUFFIN = new FoodItemStackBuilder()
        .id("GN_CARROT_MUFFIN")
        .texture(HeadTextures.MUFFIN)
        .name("胡萝卜松饼")
        .hunger(4, 0.75)
        .build();

    public static final FoodItemStack CRANBERRY_MUFFIN = new FoodItemStackBuilder()
        .id("GN_CRANBERRY_MUFFIN")
        .texture(HeadTextures.MUFFIN)
        .name("蔓越莓松饼")
        .hunger(4, 0.75)
        .build();

    public static final FoodItemStack RAISIN_MUFFIN = new FoodItemStackBuilder()
        .id("GN_RAISIN_MUFFIN")
        .texture(HeadTextures.MUFFIN)
        .name("葡萄干松饼")
        .hunger(4, 0.75)
        .build();

    // Cold desserts

    public static final FoodItemStack VANILLA_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_VANILLA_ICE_CREAM")
        .texture(HeadTextures.ICE_CREAM_WHITE)
        .name("香草冰淇淋")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack CHOCOLATE_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_CHOCOLATE_ICE_CREAM")
        .texture(HeadTextures.ICE_CREAM_BROWN)
        .name("巧克力冰淇淋")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack MINT_CHOCOLATE_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_MINT_CHOCOLATE_ICE_CREAM")
        .texture(HeadTextures.ICE_CREAM_GREEN)
        .name("薄荷冰淇淋")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack COOKIE_DOUGH_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_COOKIE_DOUGH_ICE_CREAM")
        .texture(HeadTextures.ICE_CREAM_ORANGE)
        .name("曲奇冰淇淋")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack PEANUT_BUTTER_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_PEANUT_BUTTER_ICE_CREAM")
        .texture(HeadTextures.ICE_CREAM_ORANGE)
        .name("花生酱冰淇淋")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack RED_BEAN_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_RED_BEAN_ICE_CREAM")
        .texture(HeadTextures.ICE_CREAM_RED)
        .name("红豆冰淇淋")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack GREEN_TEA_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_GREEN_TEA_ICE_CREAM")
        .texture(HeadTextures.ICE_CREAM_GREEN)
        .name("绿茶冰淇淋")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack STRAWBERRY_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_STRAWBERRY_ICE_CREAM")
        .texture(HeadTextures.ICE_CREAM_RED)
        .name("草莓冰淇淋")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack BLUEBERRY_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_BLUEBERRY_ICE_CREAM")
        .texture(HeadTextures.ICE_CREAM_BLUE)
        .name("蓝莓冰淇淋")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack CRANBERRY_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_CRANBERRY_ICE_CREAM")
        .texture(HeadTextures.ICE_CREAM_RED)
        .name("蔓越莓冰淇淋")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack COWBERRY_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_COWBERRY_ICE_CREAM")
        .texture(HeadTextures.ICE_CREAM_RED)
        .name("越橘冰淇淋")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack COCONUT_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_COCONUT_ICE_CREAM")
        .texture(HeadTextures.ICE_CREAM_WHITE)
        .name("椰子冰淇淋")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack CHERRY_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_CHERRY_ICE_CREAM")
        .texture(HeadTextures.ICE_CREAM_PINK)
        .name("樱桃冰淇淋")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack RASPBERRY_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_RASPBERRY_ICE_CREAM")
        .texture(HeadTextures.ICE_CREAM_PINK)
        .name("覆盆子冰淇淋")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack CARAMEL_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_CARAMEL_ICE_CREAM")
        .texture(HeadTextures.ICE_CREAM_BROWN)
        .name("焦糖冰淇淋")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack ORANGE_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_ORANGE_ICE_CREAM")
        .texture(HeadTextures.ICE_CREAM_ORANGE)
        .name("橙子冰淇淋")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack PEACH_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_PEACH_ICE_CREAM")
        .texture(HeadTextures.ICE_CREAM_ORANGE)
        .name("蜜桃冰淇淋")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack PINEAPPLE_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_PINEAPPLE_ICE_CREAM")
        .texture(HeadTextures.ICE_CREAM_YELLOW)
        .name("菠萝冰淇淋")
        .hunger(3, 0.75)
        .build();

    public static final FoodItemStack CHORUS_ICE_CREAM = new FoodItemStackBuilder()
        .id("GN_CHORUS_ICE_CREAM")
        .texture(HeadTextures.ICE_CREAM_PURPLE)
        .name("紫颂果冰淇淋")
        .hunger(3, 0.75)
        .effects(FoodEffect.teleport(5))
        .build();

    public static final FoodItemStack SHAVED_ICE = new FoodItemStackBuilder()
        .id("GN_SHAVED_ICE")
        .texture(HeadTextures.SHAVED_ICE)
        .name("刨冰")
        .hunger(2, 0.75)
        .build();

    public static final FoodItemStack STRAWBERRY_SHAVED_ICE = new FoodItemStackBuilder()
        .id("GN_STRAWBERRY_SHAVED_ICE")
        .texture(HeadTextures.STRAWBERRY_SHAVED_ICE)
        .name("草莓刨冰")
        .hunger(2, 0.75)
        .build();

    public static final FoodItemStack BANANA_SHAVED_ICE = new FoodItemStackBuilder()
        .id("GN_BANANA_SHAVED_ICE")
        .texture(HeadTextures.LEMON_SHAVED_ICE)
        .name("香蕉刨冰")
        .hunger(2, 0.75)
        .build();

    public static final FoodItemStack LEMON_SHAVED_ICE = new FoodItemStackBuilder()
        .id("GN_LEMON_SHAVED_ICE")
        .texture(HeadTextures.LEMON_SHAVED_ICE)
        .name("柠檬刨冰")
        .hunger(2, 0.75)
        .build();

    // Sweets / Snacks

    public static final FoodItemStack CANDY_APPLE = new FoodItemStackBuilder()
        .id("GN_CANDY_APPLE")
        .texture(HeadTextures.CANDY_APPLE)
        .name("苹果糖")
        .hunger(7, 0.75)
        .build();

    public static final FoodItemStack DONUT = new FoodItemStackBuilder()
        .id("GN_DONUT")
        .texture(HeadTextures.DONUT_PINK)
        .name("甜甜圈")
        .hunger(6, 0.75)
        .build();

    public static final FoodItemStack HONEY_DIP_DONUT = new FoodItemStackBuilder()
        .id("GN_HONEY_DIP_DONUT")
        .texture(HeadTextures.DONUT_GOLD)
        .name("蜂蜜甜甜圈")
        .hunger(6, 0.75)
        .build();

    public static final FoodItemStack GOLDEN_CHOCOLATE_DONUT = new FoodItemStackBuilder()
        .id("GN_GOLDEN_CHOCOLATE_DONUT")
        .texture(HeadTextures.DONUT_BROWN)
        .name("黄金巧克力甜甜圈")
        .hunger(6, 0.75)
        .build();

    public static final FoodItemStack STRAWBERRY_CHEESECAKE = new FoodItemStackBuilder()
        .id("GN_STRAWBERRY_CHEESECAKE")
        .texture(HeadTextures.CHEESECAKE)
        .name("草莓芝士蛋糕")
        .hunger(8, 0.75)
        .build();

    public static final FoodItemStack STRAWBERRY_CUPCAKE = new FoodItemStackBuilder()
        .id("GN_STRAWBERRY_CUPCAKE")
        .texture(HeadTextures.CUPCAKE)
        .name("草莓杯蛋糕")
        .hunger(4, 0.75)
        .build();

    public static final FoodItemStack LEMON_TART = new FoodItemStackBuilder()
        .id("GN_LEMON_TART")
        .material(Material.PUMPKIN_PIE)
        .name("柠檬蛋挞")
        .hunger(6, 0.5)
        .effects(FoodEffect.positivePotionEffect(PotionEffectType.SPEED, 120))
        .build();

    public static final FoodItemStack CHORUS_PIE = new FoodItemStackBuilder()
        .id("GN_CHORUS_PIE")
        .material(Material.PUMPKIN_PIE)
        .name("紫颂果派")
        .hunger(8, 0.5)
        .effects(FoodEffect.teleport(5))
        .build();

    public static final FoodItemStack POPPED_SORGHUM = new FoodItemStackBuilder()
        .id("GN_POPPED_SORGHUM")
        .texture(HeadTextures.POPPED_SORGHUM)
        .name("爆高粱")
        .hunger(2, 0.5)
        .build();

    public static final FoodItemStack ENCHANTED_GOLDEN_CARROT = new FoodItemStackBuilder()
        .id("GN_ENCHANTED_GOLDEN_CARROT")
        .material(Material.GOLDEN_CARROT)
        .name("附魔金萝卜")
        .hunger(8, 0.5)
        .effects(
            FoodEffect.removePotionEffect(PotionEffectType.DARKNESS),
            FoodEffect.removePotionEffect(PotionEffectType.BLINDNESS),
            FoodEffect.positivePotionEffect(PotionEffectType.NIGHT_VISION, 900))
        .build();
    static {
        ENCHANTED_GOLDEN_CARROT.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
        ENCHANTED_GOLDEN_CARROT.addItemFlags(ItemFlag.HIDE_ENCHANTS);
    }

    public static final FoodItemStack ENCHANTED_GLISTERING_MELON_SLICE = new FoodItemStackBuilder()
        .id("GN_ENCHANTED_GLISTERING_MELON_SLICE")
        .material(Material.GLISTERING_MELON_SLICE)
        .name("附魔闪烁的西瓜片")
        .hunger(4, 0.5)
        .effects(
            FoodEffect.removePotionEffect(PotionEffectType.WITHER),
            FoodEffect.removePotionEffect(PotionEffectType.POISON),
            FoodEffect.positivePotionEffect(PotionEffectType.REGENERATION, 120))
        .build();
    static {
        ENCHANTED_GLISTERING_MELON_SLICE.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
        ENCHANTED_GLISTERING_MELON_SLICE.addItemFlags(ItemFlag.HIDE_ENCHANTS);
    }

    // Drinks

    public static final FoodItemStack V7 = new FoodItemStackBuilder()
        .id("GN_V7")
        .texture(HeadTexture.FILLED_CAN.getTexture())
        .name("蔬菜7件套")
        .hunger(6, 0.75)
        .effects(
            FoodEffect.positivePotionEffect(PotionEffectType.REGENERATION, 20, 0))
        .build();

    public static final FoodItemStack BUBBLE_MILK_TEA = new FoodItemStackBuilder()
        .id("GN_BUBBLE_MILK_TEA")
        .material(Material.POTION)
        .name("珍珠奶茶")
        .hunger(4, 0.75)
        .build();
    static {
        final PotionMeta meta = (PotionMeta) BUBBLE_MILK_TEA.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.WATER));
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setColor(Color.MAROON);
        BUBBLE_MILK_TEA.setItemMeta(meta);
    }

    public static final FoodItemStack CANTALOUPE_BUBBLE_TEA = new FoodItemStackBuilder()
        .id("GN_CANTALOUPE_BUBBLE_TEA")
        .material(Material.POTION)
        .name("哈密瓜珍珠奶茶")
        .hunger(4, 0.75)
        .build();
    static {
        final PotionMeta meta = (PotionMeta) CANTALOUPE_BUBBLE_TEA.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.WATER));
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setColor(Color.ORANGE);
        CANTALOUPE_BUBBLE_TEA.setItemMeta(meta);
    }

    public static final FoodItemStack HONEYDEW_MELON_BUBBLE_TEA = new FoodItemStackBuilder()
        .id("GN_HONEYDEW_MELON_BUBBLE_TEA")
        .material(Material.POTION)
        .name("蜜瓜珍珠奶茶")
        .hunger(4, 0.75)
        .build();
    static {
        final PotionMeta meta = (PotionMeta) HONEYDEW_MELON_BUBBLE_TEA.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.WATER));
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setColor(Color.GREEN);
        HONEYDEW_MELON_BUBBLE_TEA.setItemMeta(meta);
    }

    public static final FoodItemStack APPLE_BUBBLE_TEA = new FoodItemStackBuilder()
        .id("GN_APPLE_BUBBLE_TEA")
        .material(Material.POTION)
        .name("苹果珍珠奶茶")
        .hunger(4, 0.75)
        .build();
    static {
        final PotionMeta meta = (PotionMeta) APPLE_BUBBLE_TEA.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.WATER));
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setColor(Color.LIME);
        APPLE_BUBBLE_TEA.setItemMeta(meta);
    }

    // Sin

    public static final FoodItemStack RED_WINE = new FoodItemStackBuilder()
        .id("GN_RED_WINE")
        .material(Material.POTION)
        .name("红酒")
        .hunger(3, 0.5)
        .effects(
            FoodEffect.negativePotionEffect(PotionEffectType.CONFUSION, 60, 2),
            FoodEffect.positivePotionEffect(PotionEffectType.INCREASE_DAMAGE, 45),
            FoodEffect.positivePotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 45))
        .build();
    static {
        final PotionMeta meta = (PotionMeta) RED_WINE.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.WATER));
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setColor(Color.MAROON);
        RED_WINE.setItemMeta(meta);
    }

    public static final FoodItemStack BEER = new FoodItemStackBuilder()
        .id("GN_BEER")
        .material(Material.POTION)
        .name("啤酒")
        .hunger(3, 0.5)
        .effects(
            FoodEffect.negativePotionEffect(PotionEffectType.CONFUSION, 60, 2),
            FoodEffect.positivePotionEffect(PotionEffectType.INCREASE_DAMAGE, 45),
            FoodEffect.positivePotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 45))
        .build();
    static {
        final PotionMeta meta = (PotionMeta) BEER.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.WATER));
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setColor(Color.ORANGE);
        BEER.setItemMeta(meta);
    }

    public static final FoodItemStack APPLE_CIDER = new FoodItemStackBuilder()
        .id("GN_APPLE_CIDER")
        .material(Material.POTION)
        .name("苹果酒")
        .hunger(3, 0.5)
        .effects(
            FoodEffect.negativePotionEffect(PotionEffectType.CONFUSION, 60, 2),
            FoodEffect.positivePotionEffect(PotionEffectType.INCREASE_DAMAGE, 45),
            FoodEffect.positivePotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 45))
        .build();
    static {
        final PotionMeta meta = (PotionMeta) APPLE_CIDER.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.WATER));
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setColor(Color.YELLOW);
        APPLE_CIDER.setItemMeta(meta);
    }

    public static final FoodItemStack RICE_WINE = new FoodItemStackBuilder()
        .id("GN_RICE_WINE")
        .material(Material.POTION)
        .name("米酒")
        .hunger(3, 0.5)
        .effects(
            FoodEffect.negativePotionEffect(PotionEffectType.CONFUSION, 60, 2),
            FoodEffect.positivePotionEffect(PotionEffectType.INCREASE_DAMAGE, 45),
            FoodEffect.positivePotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 45))
        .build();
    static {
        final PotionMeta meta = (PotionMeta) RICE_WINE.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.WATER));
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setColor(Color.WHITE);
        RICE_WINE.setItemMeta(meta);
    }

    public static final FoodItemStack VODKA = new FoodItemStackBuilder()
        .id("GN_VODKA")
        .material(Material.POTION)
        .name("伏特加")
        .hunger(3, 0.5)
        .effects(
            FoodEffect.negativePotionEffect(PotionEffectType.CONFUSION, 120, 4),
            FoodEffect.positivePotionEffect(PotionEffectType.INCREASE_DAMAGE, 45),
            FoodEffect.positivePotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 45))
        .build();
    static {
        final PotionMeta meta = (PotionMeta) VODKA.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.WATER));
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setColor(Color.WHITE);
        VODKA.setItemMeta(meta);
    }

    public static final FoodItemStack RUM = new FoodItemStackBuilder()
        .id("GN_RUM")
        .material(Material.POTION)
        .name("朗姆酒")
        .hunger(3, 0.5)
        .effects(
            FoodEffect.negativePotionEffect(PotionEffectType.CONFUSION, 120, 4),
            FoodEffect.positivePotionEffect(PotionEffectType.INCREASE_DAMAGE, 45),
            FoodEffect.positivePotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 45))
        .build();
    static {
        final PotionMeta meta = (PotionMeta) RUM.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.WATER));
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setColor(Color.RED);
        RUM.setItemMeta(meta);
    }

    public static final FoodItemStack WHISKEY = new FoodItemStackBuilder()
        .id("GN_WHISKEY")
        .material(Material.POTION)
        .name("威士忌")
        .hunger(3, 0.5)
        .effects(
            FoodEffect.negativePotionEffect(PotionEffectType.CONFUSION, 120, 4),
            FoodEffect.positivePotionEffect(PotionEffectType.INCREASE_DAMAGE, 45),
            FoodEffect.positivePotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 45))
        .build();
    static {
        final PotionMeta meta = (PotionMeta) WHISKEY.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.WATER));
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setColor(Color.ORANGE);
        WHISKEY.setItemMeta(meta);
    }

}
