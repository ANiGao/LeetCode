package other;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 可以将矩阵看成若干层，首先输出最外层的元素，[然后忽略最外层]
 * 其次输出次外层的元素，直到输出最内层的元素。
 */
public class LC_54 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> list = new Solution_54().spiralOrder(arr);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            Integer i = (Integer) next;
            System.out.println(i);
        }
    }
}

class Solution_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int d = matrix.length - 1;
        int r = matrix[0].length - 1;
        int u = 0, l = 0;
        while (l <= r && u <= d) {
            /*
            按层遍历 :
            遍历完一层,减去,到下一层
             第一次 [ ]
             第二次 ( ]
             第一次 ( )
             第一次 [ )
             */
            // up 不变
            for (int i = l; i <= r; i++) {
                list.add(matrix[u][i]);
            }
            // right 不变
            for (int i = u+1; i <= d; i++) {
                list.add(matrix[i][r]);
            }
            /*
            如果最后还剩下一行或者一列,[由于已经在上面语句中添加了]
            就不进行下面的添加了,会导致越界

            如果最后一行或者一列还剩下一个数 ; 也会在上面遍历
            */
            if (l < r && u < d) {
                // down 不变
                for (int i = r-1; i > l; i--) {
                    list.add(matrix[d][i]);
                }
                // left 不变
                for (int i = d; i > u; i--) {
                    list.add(matrix[i][l]);
                }
            }
            l++;
            r--;
            u++;
            d--;
        }
        return list;
    }
}