package com.JavaProject2020.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.JavaProject2020.actions.RollDiceAction;
import com.JavaProject2020.objects.Board;
import com.JavaProject2020.objects.Player;
import com.JavaProject2020.squares.PrisonSquare;
import com.JavaProject2020.squares.Square;
import com.JavaProject2020.squares.WellSquare;

public class Game {

    private ArrayList<Player> players;
    private Board board;
    private int numPlayers;

    public Game(int numPlayers) {
        Scanner input = new Scanner(System.in);
        this.numPlayers = numPlayers;
        players = new ArrayList<Player>();
        board = new Board();
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Give me the name of Player number " + (i + 1) + " : ");
            players.add(new Player(input.nextLine(), 0, board));
        }
    }

    public Game(ArrayList<Player> players, int numPlayers) {
        this.players = players;
        this.numPlayers = numPlayers;
        board = new Board();
    }

    public void start() {
        int winner = -1, round = 0;
        boolean exit = false;
        
        do {
            System.out.println("");
            System.out.println("This is the round " + round);
            for (int i = 0; i < numPlayers; i++) {
                Player tmpPlayer = players.get(i);
                System.out.println("");
                System.out.println("Now playing : " + tmpPlayer.getName());
                System.out.println("Current Square : " + tmpPlayer.getSquare());
                if (tmpPlayer.getRound() == round && tmpPlayer.getRolling()) {
                    System.out.print("Move > ");
                    Scanner input = new Scanner(System.in);
                    String move;
                    int k = 0;
                    while (k == 0) {
                        move = input.nextLine();
                        switch(move) {
                        case "Roll":
                            RollDiceAction dice = new RollDiceAction();
                            tmpPlayer.moveTo(dice.roll());
                            
                            if (tmpPlayer.getRound() == 0) {
                            	if ((dice.getDice1() == 6 && dice.getDice1() == 3) || (dice.getDice1() == 3 && dice.getDice1() == 6)) {
                            		tmpPlayer.goTo(26);
                            	}
                            	else if ((dice.getDice1() == 5 && dice.getDice1() == 4) || (dice.getDice1() == 4 && dice.getDice1() == 5)) {
                            		tmpPlayer.goTo(53);
                            	}
                            }
                            
                            Square currentSquare = board.getSquare(tmpPlayer.getSquare());
                            currentSquare.action(tmpPlayer);
                            
                            if (!(currentSquare instanceof PrisonSquare) && !(currentSquare instanceof WellSquare)) {
                                currentSquare.addPlayer(tmpPlayer);
                            }
                          
                            if (currentSquare.currentPlayer.size() > 1) {
                            	Player movingPlayer = currentSquare.currentPlayer.get(0);
                                currentSquare.currentPlayer.set(0, currentSquare.currentPlayer.get(1));
                                movingPlayer.goTo(tmpPlayer.getLastSquare());
                                System.out.println(tmpPlayer.getName() + " arrived at " + tmpPlayer.getSquare() + " and knocked back to his previous square " + movingPlayer.getName() + ", who was here before.");
                            }
                            board.getSquare(tmpPlayer.getLastSquare()).currentPlayer.clear();
                            
                            k++;
                            break;
                        case "Save":
                            SaveGame save = new SaveGame(players);
                            save.save();
                            System.out.println("Game Saved!");
                            k++;
                            break;
                        case "Exit":
                            System.out.println("Stopping the game...");
                            exit = true;
                            k++;
                            break;
                        default:
                            System.out.println("Choose either 'Roll' or 'Save' or 'Exit'");
                            break;
                        }
                    }
                    tmpPlayer.round++;
                }
                else {
                    if (tmpPlayer.getSquare() == 31 || tmpPlayer.getSquare() == 52){
                        System.out.println("You cannot play until a player arrives to help you.");
                        tmpPlayer.round++;
                    }
                    else {
                        System.out.println("You have lost this round.");
                    }
                }
				
                if (tmpPlayer.getSquare() == 63) {
                    winner = i;
                    break;
                }
                
                if (exit){
                    winner = -2;
                    break;
                }
                System.out.println("New Square : " + tmpPlayer.getSquare());
            }
            round++;
        } while (winner == -1);

        if (!exit){
            System.out.println("");
            System.out.println("    Congratulations!");
            System.out.println("");
            System.out.println("->   " + players.get(winner).getName() + "   <-");
            System.out.println("");
            System.out.println("Thanks for playing Goose!");
            System.out.println("");
        }
    }
}