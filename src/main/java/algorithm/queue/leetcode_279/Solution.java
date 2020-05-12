package algorithm.queue.leetcode_279;

import java.util.*;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    public int numSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        for(int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }
        Queue<AbstractMap.SimpleEntry<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new AbstractMap.SimpleEntry<>(n, 0));
        boolean[] flag = new boolean[n + 1];
        flag[n] = true;
        while (!queue.isEmpty()) {
            AbstractMap.SimpleEntry<Integer, Integer> entry = queue.poll();
            int reminder = entry.getKey();
            int count = entry.getValue();
            for(int i = 0; i < squares.size(); i++) {
                int square = squares.get(i);
                if(reminder - square == 0) return count + 1;
                if(reminder - square < 0) break;
                if(!flag[reminder - square]) {
                    queue.add(new AbstractMap.SimpleEntry<>(reminder - square, count + 1));
                    flag[reminder - square] = true;
                }

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.numSquares(12);
        System.out.println(res);

    }
}