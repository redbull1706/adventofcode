package aoc2022;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyFile {
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
