class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        // 순서 상관없이 가능한 모든 순열 반환 백트래킹
        int n = nums.length;
        boolean[] isUsed = new boolean[n];
        List<Integer> list = new ArrayList<>();

        bt(0, nums, isUsed, list);
        
        return result;
    }

    private void bt(int depth, int[] nums, boolean[] isUsed, List<Integer> list) {

        if (depth == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (isUsed[i]) continue;
            isUsed[i] = true;
            list.add(nums[i]);
            bt(depth + 1, nums, isUsed, list);
            isUsed[i] = false;
            list.remove(list.size() - 1);
        }
    }
}