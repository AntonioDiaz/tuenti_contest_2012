package challenge05.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import challenge05.LedsDiferences;

public class DigitalClockTest {

	public DigitalClockTest() throws Exception, IOException {
	}
	
	
	@Test
	public void testCalculateLedsDiferenceDummy() throws Exception {
		String input = "2012-01-02 00:00:00 - 2012-01-02 00:00:04";
		String expected = "";
		LedsDiferences ledsDiferences = new LedsDiferences(input);
		assertEquals(expected, ledsDiferences.calculateLedsDiference());
	}

	
	@Test
	public void testCalculateLedsDiference00() throws Exception {
		String input = "2012-01-02 00:00:00 - 2012-01-09 00:19:55";
		String expected = "15822521";
		LedsDiferences ledsDiferences = new LedsDiferences(input);
		assertEquals(expected, ledsDiferences.calculateLedsDiference());
	}


	@Test
	public void testCalculateLedsDiference01() throws Exception {
		String input = "2012-01-06 00:00:00 - 2012-01-10 11:14:44";
		String expected = "10139168";
		LedsDiferences ledsDiferences = new LedsDiferences(input);
		assertEquals(expected, ledsDiferences.calculateLedsDiference());
	}

	
	@Test
	public void testCalculateLedsDiference02() throws Exception {
		String input = "2012-01-09 00:00:00 - 2012-01-15 10:27:32";
		String expected = "14581994";
		LedsDiferences ledsDiferences = new LedsDiferences(input);
		assertEquals(expected, ledsDiferences.calculateLedsDiference());
	}
	
	@Test
	public void testCalculateLedsDiference03() throws Exception {
		String input = "2012-01-17 00:00:00 - 2012-01-24 09:57:23";
		String expected = "16791741";
		LedsDiferences ledsDiferences = new LedsDiferences(input);
		assertEquals(expected, ledsDiferences.calculateLedsDiference());
	}
	
	@Test
	public void testCalculateLedsDiference04() throws Exception {
		String input = "2012-01-15 00:00:00 - 2012-01-22 13:23:31";
		String expected = "17083065";
		LedsDiferences ledsDiferences = new LedsDiferences(input);
		assertEquals(expected, ledsDiferences.calculateLedsDiference());
	}

	@Test
	public void testCalculateLedsDiference05() throws Exception {
		String input = "2012-01-15 00:00:00 - 2012-01-20 21:09:24";
		String expected = "17083065";
		LedsDiferences ledsDiferences = new LedsDiferences(input);
		assertEquals(expected, ledsDiferences.calculateLedsDiference());
		input = "2012-01-13 00:00:00 - 2012-01-17 07:49:12";
		expected = "17083065";
		ledsDiferences = new LedsDiferences(input);
		assertEquals(expected, ledsDiferences.calculateLedsDiference());		
		input = "2012-01-08 00:00:00 - 2012-01-15 11:53:39";
		expected = "17083065";
		ledsDiferences = new LedsDiferences(input);
		assertEquals(expected, ledsDiferences.calculateLedsDiference());		
		input = "2012-01-21 00:00:00 - 2012-01-24 17:10:22";
		expected = "17083065";
		ledsDiferences = new LedsDiferences(input);
		assertEquals(expected, ledsDiferences.calculateLedsDiference());		
		input = "2012-01-17 00:00:00 - 2012-01-24 06:47:53";
		expected = "17083065";
		ledsDiferences = new LedsDiferences(input);
		assertEquals(expected, ledsDiferences.calculateLedsDiference());		
	}



}
