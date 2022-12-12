package model;

/**
 * interface for hashes
 * @author Nathan DeBliek
 * @version 1.0
 * Last Modified: 2022/12/11 added javadoc Nathan
 */
public interface HashInterface<T> {
/**
 * gets the hash code for the hash element
 * @param key the hash element
 * @return the code
 */
int gethashCode(T key);

/**
 * puts a word into the hash table or counts it up
 * @param key the hash element
 * @throws Exception a full hash table
 */
void put(T key) throws Exception;

/**
 * removes an item from the hash table
 * @param key the time to remove
 * @return the removed item
 */
T remove(T key);

/**
 * resets all hash table elements to null
 */
void reset();

/**
 * prints the hash table
 */
void printTable();
}
