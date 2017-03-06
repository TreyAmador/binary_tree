package java_binarytree;
import java.io.FileNotFoundException;
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
 * Driver Class					Begins simulation
 * @author TreyAmador
 * @version 1.0
 */
public class Driver {

	/**
	 * The driver initializes reference, tree, and query objects
	 * @param args arguments from console
	 * @throws FileNotFoundException throws exception if files not found
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		PrintWriter pw = new PrintWriter("csis.txt");
		Xref reference = new Xref(pw);
		reference.createTable("hashtable.txt");
		
		ObjectBinaryTree tree = reference.createTree("getty.txt");
		tree.inTrav(tree.getRoot());
		
		Query query = new Query(tree,pw);
		query.queryUser();
		
		reference.queryHash();
		pw.close();
	}

}
