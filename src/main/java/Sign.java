package main.java;

import java.util.stream.Stream;

public enum Sign {

	ROCK("A","X",1),
	PAPER("B","Y",2),
	SCISSORS("C","Z",3);

	private final String opponent;	
	private final String self;
	private final int points;
	Sign(String opponent, String self, int points) {
		this.opponent = opponent;
		this.self = self;
		this.points = points;
	}
	
	public String getOpponent() {
		return opponent;
	}
	
	public String getSelf() {
		return self;
	}
	
	public int getPoints() {
		return points;
	}
	
	public static Sign getByOpponent(String toGet) {
		return Stream.of(values()).filter(v->v.getOpponent().equals(toGet)).findFirst().get();
		
	}
	public static Sign getBySelf(String toGet) {
		return Stream.of(values()).filter(v->v.getSelf().equals(toGet)).findFirst().get();
	}
	
	
}
