package binarytree_;

import java.util.*;

public class BinaryTree_117 {
    /**方法:
     *
     * 解法：队列，迭代。
     * 层序遍历的时候将队列中的元素都串联一遍( 前后节点特殊处理 )
     * 然后加入下一层节点
     */
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            // 先添加 root
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node preNoed = null, node = null;
            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    // 每层的第一个节点
                    preNoed = queue.poll();
                    // 添加下一层的时候, 需要 node ; 不能让它为空
                    node = preNoed;
                } else {
                    // 链接中间节点
                    node = queue.poll();
                    preNoed.next = node;
                    preNoed = preNoed.next;
                }
                // 下一层
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            // 每层最后的节点
            preNoed.next = null;
        }
        return root;
    }
}
