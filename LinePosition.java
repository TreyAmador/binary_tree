package java_binarytree;
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
 * LinePosition Class			The line number and position of a given word object
 * @author TreyAmador
 * @version 1.0
 */
public class LinePosition implements Comparable {

	private int line, position;
	
	/**
	 * two arg ctor sets the line and position of a given word
	 * @param line the line in which the word is found
	 * @param position the position within a line in which the word is found
	 */
	public LinePosition(int line, int position){
		this.line = line;
		this.position = position;
	}
	
	/**
	 * returns the line of a given word
	 * @return the line wherein the calling word is found
	 */
	public int getLine(){
		return line;
	}
	
	/**
	 * returns the position with a line of a given word
	 * @return the position within a line wherein calling word is found
	 */
	public int getPosition(){
		return position;
	}
	
	/**
	 * compares calling line position with parameter object line position
	 * @param info the line to be compared to
	 * @return returns 1 if lefthand line is greater, -1 if less than, 0 if equal
	 */
	@Override
	public int compareTo(Object info) {
		
		LinePosition linePos = (LinePosition)info;
		if( line > linePos.getLine() )
			return 1;
		else if( line < linePos.getLine() )
			return -1;
		else if( position > linePos.getPosition() )
			return 1;
		else if( position < linePos.getPosition() )
			return -1;
		else
			return 0;
	}
}