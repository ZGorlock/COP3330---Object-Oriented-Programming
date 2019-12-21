/*
 * Zachary Gill
 * COP 3330 Object Oriented Programming
 * University of Central Florida
 */

package userInterface;

import core.Constants;
import static core.Constants.CHANCE;
import static core.Constants.FOUR_KIND;
import static core.Constants.FULL_HOUSE;
import static core.Constants.LG_STRAIGHT;
import static core.Constants.NUM_DICE;
import static core.Constants.ONES;
import static core.Constants.SIXES;
import static core.Constants.SM_STRAIGHT;
import static core.Constants.THREE_KIND;
import static core.Constants.YAHTZEE;
import core.Player;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.*;

/**
 *
 * @author ZGorlock
 */
public class ScoreCardUi extends JPanel
{
    private BoxLayout boxLayout;
    private JLabel grandTotal;    
    private LowerSectionUi lowerUi;
    private UpperSectionUi upperUi;
    
    private Player player;
    
    private YahtzeeUi ui;
    
    /**
     * Default constructor for ScoreCardUi
     */
    public ScoreCardUi()
    {
        initComponents();
    }

    /**
     *
     * @param ui
     */
    public ScoreCardUi(YahtzeeUi ui)
    {
        this.ui = ui;
        initComponents();
    }
    
    private void initComponents()
    {
        boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        
        this.setLayout(boxLayout);
        this.setMinimumSize(new Dimension(510, 650));
        this.setPreferredSize(new Dimension(510, 650));
        this.setMaximumSize(new Dimension(510, 650));
        this.setBorder(BorderFactory.createRaisedBevelBorder());

        setUpperUi(new UpperSectionUi(ui));
        setLowerUi(new LowerSectionUi(ui));

        //GRAND TOTAL
        JLabel totTotText = new JLabel("GRAND TOTAL");
        totTotText.setMinimumSize(new Dimension(350, 30));
        totTotText.setPreferredSize(new Dimension(350, 30));
        totTotText.setMaximumSize(new Dimension(350, 30));
        
        grandTotal = new JLabel(Integer.toString(Constants.ZERO));
        grandTotal.setMinimumSize(new Dimension(35, 30));
        grandTotal.setPreferredSize(new Dimension(35, 30));
        grandTotal.setMaximumSize(new Dimension(35, 30));
        
        JPanel totTot = new JPanel();
        totTot.setMinimumSize(new Dimension(500, 30));
        totTot.setPreferredSize(new Dimension(500, 30));
        totTot.setMaximumSize(new Dimension(500, 30));
        BoxLayout bl = new BoxLayout(totTot, BoxLayout.X_AXIS);
        totTot.setLayout(bl);
        totTot.add(totTotText);
        totTot.add(Box.createGlue());
        totTot.add(grandTotal);
        
       
        this.add(getUpperUi());
        this.add(getLowerUi());
        this.add(totTot);
    }

    /**
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @param player the player to set
     */
    public void setPlayer(Player player) {
        this.player = player;
        
        setGrandTotal(player.getTotalScore());
        
        getLowerUi().setPlayer(player);
        getUpperUi().setPlayer(player);
    }
    
    /**
     * @return the grandTotal
     */
    public JLabel getGrandTotal() {
        return grandTotal;
    }

    /**
     * @param grandTotal the grandTotal to set
     */
    public void setGrandTotal(int grandTotal) {
        this.grandTotal.setText(Integer.toString(grandTotal));
    }

    /**
     * @return the lowerUi
     */
    public LowerSectionUi getLowerUi() {
        return lowerUi;
    }

    /**
     * @param lowerUi the lowerUi to set
     */
    public void setLowerUi(LowerSectionUi lowerUi) {
        this.lowerUi = lowerUi;
    }

    /**
     * @return the upperUi
     */
    public UpperSectionUi getUpperUi() {
        return upperUi;
    }

    /**
     * @param upperUi the upperUi to set
     */
    public void setUpperUi(UpperSectionUi upperUi) {
        this.upperUi = upperUi;
    }
    
    /**
     *
     * @param category
     * @return
     */
    public static String categoryName(int category)
    {
        switch (category)
        {
            case Constants.ONES:
                return "ACES";
            case Constants.TWOS:
                return "TWOS";
            case Constants.THREES:
                return "THREES";
            case Constants.FOURS:
                return "FOURS";
            case Constants.FIVES:
                return "FIVES";
            case Constants.SIXES:
                return "SIXES";
            case Constants.THREE_KIND:
                return "THREE OF A KIND";
            case Constants.FOUR_KIND:
                return "FOUR OF A KIND";
            case Constants.CHANCE:
                return "CHANCE";
            case Constants.FULL_HOUSE:
                return "FULL HOUSE";
            case Constants.SM_STRAIGHT:
                return "SMALL STRAIGHT";
            case Constants.LG_STRAIGHT:
                return "LARGE STRAIGHT";
            case Constants.YAHTZEE:
                return "YAHTZEE";
            case Constants.YAHTZEE_BONUS:
                return "YAHTZEE BONUS";
            default:
                return "";
        }
    }
    
