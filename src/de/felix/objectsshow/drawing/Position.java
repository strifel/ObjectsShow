package de.felix.objectsshow.drawing;

public class Position {
    private Double x;
    private Double y;

    /**
     * Constructor with given coordinates
     * @param x of position
     * @param y of position
     */
    public Position(Double x, Double y){
        this.x = x;
        this.y = y;
    }

    /**
     * Constructor with 0,0 as coordinates
     */
    public Position(){
        x = 0.0;
        y = 0.0;
    }

    /**
     * @return x coordinate
     */
    public Double getX() {
        return x;
    }

    /**
     * Sets x coordinate of position
     * @param x coordinate
     */
    public void setX(Double x) {
        this.x = x;
    }

    /**
     * @return y coordinate
     */
    public Double getY() {
        return y;
    }

    /**
     * Sets Y coordinate
     * @param y coordinate
     */
    public void setY(Double y) {
        this.y = y;
    }

    /**
     * Adds somethings to x
     * @param x added amount
     */
    public void addX(Double x){
        setX(getX() + x);
    }

    /**
     * Adds something to y
     * @param y coordinate
     */
    public void addY(Double y){
        setY(getY() + y);
    }

    /**
     * Returns clone of position
     * @return new Position Object
     */
    public Position clone(){
        return new Position(x, y);
    }
}
