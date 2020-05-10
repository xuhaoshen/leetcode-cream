package algorithm.array.leetcode_215;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    public int findKthLargest(int[] nums, int k) {
        for(int i = 1; i < nums.length; i++) {
            int j = i - 1;
            int temp = nums[i];
            for(;j >= 0 && temp < nums[j]; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = temp;
        }
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println(res);
    }
}
