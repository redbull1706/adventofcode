package aoc2022;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class App_Day1_PART2 extends Application{
	
	
	public String run() throws IOException{
		
		Iterator<String> iterator = getIterator(Day.ONE);
		int firstMostCal = 0;
		int secondMostCal = 0;
		int thirdMostCal = 0;
		int currentElveCal = 0;
		Set<Integer> set = new TreeSet();
		while (iterator.hasNext()) {
			try {
				currentElveCal += Integer.parseInt(iterator.next());
			}catch(NumberFormatException nfe) {
				set.add(currentElveCal);
				currentElveCal = 0;
			}
		}
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
		set.size();
		System.out.println( firstMostCal+"  " + secondMostCal+"  " + thirdMostCal);
		return "in total: " + (  firstMostCal + secondMostCal + thirdMostCal);
	}

}
