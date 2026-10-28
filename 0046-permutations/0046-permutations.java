import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        // 방문 체크
        boolean[] visited = new boolean[nums.length];
        // 진행 리스트(현재)
        List<Integer> cList = new ArrayList<>();

        dfs(nums, visited, cList, answer);

        return answer;
    }

    public void dfs(int[] nums, boolean[] visited, List<Integer> cList, List<List<Integer>> answer) {

        // answer에 완성 순열 조건 달성 시 저장
        if (cList.size() == nums.length) {
            answer.add(new ArrayList<>(cList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            // 방문 인덱스면 제외
            if (visited[i]) continue;

            visited[i] = true;
            cList.add(nums[i]);

            dfs(nums, visited, cList, answer);

            // 가지치기(초기화)
            visited[i] = false;
            cList.remove(cList.size() - 1);
        }

    }
}