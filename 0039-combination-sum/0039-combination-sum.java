class Solution {
    public List<List<Integer>> combinationSum(int[] c, int t) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(result, c, t, 0, new ArrayList<>());

        return result;
    }

    void dfs(List<List<Integer>> result, int[] c, int t, int index, List<Integer> list){

        if(t < 0){
            return;
        }

        if(t == 0){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = index; i < c.length; i++){
            int n = c[i];
            list.add(n);
            dfs(result, c, t - n, i, list);
            list.remove(list.size() - 1);
        }
    }
}