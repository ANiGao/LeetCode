package binarytree_;

import java.util.Stack;

public class BinaryTree_404 {
    class Solution {
        /**
        方法一: 递归
        - 判断当前节点是不是左叶子是无法判断的，必须要通过节点的父节点来判断其左孩子是不是左叶子。
        - 如果左节点不为空，且左节点没有左右孩子，那么这个节点的左节点就是左叶子
        */
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) return 0;

            int lsum = sumOfLeftLeaves(root.left);
            int rsum = sumOfLeftLeaves(root.right);
            int midsum = 0;
            if (root.left != null && root.left.left == null && root.left.right == null) {
                midsum = root.left.val;
            }
            return lsum + rsum + midsum;
        }

        // 方法二: 迭代
        public int sumOfLeftLeaves2(TreeNode root) {
            if (root == null) return 0;
            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);
            int result = 0;
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node.left != null && node.left.left == null && node.left.right == null) {
                    result += node.left.val;
                }
                if (node.right != null) stack.add(node.right);
                if (node.left != null) stack.add(node.left);
            }
            return result;
        }

    }
}
