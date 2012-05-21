package challenge03.test;
import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import challenge03.FakeOperation;

public class FakeOperationTest {

	@Test
	public void testFakeOperation() throws IOException{
		InputStream inputStream = getClass().getResourceAsStream("input.txt");
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferReader = new BufferedReader(inputStreamReader);
		String linea;
		List<Integer> stocks = new ArrayList<Integer>();
		while ((linea = bufferReader.readLine())!=null){
			stocks.add(Integer.valueOf(linea));
		}
		inputStreamReader.close();
		List<Integer> received = FakeOperation.calculateOperation(stocks);
		List<Integer> expected = Arrays.asList(new Integer[]{9, 11, 52});
		assertEquals(expected, received);
	}
}
