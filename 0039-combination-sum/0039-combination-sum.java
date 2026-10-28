import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();

        Arrays.sort(candidates);
        dfs(candidates, 0, 0, new ArrayList<>(), answer, target);

        return answer;
    }

    private void dfs(int[] candidates, int sum, int start, List<Integer> cList, List<List<Integer>> answer, int target) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            answer.add(new ArrayList<>(cList));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            if (sum + candidates[i] > target) {
                break;
            }
            cList.add(candidates[i]);
            dfs(candidates, sum + candidates[i], i, cList, answer, target);
            cList.remove(cList.size() - 1);
        }
    }
}