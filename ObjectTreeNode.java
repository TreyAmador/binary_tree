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
 * ObjectTreeNode Class			Node on the binary tree which stores object
 * @author TreyAmador
 * @version 1.0
 */
 public class ObjectTreeNode implements ObjectTreeNodeInterface {

 private Object info;
 private ObjectTreeNode left;
 private ObjectTreeNode right;
 
 /**
  * default ctor initializes info and left and right pointers to null
  */
 public ObjectTreeNode() {
     info = null;
     left = null;
     right = null;
 }
 
 /**
  * one param ctor places object into info field with no reference to pointers
  * @param o object placed in a node, no pointers assigned
  */
 public ObjectTreeNode (Object o) {
     info = o;
     left = null;
     right = null;
 }
 
 /**
  * setter for the info in the object parameter
  * @param o the object to be set in a specific node in the tree
  */
 public void setInfo(Object o) {
     info = o;
 }
 
 /**
  * returns the info object stored in the node
  * @return the info of the object at the node
  */
 public Object getInfo() {
     return info;
 }
 
 /**
  * sets the left pointer to parameter node relative to calling node
  * @param p the tree node which occupies left pointer
  */
 public void setLeft(ObjectTreeNode p) {
     left = p;
 }
 
 /**
  * getter for the left node of the tree relative to calling node
  * @return the left tree node
  */
 public ObjectTreeNode getLeft() {
     return left;
 }
 
 /**
  * sets the right pointer to parameter node relative to calling node
  * @param p the tree node to be set to the right pointer
  */
 public void setRight(ObjectTreeNode p) {
     right = p;
 }
 
 /**
  * getter for the right node of the tree relative to calling node
  * @return the right tree node
  */
 public ObjectTreeNode getRight() {
     return right;
 }
}