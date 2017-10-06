package com.djaustin.viagogo.model;

/**
 * Represents a ticket with an associated price.
 */
public class Ticket {
    private int price;

    /**
     * Construct a new Ticket object with a given price in cents
     * @param price The price in cents of the ticket
     */
    public Ticket(int price){
        this.price = price;
    }

    /**
     * Gets the price in cents of the ticket
     * @return The price in cents of the ticket
     */
    public int getPrice() {
        return price;
    }

    /**
     * Set the price in cents of the ticket
     * @param price The new price in cents of the ticket
     */
    public void setPrice(int price){
        this.price = price;
    }

}
