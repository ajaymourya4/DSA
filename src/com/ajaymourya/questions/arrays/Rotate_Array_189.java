package com.ajaymourya.questions.arrays;

class RotateArray {

    // Brute force solution
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int move = 0;
        while (move < k) {
            int lastElement = nums[nums.length - 1];
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = lastElement;
            move++;
        }
    }



    // Optimised solution
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
