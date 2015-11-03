package com.bowling.game;

public class BowlingGame {

	private int score;
	private int scoreInRound;
	private BonusManager bonusManager;

	public BowlingGame() {
		bonusManager = new BonusManager();
	}

	public void roll(int rolledPins) {
		calculateActualScore(rolledPins);
		if (isStrike(rolledPins)) {
			bonusManager.rememberBonusForStrike();
		} else {
			scoreInRound += rolledPins;
		}
		if (isSpare()) {
			bonusManager.rememberBonusForSpare();
		}
		if (bonusManager.isEndOfRound()) {
			scoreInRound = 0;
		}
	}

	public boolean isFinished() {
		return bonusManager.isEndOfGame();
	}

	public int score() {
		return score;
	}

	private boolean isStrike(int i) {
		return i == 10;
	}

	private boolean isSpare() {
		return bonusManager.isEndOfRound() && scoreInRound == 10;
	}

	private void calculateActualScore(int i) {
		score += i * bonusManager.getBonusForRound();
		bonusManager.nextRoll();
	}
}
