package algorithm.binary_tree.leetcode_113;

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

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> curr = new LinkedList<>();
        build(result, curr, root, sum);
        return result;
    }

    private void build(List<List<Integer>> res, List<Integer> curr, TreeNode root, int sum) {
        if(root == null) {
            return;
        }
        curr.add(root.val);
        if(root.left == null && root.right == null) {
            if(sum - root.val == 0) {
                res.add(new ArrayList<>(curr));
            }
        } else {
            build(res, curr, root.left, sum - root.val);
            build(res, curr, root.right, sum - root.val);
        }
        curr.remove(curr.size() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        List<List<Integer>> res = solution.pathSum(root, 3);
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

