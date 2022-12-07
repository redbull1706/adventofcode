package aoc2022;

import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App_Day7_PART2 extends Application{
	
	
	private static final String ROOT = "root";

	public String run() throws IOException{
		
		Iterator<String> iterator = getIterator(Day.SEVEN);
		MyFile root = new MyFile(ROOT, null);
		Commander commander = new Commander(root);
		commander.addRoot(root);
		while(iterator.hasNext()) {
			String line = iterator.next();
			Command cmd = Command.getByInput(line);
			cmd.execute(commander, line);
		}
		return "The total amount of freed space for this directory is "+ getMinFolderSize(commander);
	}

	private double getMinFolderSize(Commander commander) {
		final double actualUsedSpace = commander.getFiles(ROOT).values().stream().map(k->k.getSize(0)).collect( Collectors.summingDouble(Double::doubleValue));
		double neededToFree = 30000000d - (70000000d - actualUsedSpace) ;
		double actMinimumFreed = 0d;
		for (Map.Entry<String,MyFile> entry : commander.getDirectoryTree().entrySet()) {
			double size = getSizeOfFolder(commander.getFiles(ROOT), entry.getKey());
			if(neededToFree<=size && (actMinimumFreed == 0d || actMinimumFreed>size)){
				actMinimumFreed = size;
			}
		}
		return actMinimumFreed;
	}

	private double getSizeOfFolder(Map<String, MyFile> files, String folderName) {
		List<MyFile> collect = files.entrySet().stream().filter(e->e.getKey().startsWith(folderName)).map(e->e.getValue()).collect(Collectors.toList());
		collect = collect.stream().sorted(new Comparator<MyFile>() {

			@Override
			public int compare(MyFile o1, MyFile o2) {
				return o1.getParent().getName().compareTo(o2.getParent().getName());
			}
		}).collect(Collectors.toList());
		double size = 0d;
		for (MyFile myFile : collect) {
			size+=myFile.getSize(0);
		}
		return size ;
	}
}
