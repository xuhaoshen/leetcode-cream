package algorithm.greedy.leetcode_455;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by shen
 * @version: v1.0
 * @description:
 * @date:2020/2/16
 */
public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        char[] arrS = s.toCharArray();
        char[] arrP = p.toCharArray();
        int[] letters = new int[26];
        int[] windows = new int[26];
        int left = 0;
        int right = 0;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < arrP.length; i++) {
            letters[arrP[i] - 'a'] += 1;
        }
        while (right < arrS.length) {
            int currR = arrS[right] - 'a';
            right++;
            windows[currR] += 1;
            while (windows[currR] > letters[currR]) {
                int currL = arrS[left] - 'a';
                left++;
                windows[currL] -= 1;
            }
            if(right - left == arrP.length) {
                result.add(left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> val = solution.findAnagrams("abab", "ab");
        val.stream().forEach(v -> System.out.println(v));
    }
}
