package de.felix.objectsshow.plugin;

import de.felix.objectsshow.Canvas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;

public class PluginManager implements KeyListener {
    private static final Double VERSION = 0.1;
    private ArrayList<IPlugin> plugins = new ArrayList<>();
    private HashMap<Integer, IPluginKeyEvent> keybinds = new HashMap<>();
    private Canvas canvas;

    public PluginManager(Canvas canvas) {
        this.canvas = canvas;
    }

    public boolean loadPlugin(IPlugin plugin) {
        if (plugin.getManagerVersion() <= VERSION) {
            try {
                plugin.enablePlugin(this);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            plugins.add(plugin);
            return true;
        }
        return false;
    }

    public boolean registerKeyBind(int key, IPlugin plugin) {
        //TODO Check if implements IPluginKeyEvent
        if (keybinds.containsKey(key)) return false;
        IPluginKeyEvent keyEventPlugin = (IPluginKeyEvent) plugin;
        keybinds.put(key, keyEventPlugin);
        return true;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        int code = keyEvent.getKeyCode();
        if (keybinds.get(code) != null) keybinds.get(code).keyTyped(code);
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int code = keyEvent.getKeyCode();
        if (keybinds.get(code) != null) keybinds.get(code).keyPressed(code);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        int code = keyEvent.getKeyCode();
        if (keybinds.get(code) != null) keybinds.get(code).keyReleased(code);
    }
}
