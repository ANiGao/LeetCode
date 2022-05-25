package stacksandqueues_;

import java.util.*;

public class LC_239 {
}

class Solution_239 {
    /*
    分析一下，队列里的元素一定是要排序的，而且要 **最大值放在出队口**，要不然怎么知道最大值呢。

    但如果把窗口里的元素 **都** 放进队列里，窗口移动的时候，队列需要弹出元素。
    其实队列没有必要维护窗口里的所有元素，**只需要维护有可能成为窗口里最大值的元素** 就可以了，同时保证队里里的元素数值是由大到小的。

    那么这个维护元素单调递减的队列就叫做单调队列，即单调递减或单调递增的队列。
    **不要以为实现的单调队列就是对窗口里面的数进行排序**，如果排序的话，那和优先级队列又有什么区别了呢。
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        /*
        解释一下为什么队列中要存放数组下标的值而不是直接存储数值，
        因为要判断队首的值是否在窗口范围内，由数组下标取值很方便，
        而由值取数组下标不是很方便。
         */
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            // 根据题意，i为nums下标，是要在[i - k + 1, i] 中选到最大值，只需要保证两点
            // 不理解时,可以把 1 2 交换
            // 1.队列头结点需要在[i - k + 1, i]范围内，不符合则要弹出
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                //获取并移除该deque所表示的队列的头(换句话说，该deque的第一个元素)，如果该deque为空则返回null。这个方法等价于pollFirst。
                deque.poll();
            }
            // 2.既然是单调，就要保证每次放进去的数字要比末尾的都大，否则也弹出
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                //deque获取并移除该deque容器的最后一个元素，如果该deque容器为空则返回null。
                deque.pollLast();
            }
            //将指定的元素插入到该deque容器的末尾。这个方法等价于offerLast。
            deque.offer(i);
            // 因为单调，当i增长到符合第一个k范围的时候，每滑动一步都将队列头节点放入结果就行了
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peek()];
            }
        }
        return res;
    }

}