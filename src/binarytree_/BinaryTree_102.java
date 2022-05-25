package binarytree_;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree_102 {
    public List<List<Integer>> resList = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        // checkFun01(root,0);
        checkFun02(root);
        return resList;
    }

    // 1. 递归
    public void checkFun01(TreeNode node, Integer deep) {
        if (node == null) return;
        deep++;
        // 当层级增加时，list的Item也增加
        // 利用list的索引值[deep]进行层级界定
        if (resList.size() < deep) {
            List<Integer> list = new ArrayList<>();
            resList.add(list);
        }
        // 添加node
        resList.get(deep - 1).add(node.val);
        // 进行递归
        checkFun01(node.left, deep);
        checkFun01(node.right, deep);
    }

    /*
    我们需要借用一个辅助数据结构即队列来实现
        队列先进先出，符合一层一层遍历的逻辑，
     */
    // 2. 迭代方式--借助队列
    public void checkFun02(TreeNode node) {
        if (node == null) return;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(node);

        while (!que.isEmpty()) {
            List<Integer> list = new ArrayList<>();

            // 每一层
            // 这里一定要使用固定大小size，不要使用que.size()，因为que.size是不断变化的
            int len = que.size();
            while (len > 0) {
                // 遍历当前层中的一个节点
                TreeNode tem = que.poll();
                list.add(tem.val);
                // 添加下一层
                if (tem.left != null)
                    que.offer(tem.left);
                if (tem.right != null)
                    que.offer(tem.right);
                len--;
            }
            resList.add(list);
        }
    }
}
