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
 * ObjectListNode Interface		List node interface which implements ObjectListNode
 * @author TreyAmador
 * @version 1.0
 */
public interface ObjectListNodeInterface {
	public void setInfo(Object o);
	public Object getInfo();
	public void setNext(ObjectListNode p);
	public ObjectListNode getNext();
}
