package practiceScene;

import java.util.Arrays;

public class RationalSum {

	public static void main(String[] args) {
		Rational sumNumber = new Rational(0,1);
		
		for (String arg : args) {
		//Try catch inside for loop
		try {
		
			Rational number = new Rational(arg);
			sumNumber = sumNumber.plus(number);

		
		} catch (IllegalArgumentException e) {
			System.out.println("skipping "+ arg);
		
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("skipping "+ arg);
		}
	}//end of for loop
		
System.out.println("sum = "+sumNumber);
	
		
		
	}
}

