package com.ajaymourya.questions.hashtable;

import java.util.LinkedList;
import java.util.List;

class MyHashMap {

    private int numBuckets;
    private List<Pair>[] buckets;

    private int hashFunction(int key) {
        return key % numBuckets;
    }

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        numBuckets = 15000;
        buckets = new LinkedList[numBuckets];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int hashedKey = hashFunction(key);
        if (buckets[hashedKey] == null) {
            buckets[hashedKey] = new LinkedList<>();
            buckets[hashedKey].add(new Pair(key, value));
        }
        for (int idx = 0; idx < buckets[hashedKey].size(); idx++) {
            if (buckets[hashedKey].get(idx).key == key) {
                buckets[hashedKey].get(idx).value = value;
                return;
            }
        }
        buckets[hashedKey].add(new Pair(key, value));
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int hashedKey = hashFunction(key);
        if (buckets[hashedKey] == null) {
            return -1;
        }
        for (int idx = 0; idx < buckets[hashedKey].size(); idx++) {
            if (buckets[hashedKey].get(idx).key == key) {
                return buckets[hashedKey].get(idx).value;
            }
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int hashedKey = hashFunction(key);
        if (buckets[hashedKey] == null) {
            return;
        }
        for (int idx = 0; idx < buckets[hashedKey].size(); idx++) {
            if (buckets[hashedKey].get(idx).key == key) {
                buckets[hashedKey].remove(idx);
                return;
            }
        }
        return;
    }

    class Pair {
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
