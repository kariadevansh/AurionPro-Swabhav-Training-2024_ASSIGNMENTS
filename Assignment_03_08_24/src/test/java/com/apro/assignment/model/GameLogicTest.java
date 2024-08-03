package com.apro.assignment.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameLogicTest {
    private GameLogic gameLogic;

    @BeforeEach
    void setUp() {
        gameLogic = new GameLogic(4); // Test with a 4x4 grid
    }

    @Test
    void testMakeMoveValid() {
        assertTrue(gameLogic.makeMove(0, 0));
        assertEquals('O', gameLogic.getCurrentPlayer()); // Player should switch
    }

    @Test
    void testMakeMoveInvalid() {
        gameLogic.makeMove(0, 0);
        assertFalse(gameLogic.makeMove(0, 0)); // Cell already occupied
        assertFalse(gameLogic.makeMove(-1, -1)); // Out of bounds
    }

    @Test
    void testWinCondition() {
        gameLogic.makeMove(0, 0);
        gameLogic.makeMove(1, 1);
        gameLogic.makeMove(0, 1);
        gameLogic.makeMove(1, 2);
        gameLogic.makeMove(0, 2); // X wins
        assertTrue(gameLogic.makeMove(0, 2)); // Last move should declare X as winner
    }

    @Test
    void testDrawCondition() {
        gameLogic.makeMove(0, 0);
        gameLogic.makeMove(1, 1);
        gameLogic.makeMove(0, 1);
        gameLogic.makeMove(1, 2);
        gameLogic.makeMove(0, 2);
        gameLogic.makeMove(1, 0);
        gameLogic.makeMove(2, 0);
        gameLogic.makeMove(2, 1);
        assertTrue(gameLogic.makeMove(2, 2)); // The game should declare a draw
    }

    @Test
    void testGetCurrentPlayer() {
        assertEquals('X', gameLogic.getCurrentPlayer());
        gameLogic.makeMove(0, 0);
        assertEquals('O', gameLogic.getCurrentPlayer());
    }

    @Test
    void testGetSize() {
        assertEquals(4, gameLogic.getSize());
    }
}
