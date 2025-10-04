class Solution {

    public boolean toSwap(int n1, int n2){
        String s1 = String.valueOf(n1);
        String s2 = String.valueOf(n2);

        return (s1 + s2).compareTo(s2 + s1) < 0;
    }

    public String largestNumber(int[] nums) {

        if(nums == null){
            return null;
        }
        int i = 1;
        while(i < nums.length) {
            int j = i;
            while(j > 0 && toSwap(nums[j - 1], nums[j])){
                int temp = nums[j];
                nums[j] = nums[j-1];
                nums[j - 1] = temp;
                j--;
            }
            i++;
        }

        if(nums[0] == 0){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for(int n : nums){
            sb.append(n);
        }
        return sb.toString();
    }
}