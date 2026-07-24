import java.util.*;
import java.io.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] answer = new int[nums.length - k + 1];
        ArrayDeque<Integer> adq = new ArrayDeque<>();
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {

            // 감시 범위를 벗어나면 제거
            if (!adq.isEmpty() && adq.peekFirst() <= i - k) {
                adq.pollFirst();
            }

            // 덱의 가장 앞은 최대값 유지
            while (!adq.isEmpty() && nums[adq.peekLast()] < nums[i]) {
                adq.pollLast();
            }
            adq.offerLast(i);

            // 감시하는 크기가 K보다 클때
            if (i >= k - 1) {
                answer[idx++] = nums[adq.peekFirst()];
            }
        }
        return answer;
    }
}