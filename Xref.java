package java_binarytree;
import java.io.File;
import java.io.FileNotFoundException;
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
 * Xref Class					References text documents and word inputs
 * @author TreyAmador
 * @version 1.0
 */
public class Xref {
	
	private Hash hash;
	private PrintWriter pw;
	
	/**
	 * single arg ctor which accepts printwriters
	 * @param pw printwriter which outputs text to file
	 */
	public Xref(PrintWriter pw){
		this.pw = pw;
	}
	
	/**
	 * Creates hash table for use in referencing excluded words
	 * @param fileName the file containing words to be excluded
	 * @throws FileNotFoundException exits if hashtable file not found
	 */
	public void createTable(String fileName) throws FileNotFoundException{
		
		Scanner fileScan = new Scanner(new File(fileName));
		hash = new Hash(pw);
		while (fileScan.hasNextLine()){
			hash.place(fileScan.nextLine().toLowerCase().trim());
		}
		fileScan.close();
	}
	
	/**
	 * 
	 * @param fileName, the name of the in which words will be placed in the tree
	 * @return newly constructed Object tree
	 * @throws FileNotFoundException which is thrown if file cannot be opened
	 */
	public ObjectBinaryTree createTree(String fileName) throws FileNotFoundException{
		
		ObjectBinaryTree tree = new ObjectBinaryTree();
		Scanner fileScan = new Scanner(new File(fileName));
		int line = 1;
		
		while(fileScan.hasNextLine()){
			
			String buffer = fileScan.nextLine();
			String[] tokens = buffer.toLowerCase().split("[ ]+");
			System.out.printf("%-3s %s\n", line, buffer);
			pw.printf("%-3s %s\r\n",line, buffer);
			
			for(int pos = 0; pos < tokens.length; pos++){
				char last = tokens[pos].charAt(tokens[pos].length()-1);
				while ( (last < 'a' || last > 'z') && tokens[pos].length() > 0 ){
					tokens[pos] = new String( tokens[pos].substring(0, tokens[pos].length()-1) );
					if(tokens[pos].length() > 0){
						last = tokens[pos].charAt(tokens[pos].length()-1);
					}
				}
				
				if( !tokens[pos].isEmpty() && !hash.find(tokens[pos]) )
					tree.insertBSTDup(new Word( tokens[pos], new LinePosition(line,pos+1), pw ));
			}
			line++;
		}
		System.out.println();
		pw.println();
		fileScan.close();
		
		return tree;
	}
	
	/**
	 * allows user to query values in hash
	 */
	public void queryHash(){
		hash.printHash();
	}
}