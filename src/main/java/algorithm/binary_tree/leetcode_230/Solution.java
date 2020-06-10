package algorithm.binary_tree.leetcode_230;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList();
        inorder(root, list);
        return list.get(k - 1);
    }

    private void inorder(TreeNode treeNode, List<Integer> arr) {
        if(treeNode == null) return;
        inorder(treeNode.left, arr);
        arr.add(treeNode.val);
        inorder(treeNode.right, arr);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int res = solution.kthSmallest(root, 3);
        System.out.println(res);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {
    }
    TreeNode(int x) {
        val = x;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

