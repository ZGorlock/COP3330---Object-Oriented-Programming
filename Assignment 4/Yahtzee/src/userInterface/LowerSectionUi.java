/*
 * Zachary Gill
 * COP 3330 Object Oriented Programming
 * University of Central Florida
 */
package userInterface;

import java.awt.event.*;
import core.Constants;
import static core.Constants.NUM_DICE;
import core.Die;
import core.Player;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.*;
        
/**
 *
 * @author ZGorlock
 */
public class LowerSectionUi extends JPanel implements ActionListener
{
    private ArrayList<JButton> categories;
    private ArrayList<JLabel> scores;
    
    private BoxLayout boxLayout;
    
    private JLabel totalLower;
    private JLabel totalUpper;
    
    private Player player;
    
    private YahtzeeUi ui;

    /**
     * Default constructor for LowerSectionUi
     */
    public LowerSectionUi()
    {
        initComponents();
    }

    /**
     *
     * @param ui
     */
    public LowerSectionUi(YahtzeeUi ui)
    {
        this.ui = ui;
        initComponents();
    }
    
    private void initComponents()
    {
        boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        
        // setting up JPanel
        this.setLayout(boxLayout);
        this.setMinimumSize(new Dimension(500, 305));
        this.setPreferredSize(new Dimension(500, 305));
        this.setMaximumSize(new Dimension(500, 305));
        this.setBorder(BorderFactory.createRaisedBevelBorder());

        setCategories(new ArrayList<JButton>());
        setScores(new ArrayList<JLabel>());
        
        for(int i = 0; i <= Constants.LOWER_CATERGORY; i++)
        {
            JButton category = new JButton();
            category.setMinimumSize(new Dimension(350, 30));
            category.setPreferredSize(new Dimension(350, 30));
            category.setMaximumSize(new Dimension(350, 30));
            //category.addActionListener(this);

            switch(i)
            {
                case 0:
                    category.setText(Constants.TRIPLE);
                    category.putClientProperty("category", Constants.THREE_KIND);
                    break;
                case 1:
                    category.setText(Constants.QUAD);
                    category.putClientProperty("category", Constants.FOUR_KIND);
                    break;
                case 2:
                    category.setText(Constants.FULL);
                    category.putClientProperty("category", Constants.FULL_HOUSE);
                    break;
                case 3:
                    category.setText(Constants.SMALL);
                    category.putClientProperty("category", Constants.SM_STRAIGHT);
                    break;
                case 4:
                    category.setText(Constants.LARGE);
                    category.putClientProperty("category", Constants.LG_STRAIGHT);
                    break;
                case 5:
                    category.setText(Constants.YAHTZ);
                    category.putClientProperty("category", Constants.YAHTZEE);
                    break;
                case 6:
                    category.setText(Constants.LASTCHANCE);
                    category.putClientProperty("category", Constants.CHANCE);
                    break;
                case 7:
                    category.setText(Constants.YAHTZ_BONUS);
                    category.putClientProperty("category", Constants.YAHTZEE_BONUS);
                    break;
                default:
                    category.setText("No valid value");
                    break;
            }
            category.addActionListener(this);
            category.setActionCommand(Integer.toString(i));
            //category.setVisible(false);
            categories.add(category);
            
            JLabel score = new JLabel();
            score.setMinimumSize(new Dimension(35, 30));
            score.setPreferredSize(new Dimension(35, 30));
            score.setMaximumSize(new Dimension(35, 30));
            score.setText(Integer.toString(Constants.ZERO));
            score.setVisible(true);
            scores.add(score);
        }
              
        //LOWER TOTAL
        JLabel totalLowerText = new JLabel("TOTAL of Lower Section");
        totalLowerText.setMinimumSize(new Dimension(350, 30));
        totalLowerText.setPreferredSize(new Dimension(350, 30));
        totalLowerText.setMaximumSize(new Dimension(350, 30));
        
        totalLower = new JLabel(Integer.toString(Constants.ZERO));
        totalLower.setMinimumSize(new Dimension(35, 30));
        totalLower.setPreferredSize(new Dimension(35, 30));
        totalLower.setMaximumSize(new Dimension(35, 30));
        
        JPanel totLow = new JPanel();
        totLow.setMinimumSize(new Dimension(500, 30));
        totLow.setPreferredSize(new Dimension(500, 30));
        totLow.setMaximumSize(new Dimension(500, 30));
        BoxLayout bl1 = new BoxLayout(totLow, BoxLayout.X_AXIS);
        totLow.setLayout(bl1);
        totLow.add(totalLowerText);
        totLow.add(Box.createGlue());
        totLow.add(totalLower);
        
        //UPPER TOTAL
        JLabel totalUpperText  = new JLabel("TOTAL of Upper Section");
        totalUpperText.setMinimumSize(new Dimension(350, 30));
        totalUpperText.setPreferredSize(new Dimension(350, 30));
        totalUpperText.setMaximumSize(new Dimension(350, 30));
        
        totalUpper = new JLabel(Integer.toString(Constants.ZERO));
        totalUpper.setMinimumSize(new Dimension(35, 30));
        totalUpper.setPreferredSize(new Dimension(35, 30));
        totalUpper.setMaximumSize(new Dimension(35, 30));
        
        JPanel totUpp = new JPanel();
        totUpp.setMinimumSize(new Dimension(500, 30));
        totUpp.setPreferredSize(new Dimension(500, 30));
        totUpp.setMaximumSize(new Dimension(500, 30));
        BoxLayout bl2 = new BoxLayout(totUpp, BoxLayout.X_AXIS);
        totUpp.setLayout(bl2);
        totUpp.add(totalUpperText);
        totUpp.add(Box.createGlue());
        totUpp.add(totalUpper);
        
        for (int i = 0; i < categories.size(); i++)
        {
            //addComponent(0, i, 1, 1, this, categories.get(i));
            //addComponent(1, i, 1, 1, this, scores.get(i));
            JPanel jp = new JPanel();
            jp.setMinimumSize(new Dimension(500, 30));
            jp.setPreferredSize(new Dimension(500, 30));
            jp.setMaximumSize(new Dimension(500, 30));
            
            BoxLayout bl = new BoxLayout(jp, BoxLayout.X_AXIS);
            jp.setLayout(bl);
            
            //concatenate button and score
            jp.add(categories.get(i));
            jp.add(Box.createGlue());
            jp.add(scores.get(i));
            
            this.add(jp);
        }   
        
        this.add(totUpp);
        this.add(totLow);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        int category = 0;
        
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton)e.getSource();
            category = (int)button.getClientProperty("category");
            
