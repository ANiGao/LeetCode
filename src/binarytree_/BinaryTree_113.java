package binarytree_;

import java.util.*;

public class BinaryTree_113 {
    /*
    计算路径总和 targetSum 要遍历整个树，找到所有路径，所以递归函数不要返回值！
     */
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            List<Integer> path = new ArrayList<>();
            getPath(root, targetSum, res, path);
            return res;
        }

        public void getPath(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> path) {
            path.add(root.val);
            // 叶子结点
            if (root.left == null && root.right == null) {
                // 找到了和为 targetSum 的路径, 满足条件
                if (targetSum - root.val == 0) {
                    // 添加到结果集
                    res.add(new ArrayList<>(path));
                }
                // 返回上一层, 以便迭代
                return;
            }
            //
            if (root.left != null) {
                getPath(root.left, targetSum - root.val, res, path);
                // 回溯
                path.remove(path.size() - 1);
            }
            if (root.right != null) {
                getPath(root.right, targetSum - root.val, res, path);
                // 回溯
                path.remove(path.size() - 1);
            }
        }
    }
}
