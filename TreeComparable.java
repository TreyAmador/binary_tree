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
 * TreeComparable Interface		Interface implemented in Word class
 * @author TreyAmador
 * @version 1.0
 */
public interface TreeComparable {
	public int compareTo(TreeComparable treeComparable);
	public void operate(TreeComparable treeComparable);
	public void visit();
}
