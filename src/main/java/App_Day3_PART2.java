package main.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class App_Day3_PART2 extends Application{
	
	
	
	public String run() throws IOException {
		
		Iterator<String> iterator = getIterator(DAY.THREE);
		List<String> found = new ArrayList<>();
		while (iterator.hasNext()) {
			String line1 = iterator.next();
			String line2 = iterator.next();
			String line3 = iterator.next();
			
			found.add(findCommon(line1, line2,line3));
		}
		int priorities = 0;
		int counter =0;
		for (Iterator<String> founditerator = found.iterator(); founditerator.hasNext();) {
			String string = founditerator.next();
			try {
				priorities+= (Item.valueOf(string).ordinal()+1);
			}catch(IllegalArgumentException iae) {
				return "nothing found for line "+ counter;
			}
			counter++;
		}
		return "result: "+ priorities;
	}


	private static String findCommon(String compartment1, String compartment2, String compartment3) {
		for (int i = 0; i<compartment1.length(); i++) {
			String toFind = compartment1.substring(i, i+1);
			if(compartment2.indexOf(toFind)>=0&&compartment3.indexOf(toFind)>=0){
				return toFind;
			}
		}
		return "";
	}
	
}
