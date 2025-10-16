class Solution {

    int[] dp;

    public int rob(int[] nums, int n){
        if(n < 0){
            return 0;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        dp[n] = Math.max(rob(nums, n - 1), rob(nums, n - 2) + nums[n]);
        return dp[n];
    }

    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return rob(nums, nums.length - 1);
    }
}