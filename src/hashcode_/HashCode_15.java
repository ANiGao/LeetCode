package hashcode_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HashCode_15 {
    public static void main(String[] args) {
        int[] nums={-1,0,1,2,-1,-4};
        new Solution_15().threeSum(nums);
    }
}

class Solution_15 {
    /*
     排序 + 双指针
        本题的难点在于如何去除重复解。
     算法流程：
        特判，对于数组长度 n，如果数组为 null 或者数组长度小于 33，返回 []。
        对数组进行排序。
        遍历排序后数组：
            若 nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 0，直接返回结果。
            对于重复元素：跳过，避免出现重复解
            令左指针 L=i+1，右指针 R=n-1，当 L<R 时，执行循环：
                当 nums[i]+nums[L]+nums[R]==0，执行循环，
                判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,R 移到下一位置，寻找新的解
                若和大于 0，说明 nums[R] 太大，R 左移
                若和小于 0，说明 nums[L] 太小，L 右移
     *
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // 结果集
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 3) {
            return res;
        }
        // 先排序
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            // 如果遍历的起始元素大于0，就直接退出
            if (nums[i] > 0) {
                break;
            }
            // 一次去重，当起始的值等于【前一个】元素，那么得到的结果将会和前一次相同
            /*
            错误去重方法，将会漏掉 -1,-1,2 这种情况
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            题目可知和 第18题. 四数之和 一样
            三个数中，有两个在不同位置的数，他们的值是可以重复的

            */
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                // 满足条件添加到结果集
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    // 二次去重
                /*
                虽然 i 已经去过重了，但此时的 l 为 i+1 也有可能会发生重复，
                for example: 1，2，2，2，3，3，3...
                 */
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    // 此时为三位数相加，只移动一位不可能保证结果不变
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                }
            }
        }
        return res;
    }
}