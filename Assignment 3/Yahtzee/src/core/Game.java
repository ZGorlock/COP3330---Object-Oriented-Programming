/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Zachary Gill
 */
public class Game {
    //Member Variables
    private int gameTurn;
    private ArrayList<Player> players;
    private Scanner input;
    
    
    //Methods
    
    /**
     * Overriden default constructor for Game
     */
    public Game()
    {
        //Prompt user for number of players
        System.out.print("How many players for this game? ");
        input = new Scanner(System.in);
        
        int playerCount = input.nextInt();
        players = new ArrayList<Player>(0);
        
        for (int i = 0; i < playerCount; i++)
            newPlayer();
        
    }
    
    /**
     * Adds a new player to the game
     */
    public void newPlayer()
    {
        //Prompt user for player's name
        System.out.print("Enter player's name: ");
        String name = input.next();
        
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
        for (Player p : players)
            p.rollDice();
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

    /**
     * @return the input
     */
    public Scanner getInput() {
        return input;
    }

    /**
     * @param input the input to set
     */
    public void setInput(Scanner input) {
        this.input = input;
    }
    
}
