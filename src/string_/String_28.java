package string_;

public class String_28 {
    public static void main(String[] args) {
        String a = "hello";
        String b = "ll";
        System.out.println(new Solution_28().strStr(a, b));
    }
}

class Solution_28 {
    /*
    利用双指针进行遍历搜寻
     */
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.equals("") && haystack != null) {
            return 0;
        }
        int m = haystack.length();
        int n = needle.length();
        for (int i = 0; i < haystack.length(); i++) {
            // 第一个相同
            // 判断长度是否满足
            if (i + n > m) {
                return -1;
            }
            // 判断是否符合
            if (haystack.substring(i, i + n).equals(needle)) {
                return i;
            }
            // 如果不满足,找下一个 i
        }
        return -1;
    }
}