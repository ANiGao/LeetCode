package binarytree_;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree_501 {
    /**
     * 既然是搜索树，它中序遍历就是有序的。
     * -使用pre指针和cur指针的技巧，
     * --弄一个指针指向前一个节点，这样每次cur（当前节点）才能和pre（前一个节点）作比较。
     * <p>
     * // 遍历两遍
     * 因为要求最大频率的元素集合
     * -应该是先遍历一遍数组，找出最大频率（maxCount），
     * --然后再重新遍历一遍数组把出现频率为maxCount的元素放进集合。（因为众数有多个）
     * // 遍历一遍
     * -频率count 等于 maxCount（最大频率），当然要把这个元素加入到结果集中
     * --频率count 大于 maxCount的时候，不仅要更新maxCount，而且要清空结果集
     */
    class Solution {
        List<Integer> resultList;
        TreeNode pre;
        int maxCount;
        int count;

        public int[] findMode(TreeNode root) {
            if (root == null) return null;

            // 初始化
            resultList = new ArrayList<>();
            maxCount = count = 0;
            pre = null;
            searchTree(root);
            int[] result = new int[resultList.size()];
            for (int i = 0; i < resultList.size(); i++) {
                result[i] = resultList.get(i);
            }
            return result;
        }

        public void searchTree(TreeNode root) {
            if (root == null) return;

            searchTree(root.left);

            // 判断是否从头开始
            if (pre == null) {
                count = 1;
            }
            // 相等
            else if (pre.val == root.val) {
                count++;
            }
            // 不相等
            else {
                count = 1;
            }
            if (count == maxCount) {
                resultList.add(root.val);
            } else if (count > maxCount) {
                resultList.clear();
                resultList.add(root.val);
                maxCount = count;
            }
            // 更新 pre 值
            pre = root;

            searchTree(root.right);
        }
    }
}
