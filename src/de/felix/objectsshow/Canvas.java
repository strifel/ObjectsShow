package de.felix.objectsshow;


import de.felix.objectsshow.drawing.IDrawingObject;
import de.felix.objectsshow.plugin.PluginManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;


public class Canvas {
    //All variables in this class are public in order to allow user to extend class and modify it easily
    public ArrayList<IDrawingObject> drawingObjects;
    public JFrame frame;
    public long nextRender;
    public long lastRender;
    public int time_bt_render = 33;
    public int currentFPS;
    public Thread drawThread;
    public PluginManager pluginManager;

    public Canvas(String title, int sizeX, int sizeY) {
        drawingObjects = new ArrayList<>();
        pluginManager = new PluginManager(this);
        frame = new JFrame(title);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(sizeX, sizeY);
        frame.addKeyListener(pluginManager);
        frame.addMouseListener(pluginManager);
        drawThread = new Thread(drawRunnabe);
        drawThread.start();
    }

    public void setMaxFps(int fps) {
        time_bt_render = 1000 / fps;
    }

    public void addObject(IDrawingObject object) {
        drawingObjects.add(object);
    }

    public void removeObject(IDrawingObject object) {
        drawingObjects.remove(object);
    }

    public void setBackground(Color color) {
        frame.setBackground(color);
    }

    public int getCurrentFPS() {
        return currentFPS;
    }

    public Runnable drawRunnabe = new Runnable() {
        @Override
        public void run() {
            //TODO Maybe do not use true
            nextRender = System.currentTimeMillis();


            while (true) {
                frame.getGraphics().clearRect(0, 0, frame.getWidth(), frame.getHeight());
                try {
                    for (IDrawingObject object : drawingObjects) {
                        object.draw(frame.getGraphics());
                    }
                } catch (ConcurrentModificationException ignored) {
                }
                lastRender = System.currentTimeMillis();
                nextRender = nextRender + time_bt_render;
                if (nextRender - lastRender > 0) {
                    currentFPS = 1000 / time_bt_render;
                    try {
                        Thread.sleep(nextRender - lastRender);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    long skipped = lastRender - nextRender;
                    System.err.println("System running too slow, skipped " + skipped + "ms");
                    long fps_dif = lastRender - System.currentTimeMillis();
                    if (fps_dif > 0){
                        currentFPS = Math.toIntExact(1000 / fps_dif);
                    }
                    nextRender = System.currentTimeMillis();
                }
            }
        }
    };
}
