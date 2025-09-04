class Solution {
    public int arrayPairSum(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int i : nums){
            list.add(i);
        }

        Collections.sort(list, Comparator.comparing((Integer i)->i).reversed());

        int sum = 0;
        for(int i = 0; i < list.size(); i++){
            if(i >= 0 && i < list.size() - 1){
                sum += Math.min(list.get(i), list.get(i+1));
                i++;
            }
        }

        return sum;
    }
}