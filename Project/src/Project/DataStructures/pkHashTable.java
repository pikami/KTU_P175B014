package Project.DataStructures;

import Project.Interfaces.IpkHashTable;
import Project.Interfaces.IpkLinkedList;

/**
 *
 * @author pk
 * @param <E>
 */

public class pkHashTable<K, E> implements IpkHashTable<K, E> {
    IpkLinkedList<K, E>[] Store;
    int StoreSize;

    public pkHashTable() {
        this(10);
    }
    
    public pkHashTable(int size) {
        StoreSize = size;
        @SuppressWarnings("unchecked") IpkLinkedList<K, E>[] hashtable = new pkLinkedList[StoreSize];
        Store = hashtable;
    }

    @Override
    public void add(K key, E e) {
        int index = getIndexFromHash(key.hashCode());
        if(Store[index] == null) {
            Store[index] = new pkLinkedList<K, E>();
        }
        Store[index].add(key, e);
    }
    
    @Override
    public E get(K key) {
        int index = getIndexFromHash(key.hashCode());
        if(Store[index] == null)
            return null;
        return Store[index].get(key);
    }
    
    @Override
    public E remove(K key) {
        int index = getIndexFromHash(key.hashCode());
        return Store[index].remove(key);
    }
    
    @Override
    public String toString() {
        String result = "";
        for(int i = 0; i < StoreSize; i++) {
            result += String.format("[%d]: %s\n", i, Store[i] != null ? Store[i].toString() : "");
        }
        return result;
    }
    
    private int getIndexFromHash(int hash) {
        return Math.abs(hash) % StoreSize;
    }
}
