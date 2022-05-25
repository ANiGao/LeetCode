package string_;

import java.util.Arrays;

public class JZOffer_05 {
}

class Solution_JZO_05 {
    /*
    新建一个三倍 s.length() 的字符数组，
    然后按题意进行替换
    最后返回新的字符串 new String(arr, 0, index)
     */
    public String replaceSpace(String s) {
        char[] arr = new char[s.length() * 3];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                arr[index++] = '%';
                arr[index++] = '2';
                arr[index++] = '0';
            } else {
                arr[index++] = s.charAt(i);
            }
        }
        return new String(arr, 0, index);
    }
}