/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3Kamandulis;

import java.util.Arrays;
import java.util.List;
import static java.util.Objects.hash;
import laborai.studijosktu.MapADT;

/**
 *
 * @author pk
 */
public class MapKTUOA<K, V> implements MapADT<K, V> {
    private Entry<K, V>[] table;
    private int size = 0;
    private int numberOfCollisions = 0;
    
    public MapKTUOA(int capacity) {
        table = new Entry[capacity];
    }

    @Override
    public V put(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key or value is null in put(Key key, Value value)");
        }
        
        int location = findPosition(key, true);
        if(location == -1) {
            return null;
        }
        
        table[location] = new Entry<>(key, value);
        size++;
        return value;
    }
    
    private int findPosition(K key, boolean logCollision) { // Tiesinis destymas
        int index = Math.abs(hash(key)) % table.length;
        int index0 = index;
        if(logCollision && table[index] != null && !table[index].key.equals(key)) {
            numberOfCollisions++;
        }
        for(int i = 0; i < table.length; i++) {
            if(table[index] == null || (table[index].key != null && table[index].key.equals(key)) ) {
                return index;
            }
            i++;
            index = (index0 + i * hash2(key)) % table.length;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        Arrays.fill(table, null);
        size = 0;
    }

    @Override
    public String[][] toArray() {
        String[][] result = new String[table.length][];
        for(int i = 0; i < table.length; i++) {
            String[] list = new String[1];
            if(table[i] == null) {
                list[0] = "";
            } else {
                list[0] = table[i].toString();
            }
            result[i] = list;
        }
        return result;
    }

    @Override
    public V get(K key) {
        int location = findPosition(key, false);
        if(location == -1 || table[location] == null) {
            return null;
        }
        return table[location].value;
    }

    @Override
    public V remove(K key) {
        int location = findPosition(key, false);
        if(location == -1  || table[location] == null) {
            return null;
        }
        
        V result = table[location].value;
        table[location] = new Entry<>();
        
        return result;
    }

    @Override
    public boolean contains(K key) {
        int location = findPosition(key, false);
        return location != -1 && table[location] != null;
    }

    @Override
    public boolean containsValue(V value) {
        for(int i = 0; i < table.length; i++)
            if(table[i].value.equals(value))
                return true;
        return false;
    }

    private int hash2(K key) {
        return table.length - (Math.abs(key.hashCode()) % table.length);
    }

    @Override
    public int getAvarageChainLenght() {
        return 1;
    }

    @Override
    public int getEmptyChainCount() {
        int result = 0;
        for(int i = 0; i < table.length; i++)
            if(table[i] == null)
                result++;
        return result;
    }
    
    @Override
    public int getTableCapacity() {
        return table.length;
    }
    
    @Override
    public int getNumberOfCollisions() {
        return numberOfCollisions;
    }

    @Override
    public List<V> values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    class Entry<K, V> {
        public K key;
        public V value;
        
        public Entry() {};
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        
        @Override
        public String toString() {
            return key + "=" + value;
        }
    }
}
