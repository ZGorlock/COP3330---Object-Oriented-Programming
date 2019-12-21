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
        
public class LowerSectionUi extends JPanel implements ActionListener
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
            category.addActionListener(this);
            category.setActionCommand(Integer.toString(i));
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
    
    public void actionPerformed(ActionEvent e)
    {
        //Print different message for each category
        switch(Integer.valueOf(e.getActionCommand())) {
            case 0:
                JOptionPane.showMessageDialog(this, "Selected category was : " + Constants.TRIPLE.substring(0, Constants.TRIPLE.indexOf("  ")));
                break;
            case 1:
                JOptionPane.showMessageDialog(this, "Selected category was : " + Constants.QUAD.substring(0, Constants.QUAD.indexOf("  ")));
                break;
            case 2:
                JOptionPane.showMessageDialog(this, "Selected category was : " + Constants.FULL.substring(0, Constants.FULL.indexOf("  ")));
                break;
            case 3:
                JOptionPane.showMessageDialog(this, "Selected category was : " + Constants.SMALL.substring(0, Constants.SMALL.indexOf("  ")));
                break;
            case 4:
                JOptionPane.showMessageDialog(this, "Selected category was : " + Constants.LARGE.substring(0, Constants.LARGE.indexOf("  ")));
                break;
            case 5:
                JOptionPane.showMessageDialog(this, "Selected category was : " + Constants.YAHTZ.substring(0, Constants.YAHTZ.indexOf("  ")));
                break;
            case 6:
                JOptionPane.showMessageDialog(this, "Selected category was : " + Constants.LASTCHANCE.substring(0, Constants.LASTCHANCE.indexOf("  ")));
                break;
            case 7:
                JOptionPane.showMessageDialog(this, "Selected category was : " + Constants.YAHTZ_BONUS.substring(0, Constants.YAHTZ_BONUS.indexOf("  ")));
                break;
        }
    }
}
