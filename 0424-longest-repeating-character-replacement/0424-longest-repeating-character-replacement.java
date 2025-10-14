class Solution {
    public int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int left = 0;
        int maxLen = 0;
        int maxF = 0;
        int[] fArr = new int[26];

        for(int r = 0; r < s.length(); r++){
            char c = s.charAt(r);

            fArr[c - 'A']++;
            maxF = Math.max(maxF, fArr[c - 'A']);

            int window = r - left + 1;
            if(window - maxF > k){
                char lC = s.charAt(left);
                fArr[lC - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, r - left + 1);
        }
        return maxLen;
    }
}