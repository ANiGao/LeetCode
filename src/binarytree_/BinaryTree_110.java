package binarytree_;

public class BinaryTree_110 {
    /*方法一: 递归
    既然要求比较高度，必然是要 [ 后序遍历 ]。
    1.明确递归函数的参数和返回值
参数：当前传入节点。
返回值：以当前传入节点为根节点的树的高度。
    2.明确终止条件
递归的过程中依然是遇到空节点了为终止，返回 0 ，表示当前节点为根节点的树高度为 0 
    3.明确单层递归的逻辑
分别求出其左右子树的高度，然后如果差值小于等于 1 ，则返回当前二叉树的高度，
否则则返回 - 1 ，表示已经不是二叉平衡树了。
     */
    class Solution {
        public boolean isBalanced(TreeNode root) {
            return getHeight(root) != -1;
        }

        private int getHeight(TreeNode node) {
            if (node == null) return 0;

            int leftHeight = getHeight(node.left);
            // 用 - 1 做标记, 表示非二叉平衡树
            if (leftHeight == -1) return -1;
            int rightHeight = getHeight(node.right);
            if (rightHeight == -1) return -1;

            // 左右子树高度差大于 1 ，return - 1 表示已经不是平衡树了
            if (Math.abs(leftHeight - rightHeight) > 1) return -1;
            // 是平衡二叉树时, 返回当前树高度 加上自己的根节点
            // 注意是 max
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
