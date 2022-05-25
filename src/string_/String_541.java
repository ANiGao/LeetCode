package string_;

public class String_541 {
}

class Solution_541 {
    public String reverseStr(String s, int k) {
        int n = s.length();
        // 特例：当只有单个字符时，就不用进循环了
        //      否则在 swap(char[] str, int l, int r) 时，
        //      str[r] 会越界
        if (n == 1) {
            return s;
        }
        char[] arr = s.toCharArray();
        int l = 0;
        while (l < n) {
            // 此处减一，得注意
            int r = Math.min((l + k), n) - 1;
            swap(arr, l, r);
            l += 2 * k;
        }
        return new String(arr);

    }

    public void swap(char[] str, int l, int r) {
        while (l < r) {
            char temp = str[l];
            str[l] = str[r];
            str[r] = temp;
            l++;
            r--;
        }

    }
}