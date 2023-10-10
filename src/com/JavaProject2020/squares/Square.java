package com.JavaProject2020.squares;

import java.util.ArrayList;

import com.JavaProject2020.objects.Board;
import com.JavaProject2020.objects.Player;

public abstract class Square {
	
    public int number;
    private Board board;
    public ArrayList<Player> currentPlayer;

    public Square(int number, Board board) {
        this.number = number;
        this.board = board;
        currentPlayer = new ArrayList<Player>();
    }

    public void addPlayer(Player player) {
        currentPlayer.add(player);
    }

    public boolean isPlayer() {
        return !currentPlayer.isEmpty();
    }

    public abstract void action(Player player);
}