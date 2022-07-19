package binarytree_;
import java.util.*;
public class BinaryTree_257 {
    /*
    1.题目要求从根节点到叶子的路径，所以需要 [ 前序遍历 ]
    2.我们要把路径记录下来，需要 [ 回溯 ] 来回退一个路径, 再进入另一个路径
    3.步骤
        1).递归函数函数参数以及返回值
            要传入根节点，记录每一条路径的 path，和存放结果集的 result，这里递归不需要返回值
        2).确定递归终止条件
            什么时候算是找到了叶子节点？ 是当 cur不为空，其左右孩子都为空的时候，就找到叶子节点。
            找到后进行一波路径的添加
        3).确定单层递归逻辑
            - 因为是前序遍历，需要先处理中间节点，中间节点就是我们要记录路径上的节点，先放进 path 中。
            paths.add(root.val);
            - 然后是递归和回溯的过程，
            递归
                - 上面说过没有判断 cur是否为空，
                  那么在这里递归的时候，如果为空就不进行下一层递归了
            回溯
                - 回溯和递归是一一对应的，有一个递归，就要有一个回溯
     */
    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();
            if (root == null) return res;
            List<Integer> paths = new ArrayList<>();
            traversal(root, paths, res);
            return res;
        }

        private void traversal(TreeNode root, List<Integer> paths, List<String> res) {
            paths.add(root.val);
            /*
            看似只添加了一条, 其实不是;
            着重看回溯
             */
            // 找到叶子结点
            if (root.left == null && root.right == null) {
                // 输出当前叶子结点对应的路径
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < paths.size() - 1; i++) {
                    sb.append(paths.get(i)).append("->");
                }
                sb.append(paths.get((paths.size() - 1)));
                // 将路径加入到结果集
                res.add(sb.toString());
                return;
            }
            //
            if (root.left != null) {
                traversal(root.left, paths, res);
                // 回溯; 每次回溯一个节点
                paths.remove(paths.size() - 1);
            }
            if (root.right != null) {
                traversal(root.right, paths, res);
                // 回溯
                paths.remove(paths.size() - 1);
            }
        }

    }
}
