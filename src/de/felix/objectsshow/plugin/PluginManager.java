package de.felix.objectsshow.plugin;

import de.felix.objectsshow.Canvas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

public class PluginManager implements KeyListener, MouseListener {
    private static final Double VERSION = 0.1;
    private ArrayList<IPlugin> plugins = new ArrayList<>();
    private HashMap<Integer, IPluginKeyEvent> keybinds;
    private ArrayList<IPluginMouseEvent> mouseEvents;
    private Canvas canvas;

    public PluginManager(Canvas canvas) {
        this.canvas = canvas;
        keybinds = new HashMap<>();
        mouseEvents = new ArrayList<>();
    }

    public boolean loadPlugin(IPlugin plugin) {
        if (plugin.getManagerVersion() <= VERSION) {
            plugins.add(plugin);
            try {
                plugin.enablePlugin(this);
            } catch (Exception e) {
                e.printStackTrace();
                plugins.remove(plugin);
                return false;
            }

            return true;
        }
        return false;
    }

    public boolean registerKeyBind(int key, IPlugin plugin) {
        if (!plugins.contains(plugin)) return false;
        //TODO Check if implements IPluginKeyEvent
        if (keybinds.containsKey(key)) return false;
        IPluginKeyEvent keyEventPlugin = (IPluginKeyEvent) plugin;
        keybinds.put(key, keyEventPlugin);
        return true;
    }

    public boolean registerMouseEvent(IPlugin plugin) {
        if (!plugins.contains(plugin)) return false;
        //TODO Check if implements IPluginMouseEvent
        mouseEvents.add((IPluginMouseEvent) plugin);
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

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == 2) {
            for (IPluginMouseEvent event : mouseEvents) {
                event.mouseRightClicked(mouseEvent.getX(), mouseEvent.getY());
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == 1) {
            for (IPluginMouseEvent event : mouseEvents) {
                event.mousePressed(mouseEvent.getX(), mouseEvent.getY());
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == 1) {
            for (IPluginMouseEvent event : mouseEvents) {
                event.mouseReleased(mouseEvent.getX(), mouseEvent.getY());
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
