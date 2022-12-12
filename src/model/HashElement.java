package model;

/**
 * Element for hashing strings and counting instances of strings
 * 
 * @author Nathan DeBliek
 * @version 1.0 Last Modified: 2022/12/11 added javadoc Nathan
 */
public class HashElement implements Comparable<String> {

	private String word; // key for the hash table
	private int count;
	
	/**
	 * create a new element
	 * @param word word to count
	 */
	public HashElement(String word) {
		this.word = word;
		this.count = 0;
	}
	
	/**
	 * gets word
	 * @return the word
	 */
	public String getWord() {
		return word;
	}
	
	/**
	 * sets the word
	 * @param word the word
	 */
	public void setWord(String word) {
		this.word = word;
	}
	
	/**
	 * gets count
	 * @return the count of the word
	 */
	public int getCount() {
		return count;
	}
	
	/**
	 * sets count of the word
	 * @param count of the word
	 */
	public void setCount(int count) {
		this.count = count;
	}
	
	/**
	 * increments count
	 */
	public void incrementCount() {
		this.count++;
	}
	
	@Override
	public String toString() {
		return "HashElement [word=" + word + ", count=" + count + "]";
	}

	@Override
	public int compareTo(String o) {
		return word.compareTo(o);
	}
	
	/**
	 * sums up the characters in the word
	 * @return the words value numerically
	 */
	public int textInt() {
		int count = 0;
		for (int i = 0; i < word.length(); i++) {
			count += word.charAt(i);
		}
		return count;
	}
	
	/**
	 * uses a quadratic hash thing
	 * @return the quadratic hash number sum
	 */
	public int textQuadHash() {
		int count = 0;
		for (int i = 0; i < word.length(); i++) {
			count += word.charAt(i) * (2 ^ (word.length() - i));
		}
		return count;
	}
}
