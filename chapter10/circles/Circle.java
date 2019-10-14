import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * This is a Cirlce which is affected by the gravity in the Space world.
 * It starts with a random size, weight and colour for the Circle.
 * 
 * @author Joseph Lenton - JL235@Kent.ac.uk
 * @version 17/08/2008
 */
public class Circle extends Actor
{
    /* The minimum and maximum value for each component.
     * Their value must be '>= 0' and '<= 255' */
    private static final int COLOR_MIN = 50;
    private static final int COLOR_MAX = 230;
    
    // a double version of X and Y to track sub-pixel movement
    private double x;
    private double y;
    
    // the amount to move on each frame
    private double deltaX;
    private double deltaY;
    
    // a 'weight' for the Circle so it bounces more or less then other circles
    private double weight;
    
    /* the radius of the Circle,
     * should be equal to both getWidth()/2 and getHeight()/2 */
    private int radius;
    
    /**
     * Creates a new Circle that starts moving automatically
     * with the given deltaX and deltaY values.
     * @param deltaX The starting movement along the x-axis.
     * @param deltaY The starting movement along the y-axis.
     */
    public Circle(double deltaX, double deltaY)
    {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        radius = (int)Math.round(Math.pow(Random.random(2.0, 6.0), 2));
        
        // give it a circle image
        GreenfootImage img = new GreenfootImage(radius*2, radius*2);
        img.setColor(new Color(
                Random.random(COLOR_MIN, COLOR_MAX),
                Random.random(COLOR_MIN, COLOR_MAX),
                Random.random(COLOR_MIN, COLOR_MAX),
                Random.random(COLOR_MIN, COLOR_MAX)));
        img.fillOval(0, 0, radius*2 -1, radius*2 -1);
        setImage(img);
        
        weight = radius*radius*Math.PI;
    }
    
    /**
     * @param world The World this actor is being added to, it isn't used.
     */
    protected void addedToWorld(World world)
    {
        x = getX();
        y = getY();
    }
    
    /**
     * Moves the Circle bouncing it around the World.
     */
    public void act() 
    {
        // updte deltaX/Y
        x += deltaX;
        y += deltaY;
        
        // update gravity
        deltaY += Space.GRAVITY*(weight/100.0);
        
        // update the position for X and Y
        if (x < radius) {
            deltaX = (-deltaX*0.95);
            x = radius+1;
        } else if (x > getWorld().getWidth()-radius) {
            deltaX = (-deltaX*0.95);
            x = getWorld().getWidth()-radius-1;
        }
        
        if (y < radius) {
            deltaY = -deltaY*0.95;
            y = radius+1;
        } else if (y > getWorld().getHeight()-radius) {
            deltaY = -deltaY*0.95;
            y = getWorld().getHeight()-radius-1;
        }
        
        // now set the location
        setLocation((int)Math.round(x), (int)Math.round(y));
    }    
}
