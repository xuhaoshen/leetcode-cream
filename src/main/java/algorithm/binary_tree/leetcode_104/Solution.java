package algorithm.binary_tree.leetcode_104;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        System.out.println(root.val);
        int leftHeight = maxDepth(root.left);
        System.out.println("leftHeight:" + leftHeight);
        int rightHeight = maxDepth(root.right);
        System.out.println("rightHeight:" + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
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


        int res = solution.maxDepth(root);
        System.out.println("======" + res);
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

