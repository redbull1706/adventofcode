package aoc2022;

import java.util.HashMap;
import java.util.Map;

public class Commander {
	
	private MyFile root;
	private MyFile previousroot;
	private Map<String,MyFile> directoryTree = new HashMap<>();
	private Map<String,MyFile> fileTree = new HashMap<>();
	
	public Commander(MyFile root) {
		this.root = root;
	}
	
	public MyFile getPreviousroot() {
		return previousroot;
	}
	
	public MyFile addRoot(MyFile myFile) {
		directoryTree.put(myFile.getName(), myFile);
		return myFile;
	}
	
	public MyFile add(String dirname) {
		MyFile myFile = new MyFile((root.getName()+"|"+dirname), root);
		add( myFile);
		return myFile;
	}
	
	public MyFile add(MyFile file) {
		if(file.isDirectory()) {
			directoryTree.put(file.getName(), file);
		}else {
			fileTree.put(file.getParent().getName()+"-"+file.getName() ,file);
		}
		return file;
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
	
	public Map<String, MyFile> getDirectoryTree() {
		return directoryTree;
	}
	
	public Map<String, MyFile> getFiles(String parentFolder) {
		return fileTree;
	}

	public void moveDirUp() {
		root = previousroot;
		previousroot = root.getParent();
		System.out.println(" -> "+root);
	}
	
	public void gotoRoot() {
		root = directoryTree.get("root");
		previousroot = root.getParent();
		System.out.println(" -> "+root);
	}

	public void cd(String name) {
		previousroot = root;
		root = directoryTree.get(name);
		System.out.println(" -> "+root);
	}


}
