import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A flower that reacts to mouse clicks by jumping to the right.
 * 
 * @author Michael Kolling
 * @version 1.0
 */
public class Flower  extends Actor
{
    /**
     * Act - move to the right if clicked with the mouse.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) {
            setLocation (getX() + 10, getY());
        }
    }    
}
