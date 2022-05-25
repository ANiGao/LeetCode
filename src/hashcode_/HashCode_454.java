package hashcode_;
import java.util.HashMap;
import java.util.Map;

public class HashCode_454 {
}

class Solution_454 {
    /*
    注意：
        此题重复的 元组 (i, j, k, l) 也要计算在内

    首先定义 一个unordered_map，key放a和b两数之和，value 放a和b两数之和出现的次数。
    遍历大A和大B数组，统计两个数组元素之和，和出现的次数，放到map中。

    定义int变量count，用来统计 a+b+c+d = 0 出现的次数。

    在遍历大C和大D数组，找到如果 0-(c+d) 在map中出现过的话，
    就用count把map中key对应的value也就是出现次数统计出来。
    最后返回统计值 count 就可以了
         */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int temp;
        //将前两个数组的元素和，放入map
        for (int a : nums1) {
            for (int b : nums2) {
                temp = a + b;
                //如果此 map 包含 temp 的映射关系，则返回 true
                // 存入 a + b ， 如果有重复， 则出现的次数++
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                }
                // 1 是出现次数
                else {
                    map.put(temp, 1);
                }
            }
        }
        //统计剩余的两个数组元素的和
        //在 map 中找是否存在相加为 0 的情况，同时记录次数
        for (int c : nums3) {
            for (int d : nums4) {
                temp = c + d;
                //如果此 map 包含 0-(c+d) 的映射关系，则
                if (map.containsKey(0 - temp)) {
                    //Object get(Object k)
                    //返回指定键所映射的值；如果此映射不包含该键的映射关系，则返回 null。
                    //
                    //用 count 把 map 中 key 对应的 value 也就是[出现次数]统计出来。
                    count += map.get(0 - temp);
                }
            }

        }
        return count;
    }
}