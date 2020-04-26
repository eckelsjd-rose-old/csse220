import java.util.List;

public class Recursion {

	/**
	 * 
	 * Takes two parameters s1 and s2 of type List<Integer> The integers in s1
	 * and s2 appear in non-decreasing order
	 * 
	 * Returns one int[] containing all the integers from s1 and s2 in
	 * non-decreasing order Your can modify s1 and s2 if you want and my
	 * solution leaves s1 and s2 empty.
	 * 
	 * You will want to use a helper function for this one.
	 * 
	 * See RecursionTest.java for 5 example calls
	 *
	 */
	public static int[] join(List<Integer> s1, List<Integer> s2) {
		int[] result = new int[s1.size() + s2.size()];
		int i = 0;
		int j = 0;
		int k = 0;
		return joinHelper(result, s1, s2, i, j, k);
		// return result;

	}

	static int[] joinHelper(int[] result, List<Integer> s1, List<Integer> s2, int i, int j, int k) {

		if (k == s1.size() + s2.size()) {
			return result;
		}

		if (i < s1.size() && j < s2.size()) {
			result[k] = (s1.get(i) > s2.get(j)) ? s2.get(j) : s1.get(i);
			if (result[k] == s2.get(j)) {
				// System.out.printf("i = " + i + " j = " + j + " k = " + k + "
				// Result %d = %d" + '\n',k, result[k]);
				return joinHelper(result, s1, s2, i, j + 1, k + 1);
			} else {
				// System.out.printf("i = " + i + " j = " + j + " k = " + k + "
				// Result %d = %d" + '\n',k, result[k]);
				return joinHelper(result, s1, s2, i + 1, j, k + 1);
			}

		}

		if (i == s1.size()) {
			result[k] = s2.get(j);
			// System.out.printf("i = " + i + " j = " + j + " k = " + k + "
			// Result %d = %d" + '\n',k, result[k]);
			return joinHelper(result, s1, s2, i, j + 1, k + 1);

		}
		if (j == s2.size()) {
			result[k] = s1.get(i);
			// System.out.printf("i = " + i + " j = " + j + " k = " + k + "
			// Result %d = %d" + '\n',k, result[k]);
			return joinHelper(result, s1, s2, i + 1, j, k + 1);
		}

		return result;

	}

	// Took a completely different approach to this problem; i, j, and k
	// represent 3 indices, one for both of the input
	// lists and one for a new result list. Compared each list value and
	// selected
	// the appropriate one. Depending on which one was
	// selected, the indices were adjusted differently. Recursively filled the
	// result list until index k reached its max value.
	// **************************************************************

	/**
	 * 
	 * Takes a string s and and a character c
	 * 
	 * Returns the index of the last location that c appears in s
	 * 
	 * This solution does not require a helper function but you may find it
	 * handy to use one.
	 * 
	 * If c is not in s, then returns -1
	 * 
	 * See RecursionTest.java for 6 example calls
	 */
	public static int lastLocation(String s, char c) {
		if (s.length() == 0) {
			return -1;
		}
		return lastHelper(s, c, 0, 0, false);
	}

	public static int lastHelper(String s, char c, int index, int max, boolean containsC) {
		if (index == s.length() && !containsC) {
			return -1;
		}
		if (index == s.length()) {
			return max;
		}
		if (s.charAt(index) == c) {
			max = index;
			containsC = true;
		}
		return lastHelper(s, c, index + 1, max, containsC);
	}
	// **************************************************************

	/**
	 * 
	 * Takes two parameters, subString and huntingGround
	 * 
	 * Returns the count of the max number of times that subString appears
	 * consecutively (i.e., back-to-back) in string huntingGround
	 * 
	 * You will want to use a helper function for this one.
	 * 
	 * e.g. "XX" and "qXXXXqXX" returns 2 because the first XXXX is two
	 * repetitions and the second XX is one repetition
	 * 
	 * See RecursionTest.java for 9 example calls
	 */
	public static int countConsequtiveTimesSubstringAppears(String subString, String huntingGround) {
		int count = 0;
		int maxCount = 0;
		if (subString.length() == 0 || huntingGround.length() == 0) {
			return 0;
		}
		return countHelper(subString, huntingGround, 0, 0, count, maxCount);
	}

	public static int countHelper(String subString, String huntingGround, int indexSub, int indexHunt, int count,
			int maxCount) {
		if (indexSub >= subString.length()) {
			if (count == maxCount) {
				maxCount++;
			}
			return countHelper(subString, huntingGround, 0, indexHunt, count + 1, maxCount);
		}
		if (indexHunt == huntingGround.length()) {
			return maxCount;
		}
		if (huntingGround.charAt(indexHunt) == subString.charAt(indexSub)) {
			return countHelper(subString, huntingGround, indexSub + 1, indexHunt + 1, count, maxCount);
		}
		return countHelper(subString, huntingGround, 0, indexHunt + 1, 0, maxCount);

	}
	// Finished implementation of this one: had a few bugs but generally same
	// format. Needed to track the maxCount
	// somehow, as well as reset the count when a match is not found. Also
	// needed to catch if either of the strings were
	// empty.
	// **************************************************************

	/**
	 * Takes two int parameters, x and logX
	 * 
	 * Returns true iff log2(x) = logX Where log2 means log base 2 eg
	 * isExactlyLog2Of(8,3) returns true because 2^3 = 8
	 * 
	 * See RecursionTest.java for 4 example calls
	 */
	public static boolean isExactLog2Of(int x, int logX) {
		return logHelper(x, 0) == logX;
	}

	public static int logHelper(int x, int count) {
		if (x / 2 == 1) {
			return count + 1;
		}
		return logHelper(x / 2, count + 1);
	}
	// This problem still would have been way easier if it was not recursive.
	// But here is a recursive
	// implementation of the solution. Just needed to count the number of times
	// x was divided by 2 and compare
	// it to logX.
}
