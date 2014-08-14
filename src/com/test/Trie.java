package com.test;

/**
 * This class is the implementation of the Trie data structure with two operations
 * a) insert
 * b) search
 */
public class Trie implements TrieInterface{ 

	TrieNode root;
	
	/**
	 * Constructor: -> void
	 * Effect: Initializes the root of Trie 
	 */
	Trie()
	{
		root=new TrieNode();
	}
	
	/**
	 * insert: String -> void
	 * @param str: The String to insert in the Trie
	 * Effect: Inserts the given String in the Trie 
	 */
	public void insert(String str)
	{
		root.insert(str);
	}
	
	/**
	 * insert: String[] -> void
	 * @param str[] : The array of String to insert in Trie
	 * Effect: Inserts the given array of String in the Trie 
	 */
	public void insert(String[] str)
	{
		int strLen=str.length;
		for(int strCount=0;strCount<strLen;strCount++)
		{
			root.insert(str[strCount]);
		}
	}
	
	/**
	 * search: String -> String
	 * @param str : The String to search in the Trie
	 * @return bestMatch: Returns the best possible match for the given String
	 */
	public String search(String str) {
		// TODO Auto-generated method stub
		return root.search(str);
	}
}
