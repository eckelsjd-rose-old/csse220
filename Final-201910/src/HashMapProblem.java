
import java.util.ArrayList;
import java.util.HashMap;

public class HashMapProblem {

	/*
	 * DONE
	 * 
	 * operation updateMapValues takes two parameters: HashMap<K,V> m1 String
	 * sToAdd The HashMap's K is a String The HashMap's V is an
	 * ArrayList<String>
	 * 
	 * updateMapValues modifies the map by adding the sToAdd to each ArrayList
	 * in the map
	 * 
	 * updateMapValues makes no other changes to the map other than the change
	 * described above
	 * 
	 * Example: Before call to updateMapValues m1 = {1FM=[1FM, Ford, Explorer],
	 * 1B3=[1B3, Dodge, Viper]} sToAdd = "new"
	 * 
	 * call: updateMapValues(m1, sToAdd);
	 * 
	 * After call to updateMapValues m1 = {1FM=[1FM, Ford, Explorer, new],
	 * 1B3=[1B3, Dodge, Viper, new]} sToAdd = "new"
	 * 
	 * See JUnit test scripts for more examples
	 */
	public static void updateMapValues(HashMap<String, ArrayList<String>> m1, String sToAdd) {

		for (String s : m1.keySet()) {
			ArrayList<String> currentList = m1.get(s);
			currentList.add(sToAdd);
		}
	}
}
