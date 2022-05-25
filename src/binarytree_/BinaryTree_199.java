package binarytree_;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree_199 {
    /**
     * 解法：辅助队列，迭代。
     * 依旧按照层序遍历，
     * 不过,只返回每层的最后一个节点。
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null)
                    queue.offer(temp.right);
                if (size == 1){
                    res.add(temp.val);
                }
                size--;
            }
        }
        return res;
    }

}
