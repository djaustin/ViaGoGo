# ViaGoGo Coding Exercise

## Build and Run
The coding exercise has been completed in Java, using Java version 1.8.0_144.
### Build
1. Download the repository.
2. Navigate to the root directory of the repository.
3. Create a 'build' directory.
4. Run the following from the root directory:
```bash
javac -d build src/com/djaustin/viagogo/*.java src/com/djaustin/viagogo/model/*.java src/com/djaustin/viagogo/seed/*.java
```

### Run
1. Navigate into the 'build' directory
2. Run the following from the build directory, substituting 'x' and 'y' for integer values to form a coordinate:
```bash
java com.djaustin.viagogo.Main x,y
```


## Assumptions
1. User coordinates will be passed in as the first command line argument in the form x,y.
2. For the purpose of generating data, a maximum number of tickets per event of 10 and a maximum ticket price of $100 is sufficient.

## Questions
**How might you change your program if you needed to support multiple events at the same location?**

In order to facilitate multiple events at one location, the member variable 'event' in the class 'GridLocation' could be changed to be a collection of events instead of a single instance.

**How would you change your program if you were working with a much larger world
size?**

The program has been designed to work with a larger world than specified. The grid system only stores information relating to grid locations that contain events in order to save space and the search algorithm has aims to reduce computational complexity. It may be beneficial to maintain a sorted list of tickets for each event where the first ticket has the lowest cost. This would increase the insertion time of a ticket but would reduce the search time especially for cases where the number of tickets for an event is substantial.
