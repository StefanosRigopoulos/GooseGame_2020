package com.JavaProject2020.main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int x = 0;
        
        System.out.println("Welcome to Goose Game!");
        System.out.println("");
        System.out.println("1. Start");
        System.out.println("2. Load");
        System.out.println("3. Help");
        System.out.println("4. Exit");
        
        while (x == 0) {
            String choice = input.nextLine();
            switch(choice) {
            case "Start":
                int numPlayers;
                do {
                    System.out.println("Players range from 2 to 6.");
                    System.out.print("Please specify the number of Players: ");
                    numPlayers = input.nextInt();
                }while(numPlayers > 6 || numPlayers < 2);

                Game game = new Game(numPlayers);
                game.start();

                break;
            case "Load":
                System.out.println("Returning to previous game...");
                LoadGame loadedGame = new LoadGame();
                Game loadgame = new Game(loadedGame.getPlayers(), loadedGame.getPlayers().size());
                loadgame.start();
                break;
            case "Help":
                System.out.println("Goose Game is:");
                System.out.println("This is a snake style game where you have to reach the end first.");
                System.out.println("Through the course you will find different types of squares");
                System.out.println("each with special abilites to help you or slow you down.");
                System.out.println("Test your luck by rolling the dices and hope to get through");
                System.out.println("as fast as possible.");
                System.out.println("");
                System.out.println("This game is made from:");
                System.out.println("Nikos Tsitouras");
                System.out.println("AM: 2022201600184");
                System.out.println("");
                break;
            case "Exit":
                System.out.println("Stopping the game...");
                x++;
                break;
            default:
                System.out.println("Please choose a valid option.");
                break;
            }
        }
    }
}