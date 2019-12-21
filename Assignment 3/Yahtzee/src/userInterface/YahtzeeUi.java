/*
 * Zachary Gill
 * COP 3330 Object Oriented Programming
 * University of Central Florida
 */

package userInterface;

import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;

public class YahtzeeUi implements ActionListener
{
    private GameUi gameUi;
    private PlayerUi playerUi;
    private RollUi rollUi;
    private ScoreCardUi scoreCardUi;
    
    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu game;
    private JMenuItem exit;
    private JMenuItem newGame;
    private JPanel rightPanel;

    public YahtzeeUi()
    {
        initComponents();
    }
    
    private void initComponents()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Yahtzee!");
        frame.setMinimumSize(new Dimension(800, 725));
        frame.setPreferredSize(new Dimension(800, 725));
        frame.setMaximumSize(new Dimension(800, 725));
        // Initialize the JMenuBar and add to the JFrame
        createMenu();
        
        // Add everything to the JFrame
        frame.setJMenuBar(menuBar);
        
        gameUi = new GameUi();
        playerUi = new PlayerUi();
        rollUi = new RollUi();
        
        rightPanel = new JPanel();
        rightPanel.setMinimumSize(new Dimension(300, 700));
        rightPanel.setPreferredSize(new Dimension(300, 700));
        rightPanel.setMaximumSize(new Dimension(300, 700));
        rightPanel.add(gameUi);
        rightPanel.add(playerUi);
        rightPanel.add(rollUi);
        
        scoreCardUi = new ScoreCardUi();
        
        frame.add(rightPanel, BorderLayout.EAST);
        frame.add(scoreCardUi, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    
    private void createMenu()
    {
        menuBar = new JMenuBar();
        game = new JMenu("Yahtzee");
        game.setMnemonic('Y');
        
        newGame = new JMenuItem("New Game");
        newGame.setMnemonic('N');
        newGame.addActionListener(this);
        newGame.setActionCommand("New Game");

        exit = new JMenuItem("Exit");
        exit.setMnemonic('E');
        exit.addActionListener(this);
        exit.setActionCommand("Exit");
        
        game.add(newGame);    
        game.add(exit);    
        
        menuBar.add(game);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        //Menu Actions
        switch(e.getActionCommand()) {
            case "Exit": //Exit
                System.exit(0);
                break;
            case "New Game": //New Game
                Object[] options = {"Yes",
                    "No",
                    "Cancel"};
                int n = JOptionPane.showOptionDialog(frame,
                    "Are you sure you want to start a new game?",
                    "Select an Option",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[2]);
                if (n == 0) { //If "Yes" then start new game
                    //New Game
                }
                break;
        }
    }
}
