package algorithm.array.leetcode_209;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int l = 0;
        int r = -1;
        int length = nums.length + 1;
        int sum = 0;
        while (l < nums.length) {
            if(sum < s && r + 1 < nums.length) {
                r++;
                sum += nums[r];
            } else {
                sum -= nums[l];
                l++;
            }
            if(sum >= s) {
                length = Math.min(length, r - l + 1);
            }
        }
        return length == nums.length + 1 ? 0 : length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.minSubArrayLen(6, new int[]{10, 2, 3});
        System.out.println(res);
    }
}
