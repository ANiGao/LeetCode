package string_;

public class String_151 {
}

class Solution_151 {
    /*注意：
    正则表达式中\s匹配任何空白字符，包括空格、制表符、换页符等等, 等价于[ \f\n\r\t\v]
       \f -> 匹配一个换页
       \n -> 匹配一个换行符
       \r -> 匹配一个回车符
       \t -> 匹配一个制表符
       \v -> 匹配一个垂直制表符
    而“\s+”则表示匹配任意多个上面的字符。
    因为反斜杠在Java里是转义字符，我们要使用 \ \ s +。
     */
    public String reverseWords(String s) {
        s = s.trim();
        String[] arr = s.split("\\s+");
        String str = "";
        for (int i = arr.length - 1; i > 0; i--) {
            str += arr[i] + " ";
        }
        return str + arr[0];
    }
     /*
     思路：
     由后往前利用双指针，跳过空格，获取单词长度，返回单词
        只需遍历一遍
      */
    public String reverseWords2(String s) {
        StringBuilder sb = new StringBuilder();
        // 先去除前后空格
        int ll = 0;
        int r = s.length() - 1;
        while (s.charAt(ll) == ' ') {
            ll++;
        }
        while (s.charAt(r) == ' ') {
            r--;
        }
        // 由后往前利用双指针，跳过空格，获取单词长度，返回单词
        while (ll <= r) {
            int l = r;
            // 获取单词长度
            while (l >= ll && s.charAt(l) != ' ') {
                l--;
            }
            // 左闭右开
            sb.append(s.substring(l + 1, r + 1));
            if (l > ll) {
                sb.append(' ');
            }
            while (l >= ll && s.charAt(l) == ' ') {
                l--;
            }
            r = l;
        }
        return sb.toString();
    }
}