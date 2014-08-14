package com.test;

/**
 * Comments: This is the required Class & the main Class.
 * Approach: The approach is to build a Trie of the list of prefixes
 * 			 and then search for the prefixes of the given input String
 * 			 in this Trie.
 * 			 The reason I felt using Trie in this problem is, using Trie
 * 			 I was possible to make a initial ONE time setup, but the future
 * 			 operations incurred low running time.
 *           
 */

public class Test {
	
	Trie t;
	
	/**
	 * Constructor: -> void
	 * Effect: Initializes the Trie data structure
	 */
	Test()
	{
		t=new Trie();
	}
	
	/**
	 * setup: String[] -> void
	 * @param prefixList: The possible prefixes as an Array of Strings 
	 * 					  which will be inserted in the Trie.
	 * @Complexity: O(n) where n is equal to the total number of characters
	 * 				in all the Strings.
	 * Effect: Inserts the given array of String in the Trie.
	 */
	private void setup(String[] prefixList)
	{
		t.insert(prefixList);
	}
	
	
	/**
	 * findLongestPrefix: String -> String
	 * @param inputString: The String of which the longest prefix os to be found
	 * @return longestPrefix: The longext prefix of the given String
	 * @Complexity: There can be two cases 
	 * 
	 * a) Lucky case: Consider an example 
	 * Trie is built of ["ABC","ABCEFGHIJKLMN"]
	 * Suppose we provide "ABCD" as inputString. The algorithm will stop at "E" as this is a mismatch 
	 * and "ABC" will be returned since there is an endpoint at "C"
	 * In this case the complexity is O(h) where h is the height of the longest prefix
	 * 
	 * b) Unlucky case: Consider an example
	 * Trie is built of ["ABC","ABCEFGHIJKLMN"]
	 * Suppose we provide "ABCEFGHIJKLM" as inputString. The algorithm will stop at "M" as a possible
	 * prefix matches till M but there are no further characters in the inputString 
	 * and as "M" is not an endpoint in the Trie, this is not a valid prefix. 
	 * In this case the complexity if O(m) where m is the height of the longest POSSIBLE prefix.
	 *  
	 */
	private String findLongestPrefix(String inputString)
	{
		String longestPrefix=t.search(inputString);
		return longestPrefix;
	}
	
	public static void main(String[] args)
	{
		String[] prefixList=new String[]{"abc","abcd","abcdde"};
		Test t=new Test();
		t.setup(prefixList);
		System.out.println(t.findLongestPrefix("abcd"));
	}
}
