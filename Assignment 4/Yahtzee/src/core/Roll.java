/*
 * Zachary Gill
 * COP 3330 Object Oriented Programming
 * University of Central Florida
 */
package core;

import static core.Constants.NUM_DICE;
import java.util.ArrayList;
import userInterface.RollUi;

/**
 *
 * @author Zachary Gill
 */
public class Roll {
    //Member variables
    private ArrayList<Die> dice;
    private RollUi rollUi;

    
    //Methods
    
    /**
     * Overriden default contructor
     */
    public Roll()
    {
        dice = new ArrayList<Die>();
        initializeDice();
    }
    
    /**
     * Initializes the dice
     */
    public void initializeDice()
    {
        for (int i = 0; i < NUM_DICE; i++) {
            Die die = new Die();
            dice.add(die);
        }
    }
    
    /**
     * Rolls the dice
     */
    public void rollDice()
    {
        //int i = 0;
        for (Die d : dice) {
            //i++;
            if (!d.selected)
                d.rollDie();
            //System.out.println("Die " + i + " rolled a value of " + d.toString());
        }
        //System.out.println();
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
    
    /**
     * Resets the selection state of all dice
     */
    public void resetSelected()
    {
        for (Die d : dice)
            d.selected = false;
    }
}
