package com.djaustin.viagogo.model;

/**
 * Represents a mapping between a grid coordinate and an event
 */
public class GridLocation {
    private Coordinate coordinate;
    private Event event;

    /**
     * Gets the coordinate of the event
     * @return The coordinate of the event
     */
    public Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     * Sets the coordinate of the event
     * @param coordinate The coordinate of the event
     */
    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    /**
     * Gets the event object at the grid location
     * @return The event object at the grid location
     */
    public Event getEvent() {
        return event;
    }

    /**
     * Sets the event object at the grid location
     * @param event The event object at the grid location
     */
    public void setEvent(Event event) {
        this.event = event;
    }
}
