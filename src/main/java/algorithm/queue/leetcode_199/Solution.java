package algorithm.queue.leetcode_199;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    public LinkedList<Integer> rightSideView(TreeNode root) {
        LinkedList<Integer> levels = new LinkedList<>();
        if(root == null) return levels;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            for(int i = 0; i < count; i++) {
                TreeNode treeNode = queue.poll();
                if(treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if(treeNode.right != null) {
                    queue.add(treeNode.right);
                }
                if(i == count - 1) {
                    levels.add(treeNode.val);
                }
            }
        }
        return levels;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        Solution solution = new Solution();
        List<Integer> res = solution.rightSideView(root);
        System.out.println(res);

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}