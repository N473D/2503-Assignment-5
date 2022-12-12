package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.HashElement;
import model.WordCounter;

public class WordCounterApp {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		WordCounter test;
		System.out.print("Enter a txt file(no file type): ");
		String txt = in.next();
		File newFile = new File("res/" + txt + ".txt");
		int size = -1;
		while(size <= 0) {
			System.out.print("Enter size for the Hashtable: ");
			if (in.hasNextInt()) {
				size = Math.abs(in.nextInt());
				in.nextLine();
			} else {
				System.out.println("Bad Input Please try again: ");
			}
		}
		test = new WordCounter(size);
		Scanner file;

		HashElement hash = null;
		int num = 0;
		int unique = 0;
		int count = 0;
		String[] arr = null;
		String word = null;
		String temp = null;

		try {
			file = new Scanner(newFile);
			while (file.hasNext()) {
				temp = file.next();
				temp = temp.toLowerCase();
				hash = new HashElement(temp);
				hash.setCount(1);
				test.put(hash);

				arr = temp.split("");
				count++;
				for (int i = 0; i < arr.length; i++) {
					if (arr[i].compareTo(temp) == 1) {
						unique++;
					}
				}
			}
			unique = count - unique;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(test.most());
		System.out.println("Total Words: " + test.countWords());
		System.out.println("Total Unique Words: " + test.uniqueWords());
		test.printTable();
	}
}
