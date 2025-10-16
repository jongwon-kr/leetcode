class Solution {

    public int maxSubArray(int[] nums) {

        if (nums.length <= 1) {
            return nums[0];
        }

        int max = Integer.MIN_VALUE;
        int[] memo = new int[nums.length];
        memo[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (memo[i - 1] > 0) {
                memo[i] = memo[i - 1] + nums[i];
            } else {
                memo[i] = nums[i];
            }
        }

        for(int i : memo){
            if(i >= max){
               max = i; 
            }
        }

        return max;
    }
}