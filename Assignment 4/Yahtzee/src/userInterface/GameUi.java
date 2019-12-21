/*
 * Zachary Gill
 * COP 3330 Object Oriented Programming
 * University of Central Florida
 */
package userInterface;

import core.Constants;
import core.Player;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
/**
 *
 * @author kwhiting
 */
public class GameUi extends JPanel
{
    private BoxLayout boxLayout;
    private ImageIcon logoImage;
    private JLabel round;
    private JLabel gameTurn;
    private JLabel logo;
    
    private Player player;
    
    private YahtzeeUi ui;
    
    /**
     * Default constructor for GameUi
     */
    public GameUi()
    {
        initComponents();
    }

    /**
     *
     * @param ui
     */
    public GameUi(YahtzeeUi ui)
    {
        this.ui = ui;
        initComponents();
    }
    
    private void initComponents()
    {
        setBoxLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        this.setLayout(getBoxLayout());
        this.setMinimumSize(new Dimension(200, 100));
        this.setPreferredSize(new Dimension(200, 100));
        this.setMaximumSize(new Dimension(200, 100));
        this.setBorder(BorderFactory.createRaisedBevelBorder());
        
        setLogo(new JLabel("Yahtzee"));
        getLogo().setMinimumSize(new Dimension(75, 75));
        getLogo().setPreferredSize(new Dimension(75, 75));
        getLogo().setMaximumSize(new Dimension(75, 75));
        
        //set image for logo
        logoImage = new ImageIcon( getClass().getResource("../images/yahtzee.jpg"));
        logoImage = imageResize(logoImage);
        logo.setIcon(logoImage);

        setGameTurn(new JLabel());
        //getGameTurn().setText(String.valueOf(Constants.ZERO) + " / " + 
        //                 String.valueOf(Constants.NUM_CATERGORY));        
        getGameTurn().setText(String.valueOf(Constants.ZERO));
        getGameTurn().setMinimumSize(new Dimension(20, 20));
        getGameTurn().setPreferredSize(new Dimension(20, 20));
        getGameTurn().setMaximumSize(new Dimension(20, 20));
        getGameTurn().setFont(new Font("Serif", Font.BOLD, 16));
        
        round = new JLabel();
        getRound().setMinimumSize(new Dimension(80, 20));
        getRound().setPreferredSize(new Dimension(80, 20));
        getRound().setMaximumSize(new Dimension(80, 20));
        getRound().setText(" / " + String.valueOf(Constants.NUM_CATERGORY));
        getRound().setFont(new Font("Serif", Font.BOLD, 16));
        
        this.add(getLogo());
        this.add(Box.createGlue());
        this.add(getGameTurn());
        this.add(Box.createGlue());
        this.add(getRound());
    }
    
    /**
     *
     * @param value
     */
    public void setGameTurnValue(int value)
    {
        //updates the number of the turn
        gameTurn.setText(String.valueOf(value));
    }
    
    // method to resize the image to fit on the jbutton
    private ImageIcon imageResize(ImageIcon icon)
    {
        Image image = icon.getImage();
        Image newImage = 
               image.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
        return icon;
    }

    /**
     * @return the boxLayout
     */
    public BoxLayout getBoxLayout() {
        return boxLayout;
    }

    /**
     * @param boxLayout the boxLayout to set
     */
    public void setBoxLayout(BoxLayout boxLayout) {
        this.boxLayout = boxLayout;
    }

    /**
     * @return the round
     */
    public JLabel getRound() {
        return round;
    }

    /**
     * @param round the round to set
     */
    public void setRound(int round) {
        this.round.setText(Integer.toString(round) + " / " + String.valueOf(Constants.NUM_CATERGORY));
    }

    /**
     * @return the gameTurn
     */
    public JLabel getGameTurn() {
        return gameTurn;
    }

    /**
     * @param gameTurn the gameTurn to set
     */
    public void setGameTurn(JLabel gameTurn) {
        this.gameTurn = gameTurn;
    }

    /**
     * @return the logo
     */
    public JLabel getLogo() {
        return logo;
    }

    /**
     * @param logo the logo to set
     */
    public void setLogo(JLabel logo) {
        this.logo = logo;
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
    }
}
