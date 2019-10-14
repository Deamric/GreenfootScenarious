import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A chart to display colors.
 * 
 * @author Michael Kolling
 * @version 1.0
 */
public class Chart  extends World
{
    private static final int HEIGHT = 20;
    private static final int WIDTH = 80;
    
    /**
     * Constructor for objects of class Chart.
     * 
     */
    public Chart()
    {    
        super(500, 740, 1);
        
        for (int r = 0; r < 6; r++) {
            for (int g = 0; g < 6; g++) {
                for (int b = 0; b < 6; b++) {
                    Color c = new Color (r * 51, g * 51, b * 51);
                    addObject (c, 50 + b*WIDTH, 20 + r*HEIGHT*6 + g*HEIGHT);
                }
            }
        }
    }
}
