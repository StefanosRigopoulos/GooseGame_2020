package com.JavaProject2020.squares;

import com.JavaProject2020.objects.Board;
import com.JavaProject2020.objects.Player;

public class GooseSquare extends Square{

    public GooseSquare(int number, Board board) {
        super(number, board);
    }

    @Override
    public void action(Player player) {
        player.moveTo(player.getLastRoll());
    }
}