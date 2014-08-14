package com.test;

/**
 * This class is the implementation of the TrieNode i.e. a single Node in Trie data structure
 * It also supports the same operations as Trie
 * a) insert
 * b) search
 */

public class TrieNode implements TrieInterface{

	TrieNode[] c;
	boolean isEnd=false;
	
	/**
	 * Constructor: -> void
	 * Effect: Initializes the TrieNode 
	 */
	TrieNode()
	{
		c=new TrieNode[26];
	}
	
	/**
	 * insert: String -> void
	 * @param str: The String to insert in the Trie
	 * Effect: Inserts the given String in the Trie 
	 */
	public void insert(String str)
	{
		int charVal=getCIndex(str,0);
		if(c[charVal]==null)
		{
			c[charVal]=new TrieNode();
		}
		
		if(str.length()>1)
		{
			c[charVal].insert(str.substring(1));
		}
		else
		{
			c[charVal].isEnd=true;
		}
	}

	/**
	 * search: String -> String
	 * @param str : The String to search in the Trie
	 * Approach: if the TrieNodes at particular level have the 0th character in String,
	 * the algorithm searches for further characters in the next level
	 * At a time when the last end is found, we insert that character in the result String,
	 * and backtrack from that point inserting every character at start as we know we had a valid end.
	 * @return bestMatch: Returns the best possible match for the given String
	 */
	public String search(String str)
	{
		if(str.length()==0)
			return "";
		
		StringBuilder currentString=new StringBuilder();
		int cIndex=getCIndex(str,0);
		if(c[cIndex]!=null)
		{
			//String returned from further characters than 0
			String nextString=c[cIndex].search(str.substring(1));
			//If nextString has something we append this OR if this index of rieNode is the end we append it.
			if(nextString.length()>0 || c[cIndex].isEnd==true)
			{
				currentString.insert(0,str.charAt(0));//insert this char
				currentString.append(nextString);//append further String
			}
		}
		return currentString.toString();
	}
	
	
	/**
	 * getCIndex: String, int -> int;
	 * @param str: The String of which a character is to be returned
	 * @param c: The index at which the character from the given String is to be returned
	 * @return index of the TrieNode for characted at index c in String str
	 */
	private int getCIndex(String str,int c)
	{
		int charVal=str.toUpperCase().charAt(c);
		return charVal-65;
	}
}
