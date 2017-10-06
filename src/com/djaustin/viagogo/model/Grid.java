package com.djaustin.viagogo.model;

import java.util.*;

/**
 * Represents a grid of events with associated coordinates. Only grid locations that contain events are included in the grid.
 */
public class Grid {

    // List of GridLocation objects containing the events and coordinates of existing events
    private List<GridLocation> gridLocations;

    /**
     * Constructs a new Grid object with an empty list of GridLocation objects.
     */
    public Grid(){
        this.gridLocations = new ArrayList<>();
    }

    /**
     * Gets a list of all GridLocation objects on the Grid. GridLocation objects only exist if there is an event at that location.
     * @return
     */
    public List<GridLocation> getGridLocations() {
        return gridLocations;
    }

    /**
     * Add a GridLocation object to the grid.
     * @param gridLocation The GridLocation object to be added to the grid.
     */
    public void addGridLocation(GridLocation gridLocation){
        gridLocations.add(gridLocation);
    }

    /**
     * Finds the N nearest events (using Manhattan distance) to the provided coordinate where N is the eventCount provided
     * @param coordinate The coordinate from which to calculate distance
     * @param eventCount The number of events to find
     * @return
     */
    public EventResult[] getEventsNearestToLocation(Coordinate coordinate, int eventCount){
        // Initialise a new array to store the closest events
        EventResult[] closestEvents = new EventResult[eventCount];

        // Iterate over the list of existing events once. If an event is found that is closer than those already in the array, the farthest event is replaced by the new event.
        for (int i = 0; i < gridLocations.size(); i++) {
            // Get the grid location relating to the current iteration
            GridLocation currentGridLocation = gridLocations.get(i);
            
            // Initialise and populate an EventResult object containing the Event object for that location as well as the distance from the given location.
            EventResult currentResult = new EventResult();
            currentResult.setEvent(currentGridLocation.getEvent());
            currentResult.setDistance(currentGridLocation.getCoordinate().getManhattanDistanceFromCoordinate(coordinate));
            
            // Populate the closest events array with the first n events and keep it sorted
            if (i < eventCount){
                closestEvents[i] = currentResult;
                Arrays.sort(closestEvents, new EventResultComparator());
            } else {
                // Check if the current event is closer than any of those in the result array. Replace the farthest result with the current result if so
                updateArrayIfCloserThanAny(closestEvents, currentResult);
            }
        }
        return closestEvents;
    }

    /**
     * Checks if a given EventResult object has a lower distance than any of the current array elements. Replace the object with the largest distance if it is.
     * @param closestEvents Array of current closest events
     * @param currentEventResult Event to compare to array
     */
    private void updateArrayIfCloserThanAny(EventResult[] closestEvents, EventResult currentEventResult) {
        int distanceOfCurrentEvent = currentEventResult.getDistance();
        int distanceOfFarthestEvent = closestEvents[closestEvents.length-1].getDistance();
        
        if (distanceOfCurrentEvent < distanceOfFarthestEvent){
            // Insert current event in place of current farthest and re-sort
            closestEvents[closestEvents.length-1] = currentEventResult;
            Arrays.sort(closestEvents, new EventResultComparator());
        }
    }

    /**
     * Comparator used to sort a collection of EventResult objects. The elements are sorted based on the distance property.
     */
    private class EventResultComparator implements Comparator<EventResult>{

        /**
         * Compare two EventResults based on their distance property
         * @param o1 First EventResult
         * @param o2 Second EventResult
         * @return A negative number, 0, or a positive number based on whether the first distance is lower, equal to, or higher than the second.
         */
        @Override
        public int compare(EventResult o1, EventResult o2) {
            if (o1 == null && o2 == null){
                return 0;
            } else if (o1 == null){
                return 1;
            } else if (o2 == null){
                return -1;
            } else {
                return Integer.compare(o1.getDistance(), o2.getDistance());
            }
        }
    }

}


