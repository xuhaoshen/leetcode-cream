package algorithm.stack.leetcode_144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if(curr != null) {
                res.add(curr.val);
                stack.add(curr);
                curr = curr.left;
            } else {
                TreeNode node = stack.pop();
                curr = node.right;
            }


        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(6);
        List<Integer> res = solution.preorderTraversal(treeNode);
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