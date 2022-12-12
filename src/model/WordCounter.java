package model;

//
import java.lang.reflect.Array;
import java.util.Arrays;

public class WordCounter implements HashInterface<HashElement> {
	private HashElement[] hashStorage;

	@Override
	public int gethashCode(HashElement key) {
		return key.textQuadHash() % hashStorage.length;
	}

	@Override
	public void put(HashElement key) throws Exception {
		int used = 0;
		for (int i = 0; i < hashStorage.length; i++) {
			if (hashStorage[i] != null) {
				used++;
			} else {
				break;
			}
//			System.out.println(used);
		}
//		System.out.println(used);
		if (used == hashStorage.length) {
//			System.out.println("Full");
//			System.out.println(hashStorage);
			throw new Exception("Full Hashmap");
		}
		int counter = 0;
		while (true) {
			int index = (gethashCode(key) + (counter ^ 2)) % hashStorage.length;
			if (hashStorage[index] == null) {
				hashStorage[index] = key;
				break;
			} else if (hashStorage[index].compareTo(key.getWord()) == 0) {
				hashStorage[index].incrementCount();
				break;
			} else {
				counter++;
			}
		}
	}

	@Override
	public HashElement remove(HashElement key) {
		HashElement saver = null;
		int used = 0;
		for (int i = 0; i < hashStorage.length; i++) {
			if (hashStorage[i] != null) {
				used++;
			}
		}
		if (used == 0) {
//			System.out.println("Empty");
//			System.out.println(hashStorage);
			return null;
		}
		boolean found = false;
		int counter = 0;
//		System.out.println("checkpoint2");
		while (!found) {
//			System.out.println(counter);
			int index = (gethashCode(key) + (counter ^ 2)) % hashStorage.length;
//			System.out.println(index);
//			System.out.println(hashStorage[index]);
//			System.out.println(key);
			if (hashStorage[index] != null && hashStorage[index].compareTo(key.getWord()) == 0) {
//				System.out.println("checkpoint1");
				saver = hashStorage[index];
				hashStorage[index] = null;
				found = !found;
			}
			counter++;
		}
		return saver;
	}

	@Override
	public void reset() {
		this.hashStorage = new HashElement[hashStorage.length];
		for (int i = 0; i < hashStorage.length; i++) {
			hashStorage[i] = null;
		}

	}

	@Override
	public void printTable() {
		System.out.print("[ ");
		for (int i = 0; i < hashStorage.length; i++) {
			System.out.print(hashStorage[i]);
			if (i != hashStorage.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.print(" ]");
		System.out.println();
	}

	public HashElement[] getHashStorage() {
		return hashStorage;
	}

	public void setHashStorage(HashElement[] hashStorage) {
		this.hashStorage = hashStorage;
	}

	public WordCounter(int x) {
		this.hashStorage = new HashElement[x];
		for (int i = 0; i < hashStorage.length; i++) {
			hashStorage[i] = null;
		}
	}

	public int uniqueWords() {
		int count = 0;
		for (int i = 0; i < hashStorage.length; i++) {
			if (hashStorage[i] != null) {
				count++;
			} else {
//				System.out.println(count + ":" + i);
			}
		}
		return count;
	}

	public String most() {
		int most = 0;
		for (int i = 0; i < hashStorage.length; i++) {
			if (hashStorage[most] == null && hashStorage[i] != null) {
				most = i;
			} else if (hashStorage[i] != null && hashStorage[most] != null
					&& hashStorage[i].getCount() > hashStorage[most].getCount()) {
				most = i;
			}
		}
		return "Most frequent word: " + hashStorage[most].toString();
	}

	public int countWords() {
		int count = 0;
		for (int i = 0; i < hashStorage.length; i++) {
			if (hashStorage[i] != null) {
				count += hashStorage[i].getCount();
			}
		}
		return count;
	}

	@Override
	public String toString() {
		return "WordCounter [hashStorage=" + Arrays.toString(hashStorage) + "]";
	}
}
