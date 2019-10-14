import greenfoot.Greenfoot;
import greenfoot.MouseInfo;

/**
 * This is a wrapper class for Greenfoots mouse controls.
 * It's aim is to replace the greenfoot.MouseInfo class and
 * the corresponding mouse oriented methods in the
 * greenfoot.Greenfoot class.
 * It's also designed to try to be simpler and easier to use.
 * It automatically checks Greenfoots mouse methods for
 * changes with the mouse motion.
 * @author Joseph Lenton
 * @version 27/07/2008
 */
public class Mouse
{
    private static MouseThread thread = null;
    
    /**
     * Tells any currently executing MouseThreads to stop executing.
     * Note that it does not actually kill them as they are just
     * left in a state where they should naturally stop executing.
     */
    private static void killMouseThread()
    {
        if (thread != null) {
            thread.runThread = false;
            thread = null;
        }
    }
    
    private boolean down;
    
    private int x;
    private int y;

    private int button;
    
    /**
     * Creates a new MouseHandler to get and store mouse controls.
     */
    public Mouse()
    {
        down = false;
        x = 0;
        y = 0;
        
        killMouseThread();
        thread = new MouseThread();
        thread.mouse = this;
        thread.start();
    }

    /**
     * Checks the current condition of the mouse using Greenfoots
     * standard mouse methods.
     */
    private void update()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            down = Greenfoot.mousePressed(null) || Greenfoot.mouseDragged(null);
            if (down && button == 0) {
                button = mouse.getButton();
            } else if (!down) {
                button = 0;
            }
            
            x = mouse.getX();
            y = mouse.getY();
        }
    }
    
    /**
     * @return True if any mouse button is currently down, false if not.
     */
    public boolean isMouseDown()
    {
        return down || button != 0;
    }
    
    /**
     * @return True if the left mouse button is currently down, false if not.
     */
    public boolean isLeftMouseDown()
    {
        return isMouseDown() && button == 1;
    }
    
    /**
     * @return True if the middle mouse button is currently down, false if not.
     */
    public boolean isMiddleMouseDown()
    {
        return isMouseDown() && button == 2;
    }
    
    /**
     * @return True if the right mouse button is currently down, false if not.
     */
    public boolean isRightMouseDown()
    {
        return isMouseDown() && button == 3;
    }
    
    /**
     * @return The current X positon of the mouse.
     */
    public int getX()
    {
        return x;
    }
    
    /**
     * @return The current Y positon of the mouse.
     */
    public int getY()
    {
        return y;
    }
    
    /**
     * This is a thread to update the MouseHandler instance periodically.
     * When it is not updating the MouseHandler, it is sleeping.
     */
    private class MouseThread extends Thread
    {
        private boolean runThread = true;
        private Mouse mouse;
        
        private MouseThread()
        {
            super("mouse listening thread");
        }
        
        /**
         * Calls for the associated MouseHandler to update and then sleeps.
         */
        @Override
        public void run()
        {
            while (runThread) {
                mouse.update();
                Thread.yield();
            }
            
            return;
        }
    }
}
