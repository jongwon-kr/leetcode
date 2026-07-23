import java.util.*;
import java.io.*;

class Solution {
    public int evalRPN(String[] tokens) {

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