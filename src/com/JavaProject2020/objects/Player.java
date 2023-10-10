package com.JavaProject2020.objects;

public class Player {
    
    private String name;
    private int square, lastRoll = 0, lastSquare = 0;
    public int round = 0;
    private boolean rolling = true;
    private Board board;
    
    public Player(String name, int square, Board board) {
        this.name = name;
        this.square = square;
        this.board = board;
    }

    public void rolling(boolean rolling) {
        this.rolling = rolling;
    }

    public void loseRounds(int rounds) {
        this.round += rounds;
    }

    public void goTo(int square) {
    	this.lastSquare = this.square;
        this.square = square;
    }

    public void moveTo(int move) {
    	this.lastSquare = this.square;
        if (square + move <= 63) {
            this.square += move;
            lastRoll = move;
        }
        else {
            this.square = 63 - ((this.square + move) - 63);
            lastRoll = -move;
        }
    }

    public String getName() {
        return this.name;
    }
    public int getSquare() {
        return this.square;
    }
    public int getLastRoll() {
        return this.lastRoll;
    }
    public int getLastSquare() {
        return this.lastSquare;
    }
    public int getRound() {
        return this.round;
    }
    public boolean getRolling() {
        return this.rolling;
    }

    @Override
    public String toString() {
        return this.name + " " + this.square;
    }
}
