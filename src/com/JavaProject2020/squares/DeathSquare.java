package com.JavaProject2020.squares;

import com.JavaProject2020.objects.Board;
import com.JavaProject2020.objects.Player;

public class DeathSquare extends Square{

    private final int square;

    public DeathSquare(int number, Board board, int square) {
        super(number, board);
        this.square = square;
    }

    @Override
    public void action(Player player) {
        player.goTo(square);
    }
}