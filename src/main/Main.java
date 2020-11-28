package main;

import event.BlockBreak;
import module.ModuleMain;
import module.yamlfile.FileLoaderAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private static FileLoaderAPI block = null;

    @Override
    public void onEnable () {
        Bukkit.getPluginManager().registerEvents(new BlockBreak(), this);
        Main.block = ModuleMain.getFileLoaderAPI(this, "\\", "block.yml", false);
    }

    @Override
    public void onDisable () {
    }

    public static FileLoaderAPI getBlock() {
        return Main.block;
    }
}
