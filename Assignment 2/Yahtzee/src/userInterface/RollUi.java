/*
 * Karin Whiting
 * COP 3330 Object Oriented Programming
 * University of Central Florida
 */

package userInterface;

import core.Constants;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.*;

public class RollUi extends JPanel
{
    private ArrayList<JButton> dice;
    private BoxLayout boxLayout;
    private JButton roll;
    
    public RollUi()
    {
        initComponents();
    }
    
    private void initComponents()
    {
        boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        
        this.setLayout(boxLayout);
        this.setMinimumSize(new Dimension(200, 600));
        this.setPreferredSize(new Dimension(200, 600));
        this.setMaximumSize(new Dimension(200, 600));
        this.setBorder(BorderFactory.createRaisedBevelBorder());

        dice = new ArrayList<JButton>();
        
        for(int i = 0; i < Constants.NUM_DICE; i++)
        {
            JButton die = new JButton();
            die.setMinimumSize(new Dimension(50, 50));
            die.setPreferredSize(new Dimension(50, 50));
            die.setMaximumSize(new Dimension(50, 50));
            die.setAlignmentX(Component.CENTER_ALIGNMENT);            
            die.setText(String.valueOf(i + 1));
            
            dice.add(die);
            
        }
        
        roll = new JButton("Roll Dice");
        roll.setMinimumSize(new Dimension(100, 100));
        roll.setPreferredSize(new Dimension(100, 100));
        roll.setMaximumSize(new Dimension(100, 100));
        
        for(JButton die : dice)
        {
            this.add(die);
        }   
        this.add(roll);
    }
}
