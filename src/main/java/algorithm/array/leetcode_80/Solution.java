package algorithm.array.leetcode_80;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int count = 1;
        int length = nums.length;
        for(int i = 1; i < length; i++) {
            if(nums[i] == nums[i - 1]) {
                count++;
                if(count > 2) {
                    for(int j = i + 1; j < nums.length; j++) {
                        nums[j - 1] = nums[j];
                    }
                    i--;
                    length--;
                }
            } else {
                count = 1;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int v = solution.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3});
        System.out.println(v);
    }
}
