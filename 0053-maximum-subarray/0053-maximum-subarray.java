class Solution {

    public int maxSubArray(int[] nums) {

        int currentSum = 0;
        int bestSum = Integer.MIN_VALUE;

        for(int i : nums){
            currentSum = Math.max(i, currentSum + i);
            bestSum = Math.max(bestSum, currentSum);
        }

        return bestSum;
    }
}