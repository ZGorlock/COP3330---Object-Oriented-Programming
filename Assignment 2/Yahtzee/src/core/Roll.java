/*
 * Karin Whiting
 * COP 3330 Object Oriented Programming
 * University of Central Florida
 */

package core;

import java.util.ArrayList;

public class Roll 
{
    // container for the five dice
    private ArrayList<Die> dice = new ArrayList<Die>();
    
    // no-argument constructor
    public Roll()
    {
        // initialize the dice for the roll
        initializeDice();
    }
    
    // creates the five dice and adds them to the ArrayList 
    private void initializeDice()
    {
        // creates five Die objects and adds them to the ArrayList container
        for(int i = 0; i < Constants.NUM_DICE; i++)
        {
            Die die = new Die();
            dice.add(die);
            getDice().add(die);
        }
    }
    
    public void rollDice()
    {
        int counter = 0;
        
        // loop through the dice and roll each one
        for(Die die : dice)
        {
            die.rollDie();
            counter++;
            System.out.println("Die " + counter + " rolled value of " + die.toString());
        }
    }

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
