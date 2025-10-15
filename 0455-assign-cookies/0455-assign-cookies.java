class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(s.length == 0){
            return 0;
        }
        int result = 0;

        Arrays.sort(s);
        Arrays.sort(g);
        
        for(int i = 0; i < g.length; i++){
            int gSize = g[i];

            for(int j = 0; j < s.length; j++){
                if(gSize <= s[j]){
                    result++;
                    s[j] = 0;
                    break;
                }
            }
        }

        return result;
    }
}