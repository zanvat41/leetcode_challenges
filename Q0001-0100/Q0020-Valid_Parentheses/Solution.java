public class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = -1;

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack[++top] = c;  // push
            } else {
                if (top == -1) return false; // stack empty

                char open = stack[top--];  // pop
                if ((c == ')' && open != '(') ||
                        (c == ']' && open != '[') ||
                        (c == '}' && open != '{')) {
                    return false;
                }
            }
        }

        return top == -1; // true if stack is empty
    }
}