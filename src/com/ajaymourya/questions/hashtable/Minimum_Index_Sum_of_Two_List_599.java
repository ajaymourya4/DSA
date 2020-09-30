package com.ajaymourya.questions.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class MinimumIndexSumTwoList {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        int minIndexSum = Integer.MAX_VALUE;
        int sum;
        for (int index = 0; index < list1.length; index++) {
            map.put(list1[index], index);
        }
        for (int index = 0; index < list2.length; index++) {
            if (map.containsKey(list2[index])) {
                sum = map.get(list2[index]) + index;
                if (sum < minIndexSum) {
                    result.clear();
                    minIndexSum = map.get(list2[index]) + index;
                    result.add(list2[index]);
                } else if (sum == minIndexSum)
                    result.add(list2[index]);
            }
        }
        return result.toArray(new String[result.size()]);
    }
}
