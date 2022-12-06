package aoc2022;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class Application {
	
	static final String FILE = "input_day_XY.txt"; 
	static final String PLACEHOLDER = "XY";
	
	public Iterator<String> getIterator(Day day) throws IOException{
		try {
			URL resource = getClass().getClassLoader().getResource(FILE.replace(PLACEHOLDER,String.valueOf(day.ordinal()+1) ));
			return Files.readAllLines(Paths.get(resource.toURI()), StandardCharsets.UTF_8).iterator();
		}catch(URISyntaxException use) {
			throw new IOException("could'nt read file");
		}
	}
	
	public static void main(String[] args) throws IOException {
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
