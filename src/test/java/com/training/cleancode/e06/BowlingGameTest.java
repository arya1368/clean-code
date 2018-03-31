package com.training.cleancode.e06;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {

    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
    public void allZeroGameTheScoreIsZero() throws Exception {
        rollMany(20, 0);
        assertEquals(0, game.score());
    }

    @Test
    public void allTwoGameTheScoreIsFourteen() throws Exception {
        rollMany(20, 2);
        assertEquals(40, game.score());
    }

    @Test
    public void oneSpareInGame() throws Exception {
        rollSpareInFrame();
        game.roll(3);
        rollMany(17, 0);
        assertEquals(16, game.score());
    }

    @Test
    public void itsNotASpare() throws Exception {
        game.roll(3);
        game.roll(5);
        game.roll(5);
        rollMany(17, 0);
        assertEquals(13, game.score());
    }

    @Test
    public void oneStrikeInGame() throws Exception {
        rollStrikeInFrame();
        game.roll(3);
        game.roll(2);
        rollMany(16, 0);
        assertEquals(20, game.score());
    }

    @Test
    public void perfectGame() throws Exception {
        rollMany(12, 10);
        assertEquals(300, game.score());
    }

    private void rollStrikeInFrame() {
        game.roll(10);
    }

    private void rollSpareInFrame() {
        game.roll(4);
        game.roll(6);
    }

    private void rollMany(int times, int pins) {
        for (int i = 0; i < times; i++)
            game.roll(pins);
    }
}
