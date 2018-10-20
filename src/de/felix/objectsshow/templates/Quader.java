package de.felix.objectsshow.templates;

import de.felix.objectsshow.drawing.DrawingObject;

import java.awt.*;

public class Quader extends DrawingObject {
    private int x = 20;
    private int y = 20;
    @Override
    public void setSize(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setQuaderSize(int size){
        x = size;
        y = size;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.fillRect(position.getX().intValue(),position.getY().intValue(), x, y );
    }
}
