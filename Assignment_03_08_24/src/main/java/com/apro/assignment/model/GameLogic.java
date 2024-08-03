package com.apro.assignment.model;

public class GameLogic {
    private GameBoard board;
    private char currentPlayer;

    public GameLogic(int size) {
        board = new GameBoard(size);
        currentPlayer = 'X'; // X always starts
    }

    public int getSize() {
        return board.getSize();
    }

    public boolean makeMove(int row, int col) {
        if (board.makeMove(row, col, currentPlayer)) {
            System.out.println("Move made by player: " + currentPlayer + " at (" + row + ", " + col + ")");
            if (board.checkWin(currentPlayer)) {
                System.out.println("Player " + currentPlayer + " wins!");
                return true;
            }
            if (board.isBoardFull()) {
                System.out.println("The game is a draw!");
                return true;
            }
            // Switch player
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            return false;
        } else {
            System.out.println("Invalid move by player: " + currentPlayer + " at (" + row + ", " + col + ")");
            return false;
        }
    }

    public void printBoard() {
        board.printBoard();
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }
}
