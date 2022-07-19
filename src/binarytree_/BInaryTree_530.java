package binarytree_;

public class BInaryTree_530 {
    /**
     * 二叉搜索树采用中序遍历，其实就是一个有序数组。
     * 在一个有序数组上求两个数最小差值，这是不是就是一道送分题了。
     * - 需要用一个pre节点记录一下cur节点的前一个节点。
     */

    class Solution {
        TreeNode pre;
        int result = Integer.MAX_VALUE;
        public int getMinimumDifference(TreeNode root) {
            if (root == null) return 0;
            traversal(root);
            return result;
        }
        public void traversal(TreeNode root)
        {
            if (root==null)return;

            traversal(root.left);
            if (pre!=null){
                // 暗含由小到大
                result = Math.min(result, root.val- pre.val);
            }
            // 保存上一个节点
            pre = root;
            traversal(root.right);
        }
    }
}