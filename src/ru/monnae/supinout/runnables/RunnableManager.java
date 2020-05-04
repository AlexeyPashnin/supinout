package ru.monnae.supinout.runnables;

import org.bukkit.scheduler.BukkitRunnable;
import ru.monnae.supinout.plugin.start.Supinout;
import java.util.HashMap;

public class RunnableManager {
    private Supinout instance;

    private HashMap<String, Runnable> runnables;

    public RunnableManager() {
        this.instance = Supinout.getInstance();
        runnables = new HashMap<>();
    }

    public HashMap<String, Runnable> getRunnables() {
        return runnables;
    }
}
