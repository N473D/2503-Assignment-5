package application;

import model.HashElement;
import model.WordCounter;

public class WordCounterApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordCounter test = new WordCounter(5);
		test.printTable();
		try {
			test.put(new HashElement("ONE"));
			test.put(new HashElement("TWO"));
			test.put(new HashElement("THREE"));
			test.put(new HashElement("FOUR"));
			test.put(new HashElement("FIVE"));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("fail");
		}
		test.printTable();
		System.out.println(test.remove(new HashElement("ONE")));
		test.printTable();
	}

}
