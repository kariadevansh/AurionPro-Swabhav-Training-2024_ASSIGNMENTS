package com.apro.assignment.model;

import java.util.Scanner;

public class TicTacToeFacade {
    private GameLogic gameLogic;
    private Scanner scanner;

    public TicTacToeFacade() {
        scanner = new Scanner(System.in);
        System.out.println("Enter the Grid size (to create a square matrix): ");
        int size = scanner.nextInt();
        if(size<3) {
        	System.out.println("Enter a size equal to or greater than 3! :");
        	size = scanner.nextInt();
        }
        gameLogic = new GameLogic(size); 
    }

    public TicTacToeFacade(int size) {
        scanner = new Scanner(System.in);
        gameLogic = new GameLogic(size);
    }

    // Constructor for testing
    public TicTacToeFacade(GameLogic gameLogic, Scanner scanner) {
        this.gameLogic = gameLogic;
        this.scanner = scanner;
    }

    public void startGame() {
        boolean gameEnded = false;
        while (!gameEnded) {
            gameLogic.printBoard();
            System.out.println("Player " + gameLogic.getCurrentPlayer() 
            + ", enter row and column (1 - " + gameLogic.getSize() + "):");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            // Debugging statements
            System.out.println("Received input: row = " + row + ", col = " + col);

            // Validate inputs
            if (row < 1 || row > gameLogic.getSize() || col < 1 || col > gameLogic.getSize()) {
                System.out.println("Invalid input. Please enter values between 1 and " + gameLogic.getSize());
                continue;
            }

            // Adjust for 0-based index
            gameEnded = gameLogic.makeMove(row - 1, col - 1);

            // Debugging statements
            System.out.println("Game ended status: " + gameEnded);
            System.out.println("Current Player after move: " + gameLogic.getCurrentPlayer());
        }
        gameLogic.printBoard();
    }
}
