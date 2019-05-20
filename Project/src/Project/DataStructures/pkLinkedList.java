/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.DataStructures;

import Project.Interfaces.IpkLinkedList;

/**
 *
 * @author pk
 */
public class pkLinkedList<K, E> implements IpkLinkedList<K, E> {
    private Node<K, E> root;
    private Node<K, E> current;
    
    @Override
    public E get(K key) {
        current = root;
        while(current != null) {
            if(current.key.equals(key)){
                return current.data;
            }
            current = current.next;
        }
        return null;
    }
    
    @Override
    public void add(K key, E element) {
        current = root;
        if(current == null) {
            root = new Node<K, E>(key, element);
            return;
        }
        
        while(true) {
            if(current.data == null || current.key.equals(key)) {
                current.data = element;
                return;
            } else if(current.next == null) {
                current.next = new Node<K, E>(key, element);
                return;
            }
            current = current.next;
        }
    }
    
    @Override
    public E remove(K key) {
        current = root;
        if(current == null) return null;
        // First element
        if(current.key.equals(key)) {
            root = current.next;
            return current.data;
        }
        //Others
        Node<K, E> previous = root;
        while(current.next != null) {
            previous = current;
            current = current.next;
            if(current.key.equals(key)){
                previous.next = current.next;
                return current.data;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        String result = "";
        current = root;
        while(current != null) {
            result += "\n -> [" + current.key.toString() + " : " + current.data.toString().replace("\n", "") + "]";
            current = current.next;
        }
        return result;
    }
    
    class Node<K, E> {
        public Node next;
        public E data;
        public K key;
        
        public Node(K key, E element) {
            this.key = key;
            data = element;
        }
    }
}
