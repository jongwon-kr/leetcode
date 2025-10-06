class Solution {
    public int search(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        for(int i : nums) {
            list.add(i);
        }        
        Arrays.sort(nums);
        if(binarySearch(nums, target, 0, nums.length - 1) > -1){
            return list.indexOf(target);
        } else{
            return -1;
        }
    }

    public int binarySearch(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (nums[mid] < target) {
            return binarySearch(nums, target, mid + 1, right);
        } else if (nums[mid] > target) {
            return binarySearch(nums, target, left, mid - 1);
        } else {
            return mid;
        }
    }
}