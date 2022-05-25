package string_;

public class JZOffer_58 {
}

class Solution_JZO_58 {
    public String reverseLeftWords(String s, int n) {
        // 左闭右开
        return s.substring(n, s.length()) + s.substring(0, n);
    }

}