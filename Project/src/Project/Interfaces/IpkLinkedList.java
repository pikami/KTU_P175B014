package Project.Interfaces;

/**
 *
 * @author pk
 */

public interface IpkLinkedList<K, E> {
    // Adds element to hash table
    void add(K key, E element);
    
    // Returns the element given a key
    E get(K key);
    
    // Remove element and return it
    E remove(K key);
}
