package java_binarytree;
import java.io.PrintWriter;
import java.util.Scanner;
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
 * Query Class					Allows user to query certain words in Word tree
 * @author TreyAmador
 * @version 1.0
 */
public class Query {
	
	private ObjectBinaryTree tree;
	private PrintWriter pw;
	
	/**
	 * initializes the object binary tree
	 * @param tree the tree which holds the Word data
	 */
	public Query(ObjectBinaryTree tree){
		this.tree = tree;
	}
	
	/**
	 * two arg ctor initializes the object binary tree
	 * and printwriter for csis.txt
	 * @param tree the tree which holds the Word data
	 * @param pw for writing output to txt
	 */
	public Query(ObjectBinaryTree tree, PrintWriter pw){
		this.tree = tree;
		this.pw = pw;
	}
	
	/**
	 * inquires about words to be searched from user input
	 * outputs messages to console
	 */
	public void queryUser(){
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("\nWhich word would you like to find? Enter word: ");
		pw.print("\r\nWhich word would you like to find? Enter word: ");
		String userBuf;
		
		do{
			userBuf = keyboard.nextLine();
			pw.print(userBuf+"\n");
			Word queryWord = new Word(userBuf.trim());
			ObjectTreeNode node = tree.searchBST(queryWord);
			
			if(node != null){
				wordInfo((Word)node.getInfo());
			}
			else if( node == null && userBuf.toLowerCase().trim().charAt(0) != 'y' ){
				System.out.println("The word \"" + queryWord.getWord() + "\" has not been found.");
				pw.println("The word \"" + queryWord.getWord() + "\" has not been found.");
			}
			if(userBuf.toLowerCase().trim().charAt(0) != 'y'){
				System.out.print("Query another word, or press 'y' to exit: ");
				pw.print("Query another word, or press 'y' to exit: ");
			}
		} while(userBuf.trim().charAt(0) != 'y');
		
		System.out.println("Good bye!");
		pw.println("\r\nGood bye!");
		keyboard.close();
	}
	
	/**
	 * prints each word, along with number times word is found and positions in each line
	 * @param word the Word object to be printed
	 */
	public void wordInfo(Word word){
		
		ObjectListNode p = word.getList().getFirstNode();
		System.out.print("The word \"" + word.getWord() + "\" is found " + word.getCount() + " times at positions");
		pw.print("\r\nThe word " + word.getWord() + " is found " + word.getCount() + " times at positions");
		
		while (p != null){
			LinePosition pos = (LinePosition)(p.getInfo());
			System.out.print( " " + pos.getLine() + "-" + pos.getPosition() );
			pw.print( " " + pos.getLine() + "-" + pos.getPosition() );
			p = p.getNext();
		}
		
		System.out.println(".");
		pw.println(".");
	}
}