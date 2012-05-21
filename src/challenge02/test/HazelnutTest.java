package challenge02.test;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

import challenge02.Hazelnut;

public class HazelnutTest {

	@Test
	public void testEasy01() {
		assertEquals(1, Hazelnut.calculateHazelnut(new BigInteger("1")));
	}

	@Test
	public void testEasy02() {
		assertEquals(4, Hazelnut.calculateHazelnut(new BigInteger("6")));
	}

	
	@Test
	public void testEasy03() {
		assertEquals(14, Hazelnut.calculateHazelnut(new BigInteger("2135")));
	}

	
	
}
