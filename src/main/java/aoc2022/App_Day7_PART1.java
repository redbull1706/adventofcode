package aoc2022;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class App_Day7_PART1 extends Application{
	
	
	private class MyFile {
		private double size;
		private MyFile parent;
		private List<MyFile> children;
		private boolean isDirectory;
		private String name;
		
		public MyFile(String pathname, double size, MyFile parent) {
			this.name = pathname;
			this.size = size;
			this.parent = parent;
			if(parent!=null) {
				parent.getChildren().add(this);
			}
		}
		
		public MyFile(String pathname, MyFile parent) {
			this.name = pathname;
			this.size = 0d;
			this.isDirectory = true;
			children = new ArrayList<>();
			this.parent = parent;
			if(parent!=null) {
				parent.getChildren().add(this);
			}
		}
		
		public String getName() {
			return name;
		}
		
		public boolean isDirectory() {
			return isDirectory;
		}
		
		public double getSize(double currentSize) {
			if(!isDirectory()) {
				return size;
			}else {
				for (Iterator iterator = children.iterator(); iterator.hasNext();) {
					MyFile myFile = (MyFile) iterator.next();
					currentSize+=myFile.getSize(currentSize);
				}
			}
			return currentSize;
		}
		
		public MyFile getParent() {
			if(getName().equals("root")) {
				return this;
			}
			return parent;
		}
		
		public List<MyFile> getChildren() {
			return children;
		}
		
		@Override
		public String toString() {
			return getName()+" "+getSize(0);
		}
	}
	
	private class Commander{
		
		private MyFile root,previousroot;
		
		public Commander(MyFile root) {
			this.root = root;
		}
		
		public MyFile getPreviousroot() {
			return previousroot;
		}
		
		public MyFile getRoot() {
			return root;
		}
		
		public void setPreviousroot(MyFile previousroot) {
			this.previousroot = previousroot;
		}
		
		public void setRoot(MyFile root) {
			this.root = root;
		}
		
	}
	
	public String run() throws IOException{
		Map<String,MyFile> directoryTree = new HashMap<>();
		Iterator<String> iterator = getIterator(Day.SEVEN);
		MyFile root = new MyFile("root", null);
		directoryTree.put(root.getName(), root);
		MyFile previousroot = root;
		while(iterator.hasNext()) {
			String line = iterator.next();
			String[] split = line.split(" ");
			if(line.startsWith("$")) {
				if(split[1].equals("cd")) {
					String name = split[2];
					if(name.equals("..")) {
						if(!root.getName().equals("root")) {
							root = previousroot;
							previousroot = root.getParent();
						}else {
							previousroot = directoryTree.get("root");
							root = directoryTree.get("root");
						}
					}else if(name.equals("/")) {
						root = directoryTree.get("root");
						previousroot = root.getParent();
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
				 new MyFile(name,size, root);
			}
		}
		double sum = 0;
		for (Map.Entry<String,MyFile> entry : directoryTree.entrySet()) {
			double size = entry.getValue().getSize(0);
			if(size<100000) {
				sum+=size;
			}
		}
		return "The total amount of space of directories under 100000 is "+sum;
	}
}
