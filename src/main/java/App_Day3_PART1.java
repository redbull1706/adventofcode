package main.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class App_Day3_PART1 extends Application{
	
	
	
	public String run() throws IOException{
		
		Iterator<String> iterator = getIterator(DAY.THREE);
		List<String> found = new ArrayList<>();
		while (iterator.hasNext()) {
			String line = iterator.next();
			String compartment1 = line.substring(0, line.length() / 2);
			String compartment2 = line.substring(line.length() / 2);
			found.add(findCommon(compartment1, compartment2));
		}
		int priorities = 0;
		int counter =0;
		for (Iterator<String> founditerator = found.iterator(); founditerator.hasNext();) {
			String string = founditerator.next();
			try {
				priorities+= (Item.valueOf(string).ordinal()+1);
			}catch(IllegalArgumentException iae) {
				return "nothing found for after counter "+counter;
			}
			counter++;
		}
		return "result: "+ priorities;
	}


	private static String findCommon(String compartment1, String compartment2) {
		for (int i = 0; i<compartment1.length(); i++) {
			String toFind = compartment1.substring(i, i+1);
			if(compartment2.indexOf(toFind)>=0) {
				return toFind;
			}
		}
		return "";
	}
}
