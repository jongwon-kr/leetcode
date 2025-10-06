class Solution {

    public int binarySearch(int[] nums, int target, int left, int right) {

        if(left > right){
            return -1;
        }

        int mid = (left + right) / 2;

        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] < target) {
            return binarySearch(nums, target, mid + 1, right);
        } else if (nums[mid] > target) {
            return binarySearch(nums, target, left, mid - 1);
        } else {
            return mid;
        }
    }

    public int search(int[] nums, int target) {
        int index = binarySearch(nums, target, 0, nums.length - 1);
        return index;

    }
}