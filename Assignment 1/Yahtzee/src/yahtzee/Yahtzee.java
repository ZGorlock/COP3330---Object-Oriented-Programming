/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yahtzee;

import core.Game;

/**
 *
 * @author Zachary Gill
 */
public class Yahtzee {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Instantiate an instance of class Game
        Game game = new Game();
        
        //Call method displayPlayers() in class Game
        game.displayPlayers();
        
        //Call method playGame() in class Game
        game.playGame();
    }
    
}
