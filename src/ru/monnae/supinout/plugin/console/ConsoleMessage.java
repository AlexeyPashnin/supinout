package ru.monnae.supinout.plugin.console;

import org.bukkit.ChatColor;

public class ConsoleMessage {
    private final static String ERROR  = ChatColor.DARK_RED + "[ОШИБКА]: " + ChatColor.WHITE + "%s";
    private final static String WARNING = ChatColor.RED + "[ПРЕДУПРЕЖДЕНИЕ]: " + ChatColor.WHITE + "%s";
    private final static String INFO = ChatColor.BLUE + "[ИНФОРМАЦИЯ]: " + ChatColor.WHITE + "%s";

    public static String getError(String error) {
        return String.format(ERROR, error);
    }

    public static String getWarning(String warning) {
        return String.format(WARNING, warning);
    }

    public static String getInfo(String info) {
        return String.format(INFO, info);
    }
}