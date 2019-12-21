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
public class ScoreCard {
    //Member variables
    private UpperSection upper;
    private LowerSection lower;
    
    private int grandTotal;
    
    /**
     * Default constructor for ScoreCard
     */
    public ScoreCard()
    {
        lower = new LowerSection();
        upper = new UpperSection();
    }
    
    //Member variable encapsulation

    /**
     * @return the upper
     */
    public UpperSection getUpper() {
        return upper;
    }

    /**
     * @param upper the upper to set
     */
    public void setUpper(UpperSection upper) {
        this.upper = upper;
    }

    /**
     * @return the lower
     */
    public LowerSection getLower() {
        return lower;
    }

    /**
     * @param lower the lower to set
     */
    public void setLower(LowerSection lower) {
        this.lower = lower;
    }

    /**
     * @return the grandTotal
     */
    public int getGrandTotal() {
        grandTotal = upper.getTotalScore() + lower.getTotalScore();
        return grandTotal;
    }

    /**
     * @param grandTotal the grandTotal to set
     */
    public void setGrandTotal(int grandTotal) {
        this.grandTotal = grandTotal;
    }
}
