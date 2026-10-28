import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        List<Integer> current = new ArrayList<>();

        dfs(nums, visited, current, answer);

        return answer;
    }

    public void dfs(int[] nums, boolean[] visited, List<Integer> current, List<List<Integer>> answer) {

        if (current.size() == nums.length) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;

            // 방문 체크
            visited[i] = true;
            current.add(nums[i]);

            // 다음 요소 넣기
            dfs(nums, visited, current, answer);

            // 가지치기(방문체크 롤백)
            current.remove(current.size() - 1);
            visited[i] = false;
        }
    }
}