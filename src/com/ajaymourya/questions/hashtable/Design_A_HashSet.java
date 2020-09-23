package com.ajaymourya.questions.hashtable;

import java.util.LinkedList;
import java.util.List;

class MyHashSet {
    private int numBuckets;
    private List<Integer>[] buckets;

    private int hashFunction(int key) {
        return key % numBuckets;
    }

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        numBuckets = 15000;
        buckets = new LinkedList[numBuckets];
    }

    public void add(int key) {
        int i = hashFunction(key);
        if (buckets[i] == null) buckets[i] = new LinkedList<>();
        if (buckets[i].indexOf(key) == -1)
            buckets[i].add(key);
    }

    public void remove(int key) {
        int i = hashFunction(key);
        if (buckets[i] == null) return;
        if (buckets[i].indexOf(key) != -1)
            buckets[i].remove(buckets[i].indexOf(key));
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int i = hashFunction(key);
        if (buckets[i] == null || buckets[i].indexOf(key) == -1) return false;
        return true;
    }
}
