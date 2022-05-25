package stacksandqueues_;

import java.util.*;

public class LC_347 {
}
/*
    1.首先统计元素出现的频率，这一类的问题可以使用map来进行统计。
    2.然后是对频率进行排序，这里我们可以使用一种 容器适配器就是优先级队列。
        2.1 其实就是一个披着队列外衣的堆，因为优先级队列对外接口只是从队头取元素，
        从队尾添加元素，再无其他取元素的方式，看起来就是一个队列。
        2.2 而且优先级队列内部元素是自动依照元素的权值排列。
        2.3 那么它是如何有序排列的呢？
            缺省情况下priority_queue利用max-heap（大顶堆）完成对元素的排序，
            这个大顶堆是以vector为表现形式的complete binary tree（完全二叉树）。
    3.1 定义一个大小为k的大顶堆，在每次移动更新大顶堆的时候，
    每次弹出都把最大的元素弹出去了，怎么保留下来前K个高频元素呢。
    3.2 我们要用小顶堆，因为要统计最大前k个元素，只有小顶堆每次将最小的元素弹出，
    最后小顶堆里积累的才是前k个最大元素。
 */
class Solution_347 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer, Integer> map = new HashMap();
        /* 极简主义
        map.put(num, map.getOrDefault(num, 0) + 1);
         Returns the value to which the specified key is mapped,
         or defaultValue if this map contains no mapping for the key.
         */
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        // 将 HashMap 中的键值对 映射到 entries
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        // 根据map的value值正序排，相当于一个小顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> queue =
                new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for (Map.Entry<Integer, Integer> entry : entries) {
            // 将新的元素添加进堆中并维持堆中的 k 个元素
            // 最终，堆中的元素即为前 k 个高频元素
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            res[i] = queue.poll().getKey();
        }
        return res;
    }
}