import java.util.*;
import java.io.*;

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        bt(0, nums, new ArrayList<>());
        return result;
    }
    private void bt(int idx, int[] nums, List<Integer> list) {

        result.add(new ArrayList<>(list));

        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;    // 중복 부분 수열 제거
            list.add(nums[i]);
            bt(i + 1, nums, list);
            list.remove(list.size() - 1);
        }
    }
}