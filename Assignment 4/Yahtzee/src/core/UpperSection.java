/*
 * Zachary Gill
 * COP 3330 Object Oriented Programming
 * University of Central Florida
 */
package core;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JLabel;
import userInterface.UpperSectionUi;

/**
 *
 * @author Zachary Gill
 */
public class UpperSection {
    //Member variables
    private int aces;
    private int twos;
    private int threes;
    private int fours;
    private int fives;
    private int sixes;
    
    private int totalScore;
    private int bonus;
    private int total;
    
    /**
     *
     */
    public boolean[] selected;
    
    /**
     * Default constructor for UpperSection
     */
    public UpperSection()
    {
        initializeData();
    }
    
    private void initializeData()
    {
        setAces(Constants.ZERO);
        setTwos(Constants.ZERO);
        setThrees(Constants.ZERO);
        setFours(Constants.ZERO);
        setFives(Constants.ZERO);
        setSixes(Constants.ZERO);
        setTotal(Constants.ZERO);
        setBonus(Constants.ZERO);        
        setTotalScore(Constants.ZERO);
        
        selected = new boolean[Constants.NUM_DICE + 1];
        Arrays.fill(selected, false);
    }
    
    /**
     *
     * @param ui
     */
    public void setPlayerScores(UpperSectionUi ui)
    {
        ArrayList<JLabel> scores = ui.getScores();
        
        scores.get(0).setText(Integer.toString(aces));
        scores.get(1).setText(Integer.toString(twos));
        scores.get(2).setText(Integer.toString(threes));
        scores.get(3).setText(Integer.toString(fours));
        scores.get(4).setText(Integer.toString(fives));
        scores.get(5).setText(Integer.toString(sixes));
        
        ui.setScores(scores);
    }

    /**
     *
     * @param ui
     */
    public void setPlayerCategories(UpperSectionUi ui)
    {
        ArrayList<JButton> categories = ui.getCategories();
                
        for (int i = 0; i < categories.size(); i++) {
            categories.get(i).setEnabled(!selected[i]);
        }
        
        ui.setCategories(categories);
    }
    
    //Member variable encapsulation

    /**
     * @return the aces
     */
    public int getAces() {
        return aces;
    }

    /**
     * @param aces the aces to set
     */
    public void setAces(int aces) {
        this.aces = aces;
    }

    /**
     * @return the twos
     */
    public int getTwos() {
        return twos;
    }

    /**
     * @param twos the twos to set
     */
    public void setTwos(int twos) {
        this.twos = twos;
    }

    /**
     * @return the threes
     */
    public int getThrees() {
        return threes;
    }

    /**
     * @param threes the threes to set
     */
    public void setThrees(int threes) {
        this.threes = threes;
    }

    /**
     * @return the fours
     */
    public int getFours() {
        return fours;
    }

    /**
     * @param fours the fours to set
     */
    public void setFours(int fours) {
        this.fours = fours;
    }

    /**
     * @return the fives
     */
    public int getFives() {
        return fives;
    }

    /**
     * @param fives the fives to set
     */
    public void setFives(int fives) {
        this.fives = fives;
    }

    /**
     * @return the sixes
     */
    public int getSixes() {
        return sixes;
    }

    /**
     * @param sixes the sixes to set
     */
    public void setSixes(int sixes) {
        this.sixes = sixes;
    }

    /**
     * @return the totalScore
     */
    public int getTotalScore() {
        totalScore = getTotal();
        totalScore += getBonus();
        return totalScore;
    }

    /**
     * @param totalScore the totalScore to set
     */
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    /**
     * @return the bonus
     */
    public int getBonus() {
        if (totalScore >= 63)
            bonus = 35;
        return bonus;
    }

    /**
     * @param bonus the bonus to set
     */
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    /**
     * @return the total
     */
    public int getTotal() {
        total = aces + twos + threes + fours + fives + sixes;
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
    }
    
}
