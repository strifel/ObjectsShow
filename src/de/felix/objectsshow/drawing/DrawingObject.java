package de.felix.objectsshow.drawing;

import de.felix.objectsshow.Direction;

import java.awt.*;

public class DrawingObject implements IDrawingObject {

    /**
     * I know that this should not be public,
     * but with this people can better extend this
     */
    public Position position = new Position();
    public Boolean visible = false;
    public Color color = Color.BLACK;
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
     * Sets the color
     *
     * @param color color as awt color
     */
    @Override
    public void setColor(Color color) {
        this.color = color;
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
     * Set size
     *
     * @param x
     * @param y
     */
    @Override
    public void setSize(int x, int y) {

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
        Double forward = 1.0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (Double i = 0.0; i <= distance; i= i + forward){
                    move(direction, forward);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
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
