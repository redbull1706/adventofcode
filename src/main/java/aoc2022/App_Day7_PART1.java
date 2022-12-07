package aoc2022;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class App_Day7_PART1 extends Application{
	
	
	public String run() throws IOException{
		Iterator<String> iterator = getIterator(Day.SEVEN);
		MyFile root = new MyFile("root", null);
		Commander commander = new Commander(root);
		commander.addRoot(root);
		while(iterator.hasNext()) {
			String line = iterator.next();
			Command cmd = Command.getByInput(line);
			//System.out.println(cmd.name()+"  "+line);
			cmd.execute(commander, line);
		}
		double sum = 0;
		for (Map.Entry<String,MyFile> entry : commander.getDirectoryTree().entrySet()) {
			double size = entry.getValue().getSize(0);
			System.out.println(entry.getKey()+"  "+ size);
			if(size<100000) {
				sum+=size;
			}
		}
		return "The total amount of space of directories under 100000 is "+sum;
	}
}
