package algorithm.binary_tree.leetcode_257;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        if(root == null) return res;
        dfs(root, "", res);
        return res;
    }

    private void dfs(TreeNode treeNode, String val, List<String> res) {
        if(treeNode != null) {
            val += treeNode.val;
            if(treeNode.left == null && treeNode.right == null) {
                res.add(val);
            } else {
                val += "->";
                dfs(treeNode.left, val, res);
                dfs(treeNode.right, val, res);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        List<String> p = solution.binaryTreePaths(root);
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

