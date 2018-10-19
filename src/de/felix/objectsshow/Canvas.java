package de.felix.objectsshow;

import com.sun.xml.internal.bind.v2.model.core.ID;
import de.felix.objectsshow.drawing.IDrawingObject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class Canvas {
    //All variables in this class are public in order to allow user to extend class and modify it easily
    public ArrayList<IDrawingObject> drawingObjects;
    public JFrame frame;
    public long nextRender;
    public long lastRender;
    public int time_bt_render;
    public Thread drawThread;

    public Canvas(String title, int sizeX, int sizeY){
        drawingObjects = new ArrayList<>();
        frame = new JFrame(title);
        drawThread = new Thread(drawRunnabe);
        drawThread.start();
    }
    public void setMaxFps(int fps){
        time_bt_render = 1000/fps;
    }
    public void addObject(IDrawingObject object){
        drawingObjects.add(object);
    }

    public void setBackground(Color color){
        frame.setBackground(color);
    }

    public Runnable drawRunnabe = new Runnable() {
        @Override
        public void run() {
            for (IDrawingObject object : drawingObjects){
                object.draw(frame.getGraphics());
            }
            lastRender = System.currentTimeMillis();
            nextRender = nextRender + time_bt_render;
            if (nextRender - lastRender > 0){
                try {
                    Thread.sleep(nextRender - lastRender);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };
}
