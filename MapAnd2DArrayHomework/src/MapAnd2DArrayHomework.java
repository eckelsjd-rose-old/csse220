import java.util.ArrayList;
import java.util.HashMap;


/**
 * MOST OF THESE PROBLEMS SHOULD BE DONE INDIVIDUALLY
 * One of them you can do with a partner 
 * 
 * Some practice problems with 2d arrays and hashmaps
 * Actually includes 8 regular problems and one bonus problem
 *
 * @author hewner.
 *         Created Dec 31, 2013.
 */
public class MapAnd2DArrayHomework {
	
	/**
	 * Given one string, return the most common character.
	 * 
	 * Example:
	 *   mostCommonCharacter("aaab") returns 'a'
	 *   mostCommonCharacter("abcbcdc") returns 'c'
	 * 
	 * You can assume that your string will not be empty and that
	 * one character will be more common than all the others (i.e. there
	 * won't be a tie for the most common character)
	 * 
	 * Your solution should use hashmaps, NOT nested for loops.
	 * You'll need one for loop though.
	 *
	 * @param input - string to find most common character of
	 * @return most common character
	 * 
	 */
	public static char mostCommonCharacter(String input) {
		
		HashMap<Character, Integer> list = new HashMap<>();
		int maxCount = 0;
		char maxChar = ' ';
		
		for (int i = 0; i < input.length(); i++) {
			
			char current = input.charAt(i);
			
			if (list.containsKey(current)) {
				list.put(current, list.get(current) + 1);
			}
			else {
				list.put(current, 1);
			}
		}
		
		for (char key : list.keySet()) {
			if (list.get(key) > maxCount) {
				maxCount = list.get(key);
				maxChar = key;	
			}
		}
		
		return maxChar;
	}
	
	/**
	 * 
	 * Reverses (i.e. exchanges the keys and values) a hashmap which 
	 * may contain multiple keys with the same value.  Because of this,
	 * the values of the reversed map will be a list.
	 * 
	 * 
	 * For example:
	 * {1=A,2=A,3=B} yields {A=[1,2], B=[3]}
	 * 
	 * The initial hashmap maps Integers to Strings.
	 * The reversed hashmap will map Strings to ArrayLists of Integers.
	 * 
	 * @param initialMap the HashMap to be reversed
	 * @return a copy of the hashmap with keys and values exchanged
	 */
	public static HashMap<String,ArrayList<Integer>> reverseHashmap(HashMap<Integer,String> initialMap) {
		
		HashMap<String,ArrayList<Integer>> newMap = new HashMap<>();
		
		for (Integer current : initialMap.keySet()) {
			if (newMap.keySet().contains(initialMap.get(current))) {
				ArrayList<Integer> list = newMap.get(initialMap.get(current));
				list.add(current);
				newMap.put(initialMap.get(current), list);
			}
			else {
				ArrayList<Integer> newList = new ArrayList<>();
				newList.add(current);
				newMap.put(initialMap.get(current), newList);
			}
		}
		return newMap;
	}
	
