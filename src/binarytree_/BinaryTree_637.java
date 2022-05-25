package binarytree_;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree_637 {
    /**
     * 解法：队列，迭代。
     * 层序遍历的时候把一层求个总和在取一个均值。
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            Double avg = 0d;
            int count = n;
            while (n > 0) {
                TreeNode temp = queue.poll();
                avg += temp.val;
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
                n--;
            }
            avg = avg / count;
            resList.add(avg);
        }
        return resList;
    }
}
