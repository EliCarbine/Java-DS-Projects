package HW10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class CollectionUtils {

public static double average(Collection<Integer> st) {
	Iterator<Integer>it =st.iterator();
	double avg =0.0;
	int count = 0,sum=0;
	
	if(!st.isEmpty()) {
	while (it.hasNext()) {
		count++;
		sum += it.next();
	}
	avg = (double) sum/count;

	return avg;
	}
	return avg;
}

public static int maxLength(Collection<String> st) {
	int bigString = 0;
		if(!st.isEmpty()) {
			for(String s : st) {
				if (s.length() > bigString) {
				bigString = s.length();
				}
			}
			return bigString;	
		}
		return -1;
}

public static boolean containsDuplicate(Collection<Integer> st ) {
	Set<Integer> set = new HashSet<>();
	
	for (Integer i :st) {
		if (!set.add(i)) {
	return true;
	}
	
}
	return false;
}

}



