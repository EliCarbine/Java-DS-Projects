package HW10;

import java.util.*;

public class ListUtils {

	public static String getInitials(List<String> list) {
		String line= "";
		for (String s : list) {
	char init = s.charAt(0);
	line +=init;
		}
	return line;	
	}
	
	public static void swapFirstAndLast(List<String> list){
	Collections.swap(list,0,list.size()-1);
	
	}
	
	public static List<Integer>firstN(List<Integer> list, int n) {
		return list.subList(0, n);	
		
	}
	
	public static List<Integer>lastN(List<Integer> list, int n) {
	
	return list.subList(list.size()-n, list.size());
	}
	
	//sort
	public static boolean isSorted(List<Double> list) {
// Iterator / for loop
		for (int i = 1;i<list.size();i++) {
			
			//[5,10,12,15]/ [10,5,2,1] FALSE
			if (list.get(i) < list.get(i-1)) {
		
				return false;	
			}
		}
		return true;
	}	
	
	// print sort
	public static void printSorted(List<String> list) {
	
	list = new ArrayList<>(list);
	
	list.sort(Comparator.naturalOrder());
	
	//Don't modify/sort elements after iterator
	Iterator<String> it = list.iterator();
	
	if(it.hasNext()) {	
	System.out.print(it.next());
	//No space after last element
	while (it.hasNext()) {
		System.out.print(" "+ it.next());
	}
	//newline	
	System.out.println();
		}
	}
	}
	
	

