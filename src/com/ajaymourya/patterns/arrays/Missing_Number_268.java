class Solution {
    public int missingNumber(int[] nums) {
        int count = nums.length;
        int result = (count * (count + 1) ) / 2;
        for (int num : nums) {
            result -= num;
        }
        return result;
    }
}