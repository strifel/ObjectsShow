package de.felix.objectsshow.plugins;

import de.felix.objectsshow.drawing.IDrawingObject;
import de.felix.objectsshow.exceptions.KeyAlreadyUsedException;
import de.felix.objectsshow.objects.FPSShow;
import de.felix.objectsshow.plugin.IPlugin;
import de.felix.objectsshow.plugin.IPluginKeyEvent;
import de.felix.objectsshow.plugin.PluginManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PluginSave implements IPlugin, IPluginKeyEvent {
    public static final int KEY = 0;
    private PluginManager pluginManager;
    private String folder;

    public PluginSave(File folder) {
        this.folder = folder.getAbsolutePath();
    }

    @Override
    public Double getManagerVersion() {
        return 0.1;
    }

    @Override
    public String getName() {
        return "Save";
    }

    @Override
    public void enablePlugin(PluginManager pluginManager) throws KeyAlreadyUsedException {
        this.pluginManager = pluginManager;
        if (!this.pluginManager.registerKeyBind(KEY, this)) {
            throw new KeyAlreadyUsedException(KEY);
        }
    }

    @Override
    public void disablePlugin() {

    }

    @Override
    public void keyPressed(int key) {
        //Ignoring this
    }

    @Override
    public void keyReleased(int key) {
        //Ignoring this
    }

    @Override
    public void keyTyped(int key) {
        //Because only one key is registered this is not needed
        if (key == KEY) {
            save(System.currentTimeMillis() + "");
        }
    }

    private void save(String name) {
        ArrayList<IDrawingObject> objects = pluginManager.getCanvas().drawingObjects;
        try {
            BufferedImage image = new BufferedImage(pluginManager.getCanvas().frame.getWidth(), pluginManager.getCanvas().frame.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics graphics = image.createGraphics();
            for (IDrawingObject object : objects) {
                if (object instanceof FPSShow) break;
                object.draw(graphics);
            }
            ImageIO.write(image, "PNG", new File(folder + "/" + name + ".png"));
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
