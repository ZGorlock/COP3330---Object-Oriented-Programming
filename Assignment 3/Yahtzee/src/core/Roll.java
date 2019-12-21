/*
 * Zachary Gill
 * COP 3330 Object Oriented Programming
 * University of Central Florida
 */
package core;

import java.util.ArrayList;

/**
 *
 * @author Zachary Gill
 */
public class Roll {
    //Member variables
    private ArrayList<Die> dice;

    
    //Methods
    
    /**
     * Overriden default contructor
     */
    public Roll()
    {
        dice = new ArrayList<Die>(0);
        initializeDice();
    }
    
    /**
     * Initializes the dice
     */
    public void initializeDice()
    {
        for (int i = 0; i < 5; i++) {
            Die die = new Die();
            dice.add(die);
        }
    }
    
    /**
     * Rolls the dice
     */
    public void rollDice()
    {
        int i = 0;
        for (Die d : dice) {
            i++;
            d.rollDie();
            System.out.println("Die " + i + " rolled a value of " + d.toString());
        }
        System.out.println();
    }
    
    
    //Member variable encapsulation
    
    /**
     * @return the dice
     */
    public ArrayList<Die> getDice() {
        return dice;
    }

    /**
     * @param dice the dice to set
     */
    public void setDice(ArrayList<Die> dice) {
        this.dice = dice;
    }
    
}
