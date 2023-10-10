package com.JavaProject2020.objects;

import java.util.ArrayList;

import com.JavaProject2020.squares.BridgeSquare;
import com.JavaProject2020.squares.DeathSquare;
import com.JavaProject2020.squares.GooseSquare;
import com.JavaProject2020.squares.InnSquare;
import com.JavaProject2020.squares.LabyrinthSquare;
import com.JavaProject2020.squares.PrisonSquare;
import com.JavaProject2020.squares.RegularSquare;
import com.JavaProject2020.squares.Square;
import com.JavaProject2020.squares.WellSquare;

public class Board {

    public ArrayList<Square> squares;

    public Board() {
        this.squares = new ArrayList<Square>();

        addSquare(0, "Regular");
        addSquare(1, "Regular");
        addSquare(2, "Regular");
        addSquare(3, "Regular");
        addSquare(4, "Regular");
        addSquare(5, "Goose");
        addSquare(6, "Bridge");
        addSquare(7, "Regular");
        addSquare(8, "Regular");
        addSquare(9, "Goose");
        addSquare(10, "Regular");
        addSquare(11, "Regular");
        addSquare(12, "Regular");
        addSquare(13, "Regular");
        addSquare(14, "Goose");
        addSquare(15, "Regular");
        addSquare(16, "Regular");
        addSquare(17, "Regular");
        addSquare(18, "Goose");
        addSquare(19, "Inn");
        addSquare(20, "Regular");
        addSquare(21, "Regular");
        addSquare(22, "Regular");
        addSquare(23, "Goose");
        addSquare(24, "Regular");
        addSquare(25, "Regular");
        addSquare(26, "Regular");
        addSquare(27, "Goose");
        addSquare(28, "Regular");
        addSquare(29, "Regular");
        addSquare(30, "Regular");
        addSquare(31, "Well");
        addSquare(32, "Goose");
        addSquare(33, "Regular");
        addSquare(34, "Regular");
        addSquare(35, "Regular");
        addSquare(36, "Goose");
        addSquare(37, "Regular");
        addSquare(38, "Regular");
        addSquare(39, "Regular");
        addSquare(40, "Regular");
        addSquare(41, "Goose");
        addSquare(42, "Labyrinth");
        addSquare(43, "Regular");
        addSquare(44, "Regular");
        addSquare(45, "Goose");
        addSquare(46, "Regular");
        addSquare(47, "Regular");
        addSquare(48, "Regular");
        addSquare(49, "Regular");
        addSquare(50, "Goose");
        addSquare(51, "Regular");
        addSquare(52, "Prison");
        addSquare(53, "Regular");
        addSquare(54, "Goose");
        addSquare(55, "Regular");
        addSquare(56, "Regular");
        addSquare(57, "Regular");
        addSquare(58, "Death");
        addSquare(59, "Goose");
        addSquare(60, "Regular");
        addSquare(61, "Regular");
        addSquare(62, "Regular");
        addSquare(63, "Regular");
    }

    private void addSquare(int squareNumber, String squareType) {
        if (squareType.equals("Regular")) {
            squares.add(new RegularSquare(squareNumber, this));
        }
        else if (squareType.equals("Goose")) {
            squares.add(new GooseSquare(squareNumber, this));
        }
        else if (squareType.equals("Bridge")) {
            squares.add(new BridgeSquare(squareNumber, this, 12));
        }
        else if (squareType.equals("Inn")) {
            squares.add(new InnSquare(squareNumber, this, 2));
        }
        else if (squareType.equals("Well")) {
            squares.add(new WellSquare(squareNumber, this));
        }
        else if (squareType.equals("Labyrinth")) {
            squares.add(new LabyrinthSquare(squareNumber, this, 30));
        }
        else if (squareType.equals("Prison")) {
            squares.add(new PrisonSquare(squareNumber, this));
        }
        else if (squareType.equals("Death")) {
            squares.add(new DeathSquare(squareNumber, this, 1));
        }
        else {
            System.out.println("Wrong Square Type!");
        }
    }

    public Square getSquare(int square) {
        return squares.get(square);
    }
}
