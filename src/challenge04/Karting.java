package challenge04;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Tuenti Challenge 2012 -- test 04: 20 fast 20 furious.
 * 
 * test_challenge djYYPUlDDUzHwF1qQrwS java com.tuenti.challenge04.Karting
 * submit_challenge djYYPUlDDUzHwF1qQrwS src.rar java com.tuenti.challenge04.Karting
 * 
 * @author toni
 *
 */

public class Karting {

	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		List<Circuit> circuits = Circuit.readCircuits(inputStreamReader);
		for (Circuit circuit : circuits) {
			System.out.println(Karting.calculateOilEfficient(circuit));
		}
		inputStreamReader.close();
	}

	/**
	 * Resolution efficient of the problem 04.
	 * @param circuit
	 * @return
	 */
	public static int calculateOilEfficient(Circuit circuit){
		int carRaces = 0;
		int countGroups = 0;
		Map<String, Integer> groupsOnRace = new HashMap<String, Integer>();
		List<Integer> raceParticipans = new ArrayList<Integer>();
		boolean cycleFound = false;
		for (int i = 0; i < circuit.getRaces() && !cycleFound; i++) {
			int participants = 0;
			int groupsOnThisRace = 0;
			String idGroup = "";
			/* Find groups participans in each race. */
			while (participants+circuit.getGroups().get(countGroups)<=circuit.getCars() 
					&& groupsOnThisRace<circuit.getGroups().size()) {
				participants += circuit.getGroups().get(countGroups);
				idGroup += Integer.toString(countGroups);
				countGroups = (countGroups+1) % circuit.getGroups().size();
				groupsOnThisRace++;
			}
			/* Find is there a cycle: actual set of groups have alreary participate, if so we can skip other races. */
			if (groupsOnRace.containsKey(idGroup)) {
				cycleFound = true;
				List<Integer> cycleList = raceParticipans.subList(groupsOnRace.get(idGroup), raceParticipans.size());
				int cyclesLeft = (circuit.getRaces()-i)/cycleList.size();
				int cycleRaces = 0;
				for (Integer integer : cycleList) {
					cycleRaces += integer;
				}
				carRaces += cyclesLeft * cycleRaces;
				int racesLeft = (circuit.getRaces()-i)%cycleList.size();
				for (int j = 0; j < racesLeft; j++) {
					carRaces += cycleList.get(j);
				}
			} else {
				raceParticipans.add(participants);
				groupsOnRace.put(idGroup, i);
				carRaces += participants;
			}
		}
		return carRaces;
	}
	
	
	/**
	 * Resolution symple of the problem 04.
	 * @param circuit
	 * @return
	 */
	public static int calculateOilUnefficient(Circuit circuit){
		int carRaces = 0;
		int countGroups = 0;
		for (int i = 0; i < circuit.getRaces(); i++) {
			int participants = 0;
			int groupsOnThisRace = 0;
			while (participants+circuit.getGroups().get(countGroups)<=circuit.getCars() 
					&& groupsOnThisRace<circuit.getGroups().size()) {
				participants += circuit.getGroups().get(countGroups);
				countGroups = (countGroups+1) % circuit.getGroups().size();
				groupsOnThisRace++;
			}
			
			carRaces += participants;
		}
		return carRaces;
	}
	
}
