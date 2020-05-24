package algorithm.dynamic.leetcode_53;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    public int maxProduct(int[] nums) {
        int max = nums[0];
        int imax = nums[0];
        int imin = nums[0];
        for(int i = 1; i< nums.length; i++) {
            if(nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            max = Math.max(imax, max);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maxProduct( new int[]{2,3,-2,4});
        System.out.println(res);
    }
}
