package challenge07.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import challenge07.TuentiPassword;


public class TuentiPasswordTest {

	
	@Test
	public void testValidatePassword(){
		String password01 = "12ABcdxZ";
		String password02 = "12BAcdxZ";
		String password03 = "12Z";
		List<String> subcodes = Arrays.asList(new String[]{"2Ad", "12c", "2Ac", "2Bc", "1cd", "1xZ", "1dx", "BdZ"});
		String validacion = TuentiPassword.validatePassword(password01, subcodes);
		assertEquals (true, validacion==null);
		validacion = TuentiPassword.validatePassword(password02, subcodes);
		assertEquals (true, validacion==null);
		subcodes = Arrays.asList(new String[]{"2Ad", "12c", "2Ac", "2Bc", "1cd", "1xZ", "1dx", "BdZ"});
		validacion = TuentiPassword.validatePassword(password03, subcodes);
		assertEquals (true, validacion==null);
	}
	
	@Test
	public void testPotetialPassoword() throws IOException {
		String password03 = "12Z";
		List<String> potentialPasswords = TuentiPassword.potentialPasswords(password03, '@', 4);
		List<String> potential = Arrays.asList(new String[]{"@12Z", "1@2Z", "12@Z", "12Z@"});
		assertEquals(potential, potentialPasswords);
		
		password03 = "1";
		potentialPasswords = TuentiPassword.potentialPasswords(password03, '@', 2);
		potential = Arrays.asList(new String[]{"@1", "1@"});
		assertEquals(potential, potentialPasswords);


	}	

	@Test
	public void testBreakPassword() throws IOException {
		
		assertEquals(true, false);
	}	
}
