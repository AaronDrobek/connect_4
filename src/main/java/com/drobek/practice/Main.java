package com.drobek.practice;

import java.util.Scanner;

public class Main {
    public static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        Board board = new Board();
        board.buildBoard();
        while (!board.isHasWon()) {
            board.computerMove();
            board.printBoard();
            System.out.println("enter your column 1-7");
            board.userMove();
        }
        board.printBoard();
        System.out.println("GAME OVER");
    }
}
