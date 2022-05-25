package string_;

public class String_459 {
    public static void main(String[] args) {
        String s = "babbabbabbabbab";
        System.out.println(new Solution_459().repeatedSubstringPattern(s));
    }

}

class Solution_459 {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        if (s.equals("")) {
            return false;
        }
        int[] next = new int[n];
        getNext(next, s);
/* 关键语句: 数组长度减去最长相同前后缀的长度相当于是第一个周期的长度，
也就是一个周期的长度，如果这个周期可以被整除，就说明整个数组就是这个周期的循环。

    // 如何理解这句话,首先知道前缀表的理论基础; {此时已经获取了前缀表}
        当用前缀表 next[index] 对字符串 s 匹配时;
        如果单个字符串匹配成功 ---> index++; 去下一个字符的位置
        如果单个字符串匹配失败, 就跳到前缀表 index - 1;
                    ===> 即当前字符串 s‘ 的 最长相同前后缀 ;
                    ===> 当前字符串 s‘ 的重复子串 的后一位 ,继续进行匹配

s 的最长相等前后缀的长度为 next[n - 1];
next[n - 1] == 0 ---> 说明 s 的最长相同前后缀为 0 ===> s 没有重复子串
next[n - 1] != 0 ---> 存在 s 的重复子串 s' ===> 那么(0, n - next[n - 1])就表示 {n 个重复 s' 的长度}
    如果这个周期可以被整除，就说明整个数组就是这个周期的循环
 */
        if (next[n - 1] == 0) {
            return false;
        }
        return n % (n - next[n - 1]) == 0 ? true : false;
    }

    // 获取前缀表
    public void getNext(int[] next, String s) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
    }
}
