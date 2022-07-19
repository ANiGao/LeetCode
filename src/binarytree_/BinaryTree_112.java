package binarytree_;

public class BinaryTree_112 {
    /**
     * 递归函数什么时候需要返回值？什么时候不需要返回值？这里总结如下三点：
     *
     * 1.1 如果需要搜索整棵二叉树且 [不用处理递归返回值] ，递归函数就[不要]返回值。
     * 1.2 如果需要搜索整棵二叉树且 [需要处理递归返回值] ，递归函数就[需要]返回值。
     * 2.0 如果 [要搜索其中一条符合条件的路径] ，那么递归一定[需要]返回值，因为遇到符合条件的路径了就要及时返回。（本题的情况）
     */
    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) return false;
            // 叶子结点, 已找到
            if (root.left == null && root.right == null && targetSum == root.val) {
                return true;
            }
            // 叶子结点, 未找到
            if (root.left == null && root.right == null) {
                return false;
            }
            // 在左节点找到
            if (root.left != null) {
                if (hasPathSum(root.left, targetSum - root.val)) {
                    return true;
                }
            }
            // 在右节点找到
            if (root.right != null) {
                if (hasPathSum(root.right, targetSum - root.val)) {
                    return true;
                }
            }
            return false;
        }
    }
}
