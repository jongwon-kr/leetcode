import java.util.*;
import java.io.*;

class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        class WordStat {
            String word;
            int depth;

            public WordStat(String word, int depth) {
                this.word = word;
                this.depth = depth;
            }
        }

        int answer = 0;
        if (!wordList.contains(endWord)) return answer;

        HashSet<String> set = new HashSet<>();
        for (String w : wordList) {
            set.add(w);
        }

        ArrayDeque<WordStat> q = new ArrayDeque<>();
        q.offer(new WordStat(beginWord, 1));
        while (!q.isEmpty()) {
            WordStat c = q.poll();

            if (c.word.equals(endWord)) {
                answer = c.depth;
                break;
            }

            List<String> removeList = new ArrayList<>();
            for (String w : set) {
                if (set.size() == 0) {
                    break;
                }
                if (checkCondition(c.word, w)) {
                    q.offer(new WordStat(w, c.depth + 1));
                    removeList.add(w);
                }
            }
            set.removeAll(removeList);
        }
        return answer;
    }

    private boolean checkCondition(String s1, String s2) {

        boolean result = false;

        char[] cArr1 = s1.toCharArray();
        char[] cArr2 = s2.toCharArray();

        int cnt = 0;
        for (int i = 0; i < cArr1.length; i++) {
            if (cArr1[i] != cArr2[i]) {
                cnt++;
            }
            if (cnt > 1) {
                return result;
            }
        }
        return true;
    }
}