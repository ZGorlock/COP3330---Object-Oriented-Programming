/*
 * Karin Whiting
 * COP 3330 Object Oriented Programming
 * University of Central Florida
 */

package core;

import java.util.Random;

public class Die 
{
    private int faceValue;
    
    public void rollDie()
    {
        Random random = new Random();
        setFaceValue(random.nextInt(Constants.MAX_DIE_VALUE) + 1);
    }

    /**
     * @return the faceValue
     */
    public int getFaceValue() 
    {
        return faceValue;
    }

    /**
     * @param faceValue the faceValue to set
     */
    public void setFaceValue(int faceValue) 
    {
        this.faceValue = faceValue;
    }
    
    @Override
    public String toString()
    {
        return Integer.toString(getFaceValue());
    }
} 