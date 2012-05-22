package challenge07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TuentiPassword {

	/**
	 * test_challenge 3j-tUrVkdOcBL75qQrwS java com.tuenti.challenge07.TuentiPassword
	 * submit_challenge 3j-tUrVkdOcBL75qQrwS src.jar path/program
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
//		InputStream input = TuentiPassword.class.getResourceAsStream("input.txt");
//		InputStreamReader inputStreamReader = new InputStreamReader(input);
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferReader = new BufferedReader(inputStreamReader);
		List<String> passwordPieces = new ArrayList<String>();
		String linea = bufferReader.readLine();
		while (linea !=null){
			passwordPieces.add(linea);
			linea = bufferReader.readLine();
		}
		String partial = "";
		List<String> passwords = new ArrayList<String>();
		TuentiPassword.breakPassword (partial, passwordPieces, 0, 0, passwords); 
		Collections.sort(passwords);
		for (int j = 0; j < passwords.size(); j++) {
			System.out.println (passwords.get(j));
		}
		inputStreamReader.close();
	}

	/**
	 * 
	 * @param parcial
	 * @param passwordPieces
	 * @param passwords
	 */
	private static boolean breakPassword(String partial, List<String> subcodes, int subcodeIndex, int charNumber, List<String> passwords) {
		if (TuentiPassword.validatePassword(partial, subcodes)==null){
			boolean valid = true;
			if (subcodeIndex==subcodes.size()){
				passwords.add(partial);
			} else {
				char myChar = subcodes.get(subcodeIndex).charAt(charNumber);
				charNumber++;
				if (charNumber == subcodes.get(subcodeIndex).length()) {
					charNumber = 0;
					subcodeIndex++;
				}
				List<String> potentialPasswords = TuentiPassword.potentialPasswords(partial, myChar, partial.length() + 1);
				for (String potential : potentialPasswords) {
					valid = breakPassword (potential, subcodes, subcodeIndex, charNumber, passwords);
				}				
			}
			return valid;
		} else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param partialPassword
	 * @param myChar
	 * @param position
	 * @return
	 */
	public static List<String> potentialPasswords(String partialPassword, char myChar, int position){
		List<String> candidates = new ArrayList<String>();
		if (partialPassword.indexOf(myChar)==-1) {
			for (int i=0; i<position; i++) {
				candidates.add(partialPassword.substring(0, i) + myChar + partialPassword.substring(i, partialPassword.length()));
			}
		} else {
			candidates.add(partialPassword);
		}
		return candidates;
	}
	
	/**
	 * 
	 * @param partial
	 * @param subcodes
	 * @return
	 */
	public static String validatePassword(String partial, List<String> subcodes){
		String subcodeInvalid = null;
		for (int i = 0; subcodeInvalid==null && i < subcodes.size(); i++) {
			int position = -1;
			int positionBefore = -1;
			char[] charArray = subcodes.get(i).toCharArray();
			for (int j = 0; subcodeInvalid==null &&  j < charArray.length; j++) {
				position = partial.indexOf((int)charArray[j]);
				if (position!=-1) {
					subcodeInvalid = positionBefore > position?subcodes.get(i):null;
					positionBefore = position;
				}
			}
		}
		return subcodeInvalid;
	}
}
