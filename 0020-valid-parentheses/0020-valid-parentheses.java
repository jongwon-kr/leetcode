class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            char ch;
            boolean isPop = false;
            if(!stack.isEmpty()){
                switch (c) {
                    case ')':
                        ch = stack.pop();
                        if(ch == '('){
                            isPop = true;
                        }else{
                            return false;
                        }
                        break;
                    case '}':
                        ch = stack.pop();
                        if(ch == '{'){
                            isPop = true;
                        }else{
                            return false;
                        }
                        break;
                    case ']':
                        ch = stack.pop();
                        if(ch == '['){
                            isPop = true;
                        }else{
                            return false;
                        }
                        break;
                    default:
                        break;
                }
            }

            if(!isPop){
                stack.push(c);
            }
        }

        if(stack.size() != 0){
            return false;
        }

        return true;
    }
}