/*
 * Zachary Gill
 * COP 3330 Object Oriented Programming
 * University of Central Florida
 */
package userInterface;

import java.awt.*;
import java.awt.event.*;
import core.Constants;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.*;

public class UpperSectionUi extends JPanel implements ActionListener
{
    private ArrayList<JButton> categories;
    private ArrayList<JLabel> scores;
    private BoxLayout boxLayout;
    private JLabel total;
    private JLabel bonus;
    private JLabel totalScore;
    
    public UpperSectionUi()
    {
        initComponents();
    }
    
    private void initComponents()
    {
        boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        
        this.setLayout(boxLayout);
        this.setMinimumSize(new Dimension(500, 300));
        this.setPreferredSize(new Dimension(500, 300));
        this.setMaximumSize(new Dimension(500, 300));
        this.setBorder(BorderFactory.createRaisedBevelBorder());

        categories = new ArrayList<JButton>();
        
        for(int i = 0; i < Constants.MAX_DIE_VALUE; i++)
        {
            JButton category = new JButton();
            category.setMinimumSize(new Dimension(500, 35));
            category.setPreferredSize(new Dimension(500, 35));
            category.setMaximumSize(new Dimension(500, 35));

            switch(i)
            {
                case 0:
                    category.setText(Constants.ACE);
                    break;
                case 1:
                    category.setText(Constants.TWO);
                    break;
                case 2:
                    category.setText(Constants.THREE);
                    break;
                case 3:
                    category.setText(Constants.FOUR);
                    break;
                case 4:
                    category.setText(Constants.FIVE);
                    break;
                case 5:
                    category.setText(Constants.SIX);
                    break;
                default:
                    category.setText("No valid value");
                    break;
            }
            category.addActionListener(this);
            category.setActionCommand(Integer.toString(i));
            categories.add(category);
        }
              
        totalScore = new JLabel("TOTAL SCORE                                         0");
        totalScore.setMinimumSize(new Dimension(500, 25));
        totalScore.setPreferredSize(new Dimension(500, 25));
        totalScore.setMaximumSize(new Dimension(500, 25));

        bonus = new JLabel();
        bonus.setText(Constants.BONUS);
        bonus.setMinimumSize(new Dimension(500, 25));
        bonus.setPreferredSize(new Dimension(500, 25));
        bonus.setMaximumSize(new Dimension(500, 25));
        
        total = new JLabel("TOTAL of Upper Section                                  0");
        total.setMinimumSize(new Dimension(500, 25));
        total.setPreferredSize(new Dimension(500, 25));
        total.setMaximumSize(new Dimension(500, 25));

        for(JButton category : categories)
        {
            this.add(category);
        }   
        
        this.add(totalScore);
        this.add(bonus);
        this.add(total);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        //Print different message for each category
        switch(Integer.valueOf(e.getActionCommand())) {
            case 0:
                JOptionPane.showMessageDialog(this, "Selected category was : " + Constants.ACE.substring(0, Constants.ACE.indexOf("  ")));
                break;
            case 1:
                JOptionPane.showMessageDialog(this, "Selected category was : " + Constants.TWO.substring(0, Constants.TWO.indexOf("  ")));
                break;
            case 2:
                JOptionPane.showMessageDialog(this, "Selected category was : " + Constants.THREE.substring(0, Constants.THREE.indexOf("  ")));
                break;
            case 3:
                JOptionPane.showMessageDialog(this, "Selected category was : " + Constants.FOUR.substring(0, Constants.FOUR.indexOf("  ")));
                break;
            case 4:
                JOptionPane.showMessageDialog(this, "Selected category was : " + Constants.FIVE.substring(0, Constants.FIVE.indexOf("  ")));
                break;
            case 5:
                JOptionPane.showMessageDialog(this, "Selected category was : " + Constants.SIX.substring(0, Constants.SIX.indexOf("  ")));
                break;
        }
    }
}
