package challenge01.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;

import org.junit.Test;

import challenge01.KeyBoard;

public class KeyBoardTest {
	
	@Test
	public void testConstructor() throws IOException{
		KeyBoard keyBoard = new KeyBoard();
		Map<Character, int[]> keys = keyBoard.getKeys();
		int[] myArray = new int[]{4,0};
		assertEquals(myArray[0], keys.get(new Character('j'))[0]);
		assertEquals(myArray[1], keys.get(new Character('j'))[1]);
		myArray = new int[]{5,2};
		assertEquals(myArray[0], keys.get(new Character('o'))[0]);
		assertEquals(myArray[1], keys.get(new Character('o'))[1]);
	}
	

	@Test
	public void test01() throws IOException {
		String myMsg = "HI 20";
		assertEquals ((new KeyBoard()).calculateTime(myMsg), 4000);
	}

	@Test
	public void test02() throws IOException {
		String myMsg = "tu";
		assertEquals ((new KeyBoard()).calculateTime(myMsg), 1100);
	}
	
	
}
