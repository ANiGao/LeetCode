package other;

import org.junit.jupiter.api.Test;

public class LC_581 {
    @Test
    public int findUnsortedSubarray(int[] nums) {
        /*
        从左到右维护一个最大值max,在进入右段之前，那么遍历到的nums[i]都是小于max的，
        我们要求的end就是遍历中最后一个小于max元素的位置；

        同理，从右到左维护一个最小值min，在进入左段之前，
        那么遍历到的nums[i]也都是大于min的，
        要求的begin也就是最后一个大于min元素的位置。
        index:
        0,1,2, 3,4,5,6,7 ,8,9,10
        value:
        1,2,3, 7,6,8,9,4 ,10,11,12

        index:
        begin = 3 ; end = 7
        value:
        min = 3 ; max = 10
        return = 7-3+1
         */
        int len = nums.length;
        // 连续子数组 头,尾
        int begin = 0, end = -1;

        int max = nums[0];
        int min = nums[len - 1];
        // 从左到右[维持]最大值,找到 max ,同时找到右边界 end
        for (int i = 0; i < len; i++) {
            if (nums[i] < max) {
                end = i;
            } else {
                max = nums[i];
            }
            // 从右到左[维持]最小值，找到 min ,同时找到左边界 begin
            if (min < nums[len - i - 1]) {
                begin = len - i - 1;
            } else {
                min = nums[len - i - 1];
            }
        }
        return end - begin + 1;
    }

}
