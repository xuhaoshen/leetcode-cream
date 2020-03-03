package algorithm.array.leetcode_3;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int[] index = new int[256];
        int right = 0;
        int left = 0;
        while (left < s.length()) {
            if(right < s.length() && index[s.charAt(right)] == 0) {
                index[s.charAt(right++)]++;
            } else {
                index[s.charAt(left++)]--;
            }
            result = Math.max(result, right - left);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "abcabcbb";
        int result = solution.lengthOfLongestSubstring(str);
        System.out.println(result);
    }
}
