package hashcode_;

import java.util.HashSet;
import java.util.Set;

public class HashCode_349 {
}

class Solution_349 {
    /*
    事先定义两个集合 set ; result

    在 set 集合中存入 nums1
    用 set 集合和 nums2 进行 contains 判断
        如果 contains 则将此元素存入 result 集合
    最后返回 结果
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> result = new HashSet<Integer>();
        //事先存入 nums1
        for (int num1 : nums1) {
            set.add(num1);
        }
        //判断 nums2 中的元素是否在集合中
        //如果在集合中，则将此元素存入 result 集合
        for (int num2 : nums2) {
            if (set.contains(num2)) {
                result.add(num2);
            }
        }
        //将 result 中的元素存入将要返回的数组 newNums
        int[] newNums = new int[result.size()];
        int index = 0;
        for (int num : result) {
            newNums[index++] = num;
        }
        return newNums;
    }


}