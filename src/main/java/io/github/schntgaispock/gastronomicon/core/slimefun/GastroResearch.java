package io.github.schntgaispock.gastronomicon.core.slimefun;

import io.github.schntgaispock.gastronomicon.Gastronomicon;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GastroResearch {

    private final int startKey = 645750;

    public static final Research WOODEN_TOOLS = new Research(Gastronomicon.key("wooden_tools"), startKey, "基础工具", 10);
    public static final Research STEEL_TOOLS = new Research(Gastronomicon.key("steel_tools"), startKey + 1, "钢制工具", 15);
    public static final Research CULINARY_WORKBENCH = new Research(Gastronomicon.key("culinary_workbench"), startKey + 2, "第一步", 10);
    public static final Research MULTI_STOVE = new Research(Gastronomicon.key("multi_stove"), startKey + 3, "多用炉", 15);
    public static final Research GRAIN_MILL = new Research(Gastronomicon.key("grain_mill"), startKey + 4, "谷物磨坊", 10);
    public static final Research REFRIGERATOR = new Research(Gastronomicon.key("refridgerator"), startKey + 5, "冰箱", 17);
    public static final Research FERMENTER = new Research(Gastronomicon.key("fermenter"), startKey + 6, "发酵罐", 25);
    public static final Research TRAPS = new Research(Gastronomicon.key("traps"), startKey + 7, "陷阱", 18);
    public static final Research FISHING_NETS = new Research(Gastronomicon.key("fishing_nets"), startKey + 8, "捕鱼网", 10);
    public static final Research CHEF_ANDROID = new Research(Gastronomicon.key("chef_android"), startKey + 9, "厨师机器人", 20);
    public static final Research ELECTRIC_KITCHEN = new Research(Gastronomicon.key("electric_kitchen"), startKey + 10, "电动厨房", 20);
    public static final Research SICKLES = new Research(Gastronomicon.key("sickles"), startKey + 11, "采集工具", 18);
    public static final Research RAW_INGREDIENTS = new Research(Gastronomicon.key("raw_ingredients"), startKey + 12, "原材料", 11);
    public static final Research PROCESSED_INGREDIENTS = new Research(Gastronomicon.key("processed_ingredients"), startKey + 13, "加工原材料", 19);
    public static final Research FOOD = new Research(Gastronomicon.key("food"), startKey + 14, "高端美食", 32);
    public static final Research CHEFS_HAT = new Research(Gastronomicon.key("chefs_hat"), startKey + 15, "厨师帽", 5);
    
}