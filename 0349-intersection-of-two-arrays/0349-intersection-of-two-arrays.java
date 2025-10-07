class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        Arrays.sort(nums2);

        for(int i : nums1){
            int n = Arrays.binarySearch(nums2, i);
            if(n >= 0){
                set.add(i);
            }
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}