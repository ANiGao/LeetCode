package binarytree_;

public class BinaryTree_100 {
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            if (p != null && q == null) return false;
            if (p == null && q != null) return false;
            if (p.val != q.val) return false;
            boolean istl = isSameTree(p.left, q.left);
            boolean istr = isSameTree(p.right, q.right);
            return istl && istr;
        }
    }
}
