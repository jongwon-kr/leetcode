class Solution {
    public int findNumbers(int[] nums) {
        
        int cntEven = 0;
        
        for(int i = 0; i < nums.length; i++){
            
            int checkDigits = 0;

            while (nums[i] > 0) {
                checkDigits++;
                nums[i] /= 10;
            }
            
            if(checkDigits % 2 == 0){
                cntEven++;
            }
            
        }
        
        return cntEven;
    }
}