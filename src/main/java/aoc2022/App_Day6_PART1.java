package aoc2022;

import java.io.IOException;
import java.util.Iterator;

public class App_Day6_PART1 extends Application{
	
	
	public String run() throws IOException{
		
		Iterator<String> iterator = getIterator(Day.SIX);
		String code = "";
		while (iterator.hasNext()) {
			String line = iterator.next();
			for(int i = 0;i<line.length()-3;i++) {
				code = line.substring(i,i+4);
				if(code.chars().distinct().count()==4) {
					return "the code is "+ code +" and the marker is on "+(i+4);
				}
			}
		}
		return "no result";
	}
}
