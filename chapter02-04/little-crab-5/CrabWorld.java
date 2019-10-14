import greenfoot.*;  // imports Actor, World, Greenfoot, GreenfootImage

import java.util.Random;


public class CrabWorld extends World
{
//    public static final Color pathColor = new Color(227, 202, 148);
    /**
     * Create the crab world (the beach). Our world has a size 
     * of 560x560 cells, where every cell is just 1 pixel.
     */
    public CrabWorld() 
    {
        super(560, 560, 1);
        populateWorld();
    }

    
    /**
     * Create the objects for the start of the game.
     */
    public void populateWorld()
    {
        addObject(new Crab(), 300, 300);
        
        addObject(new Lobster(), 90, 70);
        addObject(new Lobster(), 390, 200);
        addObject(new Lobster(), 360, 500);
        
        addObject(new Worm(), 20, 500);
        addObject(new Worm(), 30, 200);
        addObject(new Worm(), 60, 90);
        addObject(new Worm(), 80, 310);
        addObject(new Worm(), 150, 50);
        addObject(new Worm(), 210, 410);
        addObject(new Worm(), 220, 520);
        addObject(new Worm(), 380, 330);
        addObject(new Worm(), 410, 270);
        addObject(new Worm(), 530, 30);
    }
}