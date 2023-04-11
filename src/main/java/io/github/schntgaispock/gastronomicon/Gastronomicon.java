package io.github.schntgaispock.gastronomicon;

import java.util.logging.Level;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.guizhanss.guizhanlibplugin.updater.GuizhanUpdater;
import org.bstats.bukkit.Metrics;
import org.bstats.charts.SimplePie;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import io.github.mooy1.infinitylib.core.AbstractAddon;
import io.github.mooy1.infinitylib.core.AddonConfig;
import io.github.schntgaispock.gastronomicon.api.trees.TreeStructure;
import io.github.schntgaispock.gastronomicon.core.setup.CommandSetup;
import io.github.schntgaispock.gastronomicon.core.setup.ListenerSetup;
import io.github.schntgaispock.gastronomicon.core.setup.ResearchSetup;
import io.github.schntgaispock.gastronomicon.core.setup.ItemSetup;
import io.github.schntgaispock.gastronomicon.integration.DynaTechSetup;
import io.github.schntgaispock.gastronomicon.integration.SlimeHUDSetup;
import io.github.schntgaispock.gastronomicon.util.StringUtil;
import lombok.Getter;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.md_5.bungee.api.ChatColor;

@Getter
public class Gastronomicon extends AbstractAddon {

    private static @Getter Gastronomicon instance;

    private AddonConfig playerData;
    private AddonConfig customFood;

    public Gastronomicon() {
        super("SlimefunGuguProject", "Gastronomicon", "master", "options.auto-update");
    }

    @Override
    public void enable() {
        instance = this;

        if (!getServer().getPluginManager().isPluginEnabled("GuizhanLibPlugin")) {
            getLogger().log(Level.SEVERE, "本插件需要 鬼斩前置库插件(GuizhanLibPlugin) 才能运行!");
            getLogger().log(Level.SEVERE, "从此处下载: https://50l.cc/gzlib");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        if (getConfig().getBoolean("options.auto-update") && getDescription().getVersion().startsWith("Build")) {
            GuizhanUpdater.start(this, getFile(), "SlimegunGuguProject", "Gastronomicon", "master");
        }

        getLogger().info("#======================================#");
        getLogger().info("#    Gastronomicon by SchnTgaiSpock    #");
        getLogger().info("#   美食家    粘液科技简中汉化组汉化   #");
        getLogger().info("#======================================#");

        final Metrics metrics = new Metrics(this, 16941);

        metrics.addCustomChart(
            new SimplePie("exoticgardenInstalled", () -> Boolean.toString(isPluginEnabled("ExoticGarden"))));

        ItemSetup.setup();
        ResearchSetup.setup();
        ListenerSetup.setup();
        CommandSetup.setup();

        if (isPluginEnabled("SlimeHUD")) {
            try {
                log(Level.INFO, "检测到服务器已安装 SlimeHUD!");
                log(Level.INFO, "接入相关功能...");
                SlimeHUDSetup.setup();
            } catch (NoClassDefFoundError e) {
                log(Level.WARNING, "该服务器安装的 SlimeHUD 版本不兼容");
                log(Level.WARNING, "请更新 SlimeHUD 至最新版本!");
            }
        }

        if (!isPluginEnabled("ExoticGarden")) {
            log(Level.WARNING, "检测到服务器未安装 异域花园(ExoticGarden)!");
            log(Level.WARNING, "需要异域花园物品的配方将被隐藏。");
        }

        if (isPluginEnabled("DynaTech") && !getConfig().getBoolean("disable-dynatech-integration")) {
            try {
                log(Level.INFO, "检测到服务器已安装 动力科技(DynaTech)!");
                log(Level.INFO, "正在向动力科技添加相关作物...");
                DynaTechSetup.setup();
            } catch (NoClassDefFoundError e) {
                log(Level.WARNING, "该服务器安装的 DynaTech 版本不兼容");
                log(Level.WARNING, "请更新 DynaTech 至最新版本!");
            }
        }

        playerData = new AddonConfig("player.yml");
        customFood = new AddonConfig("custom-food.yml");

        TreeStructure.loadTrees();
    }

    @Override
    public void disable() {
        instance = null;
        if (getPlayerData() != null) {
            getPlayerData().save();
        }
    }

    public static NamespacedKey key(@Nonnull String name) {
        return new NamespacedKey(Gastronomicon.getInstance(), name);
    }

    public static boolean isPluginEnabled(String name) {
        return getInstance().getServer().getPluginManager().isPluginEnabled(name);
    }

    public static int scheduleSyncDelayedTask(Runnable runnable, long delay) {
        return Bukkit.getScheduler().scheduleSyncDelayedTask(getInstance(), runnable, delay);
    }

    public static BukkitTask scheduleSyncRepeatingTask(Runnable runnable, long delay, long interval) {
        return Bukkit.getScheduler().runTaskTimer(getInstance(), runnable, delay, interval);
    }

    public static boolean checkPermission(Player player, @Nonnull String permissionNode, @Nullable String message) {
        if (player.hasPermission(permissionNode)) {
            return true;
        }

        if (message != null)
            Gastronomicon.sendMessage(player, message);
        return false;

    }

    public static void info(String message) {
        getInstance().getLogger().info(message);
    }

    public static void warn(String message) {
        getInstance().getLogger().warning(message);
    }

    public static void error(String message) {
        getInstance().getLogger().severe(message);
    }

    public static void sendMessage(Player player, String message) {
        player.sendMessage(ChatColor.of("#c91df4") + "§l美食家§7§l> §7" + StringUtil.formatColors(message));
    }

    public static void sendMessage(Player player, Component message) {
        final Component text = Component.text()
            .content("美食家")
            .color(TextColor.color(0xc9, 0x1d, 0xf4))
            .decorate(TextDecoration.BOLD)
            .append(Component.text()
                .content(">")
                .color(TextColor.color(0xaa, 0xaa, 0xaa))
                .decorate(TextDecoration.BOLD)
                .appendSpace()
                .asComponent())
            .asComponent();
        player.sendMessage(text);
    }
}
