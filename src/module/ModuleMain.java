package module;

import module.yamlfile.ConfigManager;
import org.bukkit.ChatColor;

import java.util.HashMap;
import java.util.Map;

public class ModuleMain extends ConfigManager {
    private static Map<String, String> playerLocationMap = new HashMap<>();

    public static void addMap(String playerName, String Loc) {
        playerLocationMap.put(playerName, Loc);
    }

    public static void delMap(String playerName) {
        playerLocationMap.remove(playerName);
    }

    public static String getValue(String playerName) {
        return playerLocationMap.get(playerName);
    }

    public static String color (String msg) {
        if (msg.contains("&"))
            return msg.replace('&', ChatColor.COLOR_CHAR);
        return msg;
    }
}