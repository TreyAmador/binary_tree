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
 * Word Class					A Word class which contains a word string and its position in the text
 * @author TreyAmador
 * @version 1.0
 */
public class Word implements TreeComparable {
	
	//Word, word count, list containing position info
	private String word;
	private int count;
	private ObjectList list;
	private PrintWriter pw;
	
	/**
	 * default constructor chooses arbitrary values to initialize
	 */
	public Word(){
		this.word = "";
		this.count = 1;
		this.list = new ObjectList();
	}
	
	/**
	 * one arg ctor intiializes words, assumes single count
	 * @param word to be placed in list
	 */
	public Word(String word){
		this.word = word;
		this.count = 1;
		this.list = new ObjectList();
	}
	
	/**
	 * two arg ctor initializes word to param, a count of one at given position
	 * @param word a string which contains word of interest
	 * @param position the position of the words in an ObjectList
	 */
	public Word(String word, LinePosition position){
		this.word = word;
		count = 1;
		this.list = new ObjectList();
		list.insert(position);
	}
	
	/**
	 * three arg ctor initializes word to param, a count of one at given position
	 * @param word a string which contains word of interest
	 * @param position the position of the words in an ObjectList
	 * @param pw the PrintWriter which commits text to file
	 */
	public Word(String word, LinePosition position, PrintWriter pw){
		this.word = word;
		count = 1;
		this.list = new ObjectList();
		list.insert(position);
		this.pw = pw;
	}
	
	
	/**
	 * sets a new word
	 * here for completeness
	 * @param word to be reset to
	 */
	public void setWord(String word){
		this.word = word;
	}
	
	/**
	 * returns String representation of word to be stored
	 * @return returns String word stored in Word object
	 */
	public String getWord(){
		return word;
	}
	
	/**
	 * getter for word count
	 * @return count of current word in text
	 */
	public int getCount(){
		return count;
	}
	
	/**
	 * increments the count of a word
	 */
	public void incrementCount(){
		count++;
	}
	
	/**
	 * getter for list containing word position info
	 * @return list containing position information
	 */
	public ObjectList getList(){
		return list;
	}
	
	/**
	 * gets the position of the first node in the list
	 * present for completeness
	 * @return the info of the first node in the list
	 */
	public LinePosition getLinePosition(){
		return (LinePosition)list.getFirstNode().getInfo();
	}
	
	/**
	 * compareTo compares calling word with word somwhere in tree
	 * @param treeComparable the tree with which to find position of word
	 * @return value indicating if word is found
	 */
	@Override
	public int compareTo(TreeComparable treeComparable) {
		return this.word.compareToIgnoreCase( ((Word)treeComparable).getWord() );
	}
	
	/**
	 * operate determines what to do if no comparable node is found
	 * @param treeComparable the tree with which to compare the calling list
	 */
	@Override
	public void operate(TreeComparable treeComparable) {
		list.insert( ((Word)treeComparable).getLinePosition() );
		count++;
	}
	
	/**
	 * outputs to the user the word and line position information of the binary tree 
	 */
	@Override
	public void visit() {
		
		System.out.printf( "%-12s %-2s", word, count);
		pw.printf( "%-12s %-2s", word, count );
		
		ObjectListNode p = list.getFirstNode();
		while ( p != null ){
			LinePosition linePos = (LinePosition)p.getInfo();
			System.out.print( "  " + linePos.getLine() + "-" + linePos.getPosition());
			pw.print( "  " + linePos.getLine() + "-" + linePos.getPosition());
			p = p.getNext();
		}
		
		System.out.println();
		pw.println();
	}
}