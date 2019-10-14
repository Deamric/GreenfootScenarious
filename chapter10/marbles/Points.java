import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Points here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Points extends Actor
{
    private int lifetime = 0;
    private GreenfootImage img1;
    private GreenfootImage img2;
    
    public Points(String points)
    {
        img1 = new GreenfootImage (points + ".png");
        img2 = new GreenfootImage (2, 2);
        setImage (img1);
    }
    
    /**
     * 
     */
    public void act() 
    {
        if (lifetime > 100) {
            getWorld().removeObject(this);
        }
        if (lifetime < 30) {
            if ((lifetime/6) % 2 == 0) {
                setImage (img1);
            }
            else {
                setImage (img2);
            }
        }
        lifetime++;
    }    
}
