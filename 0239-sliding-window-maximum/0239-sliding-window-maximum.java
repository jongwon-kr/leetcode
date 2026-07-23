import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int resultIdx = 0;
        
        ArrayDeque<Integer> adq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (!adq.isEmpty() && adq.peekFirst() <= i - k) {
                adq.pollFirst();
            }

            while (!adq.isEmpty() && nums[adq.peekLast()] < nums[i]) {
                adq.pollLast();
            }
            adq.offerLast(i);

            if (i >= k - 1) {
                result[resultIdx++] = nums[adq.peekFirst()];
            }
        }

        return result;
    }
}