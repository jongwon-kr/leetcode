import java.util.*;
import java.io.*;

class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        dfs(0, 0, target, candidates, new ArrayList<>());
        return result;
    }

    private void dfs(int idx, int sum, int target, int[] cand, List<Integer> list) {
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = idx; i < cand.length; i++) {
            list.add(cand[i]);
            dfs(i, sum + cand[i], target, cand, list);
            list.remove(list.size() - 1);
        }
    }
}