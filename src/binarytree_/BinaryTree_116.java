package binarytree_;

import java.util.LinkedList;

public class BinaryTree_116 {
    /** 方法一:
     *
     *连接的方式有两种:
     * 第一种 是这两个串联的节点都有一个共同的父节点，通过父节点就可以将这两个子节点串联起来
     * 第二种 是这两个串联的节点的父节点不同，对于这种情况，如果我们能将这一层的上一层串联好。
        那么可以通过父节点的next找到邻居，完成串联。
            root.right.next => root.next.left
        这里我们需要保证 root.next 不为空就可以了
     *
     */
    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        Node pre = root;
        //循环条件是当前节点的left不为空，当只有根节点或所有叶子节点都出串联完后循环就退出了
        while (pre.left != null) {
            Node temp = pre;
            // 每一层,帮忙串下一层[i]
            while (temp != null) {
                // 第一种: 将temp的左右节点都串联起来
                // 注:外层循环已经判断了当前节点的left不为空
                temp.left.next = temp.right;
                // 第二种: 下一个不为空说明之前的上一层[i-1]已经帮我们完成串联了
                if (temp.next != null) {
                    temp.right.next = temp.next.left;
                }
                //继续右边遍历
                temp = temp.next;
            }
            // 从下一层[i+1]的最左边开始遍历
            pre = pre.left;
        }
        return root;
    }

    /**方法二:
     *
     * 解法：队列，迭代。
     * 层序遍历的时候将队列中的元素都串联一遍
     * 然后加入下一层节点
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            int n = queue.size();
            // 将队列中的元素串联起来
            Node head = queue.peek();
            for (int i = 1; i < n; ++i) {
                head.next = queue.get(i);
                head = queue.get(i);
            }
            // 遍历队列中的每个元素，将每个元素的左右节点 [下一层] 也放入队列中
            while (n > 0) {
                Node temp = queue.poll();
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
                n--;
            }
        }
        return root;
    }

    // 定义类
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
