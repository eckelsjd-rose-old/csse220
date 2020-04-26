

public class RecursionProblems {
	
	/*
	 * findAndMoveCharToFront(s, c) - takes String s and char c and
	 * returns a new String with c moved from its original location
	 * to the front of the String, all other characters in s remain the same
	 * 
	 * If c does not appear in s, then the original String s is returned	 
	 * If multiple copies of c appear in s, then the c with the smallest
	 * index is moved to the front
	 * 
	 * Don't use indexOf or other string methods that lets you search a string 
	 * for a particular value
	 * 
	 * You may want to use a helper operation to solve this problem
	 * 
	 * Examples: findAndMoveCharToFront("abcaXbyzX", 'X') produces "XabcabyzX"
	 * See JUnit test scripts for more examples
	 */
	
	static String findAndMoveCharToFront(String s, char c) {
		
		if (s.charAt(0) == c) {
			return findHelper(s);
		}
		
		return findAndMoveCharToFront(s.substring(1), c);
	}
	
	static String findHelper(String s) {
		
		if (s.length() == 0) {
			return "";
		}
		
		return s.charAt(0) + findHelper(s.substring(1));
	}
	
	// I felt like I was pretty close to a solution here. If you check out the tests
	// the only thing I'm missing are the letters from the beginning of the string, up to 
	// the letter we are searching for. I couldn't find a way to account for these letters.
	// The rest of my idea seems to work out.

}
