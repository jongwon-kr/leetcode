class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(s.length == 0){
            return 0;
        }
        int result = 0;

        Arrays.sort(s);
        Arrays.sort(g);
        
        int i = 0;
        int j = 0;
        
        while(i < g.length && j < s.length){
            int gSize = g[i];

            if(gSize <= s[j]){
                reuslt++;
            }
            j++;
        }

        return result;
    }
}