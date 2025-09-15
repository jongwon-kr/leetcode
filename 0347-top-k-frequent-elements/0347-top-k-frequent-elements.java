class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        Map<Integer, List<Integer>> map2 = new HashMap<>();

        for(int key : map.keySet()){
            int f = map.get(key);

            List<Integer> list = map2.getOrDefault(f, new ArrayList<>());
            list.add(key);
            map2.put(f, list);
        }

        int cnt = 0;
        for(int i = nums.length; i >= 0; i--){
            if(map2.get(i) != null){
                for(int r : map2.get(i)){
                    result[cnt] = r;
                    cnt++;
                    if(cnt == k){
                        return result;
                    }
                }
            }
        }

        return result;
    }
}