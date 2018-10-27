package de.felix.objectsshow.objects;

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
        if (visible) {
            graphics.setColor(color);
            Font font = new Font("TimesRoman", Font.PLAIN, 24);
            graphics.setFont(font);
            graphics.drawString(Integer.toString(canvas.currentFPS), position.getX().intValue(), position.getY().intValue());

        }
    }

}
