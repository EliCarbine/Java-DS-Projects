package HW10;

import java.util.*;
import java.io.*;



public class UniqueLetterCounter {

	public static void main(String[] args) throws FileNotFoundException {
		
		File fl = new File("input.txt");
		Scanner sc = new Scanner(fl);
	Set<Character> ot = new TreeSet<>();
		
		
		while (sc.hasNext()) {
			
		char [] line = sc.next().toCharArray();
		
		for (char i : line) {
		if(Character.isLetter(i)) {
			ot.add(i);
		}
		if(String.valueOf(i) == String.valueOf(i).toUpperCase())
			ot.add(i);
		}
	}
		System.out.print(ot.size());

	}
}
