package com.JavaProject2020.squares;

import com.JavaProject2020.objects.Board;
import com.JavaProject2020.objects.Player;

public class WellSquare extends Square{

    public WellSquare(int number, Board board) {
        super(number, board);
    }

    @Override
    public void action(Player player) {
        // Stays until another player arrives and the new player stays until another player arrives.
        if (currentPlayer.isEmpty()) {              // Empty square.
            currentPlayer.add(player);                  // Setting the new player in square.
            player.rolling(false);                      // Locking the new player to not rolling.
        }
        else {                                      // If there is a player already
            currentPlayer.get(0).rolling(true);         // Previous player goes free.
            currentPlayer.clear();                      // Clearing the currentPlayer.
            currentPlayer.add(player);                  // Setting the new player in square.
            player.rolling(false);                      // Locking the new player to not rolling.
        }
    }
}