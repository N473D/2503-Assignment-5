package model;

public class HashElement implements Comparable<String>{

private String word; //key for the hash table
private int count;
public HashElement(String word) {
	this.word = word;
	this.count = 0;
}
public String getWord() {
	return word;
}
public void setWord(String word) {
	this.word = word;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
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
public int textInt() {
	int count = 0;
	for (int i = 0; i < word.length(); i++) {
		count += word.charAt(i);
	}
	return count;
}
public int textQuadHash() {
	int count = 0;
	for (int i = 0; i < word.length(); i++) {
		count += word.charAt(i) * (2^(word.length() - i));
	}
	return count;
}

}
