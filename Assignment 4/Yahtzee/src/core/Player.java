/*
 * Zachary Gill
 * COP 3330 Object Oriented Programming
 * University of Central Florida
 */
package core;

import javax.swing.JOptionPane;

/**
 *
 * @author Zachary Gill
 */
public class Player {
    //Member variables
    private String name;
    private ScoreCard score;
    private Roll roll;
    private int rollCount;
    
    private boolean finished = false;

    
    //Methods
    
    /**
     * Overiden default constructor
     */
    public Player()
    {
        score = new ScoreCard();
        roll = new Roll();
    }
    
    /**
     * Rolls the dice
     */
    public void rollDice()
    {
        if (rollCount < 3) {
            roll.rollDice();
            rollCount++;
        }
    }
    
    /**
     *
     * @return
     */
    public int getTotalScore()
    {
        int totalScore = getTotalUpperScoreWithBonus() + getTotalLowerScore();
        score.setGrandTotal(totalScore);
        return totalScore;
    }

    /**
     *
     * @return
     */
    public int getTotalUpperScore()
    {
        return score.getUpper().getTotal();
    }

    /**
     *
     * @return
     */
    public int getTotalUpperScoreWithBonus()
    {
        return score.getUpper().getTotalScore();
    }

    /**
     *
     * @return
     */
    public int getTotalLowerScore()
    {
        return score.getLower().getTotalScore();
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

    /**
     * @return the rollCount
     */
    public int getRollCount() {
        return rollCount;
    }

    /**
     * @param rollCount the rollCount to set
     */
    public void setRollCount(int rollCount) {
        this.rollCount = rollCount;
    }

    /**
     * @return the finished
     */
    public boolean isFinished() {
        return finished;
    }

    /**
     * this should only be called at the beginning or end of a players turn
     * @param finished the finished to set
     */
    public void setFinished(boolean finished) {
        this.finished = finished; //set finished
        this.rollCount = 0; //reset roll count

        roll.resetSelected(); //reset die selections
    }
    
    
    
}
