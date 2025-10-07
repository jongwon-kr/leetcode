class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean result = false;
        for(int[] nums : matrix){
            int n = Arrays.binarySearch(nums, target);
            if(n >= 0){
                result = true;
                break;
            }
        }
        return result;
    }
}