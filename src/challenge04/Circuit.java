package challenge04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Bean that represents a circuit used on Tuenti Challenge 2012 -- test 04: 20 fast 20 furious.
 * @author toni
 *
 */

public class Circuit {

	public Circuit(int races, int cars, List<Integer> groups) {
		super();
		this.races = races;
		this.cars = cars;
		this.groups = groups;
	}

	public Circuit (String context, String groupsStr) throws NumberFormatException, IOException {
		groups = new ArrayList<Integer>();
		String[] split = context.split(" ");
		this.races = Integer.valueOf(split[0]);
		this.cars = Integer.valueOf(split[1]);
		String[] groupsSplit = groupsStr.split(" ");
		for (String string : groupsSplit) {
			groups.add(Integer.valueOf(string));
		}
	}

	public static List<Circuit> readCircuits (InputStreamReader inputStreamReader) throws NumberFormatException, IOException{
		List<Circuit> circuits = new ArrayList<Circuit>();
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		int tests = Integer.parseInt(bufferedReader.readLine());
		for (int i = 0; i < tests; i++) {
			circuits.add(new Circuit(bufferedReader.readLine(), bufferedReader.readLine()));
		}
		return circuits;
	}
	
	
	private int races;
	private int cars;
	private List<Integer> groups;
	
	public int getRaces() {
		return races;
	}
	public void setRaces(int races) {
		this.races = races;
	}
	public int getCars() {
		return cars;
	}
	public void setCars(int cars) {
		this.cars = cars;
	}
	public List<Integer> getGroups() {
		return groups;
	}
	public void setGroups(List<Integer> groups) {
		this.groups = groups;
	}

	@Override
	public String toString() {
		return "Circuit [races=" + races + ", cars=" + cars + ", groups="
				+ groups + "]";
	}
}
