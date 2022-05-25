package binarytree_;

import java.util.*;

public class BinaryTree_107 {
    /**
     * 解法：辅助队列，迭代。
     * 层序遍历，再翻转数组即可。
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        // 按层来
        while (!que.isEmpty()) {
            List<Integer> preList = new ArrayList<>();
            // 固定 size 大小
            int size = que.size();
            while (size > 0) {
                // 遍历当前层中的一个节点
                TreeNode temp = que.poll();
                preList.add(temp.val);
                // 添加下一层
                if (temp.left != null)
                    que.offer(temp.left);
                if (temp.right != null)
                    que.offer(temp.right);
                size--;
            }
            list.add(preList);
        }
        List<List<Integer>> resList = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            resList.add(list.get(i));
        }
        return resList;
    }
}
