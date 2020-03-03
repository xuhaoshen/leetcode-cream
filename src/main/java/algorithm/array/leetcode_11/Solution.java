package algorithm.array.leetcode_11;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            max = height[left] < height[right] ? Math.max(max, (right - left) * height[left++])
                    : Math.max(max, (right - left) * height[right--]);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(result);
    }
}
