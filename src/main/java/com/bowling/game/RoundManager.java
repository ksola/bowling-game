package com.bowling.game;

public class RoundManager {

	private int rolls;
	
	public void nextRoll() {
		rolls++;
	}
	
	public void finshRoundAfterThrowAStrike() {
		rolls++;
	}
	
	public boolean isEndOfRound() {
		return rolls % 2 == 0;
	}
	
	public boolean isLastRound() {
		return rolls > 18;
	}
	
	public boolean rollsWithoutBonusAThrow() {
		return rolls == 20;
	}
	
	public boolean rollsWithBonusAThrow() {
		return rolls > 21;
	}
}
