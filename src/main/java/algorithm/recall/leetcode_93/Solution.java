package algorithm.recall.leetcode_93;

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

    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if(s.length() < 4 || s.length() > 12) {
            return list;
        }
        Deque<String> deque = new ArrayDeque(4);
        dfs(s, 0, 0, deque, list);
        return list;
    }

    private int judegeIpSegment(String ip, int left, int right) {
        int length = right - left + 1;
        if(length > 1 && ip.charAt(left) == '0') {
            return -1;
        }
        int val = 0;
        for(int i = left; i <= right; i++) {
            val = val * 10 + ip.charAt(i) - '0';
        }
        if(val > 255) {
            return -1;
        }
        return val;
    }

    private void dfs(String ip, int split, int begin, Deque<String> deque, List<String> res) {
        if(begin == ip.length() && split == 4) {
            res.add(String.join(".", deque));
            return;
        }
        if((ip.length() - begin) < (4- split) || (ip.length() - begin) > (4- split)) {
            return;
        }
        for(int i = 0; i < 3; i++) {
            if(begin + i >= ip.length()) {
                break;
            }
            int ipSegment = judegeIpSegment(ip, begin, begin + i);
            if(ipSegment != -1) {
                deque.addLast(ipSegment + "");
                dfs(ip, split + 1, begin + i + 1, deque, res);
                deque.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String ip = "25525511135";
        List<String> result = solution.restoreIpAddresses(ip);
        result.stream().forEach(str -> System.out.println(str));
    }
}
