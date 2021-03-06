package binarytree_;

import java.util.*;

public class BinaryTree_145 {
    /*
    递归
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    public void postorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            postorder(root.left, list);
            postorder(root.right, list);
            list.add(root.val);
        }
    }

    /*
    迭代
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        // 后序遍历顺序 左-右-中 入栈顺序：中-左-右 出栈顺序：中-右-左， 最后翻转结果
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            result.add(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        Collections.reverse(result);
        return result;
    }
    // 统一写法
    /*
    1. 使用栈的话，无法同时解决访问节点（遍历节点）和处理节点（将元素放进结果集）不一致的情况。
    2. 那我们就将访问的节点放入栈中，把要处理的节点也放入栈中但是要做标记。
        - 如何标记呢，就是要处理的节点放入栈之后，紧接着放入一个空指针作为标记。 这种方法也可以叫做标记法。
        - 我们将访问的节点直接加入到栈中，但如果是处理的节点则后面放入一个空节点，
        这样只有空节点弹出的时候，才将下一个节点放进结果集。
    */
    public List<Integer> postorderTraversal3(TreeNode root) {
        // LinkedList 增删效率高于 ArrayList
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root != null) st.push(root);//进入循环
        while (!st.empty()) {
            TreeNode node = st.peek();
            // 后序遍历顺序 左-右-中 入栈顺序：中-右-左
            if (node != null) {
                st.pop(); // 将该节点弹出，避免重复操作，下面再将中右左节点添加到栈中
                st.push(node);                          // 添加中节点
                st.push(null); // 中节点访问过，但是还没有处理，加入空节点做为标记。
                if (node.right != null) st.push(node.right);  // 添加右节点（空节点不入栈）
                if (node.left != null) st.push(node.left);    // 添加左节点（空节点不入栈）
            } else { // 只有遇到空节点的时候，才将下一个节点放进结果集
                st.pop();           // 将空节点弹出
                node = st.peek();    // 重新取出栈中元素
                st.pop();
                result.add(node.val); // 加入到结果集
            }
        }
        return result;
    }
}