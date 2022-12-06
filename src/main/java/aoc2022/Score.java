package aoc2022;

import java.util.stream.Stream;

public enum Score {
	LOST(0,"X"),
	DRAW(3,"Y"),
	WIN(6,"Z");

	private int points;
	private String givenResult;
	Score(int points, String givenResult) {
		this.points = points;
		this.givenResult = givenResult;
	}
	
	public int getPoints() {
		return points;
	}
	
	public String getGivenResult() {
		return givenResult;
	}
	
	public static Score getByResultString(String result) {
		return Stream.of(values()).filter(v->v.getGivenResult().equals(result)).findFirst().get();
	}
}
