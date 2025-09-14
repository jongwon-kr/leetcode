class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] results = new int[temperatures.length];

        int minWarmer = 1000000, left = 0, right = 0;
        for(int i = 0; i < temperatures.length; i++){
            minWarmer = 1000000;
            left = i + 1;
            right = temperatures.length - 1;

            while(left <= right){
                if(temperatures[i] < temperatures[left]){
                    minWarmer = Math.min(left - i, minWarmer);
                    results[i] = minWarmer;
                }
                if(temperatures[i] < temperatures[right]){
                    minWarmer = Math.min(right - i, minWarmer);
                    results[i] = minWarmer;
                }
                left++;
                right--;
            }
        }
        return results;
    }
}