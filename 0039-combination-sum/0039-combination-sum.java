import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] c, int t) {
        List<List<Integer>> answer = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        dfs(c, 0, 0, t, list, answer);

        return answer;
    }

    public void dfs(int[] c, int idx, int sum, int t, List<Integer> list, List<List<Integer>> answer) {
        // 종료 조건 : 합이 큰경우, 합이 타겟과 같을 경우
        if (sum > t) {
            return;
        }
        if (sum == t) {
            answer.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i < c.length; i++) {

            sum += c[i];
            list.add(c[i]);
            
            dfs(c, i, sum, t, list, answer);

            // 되돌리기
            sum -= c[i];
            list.remove(list.size() - 1);
        }
    }
}