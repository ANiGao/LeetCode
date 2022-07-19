package binarytree_;

public class BinaryTree_572 {

    class Solution {
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if (subRoot == null) return true;  // subRoot 为 null 一定都是 true
            // subRoot 非空
            if (root == null) return false;  //只要 root 为 null，肯定是 false
            // root 也是非空
            boolean isroot = isSameTree(root, subRoot);
            boolean isleft = isSubtree(root.left, subRoot);
            boolean isright = isSubtree(root.right, subRoot);
            // 注意题目要求: 不要求相等,而是包含即可
            return isroot || isleft || isright;
        }

        public boolean isSameTree(TreeNode p, TreeNode q) {
            // 在 isSubtree 中仅仅判空了根节点
            if (p == null && q == null) return true;
            if (p == null || q == null) return false;
            if (p.val != q.val) return false;
            boolean istl = isSameTree(p.left, q.left);
            boolean istr = isSameTree(p.right, q.right);
            return istl && istr;
        }
    }

}
