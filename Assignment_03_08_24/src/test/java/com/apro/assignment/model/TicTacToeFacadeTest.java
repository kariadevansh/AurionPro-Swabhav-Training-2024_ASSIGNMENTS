package com.apro.assignment.model;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TicTacToeFacadeTest {

    private TicTacToeFacade facade;

    @BeforeEach
    void setUp() {
        // Inject mock input for testing
        String input = "3\n1 1\n2 2\n1 2\n3 3\n2 1\n1 3\n3 2\n2 3\n3 1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        GameLogic gameLogic = new GameLogic(3);
        facade = new TicTacToeFacade(gameLogic, scanner);
    }

    @Test
    void testStartGame() {
        facade.startGame();
    }
}
