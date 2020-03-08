package algorithm.array.leetcode_75;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    public void sortColors(int[] nums) {
        int left = 0;
        int current = 0;
        int right = nums.length - 1;
        int tmp;
        while (current <= right) {
            if(nums[current] == 0) {
                tmp = nums[left];
                nums[left++] = nums[current];
                nums[current++] = tmp;

            } else if(nums[current] == 2) {
                tmp = nums[right];
                nums[right--] = nums[current];
                nums[current] = tmp;
            } else {
                current++;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.sortColors(new int[]{1,2,0});
    }
}
