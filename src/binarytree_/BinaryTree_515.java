package binarytree_;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree_515 {
    /**
     * 解法：队列，迭代。
     * 层序遍历的时候把一层的最大值求出即可。
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            // 节点包含负数,先用 int 最小值
            int max = Integer.MIN_VALUE;
            while (n > 0) {
                TreeNode temp = queue.poll();
                max = Math.max(max,temp.val);
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
                n--;
            }
            resList.add(max);
        }
        return resList;
    }
}
