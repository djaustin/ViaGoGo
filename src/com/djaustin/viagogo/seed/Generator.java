package com.djaustin.viagogo.seed;

import com.djaustin.viagogo.model.*;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Class used to generate random Grid data
 */
public class Generator {

    // Tracks the number of events that have been generated
    private int eventCount;

    /**
     * Initialise a new Generator
     */
    public Generator(){
        this.eventCount = 0;
    }

    /**
     * Generates a Grid object containing a randomly distributed events with a random number of tickets in each
     * @return A randomly generated Grid object
     */
    public Grid generateGrid(int xSize, int ySize){
        Grid grid = new Grid();
        for (int i = 0; i <= xSize; i++) {
            for (int j = 0; j <= ySize; j++) {
                boolean hasEvent = ThreadLocalRandom.current().nextInt(0, 100) > 50;
                if(hasEvent){
                    GridLocation gridLocation = new GridLocation();
                    Coordinate coordinate = new Coordinate(i-xSize/2, j-ySize/2);
                    gridLocation.setCoordinate(coordinate);
                    Event event = generateRandomEvent();
                    gridLocation.setEvent(event);
                    grid.addGridLocation(gridLocation);
                }
            }
        }
        return grid;
    }

    /**
     * Generates an event with a random number of tickets (0-10) and prices (0-100)
     * @return An event containing random tickets
     */
    private Event generateRandomEvent() {
        Event event = new Event(eventCount++);
        int numberOfTickets = ThreadLocalRandom.current().nextInt(11);
        for (int i = 0; i < numberOfTickets; i++) {
            int costOfTicket = ThreadLocalRandom.current().nextInt(10000);
            Ticket ticket = new Ticket(costOfTicket);
            event.addTicket(ticket);
        }
        return event;
    }
}
