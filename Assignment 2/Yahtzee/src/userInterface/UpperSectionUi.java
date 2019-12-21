/*
 * Karin Whiting
 * COP 3330 Object Oriented Programming
 * University of Central Florida
 */
package userInterface;

import core.Constants;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.*;

public class UpperSectionUi extends JPanel
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
}
