package algorithm.queue.leetcode_102;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    private List<List<Integer>> levels = new ArrayList<>();

    private void bfs(TreeNode root, int level) {
        if(levels.size() == level) levels.add(new ArrayList<>());
        levels.get(level).add(root.val);
        if(root.left != null) {
            bfs(root.left, level + 1);
        }
        if(root.right != null) {
            bfs(root.right, level + 1);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return levels;
        bfs(root, 0);
        return levels;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution solution = new Solution();
        List<List<Integer>> res = solution.levelOrder(root);
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