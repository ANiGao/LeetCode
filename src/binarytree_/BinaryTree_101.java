package binarytree_;
import java.util.Deque;
import java.util.LinkedList;

public class BinaryTree_101 {
    /*
    方法一 :递归
    1.首先想清楚，判断对称二叉树要比较的是哪两个节点，要比较的可不是左右节点！
    2.对于二叉树是否对称，要比较的是根节点的左子树与右子树是不是相互翻转的，
        理解这一点就知道了其实我们要比较的是两个树（这两个树是根节点的左右子树），
        所以在递归遍历的过程中，也是要同时遍历两棵树。
     */
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return compare(root.left, root.right);
        }

        public boolean compare(TreeNode left, TreeNode right) {
            // 首先排除空节点的情况
            if (left == null && right != null) return false;
            else if (left != null && right == null) return false;
            else if (left == null && right == null) return true;
                // 数值不同
            else if (left.val != right.val) return false;

            // 剩下的就是数值相同了, 遍历下一层
            // 左子树：左、 右子树：右
            boolean outside = compare(left.left, right.right);
            // 左子树：右、 右子树：左
            boolean inside = compare(left.right, right.left);
            return outside && inside;
        }
    }

    /*
    方法二 :用迭代法
    使用双端队列，相当于两个栈
    */
    public boolean isSymmetric2(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root.left);
        deque.offerLast(root.right);
        while (!deque.isEmpty()) {
            TreeNode left = deque.pollFirst();
            TreeNode right = deque.pollLast();
            // 排除空节点
            if (left == null && right == null) {
                continue;
            }
            // 排除不相等
            if (left == null && right != null) return false;
            else if (left != null && right == null) return false;
            // 注意此处是比值,,,
            else if (left.val != right.val) return false;
            // 按特殊顺序, 加入下一层的节点
            deque.offerFirst(left.left);
            deque.offerFirst(left.right);
            deque.offerLast(right.right);
            deque.offerLast(right.left);
        }
        return true;
    }

}
