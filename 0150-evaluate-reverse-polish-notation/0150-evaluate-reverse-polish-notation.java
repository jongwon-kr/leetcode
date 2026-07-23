import java.util.*;
import java.io.*;

class Solution {
    public int evalRPN(String[] tokens) {
        // 후위 표기법 계산 숫자 2개가 오고 연산자가 오게 되면 먼저 계산한다.
        // stack으로해서 이전 2개의 입력값 저장해두고 연산자가 오면 계산 하고 pop하면될듯

        ArrayDeque<String> adq = new ArrayDeque<>();

        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int b = Integer.parseInt(adq.pop());
                int a = Integer.parseInt(adq.pop());
                adq.push(calculate(a, b, s));
            } else {
                adq.push(s);
            }
        }

        return Integer.parseInt(adq.pop());
    }
    
    String calculate(int a, int b, String s) {
        int result = 0;
        if (s.equals("+")) {
            result = a + b;
        } else if (s.equals("-")) {
            result = a - b;
        } else if (s.equals("*")) {
            result = a * b;
        } else if (s.equals("/")) {
            result = a / b;
        }
        return String.valueOf(result);
    }
}