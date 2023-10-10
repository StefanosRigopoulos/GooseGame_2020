package com.JavaProject2020.squares;

import com.JavaProject2020.objects.Board;
import com.JavaProject2020.objects.Player;

public class InnSquare extends Square{
	
    private final int rounds;

    public InnSquare(int number, Board board, int rounds) {
        super(number, board);
        this.rounds = rounds;
    }

    @Override
    public void action(Player player) {
        player.loseRounds(rounds);
    }
}