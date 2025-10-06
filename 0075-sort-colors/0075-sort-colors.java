class Solution {
    public void sortColors(int[] nums) {
        
        Map<Integer, Integer> colorsMap = new HashMap<>();
        for(int i : nums) {
            colorsMap.put(i, colorsMap.getOrDefault(i, 0) + 1);
        }

        int cnt = 0;
        if(colorsMap.containsKey(0)){
            for(int i = 0; i < colorsMap.get(0); i++){
                nums[cnt++] = 0;
            }
        }
        
        if(colorsMap.containsKey(1)){
            for(int i = 0; i < colorsMap.get(1); i++){
                nums[cnt++] = 1;
            }
        }
        
        if(colorsMap.containsKey(2)){
            for(int i = 0; i < colorsMap.get(2); i++){
                nums[cnt++] = 2;
            }
        }
    }
}