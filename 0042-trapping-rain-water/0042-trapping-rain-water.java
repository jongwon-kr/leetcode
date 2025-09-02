class Solution {
    public int trap(int[] height) {
        int waterCnt = 0;
        int left = 0;
        int right = height.length - 1;
        int maxLeft = height[left];
        int maxRight = height[right];

        while(left < right){
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);

            if(maxLeft <= maxRight){
                waterCnt += maxLeft - height[left];
                left++;
            }else{
                waterCnt += maxRight - height[right];
                right--;
            }
        }
        return waterCnt;
    }
}