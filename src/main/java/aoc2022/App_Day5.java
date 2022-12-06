package aoc2022;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public abstract class App_Day5 extends Application {
	
	Map<String,LinkedList<String>> initializeStack() {
		Map<String,LinkedList<String>> stack = new HashMap<>();
		LinkedList<String> slot1 = new LinkedList<>();
		slot1.add("N");
		slot1.add("W");
		slot1.add("F");
		slot1.add("R");
		slot1.add("Z");
		slot1.add("S");
		slot1.add("M");
		slot1.add("D");
		LinkedList<String> slot2 = new LinkedList<>();
		slot2.add("S");
		slot2.add("G");
		slot2.add("Q");
		slot2.add("P");
		slot2.add("W");
		LinkedList<String> slot3 = new LinkedList<>();
		slot3.add("C");
		slot3.add("J");
		slot3.add("N");
		slot3.add("F");
		slot3.add("Q");
		slot3.add("V");
		slot3.add("R");
		slot3.add("W");
		
		LinkedList<String> slot4 = new LinkedList<>();
		slot4.add("L");
		slot4.add("D");
		slot4.add("G");
		slot4.add("C");
		slot4.add("P");
		slot4.add("Z");
		slot4.add("F");
		
		LinkedList<String> slot5 = new LinkedList<>();
		slot5.add("S");
		slot5.add("P");
		slot5.add("T");
		
		LinkedList<String> slot6 = new LinkedList<>();
		slot6.add("L");
		slot6.add("R");
		slot6.add("W");
		slot6.add("F");
		slot6.add("D");
		slot6.add("H");
		
		LinkedList<String> slot7 = new LinkedList<>();
		slot7.add("C");
		slot7.add("D");
		slot7.add("N");
		slot7.add("Z");
		
		LinkedList<String> slot8 = new LinkedList<>();
		slot8.add("Q");
		slot8.add("J");
		slot8.add("S");
		slot8.add("V");
		slot8.add("F");
		slot8.add("R");
		slot8.add("N");
		slot8.add("W");
		
		LinkedList<String> slot9 = new LinkedList<>();
		slot9.add("V");
		slot9.add("W");
		slot9.add("Z");
		slot9.add("G");
		slot9.add("S");
		slot9.add("M");
		slot9.add("R");
		
		stack.put("1", slot1);
		stack.put("2", slot2);
		stack.put("3", slot3);
		stack.put("4", slot4);
		stack.put("5", slot5);
		stack.put("6", slot6);
		stack.put("7", slot7);
		stack.put("8", slot8);
		stack.put("9", slot9);
		return stack;
		
	}

}