            //get player dice
            ArrayList<Die> dice = player.getRoll().getDice();
            int[] diceArray = new int[NUM_DICE];
            for (int i = 0; i < dice.size(); i++) {
                diceArray[i] = dice.get(i).getFaceValue();
            }
            
            //make sure player has rolled the dice
            if (player.getRollCount() == 0) {
                JOptionPane.showMessageDialog(null, player.getName() + " please roll the dice first!");
                return;
            }
            
            //check to make sure you can choose category
            boolean goodCategory = ScoreCardUi.checkCategory(diceArray, category);
            boolean useZero = false;
            if (!goodCategory) {
                if (category == Constants.YAHTZEE_BONUS)
                    return;
                Object[] options = {"Yes",
                    "No",
                    "Cancel"};
                int n = JOptionPane.showOptionDialog(this,
                    "Are you sure you want to select this category? You will get a score of 0!",
                    "You will get a score of 0 for this category!",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[2]);
                if (n == 0) { //If "Yes" then start new game
                    useZero = true;
                }
                else {
                    return;
                }
            }

            //do category logic
            boolean unfinished = false;
            int categoryScore = 0;
            int categoryIndex = ScoreCardUi.lowerCategoryToCategory(category);
            switch (category) {
                case Constants.THREE_KIND:
                    //calculate score
                    categoryScore = LowerSectionUi.sumDice(dice);
                    if (useZero) categoryScore = 0;
                    
                    player.getScore().getLower().setThreeKind(categoryScore); //set score in player scorecard
                    break;
                case Constants.FOUR_KIND:
                    //calculate score
                    categoryScore = LowerSectionUi.sumDice(dice);
                    if (useZero) categoryScore = 0;
                    
                    player.getScore().getLower().setFourKind(categoryScore); //set score in player scorecard
                    break;
                case Constants.FULL_HOUSE:
                    //calculate score
                    categoryScore = Constants.FULL_HOUSE;
                    if (useZero) categoryScore = 0;
                    
                    player.getScore().getLower().setFullHouse(categoryScore); //set score in player scorecard
                    break;
                case Constants.SM_STRAIGHT:
                    //calculate score
                    categoryScore = Constants.SM_STRAIGHT;
                    if (useZero) categoryScore = 0;
                    
                    player.getScore().getLower().setSmStraight(categoryScore); //set score in player scorecard
                    break;
                case Constants.LG_STRAIGHT:
                    //calculate score
                    categoryScore = Constants.LG_STRAIGHT;
                    if (useZero) categoryScore = 0;
                    
                    player.getScore().getLower().setLgStraight(categoryScore); //set score in player scorecard
                    break;
                case Constants.YAHTZEE:
                    //calculate score
                    categoryScore = Constants.YAHTZEE;
                    if (useZero) categoryScore = 0;
                    
                    player.getScore().getLower().setYahtzee(categoryScore); //set score in player scorecard
                    player.getScore().getLower().setYahtzeeBonusCount(player.getScore().getLower().getYahtzeeBonusCount() + 1);
                    break;
                case Constants.CHANCE:
                    //calculate score
                    categoryScore = LowerSectionUi.sumDice(dice);
                    
                    player.getScore().getLower().setChance(categoryScore); //set score in player scorecard
                    break;
                case Constants.YAHTZEE_BONUS:
                    if (player.getScore().getLower().getYahtzee() == 0) {
                        JOptionPane.showMessageDialog(this, "You must score Yahtzee before scoring Yahtzee Bonus!");
                        unfinished = true;
                        break;
                    }
                    
                    //calculate score
                    categoryScore = Constants.YAHTZEE_BONUS + player.getScore().getLower().getYahtzeeBonus();
                    if (useZero) categoryScore = 0;
                    
                    if (player.getScore().getLower().getYahtzeeBonusCount() < Constants.MAX_YAHTZEE) { //if you have less than the maximum number of yahtzee bonuses
                        player.getScore().getLower().setYahtzeeBonus(categoryScore); //set score in player scorecard
                        player.getScore().getLower().setYahtzeeBonusCount(player.getScore().getLower().getYahtzeeBonusCount() + 1);
                    }
                    else {
                        //player.getScore().getLower().setYahtzeeBonus(Constants.MAX_YAHTZEE * Constants.YAHTZEE_BONUS); //set score in player scorecard
                        JOptionPane.showMessageDialog(this, "You already have the maximum Yahtzee Bonus!");
                        unfinished = true;
                    }
                    break;
                default:
                    break;
            }
            
