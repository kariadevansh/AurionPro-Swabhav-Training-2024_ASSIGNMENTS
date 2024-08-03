package com.apro.assignment.model;


public class GameBoard {
    private char[][] board;
    private int size;

    public GameBoard(int size) {
        this.size = size;
        board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public int getSize() {
        return this.size;
    }

    public char[][] getBoard() {
        return board;
    }
    
    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j]);
                if (j < size - 1) System.out.print(" | ");
            }
            System.out.println();
            if (i < size - 1) {
                for (int k = 0; k < size; k++) {
                    System.out.print("--");
                    if (k < size - 1) System.out.print("--");
                }
                System.out.println();
            }
        }
    }

    public boolean makeMove(int row, int col, char player) {
        if (row >= 0 && row < size && col >= 0 && col < size && board[row][col] == ' ') {
            board[row][col] = player;
            return true;
        }
        return false;
    }

    public boolean checkWin(char player) {
        // Check rows and columns
        for (int i = 0; i < size; i++) {
            boolean rowWin = true;
            boolean colWin = true;
            for (int j = 0; j < size; j++) {
                if (board[i][j] != player) rowWin = false;
                if (board[j][i] != player) colWin = false;
            }
            if (rowWin || colWin) return true;
        }
        
        // Check diagonals
        boolean mainDiagonalWin = true;
        boolean antiDiagonalWin = true;
        for (int i = 0; i < size; i++) {
            if (board[i][i] != player) mainDiagonalWin = false;
            if (board[i][size - 1 - i] != player) antiDiagonalWin = false;
        }
        return mainDiagonalWin || antiDiagonalWin;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
