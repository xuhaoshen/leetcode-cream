package algorithm.binary_tree.leetcode_108;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if(left > right) {
            return null;
        }
        int middle = left + (right - left) / 2;
        TreeNode treeNode = new TreeNode(nums[middle]);
        treeNode.left = build(nums, left, middle - 1);
        treeNode.right = build(nums, middle + 1, right);
        return treeNode;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode res = solution.sortedArrayToBST(new int[]{-10,-3,0,5,9});
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

