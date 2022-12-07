package aoc2022;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class App_Day7_PART2 extends Application{
	
	
	private static final String ROOT = "root";

	private class MyFile extends File{
		private double size;
		private MyFile parent;
		private List<MyFile> children;
		private boolean isDirectory;
		
		public MyFile(String pathname, double size, MyFile parent) {
			super(pathname);
			this.size = size;
			this.parent = parent;
			if(parent!=null) {
				parent.getChildren().add(this);
			}
		}
		
		public MyFile(String pathname, MyFile parent) {
			super(pathname);
			this.size = 0d;
			this.isDirectory = true;
			children = new ArrayList<>();
			this.parent = parent;
			if(parent!=null) {
				parent.getChildren().add(this);
			}
		}
		
		@Override
		public boolean isDirectory() {
			return isDirectory;
		}
		
		public double getSize() {
			if(!isDirectory()) {
				return size;
			}
			return getFiles().stream().map(k->k.size).collect( Collectors.summingDouble(Double::doubleValue));
		}
		
		public MyFile getMyParent() {
			if(getName().equals(ROOT)) {
				return this;
			}
			return parent;
		}
		
		public List<MyFile> getChildren() {
			return children;
		}
		
		@Override
		public String toString() {
			return getName()+" "+getSize();
		}
		
		public List<MyFile> getFiles(){
			return getChildren().stream().filter(child->!child.isDirectory()).collect(Collectors.toList());
		} 
		
	}
	
	public String run() throws IOException{
		Map<String,MyFile> directoryTree = new HashMap<>();
		Map<String,MyFile> files = new HashMap<>();
		Iterator<String> iterator = getIterator(Day.SEVEN);
		MyFile root = new MyFile(ROOT, null);
		directoryTree.put(root.getName(), root);
		MyFile previousroot = root;
		while(iterator.hasNext()) {
			String line = iterator.next();
			String[] split = line.split(" ");
			if(line.startsWith("$")) {
				if(split[1].equals("cd")) {
					String name = split[2];
					if(name.equals("..")) {
						if(!root.getName().equals(ROOT)) {
							root = previousroot;
							previousroot = root.getMyParent();
						}else {
							previousroot = directoryTree.get(ROOT);
							root = directoryTree.get(ROOT);
						}
					}else if(name.equals("/")) {
						root = directoryTree.get(ROOT);
						previousroot = root.getMyParent();
					}else if(directoryTree.containsKey((root.getName()+"|"+name))){
						previousroot = root;
						root = directoryTree.get((root.getName()+"|"+name));
					}
				}
			}else if(split[0].equals("dir")) {
				String name = split[1];
				directoryTree.put((root.getName()+"|"+name), new MyFile((root.getName()+"|"+name), root));
			}else {
				 double size = Long.parseLong(split[0]);
				 String name = split[1];
				 MyFile myFile = new MyFile(name,size, root);
				 files.put(myFile.getMyParent().getName()+"-"+name, myFile);
			}
		}
		return "The total amount of freed space for this directory is "+ getMinFolderSize(directoryTree, files);
	}

	private double getMinFolderSize(Map<String, MyFile> directoryTree, Map<String, MyFile> files) {
		final double actualUsedSpace = files.values().stream().map(k->k.size).collect( Collectors.summingDouble(Double::doubleValue));
		double neededToFree = 30000000d - (70000000d - actualUsedSpace) ;
		double actMinimumFreed = 0d;
		for (Map.Entry<String,MyFile> entry : directoryTree.entrySet()) {
			double size = getSizeOfFolder(files, entry.getKey());
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
				return o1.getMyParent().getName().compareTo(o2.getMyParent().getName());
			}
		}).collect(Collectors.toList());
		double size = 0d;
		for (MyFile myFile : collect) {
			size+=myFile.size;
		}
		return size ;
	}
}
