package challenge02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Tuenti Challenge: Test 2 - The binary granny. 
 * @author toni
 *
 */

public class Hazelnut {

	/**
	 * test_challenge i29WNRGxeAYsMNFqQrwS java com.tuenti.challenge02.Hazelnut
	 * ./submit_challenge i29WNRGxeAYsMNFqQrwS ../src.tar java com.tuenti.challenge02.Hazelnut
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferReader = new BufferedReader(inputStreamReader);
		String s;
		s = bufferReader.readLine();
		int lines = Integer.parseInt(s);
		for (int i = 0; i < lines; i++) {
			int hazen = Hazelnut.calculateHazelnut(new BigInteger (bufferReader.readLine()));
			System.out.format("Case #%d: %d%n", i+1, hazen);
		}
	}
	
	/**
	 * Helps Yuki to eat as much of Hazenult as posible. More info visit: tuenti challenge 2012 -- test 02
	 * @param bigInteger
	 * @return
	 */
	public static int calculateHazelnut(BigInteger bigInteger){
		int pow = bigInteger.toString(2).length()-1;
		double substract = bigInteger.doubleValue() - (Math.pow(2, pow) - 1);
		BigInteger bigIntegerMinus = new BigDecimal(substract).toBigInteger();
		String binaryStr = bigIntegerMinus.toString(2);
		String binaryStrNoOnes = binaryStr.replaceAll("1", "");
		int ones = pow;
		ones += (binaryStr.length() - binaryStrNoOnes.length());
		return ones;
	}
}
