package com.JavaProject2020.squares;

import com.JavaProject2020.objects.Board;
import com.JavaProject2020.objects.Player;

public class PrisonSquare extends Square{
    
    public PrisonSquare(int number, Board board) {
        super(number, board);
    }
    
    @Override
    public void action(Player player) {
        // Waits until a player arrives to help him and the new player continues.
        if (currentPlayer.isEmpty()) {              //Empty square.
            currentPlayer.add(player);                  // Setting the new player in square.
            player.rolling(false);                      // Locking the new player to not rolling.
        }
        else {                                      // If there is a player already
            currentPlayer.get(0).rolling(true);		// Previous player goes free.
            currentPlayer.clear();                      // Clearing the currentPlayer.
        }
    }
}