/*
 * Zachary Gill
 * COP 3330 Object Oriented Programming
 * University of Central Florida
 */

package userInterface;

import java.awt.*;
import java.awt.event.*;
import core.Constants;
import core.Die;
import core.Player;
import java.awt.Component;
import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author ZGorlock
 */
public class RollUi extends JPanel implements ActionListener
{
    private ArrayList<JToggleButton> dice;
    
    private GridBagLayout gridBagLayout;
    private GridBagConstraints constraints;
    
    private ImageIcon dieImage;
    private JButton roll;
    
    private Player player;
    
    private YahtzeeUi ui;
    
    /**
     * Default constructor for RollUi
     */
    public RollUi()
    {
        initComponents();
    }

    /**
     *
     * @param ui
     */
    public RollUi(YahtzeeUi ui)
    {
        this.ui = ui;
        initComponents();
    }
    
    private void initComponents()
    {
        gridBagLayout = new GridBagLayout();
        constraints = new GridBagConstraints();
        
        this.setLayout(gridBagLayout);
        this.setMinimumSize(new Dimension(200, 480));
        this.setPreferredSize(new Dimension(200, 480));
        this.setMaximumSize(new Dimension(200, 480));
        this.setBorder(BorderFactory.createRaisedBevelBorder());

        dice = new ArrayList<JToggleButton>();
        
        for(int i = 0; i < Constants.NUM_DICE; i++)
        {
            JToggleButton die = new JToggleButton();
            die.setMinimumSize(new Dimension(65, 65));
            die.setPreferredSize(new Dimension(65, 65));
            die.setMaximumSize(new Dimension(65, 65));
            die.setAlignmentX(Component.CENTER_ALIGNMENT);            
            die.putClientProperty("die", (i + 1));
            die.putClientProperty("value", (i + 1));
            die.addActionListener(this);
            die.setActionCommand(Integer.toString(i));
            die.setBorderPainted(die.isSelected());
            
            //get dice image
            addImage(die);
            
            //add to layout
            dice.add(die);
            addComponent(0, i, 1, 1, this, die);   
        }
            
        //roll dice button   
        roll = new JButton("Roll \nDice");
        roll.setMinimumSize(new Dimension(100, 100));
        roll.setPreferredSize(new Dimension(100, 100));
        roll.setMaximumSize(new Dimension(100, 100));
        roll.addActionListener(this);
        roll.setActionCommand("Roll");
        addComponent(0, 7, 1, 1, this, roll);  
        
    }
    
        // X is the column
    // Y is the row
    // W is the width in cells
    // H is the height in cells
    // aContainer is the container the component is added to
    // aComponent is the component being added to the container
    private void addComponent( int x, int y, int w, int h, 
                               Container aContainer, Component aComponent )  
    {  
        constraints.gridx = x;  
        constraints.gridy = y;  
        constraints.gridwidth = w;  
        constraints.gridheight = h;
        
        if(y == 7)
        {
            constraints.insets = new Insets(8, 8, 8, 8);
        }
        else
        {
            constraints.insets = new Insets(3, 3, 3, 3);
        }
        
        gridBagLayout.setConstraints( aComponent, constraints );  
        aContainer.add( aComponent );  
    } 
    
        // method for adding the images to the dice buttons
    private void addImage(JToggleButton die)
    {
        int value = (int)die.getClientProperty("value");
        dieImage = new ImageIcon( getClass().getResource("../images/" + Integer.toString(value) + ".jpg"));
        dieImage = imageResize(dieImage);
        die.setIcon(dieImage);
    }
    
        // method to resize the image to fit on the jbutton
    private ImageIcon imageResize(ImageIcon icon)
    {
        Image image = icon.getImage();
        Image newImage = 
               image.getScaledInstance(65, 65, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
        return icon;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand() == "Roll") {
            if (player.getRollCount() == 3) {
                JOptionPane.showMessageDialog(null, player.getName() + " please select a category!");
            }
            else {
                player.rollDice();
                setDice(player.getRoll().getDice());
            }
        }
        else {
            if (player.getRollCount() == 0) {
                JOptionPane.showMessageDialog(null, player.getName() + " please roll the dice first!");
                JToggleButton button = (JToggleButton)e.getSource();
                button.setSelected(false);
            }
            else if (player.getRollCount() == 3) {
                JOptionPane.showMessageDialog(null, player.getName() + " please select a category!");
                JToggleButton button = (JToggleButton)e.getSource();
                button.setSelected(false);
            }
            else {
                int die = 0;// = Integer.valueOf(e.getActionCommand());
                int value = 0;
                boolean selected = false;

                if (e.getSource() instanceof JToggleButton) {
                    JToggleButton button = (JToggleButton)e.getSource();
                    die = (int)button.getClientProperty("die");
                    value = (int)button.getClientProperty("value");
                    selected = button.isSelected();

                    player.getRoll().getDice().get(die - 1).selected = selected;

                    //selected buttons are outlined
                    button.setBorderPainted(selected);
                }
            }
        }
    }

    /**
     *
     * @param diceData
     */
    public void setDice(ArrayList<Die> diceData)
    {
        int index = 0;
        for(JToggleButton die : dice)
        {
            die.putClientProperty("value", diceData.get(index).getFaceValue());
            addImage(die);
            index++;
        }
    }
    
    /**
     * Resets the selection state of dice and applies it to the ui
     */
    public void resetSelectedDice()
    {
        for (JToggleButton d : dice) {
            d.setSelected(false);
            d.setBorderPainted(false);
        }
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
        
        resetSelectedDice();
    }
}
