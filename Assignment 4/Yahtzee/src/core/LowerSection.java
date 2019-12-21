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
import userInterface.LowerSectionUi;

/**
 *
 * @author Zachary Gill
 */
public class LowerSection {
    //Member variables
    private int threeKind;
    private int fourKind;
    private int fullHouse;
    private int smStraight;
    private int lgStraight;
    private int yahtzee;
    private int chance;
    private int yahtzeeBonus;
    
    private int yahtzeeBonusCount;
    
    private int totalScore;
    
    /**
     *
     */
    public boolean[] selected;

    /**
     *Default Constructor
     */
    public LowerSection()
    {
        initializeData();
    }
    
    private void initializeData()
    {
        setThreeKind(Constants.ZERO);
        setFourKind(Constants.ZERO);
        setChance(Constants.ZERO);
        setFullHouse(Constants.ZERO);
        setSmStraight(Constants.ZERO);
        setLgStraight(Constants.ZERO);
        setYahtzee(Constants.ZERO);
        setYahtzeeBonus(Constants.ZERO);        
        setTotalScore(Constants.ZERO);
        
        selected = new boolean[Constants.LOWER_CATERGORY + 1];
        Arrays.fill(selected, false);
    }
            
    /**
     *
     * @param ui
     */
    public void setPlayerScores(LowerSectionUi ui)
    {
        ArrayList<JLabel> scores = ui.getScores();
        
        scores.get(0).setText(Integer.toString(threeKind));
        scores.get(1).setText(Integer.toString(fourKind));
        scores.get(2).setText(Integer.toString(fullHouse));
        scores.get(3).setText(Integer.toString(smStraight));
        scores.get(4).setText(Integer.toString(lgStraight));
        scores.get(5).setText(Integer.toString(yahtzee));
        scores.get(6).setText(Integer.toString(chance));
        scores.get(7).setText(Integer.toString(yahtzeeBonus));
        
        ui.setScores(scores);
    }

    /**
     *
     * @param ui
     */
    public void setPlayerCategories(LowerSectionUi ui)
    {
        ArrayList<JButton> categories = ui.getCategories();
                
        for (int i = 0; i < categories.size(); i++) {
            categories.get(i).setEnabled(!selected[i]);
        }
        
        ui.setCategories(categories);
    }
    
    //Member variable encapsulation
    
    /**
     * @return the threeKind
     */
    public int getThreeKind() {
        return threeKind;
    }

    /**
     * @param threeKind the threeKind to set
     */
    public void setThreeKind(int threeKind) {
        this.threeKind = threeKind;
    }

    /**
     * @return the fourKind
     */
    public int getFourKind() {
        return fourKind;
    }

    /**
     * @param fourKind the fourKind to set
     */
    public void setFourKind(int fourKind) {
        this.fourKind = fourKind;
    }

    /**
     * @return the fullHouse
     */
    public int getFullHouse() {
        return fullHouse;
    }

    /**
     * @param fullHouse the fullHouse to set
     */
    public void setFullHouse(int fullHouse) {
        this.fullHouse = fullHouse;
    }

    /**
     * @return the smStraight
     */
    public int getSmStraight() {
        return smStraight;
    }

    /**
     * @param smStraight the smStraight to set
     */
    public void setSmStraight(int smStraight) {
        this.smStraight = smStraight;
    }

    /**
     * @return the lgStraight
     */
    public int getLgStraight() {
        return lgStraight;
    }

    /**
     * @param lgStraight the lgStraight to set
     */
    public void setLgStraight(int lgStraight) {
        this.lgStraight = lgStraight;
    }

    /**
     * @return the yahtzee
     */
    public int getYahtzee() {
        return yahtzee;
    }

    /**
     * @param yahtzee the yahtzee to set
     */
    public void setYahtzee(int yahtzee) {
        this.yahtzee = yahtzee;
    }

    /**
     * @return the chance
     */
    public int getChance() {
        return chance;
    }

    /**
     * @param chance the chance to set
     */
    public void setChance(int chance) {
        this.chance = chance;
    }

    /**
     * @return the yahtzeeBonus
     */
    public int getYahtzeeBonus() {
        return yahtzeeBonus;
    }

    /**
     * @param yahtzeeBonus the yahtzeeBonus to set
     */
    public void setYahtzeeBonus(int yahtzeeBonus) {
        this.yahtzeeBonus = yahtzeeBonus;
    }

    /**
     * @return the totalScore
     */
    public int getTotalScore() {
        totalScore = threeKind + fourKind + fullHouse + smStraight + lgStraight + yahtzee + chance + yahtzeeBonus;
        return totalScore;
    }

    /**
     * @param totalScore the totalScore to set
     */
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    /**
     * @return the yahtzeeBonusCount
     */
    public int getYahtzeeBonusCount() {
        return yahtzeeBonusCount;
    }

    /**
     * @param yahtzeeBonusCount the yahtzeeBonusCount to set
     */
    public void setYahtzeeBonusCount(int yahtzeeBonusCount) {
        this.yahtzeeBonusCount = yahtzeeBonusCount;
    }
    
    
}
