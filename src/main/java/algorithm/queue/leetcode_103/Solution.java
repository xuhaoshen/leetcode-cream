package algorithm.queue.leetcode_103;

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
        if(level % 2 == 0) {
            levels.get(level).add(root.val);
        } else {
            levels.get(level).add(0, root.val);
        }
        if(root.left != null) {
            bfs(root.left, level + 1);
        }
        if(root.right != null) {
            bfs(root.right, level + 1);
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return levels;
        bfs(root, 0);
        return levels;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
//        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(5);

        Solution solution = new Solution();
        List<List<Integer>> res = solution.zigzagLevelOrder(root);
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