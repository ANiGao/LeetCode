package binarytree_;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree_104 {
    /**
     * 方法一:递归
     * 本题可以使用前序（中左右），也可以使用后序遍历（左右中），
     * 使用前序求的就是深度，使用后序求的是高度。
     *
     * 而根节点的高度就是二叉树的最大深度，
     * 所以本题中我们通过后序求的根节点高度来求的二叉树最大深度。
     *
    */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth2(root.left);
            int rightHeight = maxDepth2(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
    /**
     * 方法二:层序
     * 解法：队列，迭代。
     * 每遍历一层加一即可
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res++;
        }
        return res;
    }
}
