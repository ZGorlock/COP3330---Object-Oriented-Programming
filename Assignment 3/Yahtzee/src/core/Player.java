/*
 * Zachary Gill
 * COP 3330 Object Oriented Programming
 * University of Central Florida
 */
package core;

/**
 *
 * @author Zachary Gill
 */
public class Player {
    //Member variables
    private String name;
    private ScoreCard score;
    private Roll roll;

    
    //Methods
    
    /**
     * Overiden default constructor
     */
    public Player()
    {
        roll = new Roll();
    }
    
    /**
     * Rolls the dice
     */
    public void rollDice()
    {
        System.out.println("Player " + name + " rolled:");
        roll.rollDice();
    }
    
    
    //Member variable Encapsulation
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the score
     */
    public ScoreCard getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(ScoreCard score) {
        this.score = score;
    }

    /**
     * @return the roll
     */
    public Roll getRoll() {
        return roll;
    }

    /**
     * @param roll the roll to set
     */
    public void setRoll(Roll roll) {
        this.roll = roll;
    }
    
    
    
}
