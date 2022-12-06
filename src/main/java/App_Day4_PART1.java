package main.java;

import java.io.IOException;
import java.util.Iterator;

public class App_Day4_PART1 extends Application{
	
	
	public String run() throws IOException{
		
		Iterator<String> iterator = getIterator(Day.FOUR);
		int counter = 0;
		while (iterator.hasNext()) {
			String line = iterator.next();
			String section1 = line.split(",")[0];
			String section2 = line.split(",")[1];
			if(checkFullyContains(section1,section2)) {
				counter++;
			}
		}
		return "result: "+ counter;
	}

	private static boolean checkFullyContains(String section1, String section2) {
		int section1start = Integer.valueOf(section1.split("-")[0]);
		int section1end = Integer.valueOf(section1.split("-")[1]);
		int section2start = Integer.valueOf(section2.split("-")[0]);
		int section2end = Integer.valueOf(section2.split("-")[1]);
		return section1start<=section2start && section1end>=section2end || section2start<=section1start && section2end>=section1end;
	}

}
