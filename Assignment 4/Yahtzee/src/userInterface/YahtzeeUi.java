/*
 * Zachary Gill
 * COP 3330 Object Oriented Programming
 * University of Central Florida
 */

package userInterface;

import core.Game;
import core.Player;
import core.ScoreCard;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author ZGorlock
 */
public class YahtzeeUi implements ActionListener
{
    private Game yahtzee;
    
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
    
    /**
     *
     */
    public int gameCount = 0;
    
    /**
     * Default constructor for YahtzeeUi
     */
    public YahtzeeUi()
    {
        initComponents();
    }
    
    private void initComponents()
    {
        //Setup Ui
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
        
        setGameUi(new GameUi(this));
        setPlayerUi(new PlayerUi(this));
        setRollUi(new RollUi(this));
        
        rightPanel = new JPanel();
        rightPanel.setMinimumSize(new Dimension(300, 700));
        rightPanel.setPreferredSize(new Dimension(300, 700));
        rightPanel.setMaximumSize(new Dimension(300, 700));
        rightPanel.add(getGameUi());
        rightPanel.add(getPlayerUi());
        rightPanel.add(getRollUi());
        
        setScoreCardUi(new ScoreCardUi(this));
        
        frame.add(rightPanel, BorderLayout.EAST);
        frame.add(getScoreCardUi(), BorderLayout.CENTER);
        frame.setVisible(true);
        
        //Start game functionality
        yahtzee = new Game(this);
        gameCount++;
        startGame();
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
    
    private void startGame()
    {
        yahtzee.playGame();
    }
    
    private void resetUi()
    {
        //initComponents();
        //frame.dispose();
        
        
        //reset player scores
        ArrayList<Player> players = yahtzee.getPlayers();
        for (Player p : players) {
            p.setRollCount(0);
            p.setFinished(true);
            p.setScore(new ScoreCard());
        }
        yahtzee.setPlayers(players);
        
        
        //frame.dispose();
        //yahtzee = new Game(this);
        //yahtzee.setPlayers(players);
        //initComponents();
        
        //reset game turn to 0
        yahtzee.setGameTurn(0);
        
        gameCount++;
        
        //startGame();
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
                    resetUi();
                }
                break;
        }
    }

    /**
     * @return the gameUi
     */
    public GameUi getGameUi() {
        return gameUi;
    }

    /**
     * @param gameUi the gameUi to set
     */
    public void setGameUi(GameUi gameUi) {
        this.gameUi = gameUi;
    }

    /**
     * @return the playerUi
     */
    public PlayerUi getPlayerUi() {
        return playerUi;
    }

    /**
     * @param playerUi the playerUi to set
     */
    public void setPlayerUi(PlayerUi playerUi) {
        this.playerUi = playerUi;
    }

    /**
     * @return the rollUi
     */
    public RollUi getRollUi() {
        return rollUi;
    }

    /**
     * @param rollUi the rollUi to set
     */
    public void setRollUi(RollUi rollUi) {
        this.rollUi = rollUi;
    }

    /**
     * @return the scoreCardUi
     */
    public ScoreCardUi getScoreCardUi() {
        return scoreCardUi;
    }

    /**
     * @param scoreCardUi the scoreCardUi to set
     */
    public void setScoreCardUi(ScoreCardUi scoreCardUi) {
        this.scoreCardUi = scoreCardUi;
    }
}
