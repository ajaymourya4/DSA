package com.ajaymourya.questions.arrays;


class MoveZeroes1 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int insertPos = 0;
        for (int n : nums) {
            if (n != 0)
                nums[insertPos++] = n;
        }
        while (insertPos < nums.length)
            nums[insertPos++] = 0;
    }
}

class MoveZeroes2 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                k++;
            }
        }
    }
}
