package aoc2022;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class App_Day5_PART1 extends App_Day5{
	
	
	
	public String run() throws IOException {
		Map<String, LinkedList<String>> stack = initializeStack();
		Iterator<String> itr = getIterator(Day.FIVE);
		while (itr.hasNext()) {
			String line = itr.next();
			try (Scanner scanner = new Scanner(line).useDelimiter("[^\\d]+")) {
				int amount = scanner.nextInt();
				int from = scanner.nextInt();
				int to = scanner.nextInt();
				LinkedList<String> fromSlot = stack.get(String.valueOf(from));
				LinkedList<String> toSlot = stack.get(String.valueOf(to));
				for(int i= 0;i<amount;i++) {
					toSlot.addFirst(fromSlot.removeFirst());
				}
			}
		}
		String result = "";
		for(int i = 1;i<=9;i++) {
			result += stack.get(String.valueOf(i)).getFirst();
		}
		return "the result is "+result;
	}
}
