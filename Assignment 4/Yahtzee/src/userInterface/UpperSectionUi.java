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
import core.UpperSection;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author ZGorlock
 */
public class UpperSectionUi extends JPanel implements ActionListener
{
    private ArrayList<JButton> categories;
    private ArrayList<JLabel> scores;
    
    private BoxLayout boxLayout;
    
    private JLabel total;
    private JLabel bonus;
    private JLabel totalScore;
    
    private Player player;
    
    private YahtzeeUi ui;
    
    /**
     * Default constructor for UpperSectionUi
     */
    public UpperSectionUi()
    {
        initComponents();
    }

    /**
     *
     * @param ui
     */
    public UpperSectionUi(YahtzeeUi ui)
    {
        this.ui = ui;
        initComponents();
    }
    
    private void initComponents()
    {
        // layout manager
        boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        
        // setting up JPanel
        this.setLayout(boxLayout);        
        this.setMinimumSize(new Dimension(500, 275));
        this.setPreferredSize(new Dimension(500, 275));
        this.setMaximumSize(new Dimension(500, 275));
        this.setBorder(BorderFactory.createRaisedBevelBorder());

        setCategories(new ArrayList<JButton>());
        setScores(new ArrayList<JLabel>());
        
        for(int i = 0; i < Constants.MAX_DIE_VALUE; i++)
        {
            JButton category = new JButton();
            category.setMinimumSize(new Dimension(350, 30));
            category.setPreferredSize(new Dimension(350, 30));
            category.setMaximumSize(new Dimension(350, 30));
            //category.addActionListener(this);
            
            switch(i)
            {
                case 0:
                    category.setText(Constants.ACE);
                    category.putClientProperty("category", Constants.ONES);
                    break;
                case 1:
                    category.setText(Constants.TWO);
                    category.putClientProperty("category", Constants.TWOS);
                    break;
                case 2:
                    category.setText(Constants.THREE);
                    category.putClientProperty("category", Constants.THREES);
                    break;
                case 3:
                    category.setText(Constants.FOUR);
                    category.putClientProperty("category", Constants.FOURS);
                    break;
                case 4:
                    category.setText(Constants.FIVE);
                    category.putClientProperty("category", Constants.FIVES);
                    break;
                case 5:
                    category.setText(Constants.SIX);
                    category.putClientProperty("category", Constants.SIXES);
                    break;
                default:
                    category.setText("No valid value");
                    break;
            }
            category.addActionListener(this);
            category.setActionCommand(Integer.toString(i));
            categories.add(category);
            
            JLabel score = new JLabel();
            score.setMinimumSize(new Dimension(35, 30));
            score.setPreferredSize(new Dimension(35, 30));
            score.setMaximumSize(new Dimension(35, 30));
            score.setText(Integer.toString(Constants.ZERO));
            score.setVisible(true);
            scores.add(score);
        }
              
        //TOTAL SCORE
        JLabel totalScoreText = new JLabel("TOTAL SCORE");
        totalScoreText.setMinimumSize(new Dimension(350, 30));
        totalScoreText.setPreferredSize(new Dimension(350, 30));
        totalScoreText.setMaximumSize(new Dimension(350, 30));
        
        totalScore = new JLabel(Integer.toString(Constants.ZERO));
        totalScore.setMinimumSize(new Dimension(35, 30));
        totalScore.setPreferredSize(new Dimension(35, 30));
        totalScore.setMaximumSize(new Dimension(35, 30));
        
        JPanel totScr = new JPanel();
        totScr.setMinimumSize(new Dimension(500, 30));
        totScr.setPreferredSize(new Dimension(500, 30));
        totScr.setMaximumSize(new Dimension(500, 30));
        BoxLayout bl1 = new BoxLayout(totScr, BoxLayout.X_AXIS);
        totScr.setLayout(bl1);
        totScr.add(totalScoreText);
        totScr.add(Box.createGlue());
        totScr.add(totalScore);
        
        //BONUS
        JLabel totalBonus = new JLabel(Constants.BONUS);
        totalBonus.setMinimumSize(new Dimension(350, 30));
        totalBonus.setPreferredSize(new Dimension(350, 30));
        totalBonus.setMaximumSize(new Dimension(350, 30));
        
        bonus = new JLabel(Integer.toString(Constants.ZERO));
        bonus.setMinimumSize(new Dimension(35, 30));
        bonus.setPreferredSize(new Dimension(35, 30));
        bonus.setMaximumSize(new Dimension(35, 30));
        
        JPanel totBon = new JPanel();
        totBon.setMinimumSize(new Dimension(500, 30));
        totBon.setPreferredSize(new Dimension(500, 30));
        totBon.setMaximumSize(new Dimension(500, 30));
        BoxLayout bl2 = new BoxLayout(totBon, BoxLayout.X_AXIS);
        totBon.setLayout(bl2);
        totBon.add(totalBonus);
        totBon.add(Box.createGlue());
        totBon.add(bonus);
        
        //TOTAL UPPER
        JLabel totalUpperText = new JLabel("TOTAL of Upper Section");
        totalUpperText.setMinimumSize(new Dimension(350, 30));
        totalUpperText.setPreferredSize(new Dimension(350, 30));
        totalUpperText.setMaximumSize(new Dimension(350, 30));
        
        total = new JLabel(Integer.toString(Constants.ZERO));
        total.setMinimumSize(new Dimension(35, 30));
        total.setPreferredSize(new Dimension(35, 30));
        total.setMaximumSize(new Dimension(35, 30));
        
        JPanel totUpp = new JPanel();
        totUpp.setMinimumSize(new Dimension(500, 30));
        totUpp.setPreferredSize(new Dimension(500, 30));
        totUpp.setMaximumSize(new Dimension(500, 30));
        BoxLayout bl3 = new BoxLayout(totUpp, BoxLayout.X_AXIS);
        totUpp.setLayout(bl3);
        totUpp.add(totalUpperText);
        totUpp.add(Box.createGlue());
        totUpp.add(total);

        for (int i = 0; i < categories.size(); i++)
        {
            JPanel jp = new JPanel();
            jp.setMinimumSize(new Dimension(500, 30));
            jp.setPreferredSize(new Dimension(500, 30));
            jp.setMaximumSize(new Dimension(500, 30));
            
            BoxLayout bl = new BoxLayout(jp, BoxLayout.X_AXIS);
            jp.setLayout(bl);
            
            jp.add(categories.get(i));
            jp.add(Box.createGlue());
            jp.add(scores.get(i));
            
            this.add(jp);
        }   
        
        this.add(totScr);
        this.add(totBon);
        this.add(totUpp);
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
            
            //check to make sure you can choose category
            if (!ScoreCardUi.checkCategory(diceArray, category))
                return;
      
            //make sure player has rolled the dice
            if (player.getRollCount() == 0) {
                JOptionPane.showMessageDialog(null, player.getName() + " please roll the dice first!");
                return;
            }

            //make sure category is good
            if (category < Constants.ONES || category > Constants.SIXES)
                return;
            
            //category logic
            int categoryScore = UpperSectionUi.addDice(dice, category); //add dice of that value
            switch (category) {
                case Constants.ONES:
                    player.getScore().getUpper().setAces(categoryScore); //set score in player scorecard
                    break;
                case Constants.TWOS:
                    player.getScore().getUpper().setTwos(categoryScore); //set score in player scorecard
                    break;
                case Constants.THREES:
                    player.getScore().getUpper().setThrees(categoryScore); //set score in player scorecard
                    break;
                case Constants.FOURS:
                    player.getScore().getUpper().setFours(categoryScore); //set score in player scorecard
                    break;
                case Constants.FIVES:
                    player.getScore().getUpper().setFives(categoryScore); //set score in player scorecard
                    break;
                case Constants.SIXES:
                    player.getScore().getUpper().setSixes(categoryScore); //set score in player scorecard
                    break;
                default:
                    break;
            }
            
            player.getScore().getUpper().selected[category - 1] = true; //category has been selected before
            
            //update score on ui immediately
            scores.get(category - 1).setText(Integer.toString(categoryScore));
            
            setTotal(player.getTotalUpperScore());
            player.getTotalUpperScoreWithBonus(); //perform score operations in player
            setBonus(player.getScore().getUpper().getBonus());
            setTotalScore(player.getTotalUpperScoreWithBonus());
            
            ui.getScoreCardUi().getLowerUi().setTotalUpper(player.getTotalUpperScoreWithBonus());
            ui.getScoreCardUi().setGrandTotal(player.getTotalScore());
            ui.getPlayerUi().setPlayerScore(player.getTotalScore());
            
            categories.get(category - 1).setEnabled(false); //update category button on ui immediately
            
            JOptionPane.showMessageDialog(this, "Selected category was " + ScoreCardUi.categoryName(category));
            player.setFinished(true);
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
     * @return the total
     */
    public JLabel getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total.setText(Integer.toString(total));
    }

    /**
     * @return the bonus
     */
    public JLabel getBonus() {
        return bonus;
    }

    /**
     * @param bonus the bonus to set
     */
    public void setBonus(int bonus) {
        this.bonus.setText(Integer.toString(bonus));
    }

    /**
     * @return the totalScore
     */
    public JLabel getTotalScore() {
        return totalScore;
    }

    /**
     * @param totalScore the totalScore to set
     */
    public void setTotalScore(int totalScore) {
        this.totalScore.setText(Integer.toString(totalScore));
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
        player.getScore().getUpper().setPlayerScores(this);
        
        setTotal(player.getTotalUpperScore());
        setBonus(player.getScore().getUpper().getBonus());
        setTotalScore(player.getTotalUpperScoreWithBonus());
        
        //set new player categories on ui
        player.getScore().getUpper().setPlayerCategories(this);
    }
    
    /**
     *
     * @param dice
     * @param value
     * @return
     */
    public static int addDice(ArrayList<Die> dice, int value)
    {
        int total = 0;
        for (Die d : dice) {
            int dValue = d.getFaceValue();
            if (dValue == value)
                total += dValue;
        }
        return total;
    }
}
