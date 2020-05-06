package ru.monnae.supinout.plugin.start;

import org.bukkit.plugin.java.JavaPlugin;
import ru.monnae.supinout.commands.CommandManager;
import ru.monnae.supinout.files.FileManager;
import ru.monnae.supinout.listener.ListenerManager;
import ru.monnae.supinout.users.UsersManager;
import ru.monnae.supinout.runnables.RunnableManager;

public class Supinout extends JavaPlugin {
    private static Supinout instance;
    private UsersManager usersManager;
    private FileManager fileManager;
    private ListenerManager listenerManager;
    private CommandManager commandManager;
    private RunnableManager runnableManager;

    public Supinout() {
        instance = this;
        fileManager = new FileManager();
        usersManager = new UsersManager();
        listenerManager = new ListenerManager();
        commandManager = new CommandManager();
        runnableManager = new RunnableManager();
    }

    public static Supinout getInstance() {
        return instance;
    }

    public FileManager getFileManager() {
        return this.fileManager;
    }

    public ListenerManager getListenerManager() {
        return this.listenerManager;
    }

    public RunnableManager getRunnableManager() {
        return this.runnableManager;
    }

    public UsersManager getUsersManager() {
        return this.usersManager;
    }

    @Override
    public void onEnable() {
        listenerManager.loadListeners();
        commandManager.loadCommands();
    }
}
