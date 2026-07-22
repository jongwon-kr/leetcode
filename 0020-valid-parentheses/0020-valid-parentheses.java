class Solution {
    public boolean isValid(String s) {
        
        ArrayDeque<Character> adq = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (!adq.isEmpty()) {
                char cur = adq.peek();
                if ((cur == '(' && c == ')') || (cur == '{' && c == '}') || (cur == '[' && c == ']')) {
                    adq.pop();
                } else {
                    adq.push(c);
                }
            } else {
                adq.push(c);
            }
        }

        if (adq.size() > 0) {
            return false;
        }

        return true;
    }
}