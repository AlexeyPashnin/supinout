package ru.monnae.supinout.listener;

import org.bukkit.event.Listener;
import ru.monnae.supinout.plugin.start.Supinout;

import java.util.ArrayList;

public class ListenerManager {
    private Supinout instance;

    public ListenerManager() {
        this.instance = Supinout.getInstance();
    }

    public void loadListeners() {
        ArrayList<Listener> listeners = new ArrayList<>();
        listeners.add(new AsyncPlayerChatListener());
        listeners.add(new PlayerCommandPreprocessListener());
        listeners.add(new PlayerInteractEntityListener());
        listeners.add(new PlayerInteractListener());
        listeners.add(new PlayerJoinListener());
        listeners.add(new PlayerMoveListener());
        listeners.add(new PlayerQuitListener());
        listeners.add(new PlayerDropItemListener());
        listeners.add(new PlayerItemHeldListener());
        listeners.add(new PlayerLevelChangeListener());
        listeners.add(new PlayerPickupArrowListener());
        listeners.add(new PlayerPortalListener());
        listeners.add(new EntityAirChangeListener());
        listeners.add(new EntityDamageByEntityListener());
        listeners.add(new EntityPickupItemListener());
        listeners.add(new EntityDamageListener());
        listeners.add(new InventoryClickListener());



        for (Listener listener : listeners) {
            instance.getServer()
                    .getPluginManager()
                    .registerEvents(listener, instance);
        }
    }
}