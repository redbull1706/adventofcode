package main.java;

import java.io.IOException;
import java.util.Iterator;

public class App_Day4_PART2 extends Application{
	
	
	public String getFileName() {
		return "input_day_4.txt";
	}
	
	public String run() throws IOException{
		
		Iterator<String> iterator = getIterator(getFileName());
		int counter = 0;
		while (iterator.hasNext()) {
			String line = iterator.next();
			String section1 = line.split(",")[0];
			String section2 = line.split(",")[1];
			if(checkOverlap(section1,section2)) {
				counter++;
			}
		}
		return "result: "+ counter;
	}

	private static boolean checkOverlap(String section1, String section2) {
		int section1start = Integer.valueOf(section1.split("-")[0]);
		int section1end = Integer.valueOf(section1.split("-")[1]);
		int section2start = Integer.valueOf(section2.split("-")[0]);
		int section2end = Integer.valueOf(section2.split("-")[1]);
		return checkInRange(section1start, section1end, section2end) ||
				checkInRange(section1start, section1end, section2start) ||
				checkInRange(section2start, section2end, section1start) ||
				checkInRange(section2start, section2end, section1end);
	}
	
	private static boolean checkInRange(int rangeStart, int rangeEnd, int tocheck) {
		return tocheck>=rangeStart && tocheck<=rangeEnd;
	}

}
