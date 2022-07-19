package binarytree_;

public class BinaryTree_106 {

    class Solution {
        /*
        第一步：如果数组大小为零的话，说明是空节点了。
        第二步：如果不为空，那么取后序数组最后一个元素作为节点元素。
        第三步：找到后序数组最后一个元素在中序数组的位置，作为切割点
        第四步：切割中序数组，切成中序左数组和中序右数组 （顺序别搞反了，一定是先切中序数组）
        第五步：切割后序数组，切成后序左数组和后序右数组
        第六步：递归处理左区间和右区间
         */
        public TreeNode traversal(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
            // 1 如果数组大小为零的话，说明是空节点了。
            if (inRight - inLeft == 0) {
                return null;
            }

            // 2 后序遍历数组最后一个元素，就是当前的中间节点
            int rootValue = postorder[postRight - 1];
            TreeNode root = new TreeNode(rootValue);
            // 2.1 最后还剩一个叶子节点
            if (inRight - inLeft == 1) {
                return root;
            }
            // 3 找中序遍历的切割点(根节点的位置)
            int rootIndex = 0;
            for (int i = inLeft; i < inRight; i++) {
                if (inorder[i] == rootValue) {
                    rootIndex = i;
                    break;
                }
            }

            // 4 切割中序数组，得到 中序左数组和中序右数组
            // 4.1 左闭右开区间：[0, delimiterIndex)
            // 4.2 [delimiterIndex + 1, end)

            //此时有一个很重的点，就是中序数组大小一定是和后序数组的大小相同的（这是必然）。
            //中序数组我们都切成了左中序数组和右中序数组了，那么后序数组就可以按照左中序数组的大小来切割，切成左后序数组和右后序数组。
            /*
            // 5 切割后序数组，得到 后序左数组和后序右数组
            // 5.1 postorder 舍弃末尾元素，因为这个元素就是中间节点，已经用过了
            // 5.2 左闭右开，注意这里使用了左中序数组大小作为切割点：[0, leftInorder.size)
            // 5.3 [leftInorder.size(), end)
            */
            // 6 递归处理左区间和右区间
            /*
            中左,中右
            后左,后右
             */
            root.left = traversal(inorder, inLeft, rootIndex,
                    postorder, postLeft, postLeft + (rootIndex - inLeft));
            root.right = traversal(inorder, rootIndex + 1, inRight,
                    postorder, postLeft + (rootIndex - inLeft), postRight - 1);
            return root;
        }

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder.length == 0 || postorder.length == 0) return null;
            return traversal(inorder, 0, inorder.length, postorder, 0, postorder.length);
        }
    }
}
