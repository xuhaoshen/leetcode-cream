package algorithm.binary_tree.leetcode_105;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    private Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        for(int i = 0; i < length; i++) {
            indexMap.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, length - 1, 0, length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }
        int preorder_root_index = preorder_left;
        int inorder_root_index = indexMap.get(preorder[preorder_root_index]);
        int left_size = inorder_root_index - inorder_left;
        TreeNode root = new TreeNode(preorder[preorder_root_index]);
        root.left = build(preorder, inorder, preorder_left + 1, preorder_left + left_size, inorder_left, inorder_root_index - 1);
        root.right = build(preorder, inorder, preorder_left + left_size + 1, preorder_right, inorder_root_index + 1, inorder_right);
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode res = solution.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
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

