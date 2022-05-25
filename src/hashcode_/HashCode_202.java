package hashcode_;
import java.util.HashSet;
import java.util.Set;

public class HashCode_202 {
    public static void main(String[] args) {
        int n = 2;
        Solution_202 so = new Solution_202();
        System.out.println(so.isHappy(n));
    }
}

/**
 * 1.最终会得到 11。
 * 2.最终会进入循环。
 * 3.值会越来越大，最后接近无穷大。
 *
 * 对于 3 位数的数字，它不可能大于 243。这意味着它要么被困在 243 以下的循环内，要么跌到 1。
 * 4 位或 4 位以上的数字在每一步都会丢失一位，直到降到 3 位为止。
 * 所以我们知道，最坏的情况下，算法可能会在 243 以下的所有数字上循环，然后回到它已经到过的一个循环或者回到 1。
 * 但它不会无限期地进行下去，所以我们排除第三种选择。
 *
 * 即使在代码中你不需要处理第三种情况，你仍然需要理解为什么它永远不会发生，这样你就可以证明为什么你不处理它。
 */
class Solution_202 {
    /*
    通过 HashSet 的 contains 方法判断是否循环
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        //将数存进 set 集合
        while (n != 1) {
            set.add(n);
            n = nextNum(n);
            //如果发生循环，则表示此数不是快乐数
            if (set.contains(n)) {
                break;
            }
        }
        //最后一个 nextNum 是一，即为快乐数
        return n == 1;
    }

    /*
    功能类，找到下一个数
     */
    public int nextNum(int num) {
        int nextNum = 0;
        while (num > 0) {
            int temp = num % 10;
            nextNum += temp * temp;
            num = num / 10;
        }
        return nextNum;
    }

}