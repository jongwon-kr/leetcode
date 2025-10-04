class Solution {
    public int[][] merge(int[][] intervals) {

        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt((int[] a)->a[0]));

        for(int[] arr : intervals) {
            if(!merged.isEmpty() && merged.get(merged.size() - 1)[1] >= arr[0]){
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], arr[1]);
            }else{
                merged.add(arr);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}