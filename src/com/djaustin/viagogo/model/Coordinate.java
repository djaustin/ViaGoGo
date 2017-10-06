package com.djaustin.viagogo.model;

/**
 * Class to represent a location determined by an X and a Y value on a grid
 */
public class Coordinate {
    private int x,y;

    /**
     * Construct a new coordinate with a given X and Y value
     * @param x The X value of the coordinate
     * @param y The Y value of the coordinate
     */
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Get the X value of the coordinate
     * @return The X value of the coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Set the X value of the coordinate
     * @param x The X value of the coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Get the Y value of the coordinate
     * @return y Get the Y value of the coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Set the Y value of the coordinate
     * @param y The Y value of the coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Calculates the Manhattan distance between this coordinate and another coordinate
     * @param coordinate The coordinate from which to calculate the distance
     * @return The Manhattan distance from
     */
    public int getManhattanDistanceFromCoordinate(Coordinate coordinate){
        return Math.abs(this.x - coordinate.x) + Math.abs(this.y - coordinate.y);
    }

    /**
     * Return a string representation of the Coordinate in the form (x,y) where x and y are the numeric values
     * @return A string representation of the Coordinate in the form (x,y) where x and y are the numeric values
     */
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
