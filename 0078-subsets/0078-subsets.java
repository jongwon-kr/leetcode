class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        // 모든 가능한 부분집합
        List<Integer> list = new ArrayList<>();
        bt(0, nums, list);
        return result;
    }

    private void bt(int start, int[] nums, List<Integer> list) {

        result.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            bt(i + 1, nums, list);
            list.remove(list.size() - 1);
        }

    }
}