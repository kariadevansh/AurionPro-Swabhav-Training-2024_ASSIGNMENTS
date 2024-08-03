package com.apro.assignment.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameBoardTest {
    private GameBoard board;

    @BeforeEach
    void setUp() {
        board = new GameBoard(3); // Initialize a 3x3 board for testing
    }

    @Test
    void testInitialization() {
        char[][] boardState = board.getBoard();
        assertNotNull(boardState);
        assertEquals(3, board.getSize());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(' ', boardState[i][j]);
            }
        }
    }

    @Test
    void testMakeMoveValid() {
        assertTrue(board.makeMove(0, 0, 'X'));
        assertEquals('X', board.getBoard()[0][0]);
    }

    @Test
    void testMakeMoveInvalid() {
        board.makeMove(0, 0, 'X');
        assertFalse(board.makeMove(0, 0, 'O')); // Cell already occupied
        assertFalse(board.makeMove(-1, -1, 'X')); // Out of bounds
        assertFalse(board.makeMove(3, 3, 'X')); // Out of bounds
    }

    @Test
    void testCheckWinHorizontal() {
        board.makeMove(0, 0, 'X');
        board.makeMove(0, 1, 'X');
        board.makeMove(0, 2, 'X');
        assertTrue(board.checkWin('X'));
    }

    @Test
    void testCheckWinVertical() {
        board.makeMove(0, 0, 'O');
        board.makeMove(1, 0, 'O');
        board.makeMove(2, 0, 'O');
        assertTrue(board.checkWin('O'));
    }

    @Test
    void testCheckWinMainDiagonal() {
        board.makeMove(0, 0, 'X');
        board.makeMove(1, 1, 'X');
        board.makeMove(2, 2, 'X');
        assertTrue(board.checkWin('X'));
    }

    @Test
    void testCheckWinAntiDiagonal() {
        board.makeMove(0, 2, 'O');
        board.makeMove(1, 1, 'O');
        board.makeMove(2, 0, 'O');
        assertTrue(board.checkWin('O'));
    }

    @Test
    void testIsBoardFull() {
        // Fill the board completely with no winner
        board.makeMove(0, 0, 'X');
        board.makeMove(0, 1, 'O');
        board.makeMove(0, 2, 'X');
        board.makeMove(1, 0, 'O');
        board.makeMove(1, 1, 'X');
        board.makeMove(1, 2, 'O');
        board.makeMove(2, 0, 'X');
        board.makeMove(2, 1, 'O');
        board.makeMove(2, 2, 'X');
        assertTrue(board.isBoardFull());
    }

    @Test
    void testIsBoardNotFull() {
        board.makeMove(0, 0, 'X');
        assertFalse(board.isBoardFull()); // Board is not full
    }
}
