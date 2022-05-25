package string_;

public class String_28_ {
}

class Solution_28_ {
    //前缀表（不减一）Java实现
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = new int[needle.length()];
        // 获取 next[] 前缀表
        getNext(next, needle);

        //  next 数组里记录的起始位置为 0
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            // 不匹配
            while (j > 0 && needle.charAt(j) != haystack.charAt(i))
                // j 寻找之前匹配的位置
                j = next[j - 1];
            // 匹配，j和i同时向后移动
            if (needle.charAt(j) == haystack.charAt(i))
                // i的增加在for循环里
                j++;
            // 匹配成功
            if (j == needle.length())
                // i - (needle.length() + 1)
                return i - needle.length() + 1;
        }
        return -1;

    }

    /*注意:
        字符串的 前缀 是指不包含最后一个字符的所有以第一个字符开头的连续子串；
         后缀 是指不包含第一个字符的所有以最后一个字符结尾的连续子串。
    */
    // 获取前缀表
    private void getNext(int[] next, String s) {
        /*
        String s = "aabaaf"; ===> next = {0,1,0,1,2,0}
        1.首先看 j [前缀末尾]    //同时也是 i 之前包括 i 的子串,最长相等前后缀的长度
            从 0 开始 就初始化 j = 0; ===> 代表 "aa" 字符串,暂时为 0,后续进行查找匹配
        2. next 数组的初始化
            next[0] = 0; ===> "a" 的 最长相等前后缀的长度 为 0
                也代表在 index = 0 的位置时回退到 0;
        3.然后是 i [后缀末尾]
            初始化就让 i = 1; ===> 代表字符串 "aa" index = 0,1
            i = 0 时 ===> 代表字符串 "a" ,在第二步时已经 初始化好了
         */

        // 初始化前后缀
        int j = 0;
        next[0] = 0;
        // 从字符串 "aa" 开始
        for (int i = 1; i < s.length(); i++) {
            /*
            遇见冲突,看前一位的 next 数组值,[循环不变量]
                j > 0 ,防止越界
             */
            // 前后缀不相同
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = next[j - 1];
            }
            // 前后缀相同
            if (s.charAt(j) == s.charAt(i)) {
                j++;
            }
            /* next[] 的值 ===> 最长相等前后缀的长度
             是一个一个循序增加的 ,但当不相等的时候直接就会降为 0
             */
            next[i] = j;
        }
    }
}
