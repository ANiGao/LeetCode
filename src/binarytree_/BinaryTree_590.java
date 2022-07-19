package binarytree_;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree_590 {

    // Definition for a Node.
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

    class Solution {
        List<Integer> res = new ArrayList<>();

        public List<Integer> postorder(Node root) {
            order(root);
            return res;
        }

        public void order(Node root) {
            if (root == null) {
                return;
            }
            for (Node node : root.children) {
                order(node);
            }
            res.add(root.val);
        }

    }
}
