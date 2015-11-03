package com.bowling.game;

public class BonusManager {
	/**
	 * bonus in next roll and following one
	 */
	private short[] bonus = new short[] {1,1};
	private byte nextRollIndex = 0;
	private boolean bonusRoll = false;
	private RoundManager roundManager = new RoundManager();
	
	public void rememberBonusForStrike() {
		roundManager.finshRoundAfterThrowAStrike();
		if(!roundManager.isLastRound()) {
			// bonus in the next roll
			bonus[nextRollIndex]++;
			// bonus in following one
			bonus[nextRollIndex == 1 ? 0 : 1]++;
		}
		else {
			bonusRoll = true;
		}
	}
	
	public void rememberBonusForSpare() {
		// bonus in the next roll
		if(!roundManager.isLastRound()) {
			bonus[nextRollIndex]++;
		}
		else {
			bonusRoll = true;
		}
	}
	
	public short getBonusForRound() {
		short bonusResult = bonus[nextRollIndex];
		return bonusResult;
	}
	
	public void nextRoll() {
		bonus[nextRollIndex] = 1;
		nextRollIndex = (byte) ((nextRollIndex == 1) ? 0 : 1);
		roundManager.nextRoll();
	}

	public boolean isEndOfRound() {
		return roundManager.isEndOfRound();
	}
	
	public boolean isEndOfGame() {
		return !bonusRoll && roundManager.rollsWithoutBonusAThrow()
				|| bonusRoll && roundManager.rollsWithBonusAThrow();
	}
}
