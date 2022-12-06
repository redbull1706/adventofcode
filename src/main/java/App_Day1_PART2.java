package main.java;

import java.io.IOException;
import java.util.Iterator;

public class App_Day1_PART2 extends Application{
	
	
	String getFileName()   {
		return "input_day_1.txt";
	}
	
	public String run() throws IOException{
		
		Iterator<String> iterator = getIterator(getFileName());
		int firstMostCal = 0;
		int secondMostCal = 0;
		int thirdMostCal = 0;
		int currentElveCal = 0;
		while (iterator.hasNext()) {
			try {
				currentElveCal += Integer.parseInt(iterator.next());
			}catch(NumberFormatException nfe) {
				if(firstMostCal<currentElveCal) {
					thirdMostCal = secondMostCal;
					secondMostCal = firstMostCal;
					firstMostCal = currentElveCal;
				}else if(secondMostCal < currentElveCal) {
					thirdMostCal = secondMostCal;
					secondMostCal = currentElveCal;
				}else if(thirdMostCal < currentElveCal) {
					thirdMostCal = currentElveCal;
				}
				currentElveCal = 0;
			}
		}
		return "in total: " + (  firstMostCal + secondMostCal + thirdMostCal);
	}

}
