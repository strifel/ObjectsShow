package de.felix.objectsshow.drawing;


import de.felix.objectsshow.Direction;

import java.awt.*;

public interface IDrawingObject {
    //show/hide

    /**
     * Show Object in Canvas
     */
    void show();

    /**
     * Hide Object in Canvas
     */
    void hide();
    //setter

    /**
     * Set visibility
     * @param visibility visibile if true
     */
    void setVisibility(Boolean visibility);

    /**
     * Set size
     * @param x
     * @param y
     */
    void setSize(int x, int y);
    /**
     * Set Position
     * @param pos Position as position
     */
    void setPosition(Position pos);

    //functions

    /**
     * Teleport Object
     * @param direction Direction as Direction
     * @param distance Distance as Distance (in pixel)
     */
    void move(Direction direction, Double distance);

    /**
     * Move Object
     * @param direction Direction as Direction
     * @param distance Distance as Distance
     */
    void moveSlowly(Direction direction, Double distance);
    //Getters

    /**
     * Returns Position object
     * @return Position object
     */
    Position getPosition();

    //Canvas Functions

    /**
     * This Method should only be called by Canvas
     * @param graphics JFrame Graphics Object
     */
    void draw(Graphics graphics);
}
