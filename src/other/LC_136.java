package other;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LC_136 {
    public static void main(String[] args) {
        System.out.println(new LC_136().singleNumber(new int[]{2, 2, 1}));
    }

    /*
    方法一:
        [出现次数],考虑 HashMap
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Integer o : map.keySet()) {
            if (map.get(o) == 1) {
                return o;
            }
        }
        return -1;
    }

    /*
    方法二:
        在一的基础上; 由于, [除了某个元素只出现一次以外，其余每个元素均出现两次]
            考虑优化
     */
    public int singleNumber2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            // 加入 i;
            if (!set.add(i)) {
                // 存在, 删除
                set.remove(i);
            }
        }
        return set.iterator().next();
    }

    /*
    方法三:
        由于, [除了某个元素只出现[一次]以外，其余每个元素均出现[两次]]
            考虑异或运算特性
     */
    public int singleNumber3(int[] nums) {
        // 注意，这里为0而不是其它值得原因并不是盲目的：甲 按位异或 0 得 [甲]，[甲] 按位异或 甲 得 0
        // 保留singleNumber
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }
        return res;
    }
}
