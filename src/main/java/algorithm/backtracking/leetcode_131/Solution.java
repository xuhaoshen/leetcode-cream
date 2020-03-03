package algorithm.backtracking.leetcode_131;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    public List<List<String>> partition(String s) {
        int length = s.length();
        List<List<String>> res = new ArrayList<>();
        if(length == 0) {
            return res;
        }
        Deque<String> path = new ArrayDeque<>();
        dfs(s, 0, length, path, res);
        return res;
    }

    private void dfs(String s, int begin, int length, Deque<String> path, List<List<String>> res) {
        if(begin == length) {
            res.add(new ArrayList<>(path));
        }
        for(int i = begin; i < length; i++) {
            if(checkIsPalindrome(s, begin, i)) {
                path.addLast(s.substring(begin, i+1));
                dfs(s, i + 1, length, path, res);
                path.removeLast();
            }
        }
    }

    private boolean checkIsPalindrome(String s, int left, int right) {
        while (left <= right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board =
                {};
        List<List<String>> result = solution.partition("aab");
        System.out.println(result);
    }
}
