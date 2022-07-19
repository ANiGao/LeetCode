package binarytree_;

public class BinaryTree_222 {
    class Solution {
        /*
         { //
         理解: 一
         完全二叉树只有两种情况，情况一：就是满二叉树，情况二：最后一层叶子节点没有满。
          对于情况一，
           可以直接用 2^树深度 - 1 来计算，注意这里根节点深度为1。
          对于情况二，
           分别递归左孩子，和右孩子，递归到某一深度一定会有左孩子或者右孩子为满二叉树，
          然后依然可以按照情况1来计算。
         }
         理解: 二
         * 那么我们来对 root 节点的左右子树进行 [ 左 ] 高度统计，分别记为 left 和 right，有以下两种结果：
         *  1. left == right。这说明，左子树一定是满二叉树，因为节点已经填充到右子树了，
         *      左子树必定已经填满了。所以左子树的节点总数我们可以直接得到，
         *      是 2^left - 1，加上当前这个 root 节点，则正好是 2^left。再对右子树进行递归统计。
         *  2. left != right。说明此时最后一层不满，但倒数第二层已经满了，
         *      可以直接得到右子树的节点个数。同理，右子树节点 +root 节点，
         *      总数为 2^right。再对左子树进行递归查找。
         */
        public int countNodes(TreeNode root) {
            if (root == null) return 0;
            int leftDepth = getDepth(root.left);
            int rightDepth = getDepth(root.right);
            if (leftDepth == rightDepth) {// 左子树是满二叉树
                // 2^leftDepth其实是 （2^leftDepth - 1） + 1 ，左子树 + 根结点
                return (1 << leftDepth) + countNodes(root.right);
            } else {
                return countNodes(root.left) + (1 << rightDepth);
            }
        }

        private int getDepth(TreeNode node) {
            int depth = 0;
            while (node != null) {
                depth++;
                node = node.left;
            }
            return depth;
        }
    }
}
