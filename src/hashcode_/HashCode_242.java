package hashcode_;

public class HashCode_242 {
}

class Solution_242 {
    /*
    将字符串 s 的每个字符存进数组 record
    将字符串 t 的每个字符从数组 record 中减掉
    判断最后结果是否为 0
     */
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        for (char i : s.toCharArray()) {
            record[i - 'a']++;
        }
        for (char j : t.toCharArray()) {
            record[j - 'a']--;
        }
        for (int index : record) {
            if (index != 0) {
                return false;
            }
        }
        return true;
    }

}
