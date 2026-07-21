import java.util.*;
import java.io.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        // HashMap에<값, 인덱스>를 활용

        for (int i = 0; i < nums.length; i++) {
            // 찾는 값
            int findTarget = target - nums[i];
            // 합이 target이 되는 값이 존재하면 i와 findTarget의 인덱스 리턴
            if (map.containsKey(findTarget)) {
                answer[0] = i;
                answer[1] = map.get(findTarget);
                break;
            }
            map.put(nums[i], i);
        }
        return answer;
    }
}