/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amran.solution;

import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author Amran Hossain
 *
 * Design a data structure that follows the constraints of a Least Recently Used
 * (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise
 * return -1. void put(int key, int value) Update the value of the key if the
 * key exists. Otherwise, add the key-value pair to the cache. If the number of
 * keys exceeds the capacity from this operation, evict the least recently used
 * key. The functions get and put must each run in O(1) average time complexity.
 *
 * Input ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get",
 * "get"] [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]] Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * Explanation LRUCache lRUCache = new LRUCache(2); lRUCache.put(1, 1); // cache
 * is {1=1} lRUCache.put(2, 2); // cache is {1=1, 2=2} lRUCache.get(1); //
 * return 1 lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1,
 * 3=3} lRUCache.get(2); // returns -1 (not found) lRUCache.put(4, 4); // LRU
 * key was 1, evicts key 1, cache is {4=4, 3=3} lRUCache.get(1); // return -1
 * (not found) lRUCache.get(3); // return 3 lRUCache.get(4); // return 4
 *
 */
interface Cache<K, V> {

    V get(K key);

    void put(K key, V value);
}

class Node<K, V> {

    K key;
    V value;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCacheWithGeneric<K, V> implements Cache<K, V> {

    private int capacity;
    private Map<K, Node<K, V>> map = new LinkedHashMap<>();
    private final boolean SORT_BY_ACCESS = true;
    private final float LOAD_FACTOR = 0.75F;
    Deque<Node<K,V>> deque = new LinkedList<>();

    public LRUCacheWithGeneric(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>(capacity, LOAD_FACTOR, SORT_BY_ACCESS);
    }

    @Override
    public V get(K key) {
        Node<K, V> result = map.get(key);
        if (null == result || null == result.value) {
            return null;
        }
        return result.value;
    }

    @Override
    public void put(K key, V value) {
        Node<K, V> result = map.get(key);
        if (result != null) {
            result.value = value;
            map.put(key, result);
            deque.remove(result);
            deque.addFirst(result);
            System.out.println("Updated frame " + key + " as " + value);
        } else {
            if (deque.size() == capacity) {
                Node<K, V> toRemove = deque.removeLast();
                map.remove(toRemove);
                System.out.println("Frame removed " + toRemove.key + " : " + toRemove.value);
            }
            Node<K, V> newNode = new Node(key, value);
            deque.addFirst(newNode);
            map.put(key, newNode);
            System.out.println("Frame added " + key + " : " + value);
        }
    }

    public static void main(String[] args) {
        Cache<Integer, Integer> lru = new LRUCacheWithGeneric<>(5);
        lru.get(2);
        lru.put(1, 11);
        lru.put(2, 22);
        lru.get(2);
        lru.put(3, 33);
        lru.put(4, 44);
        lru.put(5, 55);
        lru.get(2);
        lru.get(1);
        lru.put(6, 66);
    }

}
