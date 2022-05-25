package binarytree_;

import com.sun.org.apache.xpath.internal.operations.Lte;

import java.util.*;

public class BinaryTree_429 {
    /**
     * 解法：队列，迭代。
     * 层序遍历的时候把每一层全部节点一并添加。
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node temp = queue.poll();
                // 跳过分隔点
                if (temp == null){
                    continue;
                }
                list.add(temp.val);
                // 添加整层节点
                if (!temp.children.isEmpty())
                    for (Node node :temp.children) {
                        queue.offer(node);
                    }
            }
            resList.add(list);
        }
        return resList;
    }
    // 定义类
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}

