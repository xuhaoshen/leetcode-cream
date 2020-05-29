package algorithm.binary_tree.leetcode_110;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        return (Math.abs(height(root.left) - height(root.right)) < 2) && isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode treeNode) {
        if(treeNode == null) {
            return -1;
        }
        return 1 + Math.max(height(treeNode.left) , height(treeNode.right));
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
        boolean res = solution.isBalanced(root);
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

