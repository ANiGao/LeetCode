package stacksandqueues_;

import java.util.Deque;
import java.util.LinkedList;

public class LC_20 {
    public static void main(String[] args) {
        String s = "([)]";
        new Solution_20().isValid(s);
    }


}

class Solution_20 {

    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            // 碰到左括号，就把相应的右括号入栈
            if (ch == '(') {
                deque.push(')');
            } else if (ch == '{') {
                deque.push('}');
            } else if (ch == '[') {
                deque.push(']');
            }
            // 不匹配
            else if (deque.isEmpty() || deque.peek() != ch) {
                return false;
            }
            // 匹配,出栈
            else {
                deque.pop();
            }
        }
        //最后判断栈中元素是否完全匹配
        return deque.isEmpty();
    }
}
