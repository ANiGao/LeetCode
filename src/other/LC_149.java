package other;

import java.util.HashMap;
import java.util.Map;

/*
据「朴素解法」的思路，枚举所有直线的过程不可避免，但统计点数的过程可以优化。

具体的，我们可以先枚举所有可能出现的 直线斜率（根据两点确定一条直线，即枚举所有的「点对」），
使用「哈希表」统计所有 斜率 对应的点的数量，在所有值中取个 max 即是答案。

一些细节：在使用「哈希表」进行保存时，为了避免精度问题，我们直接使用字符串进行保存，
同时需要将 斜率 约干净。
 */
public class LC_149 {
    public int maxPoints(int[][] points) {
        // 结果, 默认一个点
        int res = 1;
        int n = points.length;
        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            // 由当前点 i 发出的直线所经过的最多点数量
            // 固定'基准点': points[i] = (x1, y1) (0 <= i < points.len() - 1)
            // 遍历'其它点': points[j] = (x2, y2) (i < j < points.len())
            int max = 0;
            for (int j = i + 1; j < n; j++) {
                // 测算这两点的斜率 kj = (y2 - y1) / (x2 - x1)
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                int b = y1 - y2;
                int a = x1 - x2;
                // 这里我们需要讨论一些细节和特殊情况
                // 因为涉及除法, 所以有可能出现浮点精度不够，分子分母可能出现0，假分数，分子分母符号不同的问题
                // 1. 浮点精度不够: 我们可以不进行除法运算，直接记录分子 b 和分母 a 的值
                // 2. 分子分母可能出现0的问题: 分子b为0表示斜率为0, 平行于x轴, 分母a为0, 斜率无穷大, 垂直与x轴(不会同时为0，因为不共点)
                // 3. 假分数问题: '1/2' 与 '2/4'是一样的
                // 4. 分子分母符号不同: '-1/2' 与 '1/-2'是一样的
                // 5. 设 x=(a / k) , y=(b / k) ;
                //     注意当 "x_y" = "1_2" 时和 "x_y" = "2_1" ;并不是同一条直线, 而且两者也不垂直
                /*
                A(0,0) B(1,2) C(2,4)  D(3,3)
                A-B:(0-1)/(0-2)
                key = 2_1
                B-C:
                key = 2-1

                B-D:(1-3)/(2-3)
                key = 1_2
                 */
                int k = gcd(a, b);
                String key = (a / k) + "_" + (b / k);
                // 因为每一轮基准点是固定的, 所以当遍历后续'其它点'时,
                // 如果出现了'其它点1'与'其它点2'分别与基准点的斜率值相同, 就表明这三点共线,
                // 我们可以通过记录与'基准点'斜率的数量来统计共线点的数量.
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
            // max + 1 由于默认一个点,需要加上
            res = Math.max(res, max + 1);
        }
        return res;
    }
    // 辗转相除, 求最大公约数
    // https://blog.csdn.net/qq_41575507/article/details/90752742
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
