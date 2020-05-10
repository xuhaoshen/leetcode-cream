package algorithm.dynamic.leetcode_62;

import java.util.Arrays;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    public int uniquePaths(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j-1];
            }
        }
        return cur[n-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int val = solution.uniquePaths(3, 2);
        System.out.println(val);
    }
}
