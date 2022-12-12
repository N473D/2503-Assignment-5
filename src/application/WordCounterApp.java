package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.HashElement;
import model.WordCounter;

/**
 * 
 * @author Gabriel Avinante & Nathan DeBliek
 * @version 1.0
 * Prompts user for a text file and counts overall words and repeated words
 * Last Modified: December 11 - added javadoc - Gabriel Avinante
 */
public class WordCounterApp {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		WordCounter test;
		System.out.print("Enter a txt file(no file type): "); //prompts user for file
		String txt = in.next();
		File newFile = new File("res/" + txt + ".txt");
		int size = -1;
		while(size <= 0) {
			System.out.print("Enter size for the Hashtable: ");//prompts user for size of the hashtable
			if (in.hasNextInt()) {
				size = Math.abs(in.nextInt());
				in.nextLine();
			} else {
				System.out.println("Bad Input Please try again: "); //input validation
			}
		}
		test = new WordCounter(size);
		Scanner file;

		HashElement hash = null;
		String temp = null;

		/*
		 * Reads the inputed file and adds the word strings into the hash table
		 */
		try {
			file = new Scanner(newFile);
			while (file.hasNext()) {
				temp = file.next();
				temp = temp.toLowerCase();
				hash = new HashElement(temp);
				hash.setCount(1);
				test.put(hash);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(test.most()); //prints the most reoccuring word
		System.out.println("Total Words: " + test.countWords()); //prints the total word count
		System.out.println("Total Unique Words: " + test.uniqueWords()); //prints the total amount of unique words
		//test.printTable(); //printed the hash table created
	}
}
