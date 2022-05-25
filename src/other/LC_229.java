package other;

import java.util.ArrayList;
import java.util.List;

public class LC_229 {
}
/*
摩尔投票算法的核心思想是基于这个事实：
	• 每次从序列里选择两个不相同的数字删除掉（或称为「抵消」），
	最后剩下一个数字或几个相同的数字，就是出现次数大于总数一半的那个元素。
最后,需要进行二次遍历，来确定候选者是否符合要求，将符合要求的数加到答案。
 */
class Solution_229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int element1 = 0, vote1 = 0, element2 = 0, vote2 = 0;
        for (int n : nums) {
            // 如果该元素为第一个元素，则计数加1
            if (vote1 > 0 && n == element1) {
                vote1++;
            }
            // 如果该元素为第二个元素，则计数加1
            else if (vote2 > 0 && n == element2) {
                vote2++;
            }
            // 选择第一个元素, 替换新的候选者
            else if (vote1 == 0) {
                element1 = n;
                vote1++;
            }
            // 选择第二个元素, 替换新的候选者
            else if (vote2 == 0) {
                element2 = n;
                vote2++;
            }
            // 不匹配, 相互抵消 1 次
            else {
                vote1--;
                vote2--;
            }
        }
        // 统计候选者出现的次数
        int count1 = 0, count2 = 0;
        for (int n : nums) {
            if (vote1 > 0 && n == element1) {
                count1++;
            }
            if (vote2 > 0 && n == element2) {
                count2++;
            }

        }
        // 检测元素出现的次数是否满足要求
        /*
        {1,1,1,2,2,3}
        6/3 = 2
        1 ==> 3 true
        2 ==> 2 false
         */
        if (vote1 > 0 && count1 > nums.length / 3) {
            list.add(element1);
        }
        if (vote2 > 0 && count2 > nums.length / 3) {
            list.add(element2);
        }
        return list;
    }
}