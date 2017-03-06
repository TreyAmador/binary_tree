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
 * ObjectBinaryTree Interface	Binary tree interface implemented by binary tree
 * @author TreyAmador
 * @version 1.0
 */
public interface ObjectBinaryTreeInterface {
	public ObjectTreeNode getRoot();
	public void setLeftChild(ObjectTreeNode parent, ObjectTreeNode r);
	public void setRightChild(ObjectTreeNode parent, ObjectTreeNode r);
	public void insertBST(Object o);
	public void insertBSTDup(Object o);
	public ObjectTreeNode searchBST(Object o);
	public void preTrav(ObjectTreeNode tree);
	public void inTrav(ObjectTreeNode tree);
	public void postTrav(ObjectTreeNode tree);
}
