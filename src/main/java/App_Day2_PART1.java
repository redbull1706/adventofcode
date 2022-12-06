package main.java;

import java.io.IOException;
import java.util.Iterator;

public class App_Day2_PART1 extends Application{
	
	
	
	String getFileName()    {
		return "input_day_2.txt";
	}
	
	public String run() throws IOException {
		
		Iterator<String> iterator = getIterator(getFileName());
		int points = 0;
		while (iterator.hasNext()) {
			String line = iterator.next();
			Sign opponent = Sign.getByOpponent(line.substring(0,1));
			Sign self = Sign.getBySelf(line.substring(2));
			Score score = getScore(opponent, self);
			int roundPoints = self.getPoints() + score.getPoints(); 
			points +=  roundPoints;
		}
		return points +" in total";
	}
	
	public static Score getScore(Sign opponent, Sign self) {
		if(opponent == self) {
			return Score.DRAW;
		}else if(opponent == Sign.ROCK && self == Sign.PAPER || opponent == Sign.PAPER && self==Sign.SCISSORS || opponent == Sign.SCISSORS && self== Sign.ROCK ) {
			return Score.WIN;
		}
		return Score.LOST;
	}
	
}
