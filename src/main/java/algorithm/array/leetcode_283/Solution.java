package algorithm.array.leetcode_283;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = -1;
        while (i < nums.length) {
            if(nums[i] != 0) {
                nums[++j] = nums[i];
                if(i != j) {
                    nums[i] = 0;
                }
            }
            i++;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.moveZeroes(new int[]{1});
    }
}
