package hashcode_;

public class HashCode_383 {
    public static void main(String[] args) {
        String arr1 = "aa";
        String arr2 = "ab";
        Solution_383 so = new Solution_383();
        System.out.println(so.canConstruct(arr1,arr2));
    }
}

class Solution_383 {
    /*
    将字符串 magazine 的每个字符存进数组 record【记录个数】
    将 ransomNote 中的每个字符从数组 record 中减掉
    如果 record[i] < 0 ,则不满足题意
     */
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] record = new int[26];
        for (char i : magazine.toCharArray()) {
            record[i - 'a']++;
        }
        for (char j : ransomNote.toCharArray()) {
            record[j - 'a']--;
            if (record[j - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }


}