class Solution {
    public int firstUniqChar(String s) {
        // 입력 받은 문자열의 문자 개수 카운트
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            // 다시 순회하면서 반복되지 않은 문자일 경우 인덱스 반환
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        // 끝까지 순회했는데 반복되지 않은 문자들만 존재할 경우 -1 반환
        return -1;
    }
}