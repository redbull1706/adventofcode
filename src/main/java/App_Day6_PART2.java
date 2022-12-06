package main.java;

import java.io.IOException;
import java.util.Iterator;

public class App_Day6_PART2  extends Application{
	
	
	public String getFileName() {
		return "input_day_6.txt";
	}
	
	public String run() throws IOException {
		
		Iterator<String> itr = getIterator(getFileName());
		String code = "";
		while (itr.hasNext()) {
			String line = itr.next();
			for(int i = 0;i<line.length()-13;i++) {
				code = line.substring(i,i+14);
				if(code.chars().distinct().count()==14) {
					return "the code is "+ code +" and the marker is on "+(i+14);
				}
			}
		}
		return "no result";
	}
}