            if (!unfinished) {
                if (category != Constants.YAHTZEE_BONUS || (category == Constants.YAHTZEE_BONUS && player.getScore().getLower().getYahtzeeBonusCount() == Constants.MAX_YAHTZEE)) {
                    player.getScore().getLower().selected[categoryIndex] = true; //category has been selected before
                    categories.get(categoryIndex).setEnabled(false); //update category button on ui immediately
                }

                //update score on ui immediately
                scores.get(categoryIndex).setText(Integer.toString(categoryScore));

                setTotalLower(player.getTotalLowerScore());
                //setTotalUpper(player.getTotalUpperScoreWithBonus());

                ui.getScoreCardUi().setGrandTotal(player.getTotalScore());
                ui.getPlayerUi().setPlayerScore(player.getTotalScore());

                JOptionPane.showMessageDialog(this, "Selected category was " + ScoreCardUi.categoryName(category));
                player.setFinished(true);
            }
        }
        
    }

    /**
     * @return the categories
     */
    public ArrayList<JButton> getCategories() {
        return categories;
    }

    /**
     * @param categories the categories to set
     */
    public void setCategories(ArrayList<JButton> categories) {
        this.categories = categories;
    }

    /**
     * @return the scores
     */
    public ArrayList<JLabel> getScores() {
        return scores;
    }

    /**
     * @param scores the scores to set
     */
    public void setScores(ArrayList<JLabel> scores) {
        this.scores = scores;
    }

    /**
     * @return the totalLower
     */
    public JLabel getTotalLower() {
        return totalLower;
    }

    /**
     * @param totalLower the totalLower to set
     */
    public void setTotalLower(int totalLower) {
        this.totalLower.setText(Integer.toString(totalLower));
    }

    /**
     * @return the totalUpper
     */
    public JLabel getTotalUpper() {
        return totalUpper;
    }

    /**
     * @param totalUpper the totalUpper to set
     */
    public void setTotalUpper(int totalUpper) {
        this.totalUpper.setText(Integer.toString(totalUpper));
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
        
        //set new player scores on ui
        player.getScore().getLower().setPlayerScores(this);
        
        setTotalLower(player.getTotalLowerScore());
        setTotalUpper(player.getTotalUpperScoreWithBonus());
        
        //set new player categories on ui
        player.getScore().getLower().setPlayerCategories(this);
    }
    
    /**
     *
     * @param dice
     * @return
     */
    public static int sumDice(ArrayList<Die> dice)
    {
        int total = 0;
        for (Die d : dice)
            total += d.getFaceValue();
        return total;
    }
}
