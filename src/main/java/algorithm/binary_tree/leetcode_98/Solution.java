package algorithm.binary_tree.leetcode_98;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    private boolean valid(TreeNode root, Integer low, Integer high) {
        if(root == null) return true;
        if(low != null && root.val <= low) return false;
        if(high != null && root.val >= high) return false;
        if(!valid(root.left, low, root.val)) return false;
        if(!valid(root.right, root.val, high)) return false;
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return valid(root, null, null);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        Solution solution = new Solution();
        boolean res = solution.isValidBST(root);
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

