package com.ajaymourya.questions.hashtable;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class ItersectionArrays {

    //Brute Force Solution
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hashSet = new HashSet<Integer>();
        Set<Integer> intersect = new HashSet<>();
        for (int num : nums1) {
            hashSet.add(num);
        }
        for (int num : nums2) {
            if (hashSet.contains(num))
                intersect.add(num);
        }
        int[] result = new int[intersect.size()];
        Iterator<Integer> it = intersect.iterator();
        int i = 0;
        while (it.hasNext()) {
            result[i] = it.next();
            i++;
        }
        return result;
    }

    //Optimal solution
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> hashSet = new HashSet<Integer>();
        Set<Integer> intersect = new HashSet<>();
        for (int num : nums1) {
            hashSet.add(num);
        }
        for (int num : nums2) {
            if (hashSet.contains(num))
                intersect.add(num);
        }
        int[] result = new int[intersect.size()];
        Iterator<Integer> it = intersect.iterator();
        int i = 0;
        while (it.hasNext()) {
            result[i] = it.next();
            i++;
        }
        return result;
    }
}
