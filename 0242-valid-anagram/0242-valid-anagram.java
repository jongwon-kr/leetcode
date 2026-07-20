import java.util.*;

class Solution {

    int[] sAlphas = new int[26];
    int[] tAlphas = new int[26];

    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length()) {
            return false;
        }

        for (char c : s.toCharArray()) {
            sAlphas[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            tAlphas[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (sAlphas[i] != tAlphas[i]) {
                return false;
            }
        }
        return true;
    }
}