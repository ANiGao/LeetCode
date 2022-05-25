package hashcode_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HashCode_18 {
    public static void main(String[] args) {
        int[] nums = {1, -2, -5, -4, -3, 3, 3, 5};
        int i = -11;
        Solution_18 so = new Solution_18();
        so.fourSum(nums, i);
    }
}

class Solution_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 结果集
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 4 || nums == null) {
            return res;
        }
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            /*
            if (nums[i] > target) {
                break;
            }
            此处和 target = 0 不同
            两个负数相加，结果小于两负数，不能作为评判
            */
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < len; j++) {
                /* 此处 j > i + 1  表示可以指向同一个数
                eg: 1,2,3,【4,4】,4,4,5...
                nums[]i = 3 (index=2)
                j = i+1 = 4(index=3)
                j - 1 = 3

                nums[]i = 4 (index=3)
                j = i+1 =4(index=4)
                j - 1 = 4
                j(in4) > i(in3) + 1 错 不跳过
                但此时 nums[i] == nums[j]

                题目需求：【若两个四元组元素一一对应，则认为两个四元组重复】
                    四个数中，有两个在不同位置的数，他们的值是可以重复的
                    可知 i 和 j 可以相同
                所以不能省略
                 */
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = j + 1;
                int r = len - 1;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    // 满足条件存入结果集
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        // 二次去重
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    } else if (sum > target) {
                        r--;
                    } else if (sum < target) {
                        l++;
                    }
                }
            }
        }
        return res;
    }
}