package main.java;

import java.io.IOException;
import java.util.Iterator;

public class App_Day2_PART2 extends Application{
	
	public String run() throws IOException {
		
		Iterator<String> iterator = getIterator(DAY.TWO);
		int points = 0;
		while (iterator.hasNext()) {
			String line = iterator.next();
			Sign opponent = Sign.getByOpponent(line.substring(0,1));
			Score score = Score.getByResultString(line.substring(2));
			Sign self = getSignByResultAndOpponent(score, opponent);
			int roundPoints = self.getPoints() + score.getPoints(); 
			points +=  roundPoints;
		}
		return points +" in total";
	}

	
	public static Sign getSignByResultAndOpponent(Score result, Sign opponent) {
		if(result==Score.DRAW) {
			return opponent;
		}else if(result==Score.WIN) {
			if(opponent == Sign.ROCK) {return Sign.PAPER;
			}else if(opponent == Sign.PAPER) {return Sign.SCISSORS;
			}return Sign.ROCK;
		}else if(opponent == Sign.ROCK) {return Sign.SCISSORS;
		}else if(opponent == Sign.PAPER) {return Sign.ROCK;
		}
		return Sign.PAPER;
	}
	
}