    /**
     *
     * @param lowerCategory
     * @return
     */
    public static int lowerCategoryToCategory(int lowerCategory)
    {
        switch (lowerCategory)
        {
            case Constants.THREE_KIND:
                return 0;
            case Constants.FOUR_KIND:
                return 1;
            case Constants.FULL_HOUSE:
                return 2;
            case Constants.SM_STRAIGHT:
                return 3;
            case Constants.LG_STRAIGHT:
                return 4;
            case Constants.YAHTZEE:
                return 5;
            case Constants.CHANCE:
                return 6;
            case Constants.YAHTZEE_BONUS:
                return 7;
            default:
                return 0;
        }
    }
    
    /**
     *
     * @param dice
     * @param category
     * @return
     */
    public static boolean checkCategory(int[] dice, int category) {
        boolean categoryMatch = false;
        if (category >= ONES && category <= SIXES || category == CHANCE) {
            categoryMatch = true;
        } else {

            //creates an array for each possible dice value (1-6)
            ArrayList<Integer> ones = new ArrayList<Integer>();
            ArrayList<Integer> twos = new ArrayList<Integer>();
            ArrayList<Integer> threes = new ArrayList<Integer>();
            ArrayList<Integer> fours = new ArrayList<Integer>();
            ArrayList<Integer> fives = new ArrayList<Integer>();
            ArrayList<Integer> sixes = new ArrayList<Integer>();

            /*goes through each rolled die and puts 1 as a place-holder into the appropriate ArrayList
             * e.g. if the first die value is 1, then 1 is added to the ones ArrayList or
             * if the second die value is 5, then 1 is added to the fives ArrayList*/
            for (int i = 0; i < NUM_DICE; i++) {
                if (dice[i] == 1) {
                    ones.add(1);
                } else if (dice[i] == 2) {
                    twos.add(1);
                } else if (dice[i] == 3) {
                    threes.add(1);
                } else if (dice[i] == 4) {
                    fours.add(1);
                } else if (dice[i] == 5) {
                    fives.add(1);
                } else if (dice[i] == 6) {
                    sixes.add(1);
                }
            }
            if (category == THREE_KIND) {
                if (ones.size() >= 3 || twos.size() >= 3 || threes.size() >= 3 || fours.size() >= 3 || fives.size() >= 3 || sixes.size() >= 3) {
                    categoryMatch = true;
                }
            } else if (category == FOUR_KIND) {
                if (ones.size() >= 4 || twos.size() >= 4 || threes.size() >= 4 || fours.size() >= 4 || fives.size() >= 4 || sixes.size() >= 4) {
                    categoryMatch = true;
                }
            } else if (category == YAHTZEE) {
                if (ones.size() == 5 || twos.size() == 5 || threes.size() == 5 || fours.size() == 5 || fives.size() == 5 || sixes.size() == 5) {
                    categoryMatch = true;
                }
            } else if (category == FULL_HOUSE) {
                if (ones.size() == 3 || twos.size() == 3 || threes.size() == 3 || fours.size() == 3 || fives.size() == 3 || sixes.size() == 3) {
                    if (ones.size() == 2 || twos.size() == 2 || threes.size() == 2 || fours.size() == 2 || fives.size() == 2 || sixes.size() == 2) {
                        categoryMatch = true;
                    }
                }
            } else if (category == LG_STRAIGHT) {
                if (ones.size() == 1 && twos.size() == 1 && threes.size() == 1 && fours.size() == 1 && fives.size() == 1) {
                    categoryMatch = true;
                } else if (twos.size() == 1 && threes.size() == 1 && fours.size() == 1 && fives.size() == 1 && sixes.size() == 1) {
                    categoryMatch = true;
                }
            } else if (category == SM_STRAIGHT) {
                if (ones.size() >= 1 && twos.size() >= 1 && threes.size() >= 1 && fours.size() >= 1) {
                    categoryMatch = true;
                } else if (twos.size() >= 1 && threes.size() >= 1 && fours.size() >= 1 && fives.size() >= 1) {
                    categoryMatch = true;
                } else if (threes.size() >= 1 && fours.size() >= 1 && fives.size() >= 1 && sixes.size() >= 1) {
                    categoryMatch = true;
                }
            }
        }
        return categoryMatch;
    }
}
