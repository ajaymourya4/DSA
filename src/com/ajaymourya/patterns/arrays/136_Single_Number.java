class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }

    public int singleNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int num : nums) {
            if (!hashSet.add(num)) {
                hashSet.remove(num);
            }
        }
        Iterator<Integer> it = hashSet.iterator();
        return it.next();
    }
}