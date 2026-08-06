import java.util.*;
import java.io.*;

class Solution {
    public double myPow(double x, int n) {
        double answer = 0.0;

        if (n < 0) {
            x = 1/x;
            n = -n;
        }

        answer = pow(x, n);

        return answer;
    }

    double pow(double x, long exp) {
        if (exp == 0) return 1;

        double half = pow(x, exp / 2);

        if (exp % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }
}