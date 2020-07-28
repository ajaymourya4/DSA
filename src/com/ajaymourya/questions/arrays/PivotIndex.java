package com.ajaymourya.questions.arrays;

/*
 * https://leetcode.com/problems/find-pivot-index/
 *
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.
 * We define the pivot index as the index where the sum of all the numbers to the left of the index is equal to the sum of all the numbers to the right of the index.
 * If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
 *
 * Input: nums = [1,7,3,6,5,6]
 * Output: 3
 * Explanation: The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
 * Also, 3 is the first index where this occurs.
 * */

class PivotIndex {
    public int pivotIndex(int[] nums) {
        int sum = 0, leftSum = 0;
        for (int x : nums) sum += x;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i]) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}

/*
* -> find total sum
* -> iterate the array from start to end
*    -> if compare left sum equal to right sum
*       -> return index
*    -> calculate leftsum
* -> return -1
* */