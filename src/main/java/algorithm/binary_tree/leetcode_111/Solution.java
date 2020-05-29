package algorithm.binary_tree.leetcode_111;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        int minLen = Integer.MAX_VALUE;
        if(root.left != null) {
            minLen = Math.min(minLen, minDepth(root.left));
        }
        if(root.right != null) {
            minLen = Math.min(minLen, minDepth(root.right));
        }
        return 1 + minLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.right = new TreeNode(7);
        int res = solution.minDepth(root);
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

