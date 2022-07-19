package binarytree_;

public class BinaryTree_98 {
    /**
     * 思路一 : 递归 (中序)
     * 要知道中序遍历下，输出的二叉搜索树节点的数值是有序序列。
     * 有了这个特性，验证二叉搜索树，就相当于变成了判断一个序列是不是递增的了。
     * <p>
     * 思路二 : 递归 (中序 [由小到大])
     * 递归遍历的过程中直接判断是否有序。
     * - 不能单纯的比较左节点小于中间节点，右节点大于中间节点就完事了。
     * -- 我们要比较的是 左子树所有节点小于中间节点，右子树所有节点大于中间节点。
     * - 样例中最小节点 可能是int的最小值，如果这样使用最小的int来比较也是不行的。
     * -- 此时可以初始化比较元素为long的最小值。
     */
    class Solution {
        long max = Long.MIN_VALUE;

        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;

            boolean ivbLeft = isValidBST(root.left);
            if (root.val > max) {
                max = root.val;
            } else {
                return false;
            }
            boolean ivbRight = isValidBST(root.right);

            return ivbLeft && ivbRight;

        }
    }
}
