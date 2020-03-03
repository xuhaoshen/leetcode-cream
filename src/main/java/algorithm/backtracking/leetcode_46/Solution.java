package algorithm.backtracking.leetcode_46;

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

    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(length == 0) {
            return res;
        }
        boolean[] used = new boolean[length];
        Deque<Integer> deque = new ArrayDeque<>();
        dfs(nums, length, 0, deque, used, res);
        return res;
    }

    private void dfs(int[] nums, int length, int begin, Deque<Integer> deque, boolean[] used, List<List<Integer>> res) {
        if(begin == length) {
            res.add(new ArrayList<>(deque));
            return;
        }
        for(int i = 0; i < length; i++) {
            if(!used[i]) {
                used[i] = true;
                deque.addLast(nums[i]);
                dfs(nums, length, begin + 1, deque, used, res);
                used[i]  = false;
                deque.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.permute(new int[]{1, 2, 3});
        System.out.println(result);
    }
}
