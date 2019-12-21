/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.Random;

/**
 *
 * @author Zachary Gill
 */
public class Die {
    //Member Variables
    private int faceValue;

    
    //Methods
    
    /**
     * Rolls the die
     */
    public void rollDie()
    {
        Random randomNumber = new Random();
        
        faceValue = 1 + randomNumber.nextInt(6);
    }
    
    /**
     * Gives the face value as a string.
     * 
     * @return the face value string
     */
    @Override
    public String toString()
    {
        return Integer.toString(getFaceValue());
    }
    
    
    //Member variable encapsulation
            
    /**
     * @return the faceValue
     */
    public int getFaceValue() {
        return faceValue;
    }

    /**
     * @param faceValue the faceValue to set
     */
    public void setFaceValue(int faceValue) {
        this.faceValue = faceValue;
    }
    
}
