package challenge01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author adiaz
 *
 */
public class KeyBoard {

	/** For each line we have the position on the keyboard and the number of the press needed, 
	 * the index on the list is the ascii value of the character. */
	private Map<Character,int[]> keys;
	
	private TreeKeyPad treeKeyPad;
	
	private static final int START_POSITION = 10;
	private static final int CAPS_POSITION = 11;
	private static final int ONE_PRESS = 100;
	private static final int PRESS_WAIT = 500;
	
	/**
	 * Desarrollo del primer ejercicio del tuenti challenge.
	 * test_challenge LxWJlWHOxeYNOkhqQrwS java com.tuenti.challenge01.KeyBoard
	 * submit_challenge LxWJlWHOxeYNOkhqQrwS ../src.rar java com.tuenti.challenge01.KeyBoard
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		s = in.readLine();
		int lines = Integer.parseInt(s);
		for (int i = 0; i < lines; i++) {
			System.out.println(new KeyBoard().calculateTime(in.readLine()));
		}
	}
	
	
	public KeyBoard() throws IOException {
		/** create the structure of the keys which is on the file keys.txt, where each line has the format:
		 * key1:caracter1,caracter2,caracter3.*/
		keys = new HashMap<Character, int[]>();
		InputStream inputStream = getClass().getResourceAsStream("keys.txt");
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferReader = new BufferedReader(inputStreamReader);
		String linea;
		while ((linea = bufferReader.readLine())!=null){
			if (!linea.startsWith("//") && !"".equals(linea)){
				String[] split = linea.split(":");
				int position = Integer.parseInt(split[0]);
				if (split.length>1) {
					String[] keyCharacters = split[1].split(",");
					for (int i = 0; i < keyCharacters.length; i++) {
						Character myChar = keyCharacters[i].charAt(0);
						keys.put(myChar, new int[]{position, i});
					}
				}
			}
		}	
		/** create the tree structure of the posible movements. */
		treeKeyPad = new TreeKeyPad();
	}
	
	/**
	 * 
	 * @param myLine
	 * @return
	 */
	public long calculateTime(String myLine){
		long myTime = 0;
		int origin = START_POSITION;
		boolean capsActivated = false;
		for (int i = 0; i < myLine.length(); i++) {
			Character myChar = myLine.charAt(i);
			/* Check if is necesary press CAPS. */
			boolean isUpper = Character.isUpperCase(myChar);
			if (Character.isLetter(myChar) && (!capsActivated && isUpper || capsActivated && !isUpper)){
				myTime += treeKeyPad.calculaRuta(origin, CAPS_POSITION);
				myTime += ONE_PRESS;
				origin = CAPS_POSITION;
				capsActivated = !capsActivated;
			}
			int[] charInfo = this.keys.get(Character.toLowerCase(myChar));
			if (origin!=charInfo[0] || i==0){
				myTime += treeKeyPad.calculaRuta(origin, charInfo[0] );
			} else {
				myTime += PRESS_WAIT;				
			}
			myTime += ONE_PRESS * (charInfo[1] + 1);
			origin = charInfo[0];
		}
		return myTime;
	}

	public Map<Character, int[]> getKeys() {
		return keys;
	}


	public void setKeys(Map<Character, int[]> keys) {
		this.keys = keys;
	}
}
