/*
 * Zachary Gill
 * COP 3330 Object Oriented Programming
 * University of Central Florida
 */

package userInterface;

import core.Constants;
import core.Player;

import java.awt.Dimension;
import javax.swing.*;

/**
 *
 * @author ZGorlock
 */
public class PlayerUi extends JPanel
{
    private BoxLayout boxLayout;
    private JLabel playerName;
    private JLabel playerScore;
    
    private YahtzeeUi ui;
    
    /**
     * Default constructor for PlayerUi
     */
    public PlayerUi()
    {
        initComponents();
    }

    /**
     *
     * @param ui
     */
    public PlayerUi(YahtzeeUi ui)
    {
        this.ui = ui;
        initComponents();
    }
    
    private void initComponents()
    {
        boxLayout = new BoxLayout(this, BoxLayout.X_AXIS);
        
        this.setLayout(boxLayout);
        this.setMinimumSize(new Dimension(200, 100));
        this.setPreferredSize(new Dimension(200, 100));
        this.setMaximumSize(new Dimension(200, 100));
        this.setBorder(BorderFactory.createRaisedBevelBorder());
        
        playerName = new JLabel();
        getPlayerName().setText("Name");
        getPlayerName().setMinimumSize(new Dimension(100, 100));
        getPlayerName().setPreferredSize(new Dimension(100, 100));
        getPlayerName().setMaximumSize(new Dimension(100, 100));
        
        playerScore = new JLabel();
        getPlayerScore().setText(String.valueOf(Constants.ZERO));
        getPlayerScore().setMinimumSize(new Dimension(100, 100));
        getPlayerScore().setPreferredSize(new Dimension(100, 100));
        getPlayerScore().setMaximumSize(new Dimension(100, 100));
        
        this.add(getPlayerName());
        this.add(getPlayerScore());
    }

    /**
     * @return the playerName
     */
    public JLabel getPlayerName() {
        return playerName;
    }

    /**
     * @param playerName the playerName to set
     */
    public void setPlayerName(String playerName) {
        this.playerName.setText(playerName);
    }

    /**
     * @return the playerScore
     */
    public JLabel getPlayerScore() {
        return playerScore;
    }

    /**
     * @param playerScore the playerScore to set
     */
    public void setPlayerScore(int playerScore) {
        this.playerScore.setText(Integer.toString(playerScore));
    }
}
