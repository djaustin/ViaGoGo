package com.djaustin.viagogo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing and Event with a list of associated tickets
 */
public class Event {

    private int id;
    private List<Ticket> tickets;

    /**
     * Construct a new Event object with a given ID and an empty list of tickets
     * @param id
     */
    public Event(int id){
        this.id = id;
        this.tickets = new ArrayList<>();
    }

    /**
     * Get the list of tickets associated to this event
     * @return The list of tickets associated to this event
     */
    public List<Ticket> getTickets() {
        return tickets;
    }

    /**
     * Add a ticket to the Event
     * @param ticket The ticket to be added to the event
     */
    public void addTicket(Ticket ticket){
        tickets.add(ticket);
    }

    /**
     * Returns a string representation of the Event in the format "Event : n tickets" where n is the number of tickets associated with this event
     * @return A string representation of the Event in the format "Event : n tickets" where n is the number of tickets associated with this event
     */
    @Override
    public String toString() {
        return "Event " + id + ": " + tickets.size() + " tickets";
    }

    /**
     * Gets the ID of the event
     * @return The ID of the event
     */
    public int getId() {
        return id;
    }

}
