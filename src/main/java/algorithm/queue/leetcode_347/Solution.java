package algorithm.queue.leetcode_347;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for(int key: map.keySet()) {
            if(priorityQueue.size() < k) {
                priorityQueue.add(key);
            } else if(map.get(key) > map.get(priorityQueue.peek())) {
                priorityQueue.poll();
                priorityQueue.add(key);
            }
        }
        int[] res = new int[k];
        int index = 0;
        while (!priorityQueue.isEmpty()) {
            res[index] = priorityQueue.poll();
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println(res);

    }
}