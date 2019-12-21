/*
 * Karin Whiting
 * COP 3330 Object Oriented Programming
 * University of Central Florida
 */

package core;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Game 
{
    private int gameTurn;
    private ArrayList<Player> players = new ArrayList<Player>();
    private Scanner input = new Scanner(System.in);

    // no-arguement constructor 
    public Game()
    {
        JOptionPane.showMessageDialog(null, "Let's play Yahtzee!");
        System.out.print("How many players for this game? ");
        int numPlayers = input.nextInt();
        
        // loop through number of players and create the objects
        for(int i = 0; i < numPlayers; i++)
        {
            // call method to create the new player
            newPlayer();
        }   
    }
    
    /**
     * @return the gameTurn
     */
    public int getGameTurn() 
    {
        return gameTurn;
    }

    /**
     * @param gameTurn the gameTurn to set
     */
    public void setGameTurn(int gameTurn) 
    {
        this.gameTurn = gameTurn;
    }

    /**
     * @return the players
     */
    public ArrayList<Player> getPlayers() 
    {
        return players;
    }

    /**
     * @param players the players to set
     */
    public void setPlayers(ArrayList<Player> players) 
    {
        this.players = players;
    }
    
    private void newPlayer()
    {
        // prompt the user for the player name
        System.out.print("Enter player's name: ");
        // read in string data from command prompt
        String data = input.next();
        // create a new Player with data
        Player player = new Player();
        // set the name member variable to the data read in
        player.setName(data);
        // add the player to the container
        players.add(player);
    }

    public void displayPlayers()
    {
        System.out.println("Players for this game are: ");

        // loop through players and display information
        for(Player player : players)
        {
            System.out.println(player.getName());
        }
    }
    
    public void playGame()
    {
        // loop through each player and have them do one roll 
        for(Player player : players)
        {
            player.rollDice();
        } 
    }
}
