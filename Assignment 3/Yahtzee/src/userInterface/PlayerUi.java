/*
 * Zachary Gill
 * COP 3330 Object Oriented Programming
 * University of Central Florida
 */

package userInterface;

import core.Constants;

import java.awt.Dimension;
import javax.swing.*;

public class PlayerUi extends JPanel
{
    private BoxLayout boxLayout;
    private JLabel playerName;
    private JLabel playerScore;
    
    public PlayerUi()
    {
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
        playerName.setText("Name");
        playerName.setMinimumSize(new Dimension(100, 100));
        playerName.setPreferredSize(new Dimension(100, 100));
        playerName.setMaximumSize(new Dimension(100, 100));
        
        playerScore = new JLabel();
        playerScore.setText(String.valueOf(Constants.ZERO));
        playerScore.setMinimumSize(new Dimension(100, 100));
        playerScore.setPreferredSize(new Dimension(100, 100));
        playerScore.setMaximumSize(new Dimension(100, 100));
        
        this.add(playerName);
        this.add(playerScore);
    }
}
