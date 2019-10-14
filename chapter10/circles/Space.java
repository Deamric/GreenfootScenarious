import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Point2D;

/**
 * The Space that the Circles exist and bounce around in.
 * It has gravity and tracks mouse input for creating new
 * Circles in Space. If the left mouse button is pressed
 * then a new Circle is created in the World at the current
 * mouse location. The circle will move in the direction
 * the mouse is currently moving.
 * 
 * @author Joseph Lenton - JL235@Kent.ac.uk
 * @version 17/08/2008
 */
public class Space extends World
{
    // the gravity of the Space world
    public static double GRAVITY = 0.00098;
    
    // the speed that new circles will start at
    private static double SPEED = 2;
    
    // for tracking mouse position
    private static final Mouse MOUSE = new Mouse();
    
    // the maximum delay to wait for in order to create circles
    private static final int CIRCLE_DELAY = 6;
    
    // the position of the mouse currently, and on the last time it acted
    private Point currentPosition;
    private Point lastPosition;
    
    // the current delay to wait for creating circles
    private int circleDelay;
    
    /**
     * Trivial constructor creating a new Space world.
     */
    public Space()
    {
        super(800, 600, 1);
        
        currentPosition = null;
        lastPosition = null;
        
        // give it a black background
        GreenfootImage background = new GreenfootImage(getWidth(), getHeight());
        background.setColor(Color.BLACK);
        background.fill();
        setBackground(background);
    }
    
    /**
     * Waits for user mouse input and then creates new Circles
     * if any mouse button is pressed. It'll be produced at the
     * current location of the Mouse.
     */
    public void act()
    {
        // increment the delay
        circleDelay = ++circleDelay % CIRCLE_DELAY;
        
        // if there is user input and we have the position to make a circle
        if (MOUSE.isLeftMouseDown() && hasPosition()) {
            // if we should make a circle on this frame
            if (circleDelay == 0) {
                Point2D deltaXY = calculateDeltaXY();
                addObject(
                    new Circle(deltaXY.getX(),deltaXY.getY()),
                    currentPosition.x,
                    currentPosition.y);
            }
        }
        
        // track the mouse position
        Point newPosition = new Point(MOUSE.getX(), MOUSE.getY());
        // If the mouse position has changed, we record it.
        /* If we update when the mouse hasn't moved then the circles
         * just spit out in one direction. */
        if (!newPosition.equals(currentPosition)) {
            lastPosition = currentPosition;
            currentPosition = newPosition;
        }
    }
    
    /**
     * @return True if there are recorded positions, false if not.
     */
    private boolean hasPosition()
    {
        return currentPosition != null && lastPosition != null;
    }
    
    /**
     * @return A new Point2D that contains the initial DeltaX and DeltaY based on the stored positions.
     */
    private Point2D calculateDeltaXY()
    {
        double angle = Math.atan2(
                currentPosition.y - lastPosition.y,
                currentPosition.x - lastPosition.x);
        return new Point2D.Double(SPEED*Math.cos(angle), SPEED*Math.sin(angle));
    }
}
