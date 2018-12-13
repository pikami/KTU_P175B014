package Project.Interfaces;

/**
 *
 * @author pk
 */

public interface IpkHashTable<K, E> {
    // Adds element to hash table
    void add(K key, E e);
    
    // Returns the element given a key
    E get(K key);
    
    // Remove element and return it
    E remove(K key);
}
