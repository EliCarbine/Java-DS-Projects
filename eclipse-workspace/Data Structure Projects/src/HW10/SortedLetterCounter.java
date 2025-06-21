package HW10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Map.Entry;

public class SortedLetterCounter {
	public static void main(String[] args) throws FileNotFoundException {
		
	Scanner sc = new Scanner(new File("input.txt"));
	int count = 1;
	Map<Character,Integer>letters = new TreeMap<>();
	Iterator<Entry<Character,Integer>>it ;
	
	while (sc.hasNext()) {
	String line =  sc.next();
	char[] unique = line.toCharArray();
	
	for(char i : unique) {
	if(Character.isLetter(i)) {
			if(!letters.containsKey(i)) {	
	letters.put(i, count);
	} else {
		letters.put(i,letters.get(i)+ 1);
	}
	}
	}
	}
	
	for(char s : letters.keySet()) {
		System.out.println(s+": "+ letters.get(s));
	
			
		}
	}
	}




