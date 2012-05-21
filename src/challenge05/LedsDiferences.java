package challenge05;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 
 * @author toni
 * test_challenge ktiL14teFqixsfBqQrwS java com.tuenti.challenge05.DigitalClock
 * submit_challenge ktiL14teFqixsfBqQrwS 45src.rar java com.tuenti.challenge05.DigitalClock
 */

public class LedsDiferences {

	public static void main(String[] args) throws Exception {
		String linea = "2012-01-02 00:00:00 - 2012-01-09 00:00:01";
		LedsDiferences ledsDiferences = new LedsDiferences(linea);
		System.out.print(ledsDiferences);
		System.out.print(" " + ledsDiferences.calculateLedsDiference() + "\n");		
	}
	
	public static void mainOld2(String[] args) throws Exception {
		String linea = "2012-01-02 00:00:00 - 2012-01-09 00:00:01";
		LedsDiferences ledsDiferences = new LedsDiferences(linea);
		System.out.print(ledsDiferences);
		System.out.print(" " + ledsDiferences.calculateLedsDiference() + "\n");
		linea = "2012-01-02 00:00:00 - 2012-01-09 00:00:09";
		ledsDiferences = new LedsDiferences(linea);
		System.out.print(ledsDiferences);
		System.out.print(" " + ledsDiferences.calculateLedsDiference() + "\n");
		linea = "2012-01-02 00:00:00 - 2012-01-09 00:00:10";
		ledsDiferences = new LedsDiferences(linea);
		System.out.print(ledsDiferences);
		System.out.print(" " + ledsDiferences.calculateLedsDiference() + "\n");
	}
	public static void mainOld(String[] args) throws Exception {
		InputStream inputStream = LedsDiferences.class.getResourceAsStream("input.txt");
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		//InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferReader = new BufferedReader(inputStreamReader);
		String linea = bufferReader.readLine();
		while (linea !=null && !linea.isEmpty()){
			LedsDiferences ledsDiferences = new LedsDiferences(linea);
			System.out.println(ledsDiferences + "\t" + ledsDiferences.calculateLedsDiference());
			linea = bufferReader.readLine();
		}
		inputStreamReader.close();
	}

	public static final long LEDS_DIFERENCE_ONE_DAY = 0;
	public static final String DATE_FORMAT_STR = "yyyy-MM-dd HH:mm:ss";
	/** Number of leds needed to show the date 00:00:00. */
	public static final long NUM_LEDS_INICIO = 36;
	
	private Calendar dateFrom;
	
	private Calendar dateTo;
	
	public LedsDiferences(String input) throws ParseException{
		DateFormat df = new SimpleDateFormat(DATE_FORMAT_STR);
		String[] datesStr = input.split(" - ");
		dateFrom = Calendar.getInstance();
		dateFrom.setTime(df.parse(datesStr[0]));
		dateTo = Calendar.getInstance();
		dateTo.setTime(df.parse(datesStr[1]));
	}
	
	public long calculateLedsDiference(){
		long ledsFrom = this.calculateLeds(dateFrom);
		long ledsTo = this.calculateLeds(dateTo);
		System.out.print("\t" + ledsTo + "-" + ledsFrom + " = ");
		return ledsTo - ledsFrom;
	}

	private long calculateLeds(Calendar myCalendar){
		int[] digits = LedsDiferences.calculateDigits(myCalendar);
		long ledsNumber = NUM_LEDS_INICIO;
		int[] ciclos = new int[]{6,16,10,16,10,16};
		int[] base = new int[]{2,10,6,10,6,10};
		int accumulated = 0;
		for (int i = 0; i < digits.length; i++) {
			ledsNumber += LedsDiferences.fromDigit2Leds(digits[i]);
			ledsNumber += (accumulated * ciclos[i]);
			accumulated = ((accumulated * base[i]) + digits[i]);
		}
		/* calculate zeros.*/
		int maxDigit = -1;
		for (int i : digits) {
			if (maxDigit==-1 && i!=0){
				maxDigit = digits[i];
			}
		}
		
		long zeroNumbers = 0;
		/* 00:00:00 - 00:00:01 - 00:00:02 - .. - 00:00:10 */
		for (int i = digits.length-1; i>=0 ; i--) {
			
			//zeroNumbers += digits[i]*i;
		}
		System.out.println(zeroNumbers);
		return ledsNumber;
		
	}
	
	/**
	 * 
	 * @param calendar
	 * @return
	 */
	public static int[] calculateDigits(Calendar calendar){
		int[] listaDigitos = new int[6];
		listaDigitos[0] = calendar.get(Calendar.HOUR)/10;
		listaDigitos[1] = calendar.get(Calendar.HOUR)%10;
		listaDigitos[2] = calendar.get(Calendar.MINUTE)/10;
		listaDigitos[3] = calendar.get(Calendar.MINUTE)%10;
		listaDigitos[4] = calendar.get(Calendar.SECOND)/10;
		listaDigitos[5] = calendar.get(Calendar.SECOND)%10;
		return listaDigitos;
	}
	
	/**
	 * Calculate the number of leds saved per digit, this is accumulative, the leds saved for '2' are saved for one and zero 
	 * @param myDigit
	 * @return
	 */
	private static int fromDigit2Leds(int myDigit){
		int[] ledsSaved = new int[]{0,2,3,7,10,13,18,20,27,30,34};
		return ledsSaved[myDigit];
	}
	
	
	@Override
	public String toString() {
		DateFormat df = new SimpleDateFormat(DATE_FORMAT_STR);
		return "LedsDiferences [dateFrom=" + df.format(dateFrom.getTime()) + ", dateTo=" + df.format(dateTo.getTime()) + "]";
	}
	
	public Calendar getDateFrom() {
		return dateFrom;
	}

	public Calendar getDateTo() {
		return dateTo;
	}
}
