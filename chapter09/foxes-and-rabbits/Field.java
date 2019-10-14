import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * The world contaning the foxes and rabbits (and other animals you might like to create).
 * 
 * @author mik
 * @version 1.0
 */
public class Field extends World
{
    // Constants representing configuration information for the simulation.
    // The default width for the grid.
    private static final int WIDTH = 40;
    // The default depth of the grid.
    private static final int HEIGHT = 30;
    // The probability that a fox will be created in any given grid position (in percent).
    private static final int FOX_CREATION_PROBABILITY = 2;
    // The probability that a rabbit will be created in any given grid position (in percent).
    private static final int RABBIT_CREATION_PROBABILITY = 8;

    // The current step of the simulation.
    private int step = 0;

    /**
     * Create the field and populate it with foxes and rabbits.
     */
    public Field()
    {    
        super(WIDTH, HEIGHT, 8);
        populate();
        addObject(new Plotter(300, 150, 500, this, Rabbit.class, Fox.class), 0, 0);
    }
    
    /**
     * Populate a field with foxes and rabbits.
     */
    private void populate()
    {
        for(int row = 0; row < HEIGHT; row++) {
            for(int col = 0; col < WIDTH; col++) {
                if(Greenfoot.getRandomNumber(100) <= FOX_CREATION_PROBABILITY) {
                    Fox fox = new Fox(true);
                    addObject(fox, col, row);
                }
                else if(Greenfoot.getRandomNumber(100) <= RABBIT_CREATION_PROBABILITY) {
                    Rabbit rabbit = new Rabbit(true);
                    addObject(rabbit, col, row);
                }
                // else leave the location empty.
            }
        }
    }

    /**
     * Generate a random location that is adjacent to the
     * given location, or is the same location.
     * The returned location will be within the valid bounds
     * of the field.
     */
    public Location randomAdjacentLocation(int x, int y)
    {
        // Generate an offset of -1, 0, or +1 for both the current x and y.
        int nextX = x + Greenfoot.getRandomNumber(3) - 1;
        int nextY = y + Greenfoot.getRandomNumber(3) - 1;
        // Check in case the new location is outside the bounds.
        if(nextX < 0 || nextX >= WIDTH || nextY < 0 || nextY >= HEIGHT) {
            return new Location(x, y);
        }
        else {
            return new Location(nextX, nextY);
        }
    }
    
    /**
     * Try to find a free location that is adjacent to the
     * given location. If there is none, then return the current
     * location if it is free. If not, return null.
     * The returned location will be within the valid bounds
     * of the field.
     */
    public Location freeAdjacentLocation(int x, int y)
    {
        Iterator<Location> adjacent = adjacentLocations(x, y);
        while(adjacent.hasNext()) {
            Location next = adjacent.next();
            if(getObjectsAt(next.getX(), next.getY(), null).isEmpty()) {
                return next;
            }
        }
        // check whether current location is free
        if(getObjectsAt(x, y, null).isEmpty()) {
            return new Location(x, y);
        } 
        else {
            return null;
        }
    }

    /**
     * Generate an iterator over a shuffled list of locations adjacent
     * to the given one. The list will not include the location itself.
     * All locations will lie within the grid.
     */
    public Iterator<Location> adjacentLocations(int x, int y)
    {
        List<Location> locations = new LinkedList<Location>();
        for(int xoffset = -1; xoffset <= 1; xoffset++) {
            int nextX = x + xoffset;
            if(nextX >= 0 && nextX < WIDTH) {
                for(int yoffset = -1; yoffset <= 1; yoffset++) {
                    int nextY = y + yoffset;
                    // Exclude invalid locations and the original location.
                    if(nextY >= 0 && nextY < HEIGHT && (xoffset != 0 || yoffset != 0)) {
                        locations.add(new Location(nextX, nextY));
                    }
                }
            }
        }
        Collections.shuffle(locations);
        return locations.iterator();
    }
}
