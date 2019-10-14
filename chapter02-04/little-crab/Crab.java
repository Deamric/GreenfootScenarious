import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * This class defines a crab. Crabs live on the beach.
 */
public class Crab extends Animal
{
    public void act()
    {
       
        checkKeyPress();
      
    }
    public void checkKeyPress(){
         if (Greenfoot.isKeyDown("left")){
             turn(-7);
            }
         if(Greenfoot.isKeyDown("right")){
            turn(7); 
            }
         if(Greenfoot.isKeyDown("up")){
            move(10); 
            }
         if(Greenfoot.isKeyDown("down")){
            move(-10); 
            }
    }
}


