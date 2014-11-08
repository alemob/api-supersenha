package br.com.alexmob.api.supersenha.entity;

import java.math.BigDecimal;

/**
 * Created by alexandre on 08/11/14.
 */
public class GuessResult {

	private final double seconds;
	private final Reason reason;
	private final double averageGuesses;

	public GuessResult (double averageGuesses, double seconds, Reason reason){
		this.seconds = seconds;
		this.reason = reason;
		this.averageGuesses = averageGuesses;
	}

	public double getSeconds () {
		return seconds;
	}

	public Reason getReason () {
		return reason;
	}

	public double getAverageGuesses () {
		return averageGuesses;
	}
}
