package com.JavaProject2020.actions;

import java.util.Random;

public class RollDiceAction{
	
    private final int Dice1, Dice2;

    public RollDiceAction() {
        Random Dice = new Random();
        this.Dice1 = 1 + Dice.nextInt(6);
        this.Dice2 = 1 + Dice.nextInt(6);
    }
    
    public int roll(){
        System.out.println("You rolled " + Dice1 + " and " + Dice2);
        return Dice1 + Dice2;
    }
    
    public int getDice1() {
    	return this.Dice1;
    }
    public int getDice2() {
    	return this.Dice2;
    }
}