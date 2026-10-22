import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        // 인덱스를 저장할 스택
        ArrayDeque<Integer> adq = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!adq.isEmpty() && temperatures[i] > temperatures[adq.peek()]) {
                int prevIndex = adq.pop();
                answer[prevIndex] = i - prevIndex;
            }
            adq.push(i);
        }

        return answer;
    }
}