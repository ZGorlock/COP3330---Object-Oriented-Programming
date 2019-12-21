/*
 * Zachary Gill
 * COP 3330 Object Oriented Programming
 * University of Central Florida
 */
package userInterface;

import core.Constants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;
/**
 *
 * @author kwhiting
 */
public class GameUi extends JPanel
{
    private BoxLayout boxLayout;
    private JLabel round;
    private JLabel gameTurn;
    private JLabel logo;
    
    public GameUi()
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
        
        logo = new JLabel("Yahtzee");
        logo.setMinimumSize(new Dimension(100, 100));
        logo.setPreferredSize(new Dimension(100, 100));
        logo.setMaximumSize(new Dimension(100, 100));

        gameTurn = new JLabel();
        gameTurn.setText(String.valueOf(Constants.ZERO) + " / " + 
                         String.valueOf(Constants.NUM_CATERGORY));
        gameTurn.setMinimumSize(new Dimension(100, 100));
        gameTurn.setPreferredSize(new Dimension(100, 100));
        gameTurn.setMaximumSize(new Dimension(100, 100));
        
        round = new JLabel("Round");
        round.setMinimumSize(new Dimension(100, 100));
        round.setPreferredSize(new Dimension(100, 100));
        round.setMaximumSize(new Dimension(100, 100));
        
        this.add(logo);
        this.add(gameTurn);
    }
}