	/**
	 * During a heat wave, any sign of lower temperatures is news.  This function takes an 
	 * array of temperatures and an array of the cities where each temperature reading was 
	 * recorded.  The function should return the name of a city that experienced a temperature 
	 * drop.  If no city experienced a drop, the function should return null.
	 * 
	 * You can assume only 1 city will experience a drop.
	 * 
	 * Use maps to solve this problem.
	 * 
	 * Example 1:
	 * 
	 * Temps:    City:
	 * 80        Seattle
	 * 100       LA
	 * 81        Seattle
	 * 99        LA
	 * 
	 * The function should return "LA" because it experienced a drop from 100 to 99.
	 * 
	 * Example 2:
	 * 
	 * Temps:    City:
	 * 91        Terre Haute
	 * 92        Terre Haute
	 * 80        Seattle
	 * 93        Terre Haute
	 * 100       LA
	 * 83        Seattle
	 * 93        Terre Haute
	 * 82        Seattle
	 * 105       LA
	 * 85        Seattle
	 * 
	 * The function should return "Seattle" because 83 to 82 was a drop.
	 *
	 * Example 3:
	 * 
	 * Temps:    City:
	 * 91        Terre Haute
	 * 92        Terre Haute
	 * 80        Seattle
	 * 
	 * The function should return null because no city had a drop.
     *
	 * @param temps temperatures recorded in time order
	 * @param names names of the cities where each temperature was taken
	 * @return city that had a temperature drop
	 */
	public static String getTemperatureDropCity(int[] temps, String[] tempCity) {
		
		HashMap<String, ArrayList<Integer>> cityMap = new HashMap<>();
		
		for (int i=0; i < temps.length; i++) {
			if (cityMap.keySet().contains(tempCity[i])) {
				String currentCity = tempCity[i];
				ArrayList<Integer> tempArray = cityMap.get(currentCity);
				tempArray.add(temps[i]);
				cityMap.put(currentCity, tempArray);
			}
			else {
				ArrayList<Integer> newTemp = new ArrayList<>();
				newTemp.add(temps[i]);
				cityMap.put(tempCity[i], newTemp);
			}
		}
		
		for (String keyCity : cityMap.keySet()) {
			
			ArrayList<Integer> currentList = cityMap.get(keyCity);
			
			for (int j=0; j < currentList.size() - 1; j++) {
				if (currentList.get(j+1) < currentList.get(j)) {
					return keyCity;
				}
			}
		}

		return null;
	}
	
	
	/**
	 * In a particular school (not Rose-Hulman) each course can only have 1 pre-requisite course.
	 *  
	 * These pre-req courses are represented by a map, for example:
	 * 
	 * {"CS120"="","CS220"="CS120","CS230"="CS220","MA100"="MA102","MA102"="MA100"}
	 * 
	 * Note that if a course has no pre-req, it is represented by the empty string ""
	 * 
	 * So in this example, CS120 has no pre-req course.
	 *                     CS220 has a pre-req of 120
	 *                     CS230 has a pre-req of 220
	 *                     MA100 has a pre-req of MA102
	 *                     MA102 has a pre-req of MA100
	 *                     
	 * Your job is to write a function that determines how many courses must be taken to take a specific course.
	 * 
	 * So your function should return 0 for "CS120"
	 *    your function should return 1 for "CS220"
	 *    your function should return 2 for "CS230"
	 *    your function should return -1 for "MA102" or "MA100".  They are in a pre-req loop, so it is impossible to take any of the courses. 
	 * 
	 * @param courseMap map of all courses to a pre-req
	 * @param course course to check
	 * @return number of courses before you can take given course, or -1 if it is in a pre-req loop
	 */
	public static int getNumberOfCoursesToTake(HashMap<String,String> courseMap, String course) {
		
		String currentCourse = course;
		int count = 0;
		HashMap<String, Integer> courseTracker = new HashMap<>();
		
		while(true) {
			
			String preReq = courseMap.get(currentCourse);
			
			if (courseTracker.keySet().contains(currentCourse)) {
				return -1;
			}
			
			courseTracker.put(currentCourse, 1);
			
			if (preReq.equals("")) {
				return count;
			}
		
			currentCourse = preReq;
			count++;
		}
	}
	
