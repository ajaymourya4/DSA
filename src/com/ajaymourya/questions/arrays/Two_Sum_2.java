package com.ajaymourya.questions.arrays;

class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] index = new int[2];
        int start = 0, end = numbers.length - 1;
        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum == target) {
                index[0] = start + 1;
                index[1] = end + 1;
                break;
            } else if (sum > target)
                end--;
            else
                start++;
        }
        return index;
    }
}

/**
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
