package algorithm.binary_tree.leetcode_101;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        return symmetric(root, root);
    }

    private boolean symmetric(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return  false;
        if(!symmetric(p.right, q.left)) return false;
        if(!symmetric(p.left, q.right)) return false;
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);


        boolean res = solution.isSymmetric(root);
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