	/**
	 * 
	 * Given a square array, determines if it is diagonal
	 * That is, returns true if all values in the array are 0 
	 * except the main diagonal.  The main diagonal is entries of the form
	 * data[i][j] where i == j.  Elements on the main
	 * diagonal can be 0 or any other number.
	 * 
	 * Examples:
	 * {{1,0,0},
	 *  {0,2,0}
	 *  {0,0,3}} yields true
	 *  
	 * {{1,0,9},
	 *  {0,2,0},
	 *  {0,0,3}} yields false because 0,2 is nonzero
	 * 
	 * {{0,0,0},
	 *  {0,0,0},
	 *  {0,0,3}} yields true because there can be 0
	 *                  entries on the diagonal if desired
	 * @param data input array
	 * @return true if it is diagonal, false otherwise
	 */
	public static boolean isDiagonal(int[][] data) {
		
		for (int i=0; i < data.length; i++) {
			
			for (int j=0; j < data[0].length; j++) {
				if (i != j) {
					if (data[i][j] != 0) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	/**
	 * 
	 * Given a 2D array populated with a sequence of characters 
	 * that wrap from the rightmost position to the leftmost position 
	 * on the next row, find the length of the longest sequence of repeated 
	 * characters. 
	 * 
	 * For example
	 * 
	 * abba
	 * dafa
	 * 
	 * Has a longest sequence of 2 for the 2 repeated
	 * bs
	 * 
	 * 2 Bs yield the longest repeat sequence here. Note that the As do not 
	 * follow after each other and hence, do not get considered.
	 * 
	 * The array is considered to "wrap" 
	 * from the rightmost position to the leftmost
	 * position on the next line.
	 * 
	 * For example:
	 * 
	 * abcdd
	 * ddefg
	 * 
	 * Is considered to have a longest sequence of 4
	 * because the two ds on the right "wrap around"
	 * to connect with the two ds on the next line 
	 * 
	 * @param data
	 * @return the length of the longest sequence
	 */
	public static int longestRepeatSequence(char[][] data) {
		
		int count = 1;
		int maxCount = 1;
		char lastChar = ' ';
		
		for (int i=0; i<data.length; i++) {
			
			if (lastChar == data[i][0]) {
				count++;
			}
			else {
				if (count > maxCount) {
					maxCount = count;
				}
			count = 1;
			}
			
			for (int j=0; j<data[0].length - 1; j++) {
				if (data[i][j] == data[i][j+1]) {
					count ++;
				}
				else {
					if (count > maxCount) {
						maxCount = count;
					}
				count = 1;
				}
			}
			
			lastChar = data[i][data[0].length - 1];
			
		}
		if (count > maxCount) {
			maxCount = count;
		}
		
		return maxCount;
	}
	
	/**
	 * Given a 2D array of characters, returns a string consisting of all the characters
	 * in column-order, that is, one column at a time, going from left to right.
	 * 
	 * For example, 
	 * 
	 * hlo
	 * el! 
	 * 
	 * returns the string "hello!"
	 * 
	 * @param data rectangular 2D array.
	 * @return a single string made of all the characters in each column.
	 */
	public static String stringFromColumns(char[][] data) {
		
		ArrayList<Character> list = new ArrayList<>();
		
		for (int i=0; i < data[0].length; i++) {
			for (int j=0; j < data.length; j++) {
				list.add(data[j][i]);
			}
		}
		
		/*Stack Overflow was used here to find the StringBuilder class and .append function
		to create a string out of the character entries in the array list created previously.*/
		
		StringBuilder builder = new StringBuilder(list.size());
		for (char example : list) {
			builder.append(example);
		}
		
		String solution = builder.toString();
		return solution;
	}
	
	
	
	/**
	 * Given A specific starting position and distance
	 * returns a 10x10 character array with all positions
	 * that are less than or equal to that manhattan distance 
	 * from the starting position marked with an x.
	 * 
	 * Recall the manhattan distance is the distance
	 * in terms of number of direct steps North South East West.
	 *
	 * You can compute the manhanttan distance with this formula
        * distance = |x1 - x2| + |y1 - y2|
	 * 
	 * Unmarked cells should be filled with a period '.'
	 * 
	 * For example, given row=1,col=1,distance 1
	 * .x........
	 * xxx.......
	 * .x........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * 
	 * For example, given row=1,col=6,distance 2
	 * .....xxx..
	 * ....xxxxx.
	 * .....xxx..
	 * ......x...
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........

	 * 
	 * @param row starting position row
	 * @param col starting position col
	 * @param distance
	 * @return new 10x10 char array with correct squares marked
	 */
	public static char[][] distanceArray(int row, int col, int distance) {
		
		int x0 = row;
		int y0 = col;
		char[][] solArray = new char[10][10];
		
		for (int i=0; i<10; i++) {
			for (int j=0; j<10; j++) {
				int x1 = i;
				int y1 = j;
				int distance1 = Math.abs(x0 - x1) + Math.abs(y0 - y1);
				if (distance1 <= distance) {
					solArray[i][j] = 'x';
				}
				else {
					solArray[i][j] = '.';
				}
			}
		}
		return solArray;
	}
	
	/**
	 * BONUS: Extra credit problem
	 * 
	 * Feel free to skip this one if you don't have time.
	 * It's a little harder.
	 * 
	 * You are given a map indicating the elevation of
	 * a small area like a desk.  A ball is placed on the desk.
	 * The ball will roll downhill going north south east or west.
	 *
	 * The ball always starts at position 1,1
	 *
	 * It will always choose the path of steepest descent.
	 * It will eventually come to rest when it is at a position
	 * where all neighboring positions are higher/equal.  
	 * Return the elevation of that position.
	 * 
	 * You can assume that map will be such that the ball
	 * will always come to rest without moving through an edge
	 * 
	 * You can assume there will always be one steepest
	 * position for the ball to go to
	 * 
	 * For example, in an array like this:
	 * 9999
	 * 9549
	 * 9999 yields 4
	 * The ball would start in 1,1 (5) rolls to 4 and stops
	 * 
	 * 99999999999
	 * 98711111199
	 * 96999999999
	 * 95444444399
	 * 99999999999 yields 4
	 * The ball starts at 8, follows steepest decent to 6
	 * Then at the first 4 there is no lower position so it
	 * stops
	 * 
	 * @param map map indicating elevation
	 * @return height where the ball stops
	 */
	public static int ballRestElevation(int[][] map) {
		
		int[] currentLocation = {1,1};
		int count = 0;
		
		while (true) {

			HashMap<int[], Integer> adjacent = new HashMap<>();
			for (int i = currentLocation[0] - 1; i < currentLocation[0] + 2; i++) {
				for (int j = currentLocation[1] - 1; j < currentLocation[1] + 2; j++) {
					if (j == currentLocation[1] || i == currentLocation[0]) {
						adjacent.put(new int[] { i, j }, map[i][j]);
					}
				}
			}
			for (int[] key : adjacent.keySet()) {
				if (map[key[0]][key[1]] < map[currentLocation[0]][currentLocation[1]]) {
					currentLocation[0] = key[0];
					currentLocation[1] = key[1];
					count++;
				}
			}
			if (count > 0) {
				count = 0;
				continue;
			}
			return map[currentLocation[0]][currentLocation[1]];
		}
	}

	private static void or() {
		// TODO Auto-generated method stub.
		
	}
}
