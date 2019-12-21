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
        
public class LowerSectionUi extends JPanel
{
    private ArrayList<JButton> categories;
    private ArrayList<JLabel> scores;
    private BoxLayout boxLayout;
    private JLabel totalLower;
    private JLabel totalUpper;

    public LowerSectionUi()
    {
        initComponents();
    }
    
    private void initComponents()
    {
        boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        
        this.setLayout(boxLayout);
        this.setMinimumSize(new Dimension(500, 500));
        this.setPreferredSize(new Dimension(500, 500));
        this.setMaximumSize(new Dimension(500, 500));
        this.setBorder(BorderFactory.createRaisedBevelBorder());

        categories = new ArrayList<JButton>();
        
        for(int i = 0; i <= Constants.LOWER_CATERGORY; i++)
        {
            JButton category = new JButton();
            category.setMinimumSize(new Dimension(500, 35));
            category.setPreferredSize(new Dimension(500, 35));
            category.setMaximumSize(new Dimension(500, 35));

            switch(i)
            {
                case 0:
                    category.setText(Constants.TRIPLE);
                    break;
                case 1:
                    category.setText(Constants.QUAD);
                    break;
                case 2:
                    category.setText(Constants.FULL);
                    break;
                case 3:
                    category.setText(Constants.SMALL);
                    break;
                case 4:
                    category.setText(Constants.LARGE);
                    break;
                case 5:
                    category.setText(Constants.YAHTZ);
                    break;
                case 6:
                    category.setText(Constants.LASTCHANCE);
                    break;
                case 7:
                    category.setText(Constants.YAHTZ_BONUS);
                    break;
                default:
                    category.setText("No valid value");
                    break;
            }
            categories.add(category);
        }
              
        totalLower = new JLabel("TOTAL of Lower Section                              0");
        totalLower.setMinimumSize(new Dimension(500, 35));
        totalLower.setPreferredSize(new Dimension(500, 35));
        totalLower.setMaximumSize(new Dimension(500, 35));

        totalUpper = new JLabel("TOTAL of Upper Section                              0");
        totalUpper.setMinimumSize(new Dimension(500, 35));
        totalUpper.setPreferredSize(new Dimension(500, 35));
        totalUpper.setMaximumSize(new Dimension(500, 35));
        
        for(JButton category : categories)
        {
            this.add(category);
        }   
        
        this.add(totalUpper);
        this.add(totalLower);
    }
}
