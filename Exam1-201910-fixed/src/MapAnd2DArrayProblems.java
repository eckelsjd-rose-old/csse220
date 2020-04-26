import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MapAnd2DArrayProblems {
	
	/**
	 * Input arrays a1 and a2 have the same number of columns, but
	 * may not have the same number of rows.
	 * 
	 * Your task is to create and return a new 2D array that contains
	 * a1's rows as the top part of the new 2D array, and a2's rows at the
	 * bottom part of the new 2D array
	 * 
	 * For example:
	 * a1 = {{0,1},{2,3},{4,5}} - has 3 rows
	 * a2 = {{6,7}} - has 1 row
	 * putTogether(a1, a2) --> {{0,1},{2,3},{4,5},{6,7}} - has 4 rows
	 * 
	 * a1 = {{0,1,-1},{2,3,-10},{4,5,-100}}
	 * a2 = {{6,7,800},{5,4,3},{1,2,3},{33,44,55}}
	 * putTogether(a1, a2) --> {{0,1,-1},{2,3,-10},{4,5,-100},{6,7,800},{5,4,3},{1,2,3},{33,44,55}}
	 * 
	 * a1 = {{0}}
	 * a2 = {{1}}
	 * putTogether(a1, a2) --> {{0},{1}}
	 * 
	 */
	public static int [][] putTogether(int[][] a1, int [][] a2) {
		int[][] combined = new int[a1.length + a2.length][a1[0].length]; // the goal here was to create an new array with a length equal to the sum of the two arrays,
		// and then essentially concatenate them one after the other.
		
		for (int i=0; i<a1.length; i++) {
			for (int j=0; j<a1[0].length;j++) {
				combined[i][j] = a1[i][j];
			}
		}
		int q = 0;
		int r = 0;
		for (int m=a1.length;m<a1.length+a2.length; m++) {
			for (int n=0; n<a1[0].length;n++) {
				combined[m][n] = a2[q][r];
				r++;
			}
			r = 0;
			q++;
		}
		return combined;
	}
	
	/**
	 * Given a hash map and a set of values to find, find all the keys that are associated with
	 * the values in valuesToFind, put those keys into a new ArrayList and return that ArrayList
	 * Note: the order in which the keys appear in the returned ArrayList does not matter
	 * 
	 * If none of valuesToFind are associated with any key in the map, then return an empty ArrayList
	 * 
	 * For example:
	 * map = {87="falcon", 91="sparrow", 12="woodpecker", 10="woodpecker", 11="blackbird"}
	 * valuesToFind = {"sparrow", "falcon"}
	 * <87,91> is returned (or <91,87> is returned, either one)
	 * 
	 * map = {87="falcon", 91="sparrow", 12="woodpecker", 10="woodpecker", 11="blackbird"}
	 * valuesToFind = {"woodpecker", "falcon"}
	 * <87,11,12> is returned (in any order)
	 * 
	 * map = {87="falcon", 91="sparrow", 10="woodpecker", 11="blackbird"}
	 * valuesToFind = {}
	 * <> is returned
	 * 
	 * map = {87="falcon", 91="sparrow", 10="woodpecker", 11="blackbird"}
	 * valuesToFind = {"pileated", "owl"}
	 * <> is returned
	 * 
	 * map = {}
	 * valuesToFind = {"pileated", "owl"}
	 * <> is returned
	 * 
	 * @param map 
	 * @param valueToFind
	 * @return key in map associated with valueToFind, or -1 if no key associated with valueToFind
	 */
	public static ArrayList<Integer> findKeysThatMatchesValues(HashMap<Integer,String> map, HashSet<String> valuesToFind) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (Integer key: map.keySet()) {
			String value = map.get(key);
			if (valuesToFind.contains(value)) {
				result.add(key);
			}
		}
		return result;		
	}
}
