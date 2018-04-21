package com.training.cleancode.e06;

@SuppressWarnings("WeakerAccess")
public class Game {

    private final int[] rolls = new int[21];
    private int currentTurn;

    public void roll(int pins) {
        rolls[currentTurn++] = pins;
    }

    public int score() {
        return calculateScore();
    }

    private int calculateScore() {
        int score = 0;
        int firstBallInFrame = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(firstBallInFrame)) {
                score += 10 + calculateBonusOfStrike(firstBallInFrame);
                firstBallInFrame++;
            } else {
                if (isSpare(firstBallInFrame))
                    score += calculateBonusOfSpare(firstBallInFrame);
                score += rolls[firstBallInFrame] + rolls[firstBallInFrame + 1];
                firstBallInFrame += 2;
            }
        }
        return score;
    }

    private boolean isStrike(int firstBallInFrame) {
        return rolls[firstBallInFrame] == 10;
    }

    private int calculateBonusOfStrike(int firstBallInFrame) {
        return rolls[firstBallInFrame + 1] + rolls[firstBallInFrame + 2];
    }

    private boolean isSpare(int firstBallInFrame) {
        return rolls[firstBallInFrame] + rolls[firstBallInFrame + 1] == 10;
    }

    private int calculateBonusOfSpare(int firstBallInFrame) {
        return rolls[firstBallInFrame + 2];
    }

}
