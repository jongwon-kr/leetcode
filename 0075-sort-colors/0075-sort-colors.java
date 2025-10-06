class Solution {
    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = nums.length;

        while (white < blue) {
            if (nums[white] < 1) {
                int temp = nums[red];
                nums[red] = nums[white];
                nums[white] = temp;
                red++;
                white++;
            } else if (nums[white] > 1) {
                blue--;
                int temp = nums[white];
                nums[white] = nums[blue];
                nums[blue] = temp;
            } else {
                white++;
            }
        }
    }
}