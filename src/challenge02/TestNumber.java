package challenge02;

import java.math.BigDecimal;

public class TestNumber {

	
	public static void main(String[] args) {
		double myDouble = Math.pow(10, 19) ;
		
		long myLong = Long.MAX_VALUE;
		double myDoubleBis = Long.MAX_VALUE;
		
		System.out.println(myLong);
		System.out.println(myDouble);
		System.out.println(myDoubleBis);
		System.out.println((myDouble<myDoubleBis?"bien":"mal"));
		System.out.println(myDouble - myLong);
		System.out.println(myDoubleBis + (myDouble - myLong));
		
		System.out.println(new Double(2666));
		System.out.println(new BigDecimal(new Double(2666)).toBigInteger());
		
		
	}
}
