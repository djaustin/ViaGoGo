package com.djaustin.viagogo;

import com.djaustin.viagogo.model.*;
import com.djaustin.viagogo.seed.Generator;

import java.util.Optional;

public class Main {
    /**
     * Generates a random 20x20 grid of events and tickets then finds the 5 closest events to a point provided as a command line argument
     * @param args The command line arguments used to run the program. The user coordinate should be the first argument in the form x,y
     */
    public static void main(String[] args) {
        // Generate seed data
        Generator generator = new Generator();
        Grid grid = generator.generateGrid(20, 20);

        Optional<Coordinate> parsedCoordinate = validateAndParseUserInput(args);
        if(!parsedCoordinate.isPresent()){
            System.out.println("Invalid coordinate argument. Please input in the format x,y");
        } else{
            Coordinate userCoordinate = parsedCoordinate.get();
            // Search grid for 5 closest results
            EventResult[] eventResults = grid.getEventsNearestToLocation(userCoordinate, 5);
            // Output information for the events

            for(int i = 0; i < eventResults.length; i++) {
                EventResult result = eventResults[i];
                // Skip this iteration if less results were returned than expected
                if(result == null){continue;}

                // Print event ID
                System.out.printf("Event %03d : ", result.getEvent().getId());

                // Attempt to find cheapest ticket. There may be no tickets for the event
                Optional<Ticket> cheapestTicket = result.getEvent().getTickets().stream().reduce((ticket, ticket2) -> {
                    if (ticket.getPrice() > ticket2.getPrice()) {
                        return ticket2;
                    } else {
                        return ticket;
                    }
                });
                // Print ticket price if a cheapest ticket is found. Print 'No tickets' otherwise
                if (cheapestTicket.isPresent()) {
                    System.out.printf("$%.2f, ", cheapestTicket.get().getPrice() / 100.0);
                } else {
                    System.out.print("No tickets, ");
                }
                // Print the distance from user input to the event
                System.out.println("Distance " + result.getDistance());
            }

        }
    }

    /**
     * Validates the command line arguments to ensure that the first argument is a coordinate in the correct format.
     * @param args The command line arguments used to run the program.
     * @return Optional Coordinate if it was possible to parse the user input. Returns empty Optional if parsing was unsuccessful.
     */
    public static Optional<Coordinate> validateAndParseUserInput(String[] args){
        if (args.length < 1){
            return Optional.empty();
        } else {
            String coordinateString = args[0];
            String[] separatedCoordinateStrings = coordinateString.split(",");
            if (separatedCoordinateStrings.length != 2){
                return Optional.empty();
            }
            try {
                Coordinate userCoordinate = new Coordinate(Integer.parseInt(separatedCoordinateStrings[0]), Integer.parseInt(separatedCoordinateStrings[1]));
                return Optional.of(userCoordinate);
            } catch(NumberFormatException e){
                return Optional.empty();
            }

        }


    }
}
