package binarytree_;
import java.util.*;
public class BinaryTree_559 {
    class Solution {
        /*
        方法一: 递归
         */
        public int maxDepth(Node root) {
            if (root == null) return 0;

            int cDepth = 0;
            if (root.children != null) {
                for (Node node : root.children) {
                    cDepth = Math.max(cDepth,maxDepth(node));
                }
            }
            return ++cDepth;
        }

        /*
        方法二: 层序遍历
         */
        public int maxDepth2(Node root) {
            if (root == null) return 0;
            int res = 0;
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    List<Node> list = queue.poll().children;
                    for (Node node : list) {
                        if (node != null) {
                            queue.offer(node);
                        }
                    }
                }
                res++;
            }
            return res;
        }
    }

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
    }
}