class Solution {
     void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int zeroCount = 0;
        int oneCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else if (num == 1) {
                oneCount++;
            }
        }
        int i = 0;
        while (i < zeroCount) {
            nums[i] = 0;
            i++;
        }
        while (i < zeroCount + oneCount) {
            nums[i] = 1;
            i++;
        }
        while (i < nums.length) {
            nums[i] = 2;
            i++;
        }
    }

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int low = 0;
        int high = nums.length - 1;
        int medium = 0;
        int temp;
        while (medium <= high) {
            switch(nums[medium]) {
                case 0 : {
                    temp = nums[low];
                    nums[low] = nums[medium];
                    nums[medium] = temp;
                    low++;
                    medium++;
                    break;
                    }
                case 1 : {
                    medium++;
                    break;
                }
                case 2 : {
                    temp = nums[high];
                    nums[high] = nums[medium];
                    nums[medium] = temp;
                    high--;
                    break;
                }
            }
        }
    }
}