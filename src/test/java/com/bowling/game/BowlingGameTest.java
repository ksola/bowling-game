package com.bowling.game;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class BowlingGameTest {

	@Test
	public void shouldScoreEqual5When5IsRoll() {
		// given
		BowlingGame bowlingGame = new BowlingGame();

		// when
		bowlingGame.roll(5);

		// then
		Assertions.assertThat(bowlingGame.score()).isEqualTo(5);
	}

	@Test
	public void shouldScoreEqual10WhenDoubleRoll5() {
		// given
		BowlingGame bowlingGame = new BowlingGame();

		// when
		bowlingGame.roll(5);
		bowlingGame.roll(5);

		// then
		assertThat(bowlingGame.score()).isEqualTo(10);
	}

	@Test
	public void shouldScoreEqual15WhenThreeTimeRoll5() {
		// given
		BowlingGame bowlingGame = new BowlingGame();

		// when
		bowlingGame.roll(5);
		bowlingGame.roll(5);
		bowlingGame.roll(5);

		// then
		assertThat(bowlingGame.score()).isEqualTo(20);
	}

	@Test
	public void shouldScoreEqual26AfterScoreAnd5And3() {
		// given
		BowlingGame bowlingGame = new BowlingGame();

		// when
		bowlingGame.roll(10);
		bowlingGame.roll(5);
		bowlingGame.roll(3);

		// then
		assertThat(bowlingGame.score()).isEqualTo(26);
	}

	@Test
	public void shouldScoreEqual35After6Roll5Pins() {
		// given
		BowlingGame bowlingGame = new BowlingGame();

		// when
		for (int i = 0; i < 6; i++) {
			bowlingGame.roll(5);
		}

		// then
		assertThat(bowlingGame.score()).isEqualTo(40);
	}

	@Test
	public void shouldScoreEqual73After3StriksAn5And3() {
		// given
		BowlingGame bowlingGame = new BowlingGame();

		// when
		for (int i = 0; i < 3; i++) {
			bowlingGame.roll(10);
		}
		bowlingGame.roll(5);
		bowlingGame.roll(3);

		// then
		assertThat(bowlingGame.score()).isEqualTo(81);
	}

	@Test
	public void shouldScoreEqual280After11Strikes() {
		// given
		BowlingGame bowlingGame = new BowlingGame();

		// when
		for (int i = 0; i < 11; i++) {
			bowlingGame.roll(10);
		}

		// then
		assertThat(bowlingGame.score()).isEqualTo(290);
	}

	@Test
	public void shouldScoreEqual68AfterStrikeAndSpare() {
		// given
		BowlingGame bowlingGame = new BowlingGame();

		// when
		bowlingGame.roll(10);
		bowlingGame.roll(9);
		bowlingGame.roll(1);
		bowlingGame.roll(10);
		bowlingGame.roll(8);
		bowlingGame.roll(1);

		// then
		assertThat(bowlingGame.score()).isEqualTo(68);
	}

	@Test
	public void shouldScoreEqual160WhenNoStrikeAndSpareThrown() {
		// given
		BowlingGame bowlingGame = new BowlingGame();

		// when
		for (int i = 0; i < 10; i++) {
			bowlingGame.roll(5);
			bowlingGame.roll(3);
		}

		// then
		assertThat(bowlingGame.score()).isEqualTo(80);
	}

	@Test
	public void shouldScoreEqual300When12StrikesAreThrown() {
		// given
		BowlingGame bowlingGame = new BowlingGame();

		// when
		for (int i = 0; i < 12; i++) {
			bowlingGame.roll(10);
		}

		// then
		assertThat(bowlingGame.score()).isEqualTo(300);
	}

	@Test
	public void shouldScoreEqual289When9StrikesAndSpareAndBounusRollIsThrown() {
		// given
		BowlingGame bowlingGame = new BowlingGame();

		// when
		for (int i = 0; i < 9; i++) {
			bowlingGame.roll(10);
		}
		bowlingGame.roll(8);
		bowlingGame.roll(2);
		bowlingGame.roll(8);

		// then
		assertThat(bowlingGame.score()).isEqualTo(276);
	}

	@Test
	public void shouldScoreEqual187After5StrikesAnd4Spares() {
		// given
		BowlingGame bowlingGame = new BowlingGame();

		// when
		bowlingGame.roll(10);

		bowlingGame.roll(9);
		bowlingGame.roll(1);

		bowlingGame.roll(5);
		bowlingGame.roll(5);

		bowlingGame.roll(7);
		bowlingGame.roll(2);

		bowlingGame.roll(10);

		bowlingGame.roll(10);

		bowlingGame.roll(10);

		bowlingGame.roll(9);
		bowlingGame.roll(0);

		bowlingGame.roll(8);
		bowlingGame.roll(2);

		bowlingGame.roll(9);
		bowlingGame.roll(1);

		bowlingGame.roll(10);

		// then
		assertThat(bowlingGame.score()).isEqualTo(187);
	}

	@Test
	public void shouldScoreEqual150When10SparesAreThrowAndLast5() {
		// given
		BowlingGame bowlingGame = new BowlingGame();
		
		// when
		for (int i = 0; i < 21; i++) {
			bowlingGame.roll(5);
		}

		// then
		assertThat(bowlingGame.score()).isEqualTo(150);
	}

	@Test
	public void shouldScoreEqual289When10StrikesAreAndLastSpareThrown() {
		// given
		BowlingGame bowlingGame = new BowlingGame();

		// when
		for (int i = 0; i < 10; i++) {
			bowlingGame.roll(10);
		}
		bowlingGame.roll(9);
		bowlingGame.roll(1);

		// then
		assertThat(bowlingGame.score()).isEqualTo(289);
	}

	@Test
	public void shouldBowlingGameBeFinishedAfter20RollsWithoutStirkeAndSpare() {
		// given
		BowlingGame bowlingGame = new BowlingGame();

		// when
		for (int i = 0; i < 10; i++) {
			bowlingGame.roll(5);
			bowlingGame.roll(3);
		}

		// then
		assertThat(bowlingGame.isFinished()).isTrue();
	}

	@Test
	public void shouldBowlingGameBeNotFinishedAfter12Rolls() {
		// given
		BowlingGame bowlingGame = new BowlingGame();

		// when
		for (int i = 0; i < 12; i++) {
			bowlingGame.roll(5);
		}

		// then
		assertThat(bowlingGame.isFinished()).isFalse();
	}
	
	@Test
	public void shouldBowlingGameBeFinishedAfter12RollsWithAllStirkes() {
		// given
		BowlingGame bowlingGame = new BowlingGame();

		// when
		for (int i = 0; i < 12; i++) {
			bowlingGame.roll(10);
		}

		// then
		assertThat(bowlingGame.isFinished()).isTrue();
	}

	@Test
	public void shouldBowlingGameBeNotFinishedAfter20RollsWithLastStirke() {
		// given
		BowlingGame bowlingGame = new BowlingGame();

		// when
		for (int i = 0; i < 9; i++) {
			bowlingGame.roll(5);
			bowlingGame.roll(3);
		}
		bowlingGame.roll(10);

		// then
		assertThat(bowlingGame.isFinished()).isFalse();
	}
	
	@Test
	public void shouldBowlingGameBeNotFinishedAfter20RollsWithLastStirkeAndOneRoll() {
		// given
		BowlingGame bowlingGame = new BowlingGame();
		
		// when
		for (int i = 0; i < 9; i++) {
			bowlingGame.roll(5);
			bowlingGame.roll(3);
		}
		bowlingGame.roll(10);
		bowlingGame.roll(7);
		
		// then
		assertThat(bowlingGame.isFinished()).isFalse();
	}
	
	@Test
	public void shouldBowlingGameBeFinishedAfter20RollsWithLastStirkeAnd2Rolls() {
		// given
		BowlingGame bowlingGame = new BowlingGame();
		
		// when
		for (int i = 0; i < 9; i++) {
			bowlingGame.roll(5);
			bowlingGame.roll(3);
		}
		bowlingGame.roll(10);
		bowlingGame.roll(7);
		bowlingGame.roll(2);
		
		// then
		assertThat(bowlingGame.isFinished()).isTrue();
	}

	@Test
	public void shouldBowlingGameBeNotFinishedAfter20RollsWithLastSpare() {
		// given
		BowlingGame bowlingGame = new BowlingGame();

		// when
		for (int i = 0; i < 9; i++) {
			bowlingGame.roll(5);
			bowlingGame.roll(3);
		}
		bowlingGame.roll(9);
		bowlingGame.roll(1);

		// then
		assertThat(bowlingGame.isFinished()).isFalse();
	}

}
