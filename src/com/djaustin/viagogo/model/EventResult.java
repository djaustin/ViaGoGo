package com.djaustin.viagogo.model;

/**
 * Represents a result of searching for nearby events. Contains the Event and the Manhattan distance from the query location
 */
public class EventResult {
    private Event event;
    private int distance;

    /**
     * Gets the Event object contained in this event result.
     * @return The Event object contained in this event result.
     */
    public Event getEvent() {
        return event;
    }

    /**
     * Sets the Event object contained in this event result.
     * @param event The Event object to be contained in this event result.
     */
    public void setEvent(Event event) {
        this.event = event;
    }

    /**
     * Gets the distance from the Event location to the query location
     * @return The distance from the Event location to the query location
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Sets the distance from the Event location to the query location
     * @param distance The distance form the Event location to the query location
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }
}
