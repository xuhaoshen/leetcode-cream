package algorithm.binary_tree.leetcode_437;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return count(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int count(TreeNode treeNode, int value) {
        if(treeNode == null) return 0;
        value = value - treeNode.val;
        int result = 0;
        if(value == 0) {
            result = result + 1;
        }
        return result + count(treeNode.left, value) + count(treeNode.right, value);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int p = solution.pathSum(root, 4);
        System.out.println(p);
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

