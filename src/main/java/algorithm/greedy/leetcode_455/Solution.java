package algorithm.greedy.leetcode_455;

import java.util.Arrays;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    public int findContentChildren(int[] g, int[] s) {
        if(g == null || s == null) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for(int i = 0;count < g.length && i < s.length; i++) {
            if(g[count] <= s[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.findContentChildren(new int[]{1,2}, new int[]{1,2,3});
        System.out.println(res);
    }
}
