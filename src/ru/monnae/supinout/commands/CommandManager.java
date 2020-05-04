package ru.monnae.supinout.commands;

import org.bukkit.command.CommandExecutor;
import ru.monnae.supinout.plugin.start.Supinout;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private Supinout instance;

    public CommandManager() {
        this.instance = Supinout.getInstance();
    }

    public void loadCommands() {
        Map<String, CommandExecutor> commandExecutors = new HashMap<>();
        commandExecutors.put("signup", new SignUp());
        commandExecutors.put("signin", new SignIn());

        for (String command : commandExecutors.keySet()) {
            instance.getCommand(command).setExecutor(commandExecutors.get(command));
        }
    }
}