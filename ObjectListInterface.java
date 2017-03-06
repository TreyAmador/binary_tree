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
 * ObjectList Interface			List implemented by ObjectList
 * @author TreyAmador
 * @version 1.0
 */
public interface ObjectListInterface {
	public ObjectListNode getFirstNode();
	public ObjectListNode getLastNode();
	public Object getFirst();
	public Object getLast();
	public void addFirst(Object o);
	public void addFirst(ObjectListNode p);
	public void addLast(Object o);
	public void addLast(ObjectListNode p);
	public Object removeFirst();
	public Object removeLast();
	public void insertAfter (ObjectListNode p, Object o);
	public void insertAfter(ObjectListNode p, ObjectListNode q);
	public Object deleteAfter(ObjectListNode p);
	public void insert(Object o);
	public void insert(ObjectListNode r);
	public Object remove(Object o);
	public boolean contains(Object o);
	public ObjectListNode select(Object o);
	public boolean isEmpty();
	public void clear();
	public int size();
	public ObjectList copyList();
	public void reverse();
}