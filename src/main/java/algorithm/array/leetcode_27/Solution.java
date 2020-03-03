package algorithm.array.leetcode_27;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    public int removeElement(int[] nums, int val) {
        int i=0;
        for (int j=0;j<nums.length;j++){
            if (nums[j]!=val){
                nums[i]=nums[j];
                i++;
            }
        }
        return i;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2);
        System.out.println(result);
    }
}
