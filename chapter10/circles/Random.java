/**
 * A fully static class offering some simple utility
 * random functions. It allows the generating of random
 * values between a minimum and maximum value.
 * 
 * This is meant as a small utility class for times when you
 * need a one off random number between a given range.
 * It is designed to save the time and trouble of either using
 * the greenfoot.Greenfoot.getRandomNumber method or
 * the java.util.Random class.
 * 
 * All of the random static methods take a minimum and
 * maximum value. The value they return is from the minimum
 * (inclusive) to the maximum (exclusive).
 * 
 * The Random class can also be seeded to a pre-set value,
 * however for complex random code the java.util.Random
 * class might be a better option.
 * 
 * As default this Random class will seed to the current time
 * when the class is loaded.
 * 
 * @author Joseph Lenton
 * @version 27/07/2008
 */
public final class Random
{
    private static java.util.Random rand = new java.util.Random(System.currentTimeMillis());
    
    /**
     * Sets the starting seed value for this Random class.
     * This is the value used when calculating more random
     * numbers, and by seeding to a specific number you can
     * generate the same series of random number.
     * @param seed The long value to seed this too.
     */
    public static void seed(long seed)
    {
	    rand.setSeed(seed);
    }
    
    /**
     * @param minimum The minimun random number, inclusively.
     * @param maximum The maximum random number, exclusively.
     * @return A number greater or equal to minimum, less then maximum.
     */
    public static double random(double minimum, double maximum)
    {
        if(maximum-minimum != 0) {
            return rand.nextDouble()*(maximum-minimum) + minimum;
        }
        else {
            return 0.0;
        }
    }
    
    /**
     * @param minimum The minimun random number, inclusively.
     * @param maximum The maximum random number, exclusively.
     * @return A number greater or equal to minimum, less then maximum.
     */
    public static float random(float minimum, float maximum)
    {
        if(maximum-minimum != 0) {
            return rand.nextFloat()*(maximum-minimum) + minimum;
        }
        else {
            return 0;
        }
    }
    
    /**
     * @param minimum The minimun random number, inclusively.
     * @param maximum The maximum random number, exclusively.
     * @return A number greater or equal to minimum, less then maximum.
     */
    public static int random(int minimum, int maximum)
    {
        if(maximum-minimum != 0) {
            return rand.nextInt(maximum-minimum)+minimum;
        }
        else {
            return 0;
        }
    }
    
    /**
     * @return Randomly returns either a True or False.
     */
    public static boolean randomBoolean()
    {
        return rand.nextBoolean();
    }
    
    /**
     * @return A random double value between 0 and 1.
     */
    public static double randomDouble() {
        return rand.nextDouble();
    }
    
    /**
     * Cannot use it's constructor.
     */
    private Random() { }
}
