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
 * ObjectBinaryTree Class		Binary tree which stores objects
 * @author TreyAmador
 * @version 1.0
 */
public class ObjectBinaryTree implements ObjectBinaryTreeInterface {

	private ObjectTreeNode root;
 
 /**
  * default ctor
  * initializes root of tree to null
  */
 public ObjectBinaryTree() {
     root = null;
 }
 
 /**
  * getter for root of tree
  * @return the root, or first node, of tree
  */
 public ObjectTreeNode getRoot() {
     return root;
 }
 
 /**
  * sets left node relative to parent node
  * @param parent the node to which the left node will be attached
  * @param r the node to be placed to the left of the parent
  */
 public void setLeftChild(ObjectTreeNode parent, ObjectTreeNode r) {
     if (parent == null || parent.getLeft() != null) {
         System.out.println("Runtime Error: setLeftChild()");
         System.exit(1);
     }
     parent.setLeft(r);
 }
 
 /**
  * sets right node relative to parent node
  * @param parent the node to which the right node will be attached
  * @param r the node to be placed to the right of the parent
  */
 public void setRightChild(ObjectTreeNode parent, ObjectTreeNode r){
     if (parent == null || parent.getRight() != null) {
         System.out.println("Runtime Error: setRightChild()");
         System.exit(1);
     }
     parent.setRight(r);
 }

 /**
  * inserts a parameter object into the correct node
  * based on info in comparable function
  * @param o the object to be inserted into a node in the binary tree
  */
 public void insertBST(Object o) {
     ObjectTreeNode p, q;
             
     ObjectTreeNode r = new ObjectTreeNode(o);
     if (root == null)
         root = r;
     else {
         p = root;
         q = root;
         while (q != null) {
             p = q;
             if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0 )
                 q = p.getLeft();
             else
                 q = p.getRight();
         }
         if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0)
             setLeftChild(p, r);
         else
             setRightChild(p, r);
     }
 }

 /**
  * inserts parameter object into correct node
  * accounts for duplicates by not inserted repetitive nodes
  * but modifies existing node based on some criteria in operate function
  * @param o the object to be compared to other nodes or inserted in tree
  */
 public void insertBSTDup(Object o) {
     ObjectTreeNode p, q;
             
     ObjectTreeNode r = new ObjectTreeNode(o);
     if (root == null)
         root = r;
     else {
         p = root;
         q = root;
         while (q != null && ((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) != 0) {
             p = q;
             if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0)
                 q = p.getLeft();
             else
                 q = p.getRight();
         }
         if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0)
             setLeftChild(p, r);
         else if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) > 0)
             setRightChild(p, r);
         else ((TreeComparable)(p.getInfo())).operate((TreeComparable)(r.getInfo()));
     }
 }
 
 /**
  * search the tree for an object comparable to parameter object
  * @param o the object to be found in the tree
  * @return the node if found or null if not found
  */
 public ObjectTreeNode searchBST(Object o) {
     ObjectTreeNode p;
             
     ObjectTreeNode r = new ObjectTreeNode(o);
     if(root != null) {
         p = root;
         while (p != null) {
             if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0)
                 p = p.getLeft();
             else if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) > 0)
                 p = p.getRight();
             else 
                 return p;
         }
     }
     return null;
 }

 /**
  * traverses the tree in prefix order
  * gets info at each node
  * @param tree the tree to be traversed
  */
 public void preTrav(ObjectTreeNode tree) {
     if (tree != null) {
         ((TreeComparable)tree.getInfo()).visit();
         preTrav(tree.getLeft());
         preTrav(tree.getRight());
     }
 }
 
 /**
  * traverses the tree in infix order
  * gets info at each node
  * @param tree the tree to be traversed
  */
 
 public void inTrav(ObjectTreeNode tree) {
     if (tree != null) {
         inTrav(tree.getLeft());
         ((TreeComparable)tree.getInfo()).visit();
         inTrav(tree.getRight());
     }
 }
 
 /**
  * traverses the tree in postfix order
  * gets info at each node
  * @param tree the tree to be traversed
  */
 
 public void postTrav(ObjectTreeNode tree) {
     if (tree != null) {
         postTrav(tree.getLeft());
         postTrav(tree.getRight());
         ((TreeComparable)tree.getInfo()).visit();
     }
 }
}