import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A representation of a given RGB color value.
 * 
 * @author Michael Kolling
 * @version 1.0
 */
public class Color  extends Actor
{
    /**
     * Create a color patch with given RGB value.
     */
    public Color(int r, int g, int b)
    {
        GreenfootImage img = new GreenfootImage (80, 20);
        img.setColor (new java.awt.Color(r, g, b));
        img.fill();
        
        if (g < 128) {
            img.setColor (java.awt.Color.WHITE);
        }
        else {
            img.setColor (java.awt.Color.BLACK);
        }
        img.setFont (img.getFont().deriveFont(10.0f));
        img.drawString (r + "," + g + "," + b, 10, 14);

        setImage (img);
    }
}
