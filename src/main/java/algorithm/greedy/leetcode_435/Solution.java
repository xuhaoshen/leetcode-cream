package algorithm.greedy.leetcode_435;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int count = 1;
        int currEnd = intervals[0][1];
        for(int[] interval: intervals) {
            int currStart = interval[0];
            if(currStart >= currEnd) {
                count++;
                currEnd = interval[1];
            }
        }
        return intervals.length - count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = new int[][]{{1,2}, {2,3}, {3,4}, {1,3}};
        int res = solution.eraseOverlapIntervals(intervals);
        System.out.println(res);
    }
}
