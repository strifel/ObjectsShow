package de.felix.objectsshow;

public enum Direction {
    UP(-1.0, 0.0),
    DOWN(1.0, 0.0),
    RIGHT(0.0, 1.0),
    LEFT(0.0, -1.0),
    UP_RIGHT(-1.0, 1.0),
    UP_LEFT(-1.0, -1.0),
    DOWN_RIGHT(1.0, 1.0),
    DOWN_LEFT(1.0, -1.0);

    Double x;
    Double y;

    Direction(Double x, Double y) {
        this.x = x;
        this.y = y;
    }
    public Double getXMultiplicator(){
        return this.x;
    }
    public Double getYMultiplicator(){
        return this.y;
    }
}
