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
 * ObjectListNode Class			List Node which stores word objects
 * @author TreyAmador
 * @version 1.0
 */
public class ObjectListNode implements ObjectListNodeInterface {
    
	//info field, field to next node
	private Object info;
    private ObjectListNode next;
    
    /**
     * Default constructor, sets info and next to null
     */
    public ObjectListNode() {
        info = null;
        next = null;
    }

    /**
     * One parameter constructor, sets info to Object and next to null
     * @param o, initializes new node to Object
     */
    public ObjectListNode (Object o) {
        info = o;
        next = null;
    }    
    
    /**
     * Two argument constructor, sets info and next fields to parameters
     * @param o, Object placed in info field
     * @param p, ObjectListNode placed in next field
     */
    public ObjectListNode (Object o, ObjectListNode p) {
        info = o;
        next = p;
    }       

    /**
     * Sets info field
     * @param o, Object placed in info field
     */
    public void setInfo(Object o) {
        info = o;
    }    

    /**
     * Returns object in info field
     * @return info, Object in info field
     */
    public Object getInfo() {
        return info;
    }

    /**
     * Sets next field
     * @param p, ObjectListNode set into next field
     */
    public void setNext(ObjectListNode p) {
        next = p;
    }

    /**
     * Returns object in info field
     * @return next, the ObjectListNode pointed at by current node
     */
    public ObjectListNode getNext() {
        return next;
    }
}