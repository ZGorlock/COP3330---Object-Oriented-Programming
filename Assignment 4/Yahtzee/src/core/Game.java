/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import userInterface.YahtzeeUi;

/**
 *
 * @author Zachary Gill
 */
public class Game {
    //Member Variables
    private int gameTurn;
    private ArrayList<Player> players;
    private Scanner input;
    
    private YahtzeeUi ui;
    
    
    //Methods
    
    /**
     * Overriden default constructor for Game
     * @param ui
     */
    public Game(YahtzeeUi ui)
    {
        this.ui = ui;
        
        //Prompt user for number of players
        int playerCount = Integer.parseInt(JOptionPane.showInputDialog("How many players for this game?"));
        //System.out.print("How many players for this game? ");
        //input = new Scanner(System.in);
        
        //int playerCount = input.nextInt();
        players = new ArrayList<Player>(0);
        
        //set game turn to 0
        setGameTurn(Constants.ZERO);
        
        //create new players
        for (int i = 0; i < playerCount; i++)
            newPlayer();
        
        //initalized dialog
        JOptionPane.showMessageDialog(null, "Let's play Yahtzee!");
    }
    
    /**
     * Adds a new player to the game
     */
    public void newPlayer()
    {
        //Prompt user for player's name
        //System.out.print("Enter player's name: ");
        //String name = input.next();
        
        String name = JOptionPane.showInputDialog("Enter player " + (players.size() + 1) + "'s name:");
        
        //create new player
        Player player = new Player();
        player.setName(name);
        
        //add player to player list
        players.add(player);
    }
    
    /**
     * Displays the names of the players
     */
    public void displayPlayers()
    {
        System.out.println("Players for this game are:");
        for (Player p : players)
            System.out.println(p.getName());
        System.out.println();
    }
    
    /**
     * Plays yahtzee
     */
    public void playGame()
    {
        for (int i = 0; i < Constants.NUM_CATERGORY; i++) {            
            //update round number on ui
            ui.getGameUi().setGameTurnValue(i + 1);
            
            JOptionPane.showMessageDialog(null, "YAHTZEE Round " + (i + 1));
            
            //for each player
            for (Player p : players) {
                p.setFinished(false);
                
                //update current player on ui
                ui.getPlayerUi().setPlayerName(p.getName());
                ui.getPlayerUi().setPlayerScore(p.getTotalScore());
                ui.getRollUi().setPlayer(p);
                ui.getScoreCardUi().setPlayer(p);

                JOptionPane.showMessageDialog(null, p.getName() + "'s turn!");

                int oldGameCount = ui.gameCount;
                //wait until player's turn is over
                while(!p.isFinished()) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (ui.gameCount != oldGameCount)
                        playGame();
                }
            }
        }
        
        String winner = "";
        int winnerScore = 0;
        for (Player p : players) {
            int pScore = p.getTotalScore();
            if (pScore > winnerScore) {
                winner = p.getName();
                winnerScore = pScore;
            }
        }
        JOptionPane.showMessageDialog(null, winner + " is the winner!");
    }
    
    
    //Member variable encapsulation
    
    /**
     * @return the gameTurn
     */
    public int getGameTurn() {
        return gameTurn;
    }

    /**
     * @param gameTurn the gameTurn to set
     */
    public void setGameTurn(int gameTurn) {
        this.gameTurn = gameTurn;
    }

    /**
     * @return the players
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players to set
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    
}
