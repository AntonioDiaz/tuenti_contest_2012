package challenge03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Tuenti Challenge 2012 -- test 03: The evil trader.
 * Supposition: It is not possible to sell before to buy.
 * 
 * test_challenge onzdQEStly0713NqQrwS java com.tuenti.challenge03.FakeOperation
 * 
 * 
 * @author toni
 *
 */
public class FakeOperation {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferReader = new BufferedReader(inputStreamReader);
		List<Integer> stocks = new ArrayList<Integer>();
		String linea = bufferReader.readLine();
		while (linea !=null && !"".equals(linea)){
			stocks.add(Integer.valueOf(linea));
			linea = bufferReader.readLine();
		}
		inputStreamReader.close();
		List<Integer> operation = FakeOperation.calculateOperation(stocks);
		System.out.println(operation.get(0) + "00 " + operation.get(1) + "00 " + operation.get(2));
	}

	/**
	 * Calculate the most diference between two the values (A and B) of the list. 
	 * The position of A on the list it is before than the position of B.
	 * @param stocks
	 * @return
	 */
	public static final List<Integer> calculateOperation(List<Integer> stocks){
		int profit = Integer.MIN_VALUE;
		int whenToBuy = 0;
		int whenToSell = 0;
		for (int i = 0; i < stocks.size(); i++) {
			int accumulated = 0;
			for (int j = i; j < stocks.size() && accumulated >=0; j++){
				accumulated += stocks.get(j) - stocks.get(i);
				if (stocks.get(j) - stocks.get(i)>profit){
					profit = stocks.get(j) - stocks.get(i);
					whenToBuy = i;
					whenToSell = j;
				}
			}
		}
		return Arrays.asList(new Integer[]{whenToBuy, whenToSell, profit});
	}
}
