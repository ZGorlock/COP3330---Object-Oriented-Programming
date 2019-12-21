/*
 * Zachary Gill
 * COP 3330 Object Oriented Programming
 * University of Central Florida
 */

package userInterface;

import core.Constants;
import java.awt.Dimension;

import javax.swing.*;

public class ScoreCardUi extends JPanel
{
    private BoxLayout boxLayout;
    private JLabel grandTotal;    
    private LowerSectionUi lowerUi;
    private UpperSectionUi upperUi;
    
    public ScoreCardUi()
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

        upperUi = new UpperSectionUi();
        lowerUi = new LowerSectionUi();

        grandTotal = new JLabel("GRAND TOTAL                                        0");
        grandTotal.setMinimumSize(new Dimension(500, 35));
        grandTotal.setPreferredSize(new Dimension(500, 35));
        grandTotal.setMaximumSize(new Dimension(500, 35));
       
        this.add(upperUi);
        this.add(lowerUi);
        this.add(grandTotal);
    }
}
