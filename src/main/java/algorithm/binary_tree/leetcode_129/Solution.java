package algorithm.binary_tree.leetcode_129;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return build(root, 0);
    }

    private int build(TreeNode treeNode, int res) {
        if(treeNode == null) {
            return 0;
        }
        res = res * 10 + treeNode.val;
        if(treeNode.left == null && treeNode.right == null) {
            return res;
        }
        return build(treeNode.left, res) + build(treeNode.right, res);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int res = solution.sumNumbers(root);
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

