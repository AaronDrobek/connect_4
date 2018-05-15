package com.drobek.practice;


public class Board {
    private final int MAXROW = 7;
    private final int MAXCOL = 7;
    private Target[][] gameBoard = new Target[MAXROW][MAXCOL];
    private boolean hasWon = false;

    public boolean isHasWon() {
        return hasWon;
    }

    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }

    public void buildBoard() {
        for (int row = 0; row < gameBoard.length; row++) {

            for (int col = 0; col < gameBoard[row].length; col++) {
                Target target = new Target();
                target.setDisplayIcon("--");
                target.setOccupied(false);
                gameBoard[row][col] = target;
            }
        }

    }

    public void printBoard() {
        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard[row].length; col++) {
                Target target = gameBoard[row][col];
                System.out.print(target.getDisplayIcon() + "\t");
            }
            System.out.println();
        }
    }

    public void computerMove() {
        int computerCol = (int) (Math.random() * 6);
        for (int row = 6; row >= 0; row--) {
            if (!gameBoard[row][computerCol].isOccupied()) {
                gameBoard[row][computerCol].setDisplayIcon("O");
                gameBoard[row][computerCol].setOccupied(true);
                checkWin(row, computerCol, "O");
                break;
            }
        }
    }

    public void userMove() {
        int userCol = Main.reader.nextInt();
        userCol = userCol -1;
        for (int row = 6; row >= 0; row--) {
            if (!gameBoard[row][userCol].isOccupied()) {
                gameBoard[row][userCol].setDisplayIcon("X");
                gameBoard[row][userCol].setOccupied(true);
                checkWin(row, userCol, "X");
                break;
            }
        }

    }

    public void checkWin(int row, int col, String whoMoves) {


        int iconCounter = 0;


        for (int loopCol = 0; loopCol <= 6; loopCol++) {
            if (gameBoard[row][loopCol].getDisplayIcon().equals(whoMoves)) {
                iconCounter++;
            } else {
                iconCounter = 0;

            }
        }
        if (iconCounter >= 4) {
            setHasWon(true);
            System.out.println("Player "+whoMoves + " You won!");
        }


        for (int loopRow = 0; loopRow <= 6; loopRow++) {
            if (gameBoard[loopRow][col].getDisplayIcon().equals(whoMoves)) {
                iconCounter++;
            } else {
                iconCounter = 0;

            }
        }
        if (iconCounter >= 4) {
            setHasWon(true);
            System.out.println("Player "+whoMoves + " You won!");
        }

    }


}
