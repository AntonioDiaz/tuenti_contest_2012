package challenge04.test;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.junit.Test;

import challenge04.Circuit;
import challenge04.Karting;

public class KartingTest {

	List<Circuit> circuitsEasy;
	List<Circuit> circuitsDificult;
	
	public KartingTest() throws Exception, IOException{
		InputStream inputStream = getClass().getResourceAsStream("input_easy.txt");
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		circuitsEasy = Circuit.readCircuits(inputStreamReader);
		inputStream = getClass().getResourceAsStream("input_easy.txt");
		inputStreamReader = new InputStreamReader(inputStream);
		circuitsDificult = Circuit.readCircuits(inputStreamReader);

	}
	
	@Test
	public void testCalcultateOilEasy01() throws IOException {
		int oil = Karting.calculateOilEfficient(circuitsEasy.get(0));
		assertEquals(12, oil);
	}

	@Test
	public void testCalcultateOilEasy02() throws IOException {
		int oil = Karting.calculateOilEfficient(circuitsEasy.get(1));
		assertEquals(100, oil);
	}
	
	@Test
	public void testCalcultateOilEasy03() throws IOException {
		int oil = Karting.calculateOilEfficient(circuitsEasy.get(2));
		assertEquals(18, oil);
	}
	
	
	@Test
	public void testCalcultateDificult() throws IOException {
		for (Circuit circuit : circuitsDificult) {
			assertEquals(Karting.calculateOilEfficient(circuit), Karting.calculateOilUnefficient(circuit));
		}
	}
}
