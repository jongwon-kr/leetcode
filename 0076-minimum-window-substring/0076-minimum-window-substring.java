import java.util.*;

class Solution {

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0; 
        int required = t.length(); 
        int minLen = Integer.MAX_VALUE; 
        int minStart = 0; 

        for (int right = 0; right < s.length(); right++) {
            char rChar = s.charAt(right);

            if (need.containsKey(rChar)) {
                if (need.get(rChar) > 0) {
                    required--;
                }
                need.put(rChar, need.get(rChar) - 1);
            }

            while (required == 0) {
                int currentLen = right - left + 1;
                if (currentLen < minLen) {
                    minLen = currentLen;
                    minStart = left;
                }

                char lChar = s.charAt(left);

                if (need.containsKey(lChar)) {
                    need.put(lChar, need.get(lChar) + 1);
                    if (need.get(lChar) > 0) {
                        required++;
                    }
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}