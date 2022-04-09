/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amran.solution;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 *
 * @author Amran Hossain
 */
public class LRUCache {

    /**
     * Design a data structure that follows the constraints of a Least Recently
     * Used (LRU) cache.
     *
     * Implement the LRUCache class:
     *
     * LRUCache(int capacity) Initialize the LRU cache with positive size
     * capacity. int get(int key) Return the value of the key if the key exists,
     * otherwise return -1. void put(int key, int value) Update the value of the
     * key if the key exists. Otherwise, add the key-value pair to the cache. If
     * the number of keys exceeds the capacity from this operation, evict the
     * least recently used key. The functions get and put must each run in O(1)
     * average time complexity.
     *
     * Input ["LRUCache", "put", "put", "get", "put", "get", "put", "get",
     * "get", "get"] [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3],
     * [4]] Output [null, null, null, 1, null, -1, null, -1, 3, 4]
     *
     * Explanation LRUCache lRUCache = new LRUCache(2); lRUCache.put(1, 1); //
     * cache is {1=1} lRUCache.put(2, 2); // cache is {1=1, 2=2}
     * lRUCache.get(1); // return 1 lRUCache.put(3, 3); // LRU key was 2, evicts
     * key 2, cache is {1=1, 3=3} lRUCache.get(2); // returns -1 (not found)
     * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
     * lRUCache.get(1); // return -1 (not found) lRUCache.get(3); // return 3
     * lRUCache.get(4); // return 4
     *
     * @param args the command line arguments
     */
    private int capacity;
    private LinkedHashMap<Integer, Integer> map;
    private final boolean SORT_BY_ACCESS = true;
    private final float LOAD_FACTOR = 0.75F;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>(capacity, LOAD_FACTOR, SORT_BY_ACCESS);
    }

    public int get(int key) {
        Integer value = this.map.get(key);
        if (value == null) {
            value = -1;
        }
        return value;

    }

    public void put(int key, int value) {
        if (!this.map.containsKey(key)
                && this.map.size() >= this.capacity) {
            Iterator<Integer> it = this.map.keySet().iterator();
            it.next();
            it.remove();
        }
        this.map.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache c;

        // Starts empty.
        c = new LRUCache(2);
        assert c.get(1) == -1;

        // Below capcity.
        c = new LRUCache(2);
        c.put(1, 1);
        assert c.get(1) == 1;
        assert c.get(2) == -1;
        c.put(2, 4);
        assert c.get(1) == 1;
        assert c.get(2) == 4;

        // Above capacity, oldest is removed.
        c = new LRUCache(2);
        c.put(1, 1);
        c.put(2, 4);
        c.put(3, 9);
        assert c.get(1) == -1;
        assert c.get(2) == 4;
        assert c.get(3) == 9;

        // get renews entry
        c = new LRUCache(2);
        c.put(1, 1);
        c.put(2, 4);
        assert c.get(1) == 1;
        c.put(3, 9);
        assert c.get(1) == 1;
        assert c.get(2) == -1;
        assert c.get(3) == 9;

        // Double put does not remove due to capacity.
        c = new LRUCache(2);
        assert c.get(2) == -1;
        c.put(2, 6);
        assert c.get(1) == -1;
        c.put(1, 5);
        c.put(1, 2);
        assert c.get(1) == 2;
        assert c.get(2) == 6;
    }

}
