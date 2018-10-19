package de.felix.objectsshow.drawing;

import de.felix.objectsshow.Canvas;
import de.felix.objectsshow.Direction;

import java.awt.*;

public class DrawingObject implements IDrawingObject {

    /**
     * I know that this should not be public,
     * but with this people can better extend this
     */
    public Position position;
    public Boolean visible;
    /**
     * Show Object in Canvas
     */
    @Override
    public void show() {
        setVisibility(true);
    }

    /**
     * Hide Object in Canvas
     */
    @Override
    public void hide() {
        setVisibility(false);
    }

    /**
     * Set visibility
     *
     * @param visibility visibile if true
     */
    @Override
    public void setVisibility(Boolean visibility) {
        visible = visibility;
    }

    /**
     * Set Position
     *
     * @param pos Position as position
     */
    @Override
    public void setPosition(Position pos) {
        position = pos;
    }

    /**
     * Teleport Object
     *
     * @param direction Direction as Direction
     * @param distance  Distance as Distance (in pixel)
     */
    @Override
    public void move(Direction direction, Double distance) {
        position.addX(distance * direction.getXMultiplicator());
        position.addY(distance * direction.getYMultiplicator());
    }

    /**
     * Move Object
     *
     * @param direction Direction as Direction
     * @param distance  Distance as Distance
     */
    @Override
    public void moveSlowly(Direction direction, Double distance) {
        Double forward = distance * 0.01;
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (Double i = 0.0; i <= distance; i= i + forward){
                    move(direction, forward);
                }
            }
        }).start();
    }

    /**
     * Returns Position object
     *
     * @return Position object
     */
    @Override
    public Position getPosition() {
        return position;
    }

    /**
     * Returns a new Position Object
     * @return Postion object (not referenced)
     */
    public Position getPositionWithoutReference(){
        return position.clone();
    }
    /**
     * This Method does nothing here. Because this is an empty Object, so it should not show anything
     * @param graphics JFrame Graphics Object
     */
    @Override
    public void draw(Graphics graphics) {
        /*
        if (visible){
            ...
        }
        */
    }
}
