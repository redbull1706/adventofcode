package main.java;

import java.io.IOException;
import java.util.Iterator;

public class App_Day1_PART1 extends Application{
	
	
	 String getFileName()   {
		return "input_day_1.txt";
	}
	
	public String run() throws IOException{
		Iterator<String> iterator = getIterator(getFileName());
		int maxCal = 0;
		int currentElveCal = 0;
		while (iterator.hasNext()) {
			try {
				currentElveCal += Integer.parseInt(iterator.next());
			}catch(NumberFormatException nfe) {
				if(maxCal<currentElveCal) {
					maxCal = currentElveCal;
				}
				currentElveCal = 0;
			}
		}
		return maxCal +" is the solution ";
	}

}
