class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        // 1 ~ n 까지의 수를 가지고 K개의 숫자로 가능한 모든 조합 반환

        List<Integer> list = new ArrayList<>();

        bt(1, n, k, list);

        return result;
    }

    private void bt(int start, int n, int k, List<Integer> list) {

        if (list.size() == k) {
            result.add(new ArrayList<>(list));
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            bt(i + 1, n, k, list);
            list.remove(list.size() - 1);
        }

    }
}