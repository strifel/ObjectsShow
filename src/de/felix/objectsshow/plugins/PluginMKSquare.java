package de.felix.objectsshow.plugins;

import de.felix.objectsshow.drawing.Position;
import de.felix.objectsshow.objects.Quader;
import de.felix.objectsshow.plugin.IPlugin;
import de.felix.objectsshow.plugin.IPluginMouseEvent;
import de.felix.objectsshow.plugin.PluginManager;

public class PluginMKSquare implements IPlugin, IPluginMouseEvent {

    private PluginManager manager;
    private int startX = -1;
    private int startY = -1;

    @Override
    public Double getManagerVersion() {
        return 0.1;
    }

    @Override
    public String getName() {
        return "MKSquare";
    }

    @Override
    public void enablePlugin(PluginManager pluginManager) {
        manager = pluginManager;
        manager.registerMouseEvent(this);

    }

    @Override
    public void disablePlugin() {

    }

    @Override
    public void mousePressed(int x, int y) {
        if (startX == -1 && startY == -1) {
            startX = x;
            startY = y;
        }
    }

    @Override
    public void mouseReleased(int x, int y) {
        Quader drawed = new Quader();
        if (x - startX > 0 && y - startY > 0) {
            drawed.setSize(x - startX, y - startY);
            drawed.setPosition(new Position(startX + 0.0, startY + 0.0));
        } else if (startX - x > 0 && startY - y > 0) {
            drawed.setSize(startX - x, startY - y);
            drawed.setPosition(new Position(x + 0.0, y + 0.0));
        } else if (startX - x > 0 && y - startY > 0) {
            drawed.setSize(startX - x, y - startY);
            drawed.setPosition(new Position(x + 0.0, startY + 0.0));
        } else if (x - startX > 0 && startY - y > 0) {
            drawed.setSize(x - startX, startY - y);
            drawed.setPosition(new Position(startX + 0.0, y + 0.0));
        }
        drawed.show();
        manager.getCanvas().addObject(drawed);

        startX = -1;
        startY = -1;
    }

    @Override
    public void mouseRightClicked(int x, int y) {

    }
}
