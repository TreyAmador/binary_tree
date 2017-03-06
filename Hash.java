package java_binarytree;
import java.io.PrintWriter;
/**
 * Project Title:				Binary Tree and Hashing
 * Project Description:			Organizes words from an input file into a binary tree
 * 								Allows user to query to find words
 * 								Certain words placed on hash table are ignored
 * Version or Date:				8 May 2016
 * How to Start the Project:	Run Driver, ensure getty.txt and hashtable.txt is in relevant folder
 * Author:						Trey Amador
 * StudentID:					010955903
 * User Instructions:			Check text files exist.
 * 								Run Driver, watch for output in console window
 * Hash Class					A hash table which stores words that will not be included in output
 * @author TreyAmador
 * @version 1.0
 */
public class Hash {
	
	//hash table, size, sentinel values, etc...
	private String[] hash;
	private static final int HASH_SIZE = 37;
	private static final String SENTINEL = "??????????";
	private int collisions;
	private PrintWriter pw;
	
	//uses table of values which correspond to specific letters
	//inspired by a derivation of Pearson hashing
	private static int[] valueTable = {	
										14, 12, 20, 24, 11, 3, 
										9, 18, 21, 1, 13, 15, 2, 
										17, 22, 8, 16, 4, 6, 25, 
										23, 0, 10, 19, 7, 5
									  };
	
	/**
	 * Hash constructor initializes hash table with empty string elements
	 * initializes collision counter
	 */
	public Hash(){
		hash = new String[HASH_SIZE];
		for(int i = 0; i < HASH_SIZE; i++){
			hash[i] = new String("");
		}
		collisions = 0;
	}
	
	/**
	 * on arg ctor accepts printwriter for output to csis.txt
	 * @param pw printwriter to output to text file
	 */
	public Hash(PrintWriter pw){
		hash = new String[HASH_SIZE];
		for(int i = 0; i < HASH_SIZE; i++){
			hash[i] = new String("");
		}
		collisions = 0;
		this.pw = pw;
	}
	
	/**
	 * places each element in hash array based on function
	 * @param element the element to be quantified, in this case a String
	 */
	public void place(String element){
		int key = function(element);
		while( !hash[key].equals("") || hash[key].equals(SENTINEL)){
			key = probe(key);
			collisions++;
		}
		hash[key] = element;
	}
	
	/**
	 * determines if word is found in hash table
	 * @param element, the element corresponding to key to be found
	 * @return boolean representing if char is found or not
	 */
	public boolean find(String element){
		int key = function(element);
		int iterations = 0;
		
		while(iterations < HASH_SIZE){
			
			if(hash[key].equals(element))
				return true;
			else if( hash[key].equals("") || hash[key].equals(SENTINEL) )
				return false;
			
			key = probe(key);
			iterations++;
		}
		return false;
	}
	
	/**
	 * element to be deleted from hash table
	 * places sentinel in its place
	 * @param element the element to be deleted
	 */
	public void delete(String element){
		int key = function(element);
		int iterations = 0;
		while(!hash[key].equals(SENTINEL) && iterations < HASH_SIZE ){
			if(hash[key].equals(element)){
				hash[function(element)] = SENTINEL;
			}
			else if (!hash[key].equals(SENTINEL)){
				key = probe(key);
			}
			iterations++;
		}
	}
	
	/**
	 * hash function that finds key based on parameter String
	 * @param element the String to be calculated
	 * @return the key value, without linear probing
	 */
	public int function(String element){
		int key = 0;
		for(int i = 0; i < element.length(); i++){
			key += valueTable[element.charAt(i)-'a'];
		}
		return key % HASH_SIZE;
	}
	
	/**
	 * provides linear probing by incrementing key, dividing by hash size if out of bounds
	 * @param key the key value which serves and index in hash array
	 * @return the incremented key value
	 */
	public int probe(int key){
		return (key++) % HASH_SIZE;
	}
	
	/**
	 * returns the number of collisions in hash table
	 * @return the number of collisions in hash function
	 */
	public int getCollisionCount(){
		return collisions;
	}
	
	/**
	 * prints each key-value pair of the hash table, along with a description of the hash function
	 */
	public void printHash(){
		
		System.out.println("\nHash table:");
		pw.println("\r\nHash table:");
		
		for(int i = 0; i < HASH_SIZE; i++){
			System.out.println(i + " " + hash[i]);
			pw.println(i + " " + hash[i]);
		}
		System.out.println("\nCollisions: " + collisions);
		pw.println("\r\nCollisions: " + collisions);
		
		System.out.println("This hash function worked by treating each character in the \n"
				+ "address as an index into a table with randomly generated values. \n"
				+ "These values were summed, and mod 37 was taken.\n"
				+ "This was inspired by a derivation of Pearson hashing");
		pw.println("This hash function worked by treating each character in the \r\n"
				+ "address as an index into a table with randomly generated values. \r\n"
				+ "These values were summed, and mod 37 was taken.\n"
				+ "This was inspired by a derivation of Pearson hashing");
	}
}