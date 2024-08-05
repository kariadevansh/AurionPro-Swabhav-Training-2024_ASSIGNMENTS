package com.apro.model;

import java.util.Scanner;

public class TicTacToeFacade {
    private GameLogic gameLogic;
    private Scanner scanner;

    public TicTacToeFacade() {
        scanner = new Scanner(System.in);
        System.out.println("Enter the Grid size (to create a square matrix): ");
        int size = scanner.nextInt();
        gameLogic = new GameLogic(size); // Initialize with the given size
    }

    public void startGame() {
        boolean gameEnded = false;
        while (!gameEnded) {
            gameLogic.printBoard();
            System.out.println("Player " + gameLogic.getCurrentPlayer() 
            + ", enter row and column (0 - "+(gameLogic.getSize()-1)+"):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            gameEnded = gameLogic.makeMove(row, col);
        }
        gameLogic.printBoard();
    }

    public static void main(String[] args) {
        TicTacToeFacade facade = new TicTacToeFacade();
        facade.startGame();
    }
}
