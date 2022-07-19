package binarytree_;

public class BinaryTree_105 {
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0 || inorder.length == 0) return null;
            return traversal(preorder, 0, preorder.length,
                    inorder, 0, inorder.length);
        }

        public TreeNode traversal(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
            // 1 如果数组大小为零的话，说明是空节点了。
            if (inRight - inLeft == 0) return null;

            // 2 前序遍历的第一个元素, 就是当前的中间结点(当前的根节点)
            int rootValue = preorder[preLeft];
            TreeNode root = new TreeNode(rootValue);
            // 2.1 结束条件(遇到了叶子结点)
            if (inRight - inLeft == 1) return root;

            // 3 找到中间结点在中序遍历的位置
            int rootIndex = 0;
            for (int i = inLeft; i < inRight; i++) {
                if (inorder[i] == rootValue) {
                    rootIndex = i;
                    break;
                }
            }

            // 4 根据中间结点的位置对中序遍历进行分串(去除中间结点)[左开右闭{和for有关}]
            //  4.1 利用分好的 前中序长度相等 分 中序
            // 5 将分好的串进行递归
            /*
            前左,前右
            中左,中右
             */
            root.left = traversal(preorder, preLeft + 1, preLeft + 1 + (rootIndex - inLeft),
                    inorder, inLeft, rootIndex);
            root.right = traversal(preorder, preRight - (inRight - (rootIndex + 1)), preRight,
                    inorder, rootIndex + 1, inRight);
            return root;
        }
    }
}
