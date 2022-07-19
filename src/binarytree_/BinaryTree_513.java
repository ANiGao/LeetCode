package binarytree_;

import java.util.*;

public class BinaryTree_513 {
    class Solution {
        /*
        方法一: 递归
        1. 如果使用递归法，如何判断是最后一行呢，其实就是深度最大的叶子节点一定是最后一行。
        所以要找深度最大的叶子节点
        2. 那么如果找最左边的呢？可以使用前序遍历，这样才先优先左边搜索，
        然后记录深度最大的叶子节点，此时就是树的最后一行最左边的值。
         */
        // 标记最长深度之后, 递归就不需要返回值了
        // (如果需要遍历整棵树，递归函数就不能有返回值。如果需要遍历某一条固定路线，递归函数就一定要有返回值！)
        private int treeDeep = -1;
        // 记录需要返回的结果
        private int res = 0;

        public int findBottomLeftValue(TreeNode root) {
            res = root.val;
            findBLeftValue(root, 0);
            return res;
        }

        public void findBLeftValue(TreeNode root, int deep) {
            if (root == null) return;
            // 找到叶子节点
            if (root.left == null && root.right == null) {
                if (deep > treeDeep) {
                    // 更新结果, (每一行中的第一个节点值)
                    res = root.val;
                    // 更新最大深度
                    treeDeep = deep;
                }
            }
            if (root.left != null) {
                // 如果是 deep++, 则会立马加上; 如果是 deep + 1 ,则不会立马加, 隐藏了回溯
                findBLeftValue(root.left, deep + 1);
            }
            if (root.right != null) {
                findBLeftValue(root.right, deep + 1);
            }
        }

        /*
        方法二: 层序
         */
        public int findBottomLeftValue2(TreeNode root) {
            int res = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode temp = queue.poll();
                    // 不断对 res 结果进行更新, 到最后一个时即为需要的结果
                    if (i == 0) {
                        res = temp.val;
                    }
                    if (temp.left != null) {
                        queue.offer(temp.left);
                    }
                    if (temp.right != null) {
                        queue.offer(temp.right);
                    }
                }
            }
            return res;
        }
    }
}
