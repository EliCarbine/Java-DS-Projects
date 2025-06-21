package HW10;

import java.io.*;
import java.util.*;

public class ReveresePrinter {
	
	public static void main(String [] args) throws FileNotFoundException {
		
		File fl = new File("/Users/elijahjay/eclipse-workspace/Practice/src/HW10/output.txt");
		Scanner sc = new Scanner(fl);
		
		List<String> numbers = new ArrayList<>();
		
		while (sc.hasNext()) {
		String num = sc.next();
		 numbers.add(num);
		}
		
		//numbers.indexOf(String.valueOf(1));
		Collections.reverse(numbers);
		
		if (!numbers.isEmpty()) {
		for (int i = 0; i < numbers.size(); i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(numbers.get(i));
        }
        System.out.println();
       
		if(fl.length() == 0 ) {
		return;	
		}
		
	}
	
	}

}
