package binarytree_;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree_111 {
    /**
     * 方法:一
     * 递归
     *
     * 叶子节点的定义是左孩子和右孩子都为 null 时叫做叶子节点
     * 当 root 节点左右孩子都为空时，返回 1
     * 当 root 节点左右孩子有一个为空时，返回不为空的孩子节点的深度(加上当前节点 1 个)
     * 当 root 节点左右孩子都不为空时，返回左右孩子较小深度的节点值
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int mdl = minDepth(root.left);
        int mdr = minDepth(root.right);
        //1.如果左孩子和右孩子有为空的情况，直接返回m1+m2+1
        //2.如果都不为空，返回较小深度+1
        return root.left == null || root.right == null ?
                mdl + mdr + 1 : Math.min(mdl, mdr) + 1;
    }

    /**
     * 方法:二
     * 解法: 队列，迭代。
     *
     *
     * 需要注意的是，只有当左右孩子都为空的时候，才说明遍历到最低点了。
     * 如果其中一个孩子为空则不是最低点
     */
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return res;
                }
                if (node.left != null) {
                    queue.add(node.left);

                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return res;
    }
}
