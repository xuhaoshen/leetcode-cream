package algorithm.array.leetcode_680;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return check(s, left + 1, right) || check(s, left, right + 1);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean check(String s, int i, int j) {
        while (i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.validPalindrome( "abc");
        System.out.println(res);
    }
}
