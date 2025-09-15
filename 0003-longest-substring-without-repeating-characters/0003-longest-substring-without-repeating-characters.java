class Solution {
    public int lengthOfLongestSubstring(String s) {
        int sIdx = 0, eIdx = 0, max = 0;
        char[] charArr = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char c : charArr){
            if(map.containsKey(c) && sIdx <= map.get(c)){
                sIdx = map.get(c) + 1;
            } else {
                max = Math.max(max, eIdx - sIdx + 1);
            }

            map.put(c, eIdx);
            eIdx++;
        }

        return max;
    }
}