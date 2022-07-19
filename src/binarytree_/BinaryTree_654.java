package binarytree_;

public class BinaryTree_654 {
    /*
    构造树一般采用的是前序遍历，因为先构造中间节点，然后递归构造左子树和右子树。
    确定递归函数的参数和返回值

    注意类似用数组构造二叉树的题目，每次分隔尽量不要定义新的数组，
    而是通过下标索引直接在原数组上操作，这样可以节约时间和空间上的开销。
    */
    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return constructMBT(nums, 0, nums.length);
        }

        private TreeNode constructMBT(int[] nums, int leftIndex, int rightIndex) {
            // 终止条件
            if (rightIndex - leftIndex < 1) return null;
            if (rightIndex - leftIndex == 1) return new TreeNode(nums[leftIndex]);
            // 最大值作为中节点
            int maxIndex = leftIndex;
            for (int i = leftIndex + 1; i < rightIndex; i++) {
                if (nums[i] > nums[maxIndex]) {
                    maxIndex = i;
                }
            }
            TreeNode root = new TreeNode(nums[maxIndex]);
            // 左串
            root.left = constructMBT(nums, leftIndex, maxIndex);
            // 右串 (去除最大节点)
            root.right = constructMBT(nums, maxIndex + 1, rightIndex);
            return root;
        }
    }
}
