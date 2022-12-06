package main.java;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class Application {
	
	public Iterator<String> getIterator(String fileName) throws IOException{
		return Files.readAllLines(Paths.get(new File(fileName).getAbsolutePath()), StandardCharsets.UTF_8).iterator();
	}
	
	public static void main(String[] args) throws IOException, URISyntaxException {
		System.out.println(new App_Day1_PART1().run());
		System.out.println(new App_Day1_PART2().run());
		System.out.println(new App_Day2_PART1().run());
		System.out.println(new App_Day2_PART2().run());
		System.out.println(new App_Day3_PART1().run());
		System.out.println(new App_Day3_PART2().run());
		System.out.println(new App_Day4_PART1().run());
		System.out.println(new App_Day4_PART2().run());
		System.out.println(new App_Day5_PART1().run());
		System.out.println(new App_Day5_PART2().run());
		System.out.println(new App_Day6_PART1().run());
		System.out.println(new App_Day6_PART2().run());
	}
}
