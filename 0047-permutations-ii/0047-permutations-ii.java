import java.util.*;
import java.io.*;

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] vis = new boolean[nums.length];
        dfs(0, 0, nums, vis, new ArrayList<>());
        return result;
    }

    private void dfs(int idx, int depth, int[] nums, boolean[] vis, List<Integer> list) {

        if (depth == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]) continue;
            if(vis[i]) continue;
            list.add(nums[i]);
            vis[i] = true;
            dfs(i, depth + 1, nums, vis, list);
            list.remove(list.size() - 1);
            vis[i] = false;
        }
    }
}