package com.ajaymourya.questions.arrays;

/*
 * https://leetcode.com/problems/plus-one/
 *
 * Given a non-empty array of digits representing a non-negative integer, increment one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * */
class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] nums = new int[n + 1];
        nums[0] = 1;
        return nums;
    }
}

/*
 * -> iterate the array of digits from end
 *    -> if digits[end] < 9 increment digits[end] and return
 *       -> else set digits[end] to 0
 * -> create an array with incremented size by one than the original array
 * -> set array[0] = 1 to handle this case [9,9,9,9]
 * */