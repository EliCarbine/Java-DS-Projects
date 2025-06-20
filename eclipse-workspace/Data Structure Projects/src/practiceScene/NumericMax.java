package practiceScene;

public class NumericMax {

	public static void main(String[] args) {
		
		args = new String[] {null};
	double max = Double.NEGATIVE_INFINITY;
	for (String s: args) {
	try {
		char[] arr =s.toCharArray();
		
	double value = Double.parseDouble(s);
	if (value > max) {
		max = value;
		}
		
	} catch (NumberFormatException e) {
        System.out.println("skipping " + s);
    } catch (NullPointerException e) {
    	System.out.println("wrong");
    }
	
	}
	 if (max == Double.NEGATIVE_INFINITY) {
         System.out.println("no numeric arguments");
     } else {
    	 System.out.println("max = "+max);
     }
	
}
}
	


