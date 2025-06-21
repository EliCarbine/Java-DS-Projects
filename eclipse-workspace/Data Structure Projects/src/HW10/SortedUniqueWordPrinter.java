package HW10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SortedUniqueWordPrinter {

	public static void main(String[] args) throws FileNotFoundException {

		File fl = new File("/Users/elijahjay/eclipse-workspace/Practice/src/HW10/output.txt");
		Scanner sc = new Scanner(fl);

		Set<String> names = new TreeSet<>();
		while(sc.hasNext()) {
			String word = sc.next();
			names.add(word);
		}
		Iterator<String> it =names.iterator();

		while(it.hasNext()) {
			System.out.print(it.next()+" ");	
		}
		System.out.println();	
		sc.close();
	}

}
