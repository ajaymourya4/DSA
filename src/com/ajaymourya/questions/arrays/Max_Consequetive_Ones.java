package com.ajaymourya.questions.arrays;

class MaxConsequetiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0, k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                k++;
            } else {
                k = 0;
            }
            if (maxCount < k)
                maxCount = k;
        }
        return maxCount;
    }
}
