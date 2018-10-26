package de.felix.objectsshow.templates;

import de.felix.objectsshow.Canvas;
import de.felix.objectsshow.drawing.DrawingObject;

import java.awt.*;

public class FPSShow extends DrawingObject {
    private Canvas canvas;

    public FPSShow(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void draw(Graphics graphics) {
        if (visible)
            graphics.drawChars(Integer.toString(canvas.currentFPS).toCharArray(), position.getX().intValue(), position.getY().intValue(), 20, 20);

    }

}
