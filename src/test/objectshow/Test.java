package test.objectshow;

import de.felix.objectsshow.Canvas;
import de.felix.objectsshow.Direction;
import de.felix.objectsshow.drawing.Position;
import de.felix.objectsshow.templates.FPSShow;
import de.felix.objectsshow.templates.Quader;

public class Test {
    public static void main(String[] args){
        Canvas canvas = new Canvas("Test", 500, 500);
        canvas.setMaxFps(30);
        Quader quader = new Quader();
        quader.setQuaderSize(50);
        quader.moveSlowly(Direction.DOWN_RIGHT, 200.0);
        quader.show();
        canvas.addObject(quader);
        FPSShow fps = new FPSShow(canvas);
        fps.show();
        fps.setPosition(new Position(20.0,20.0));
        canvas.addObject(fps);
    }
}
