package stacksandqueues_;

import java.util.ArrayDeque;

public class LC_1047 {
}

class Solution_1047 {
    public String removeDuplicates(String s) {
        //ArrayDeque会比LinkedList在[除了删除元素这一点外]会快一点
        //参考：https://stackoverflow.com/questions/6163166/why-is-arraydeque-better-than-linkedlist
        ArrayDeque<Character> deque = new ArrayDeque<>();
        char temp;
        for (int i = 0; i < s.length(); i++) {
            temp = s.charAt(i);
            if (deque.isEmpty() || deque.peek() != temp) {
                deque.push(temp);
            } else {
                deque.pop();
            }
        }
        String string = "";
        while (!deque.isEmpty()) {
            // string += deque.pop();
            // string = string + deque.pop(); 反向了
            string = deque.pop() + string;
        }
        return string;
    }
}
/*  双指针:top i
        for (int i = 0; i < S.length(); i++) {
            if (top == -1 || s[top] != s[i]) {
                s[++top] = s[i];
        数组去重算法(?)
 */
class Solution_1047_ {
    public String removeDuplicates(String S) {
        char[] s = S.toCharArray();
        int top = -1;
        for (int i = 0; i < S.length(); i++) {
            // 无重复就添加(将之覆盖)
            if (top == -1 || s[top] != s[i]) {
                s[++top] = s[i];
            }
            // 重复就往后退(将之排除)
            else {
                top--;
            }
        }
        return String.valueOf(s, 0, top + 1);
    }
}